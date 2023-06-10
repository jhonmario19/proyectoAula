package archivos;

import excepciones.ExcepcionArchivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class ArchivoCliente extends Archivo {

    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoCliente() {
        this("clientes.txt");
    }

    public ArchivoCliente(String ruta) {
        super(ruta);
    }

    public FileWriter getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(FileWriter modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    public void guardarCliente(Cliente cliente) {
        PrintWriter pw = null;

        try {

            this.modoEscritura = new FileWriter(archivo, true);
            pw = new PrintWriter(this.modoEscritura);
            if (cliente == null) {
                pw.print("");
            } else {
                pw.println(cliente.toString());
            }

        } catch (IOException ae) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private Cliente cargarDatos(String data[]) {

        int cedula = Integer.parseInt(data[1]);
        String nombre = data[2];
        String direccion = data[3];
        byte edad = Byte.parseByte(data[4]);
        long telefono = Long.parseLong(data[5]);
        
        Cliente cliente = new Cliente(cedula, nombre, direccion, edad, telefono);
        return cliente;
    }

    public ArrayList<Cliente> listarClientes() throws ExcepcionArchivo {
        ArrayList<Cliente> lista;
        try {
            this.modoLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.modoLectura.hasNext()) {

                String datos[] = this.modoLectura.nextLine().split(";");
                Cliente cl = this.cargarDatos(datos);
                lista.add(cl);
            }
            return lista;

        } catch (FileNotFoundException ioe) {
            throw new ExcepcionArchivo("Archivo clientes no existe");
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    public Cliente buscarCliente(Cliente cliente) throws ExcepcionArchivo {
        Cliente clienteBuscado = null;
        
        try{
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Cliente aux = this.cargarDatos(datos);
                
                if(aux.getCedula() == cliente.getCedula()){
                    clienteBuscado = aux;
                }
            }
            
            return clienteBuscado;
            
        }catch (FileNotFoundException ae){
            throw new ExcepcionArchivo("No se pudo abrir el archivo para buscar el dato");
            
        }finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }
    
    private void renombrarArchivo(File tmp) throws IOException{
        if(!tmp.exists())
            throw new IOException("El archivo temporal no existe");
            
        if(!this.archivo.delete()){
            tmp.delete();
            throw new IOException("No es posible eliminar el archivo original");
        }
        
        if(!tmp.renameTo(this.archivo)){
            throw new IOException("No es posible renombrar el archivo temporal");
        }    
    }

    public void eliminarCliente(Cliente cliente) throws ExcepcionArchivo {
        ArchivoCliente archivoTmp = new ArchivoCliente("clientes.tpm");
        int i = 0;
        
        try{
            
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Cliente aux = this.cargarDatos(datos);
                
                if(aux.getCedula() != cliente.getCedula()){
                    archivoTmp.guardarCliente(aux);
                    i++;
                }
            }
            if(i==0){
                archivoTmp.guardarCliente(null);   
            }
            this.renombrarArchivo(archivoTmp.archivo);
            this.modoLectura.close();
            
        }catch (FileNotFoundException ae){
            throw new ExcepcionArchivo("No se pudo abrir el archivo");
            
        }catch (IOException e){
            throw new ExcepcionArchivo(e.getMessage());
            
        }finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }

    public void actualizarCliente(Cliente cliente) throws ExcepcionArchivo {
        this.eliminarCliente(cliente);
        this.guardarCliente(cliente);
    }

}
