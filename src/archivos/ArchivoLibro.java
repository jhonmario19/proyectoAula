package archivos;

import excepciones.ExcepcionArchivo;
import modelo.Libro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class ArchivoLibro extends Archivo {

    private FileWriter modoEscritura;
    private Scanner modoLectura;
    ArchivoCliente archivoCliente;

    public ArchivoLibro() {
        this("libros.txt");
    }

    public ArchivoLibro(String ruta) {
        super(ruta);
        this.archivoCliente = new ArchivoCliente();
    }

    public FileWriter getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(FileWriter modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    public void guardarLibro(Libro lb) {
        PrintWriter pw = null;

        try {

            this.modoEscritura = new FileWriter(archivo, true);
            pw = new PrintWriter(this.modoEscritura);
            if (lb == null) {
                pw.print("");
            } else {
                pw.println(lb.toString());
            }

        } catch (IOException ae) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private Libro cargarDatos(String data[]) throws ExcepcionArchivo {

        String isbn = data[1];
        String titulo = data[2];
        String editorial = data[3];
        int yearPublicacion = Integer.parseInt(data[4]);
        String autor = data[5];
        boolean estadoReserva = Boolean.parseBoolean(data[6]);

        Cliente clienteBuscado;
        if (data[7].equalsIgnoreCase("null")) {
            clienteBuscado = null;
        } else {
            Cliente cliente = new Cliente();
            cliente.setCedula(Integer.parseInt(data[7]));
            clienteBuscado = this.archivoCliente.buscarCliente(cliente);
        }

        Libro libro = new Libro(isbn, titulo, autor, editorial, yearPublicacion);
        libro.setEstadoReserva(estadoReserva);
        libro.setClienteAsociado(clienteBuscado);

        return libro;
    }

    public ArrayList<Libro> listarlibros() throws ExcepcionArchivo {
        ArrayList<Libro> lista;
        try {
            this.modoLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.modoLectura.hasNext()) {

                String datos[] = this.modoLectura.nextLine().split(";");
                Libro lb = this.cargarDatos(datos);
                lista.add(lb);
            }
            return lista;

        } catch (FileNotFoundException ioe) {
            throw new ExcepcionArchivo("Archivo libros no existe");
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    public Libro buscarLibro(Libro lb) throws ExcepcionArchivo {
        Libro libroBc = null;

        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String datos[] = this.modoLectura.nextLine().split(";");
                Libro aux = this.cargarDatos(datos);
                if (aux.getIsbn().equals(lb.getIsbn())) {
                    libroBc = aux;
                }
            }

            return libroBc;

        } catch (FileNotFoundException ae) {
            throw new ExcepcionArchivo("No se pudo abrir el archivo para buscar el dato");

        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    private void renombrarArchivo(File tmp) throws IOException {
        if (!tmp.exists()) {
            throw new IOException("El archivo temporal no existe");
        }

        if (!this.archivo.delete()) {
            tmp.delete();
            throw new IOException("No es posible eliminar el archivo original");
        }

        if (!tmp.renameTo(this.archivo)) {
            throw new IOException("No es posible renombrar el archivo temporal");
        }
    }

    public void eliminarLibro(Libro lb) throws ExcepcionArchivo {

        ArchivoLibro archivoTmp = new ArchivoLibro("libros.tpm");
        int i = 0;

        try {

            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String datos[] = this.modoLectura.nextLine().split(";");
                Libro aux = this.cargarDatos(datos);

                if (!aux.getIsbn().equalsIgnoreCase(lb.getIsbn())) {
                    archivoTmp.guardarLibro(aux);
                    i++;
                }
            }
            if (i == 0) {
                archivoTmp.guardarLibro(null);
            }
            this.renombrarArchivo(archivoTmp.archivo);
            this.modoLectura.close();

        } catch (FileNotFoundException ae) {
            throw new ExcepcionArchivo("No se pudo abrir el archivo");

        } catch (IOException e) {
            throw new ExcepcionArchivo(e.getMessage());

        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    public void actualizarLibro(Libro lb) throws ExcepcionArchivo {
        this.eliminarLibro(lb);
        this.guardarLibro(lb);
    }

}
