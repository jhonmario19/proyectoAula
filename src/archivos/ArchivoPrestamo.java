package archivos;

import excepciones.ExcepcionArchivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Libro;
import modelo.Prestamo;

public class ArchivoPrestamo extends Archivo {

    private FileWriter modoEscritura;
    private Scanner modoLectura;
    ArchivoCliente archivoCliente;
    ArchivoLibro archivoLibro;

    public ArchivoPrestamo() {
        this("prestamos.txt");
    }

    public ArchivoPrestamo(String ruta) {
        super(ruta);
        this.archivoCliente = new ArchivoCliente();
        this.archivoLibro = new ArchivoLibro();
    }

    public FileWriter getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(FileWriter modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    public void guardarPrestamo(Prestamo prestamo) {
        PrintWriter pw = null;

        try {

            this.modoEscritura = new FileWriter(archivo, true);
            pw = new PrintWriter(this.modoEscritura);
            if (prestamo == null) {
                pw.print("");
            } else {
                pw.println(prestamo.toString());
            }

        } catch (IOException ae) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private Prestamo cargarDatos(String data[]) throws ExcepcionArchivo {

        int cedulaCliente = Integer.parseInt(data[1]);
        Cliente auxCliente = new Cliente();
        auxCliente.setCedula(cedulaCliente);
        Cliente clienteBuscado = archivoCliente.buscarCliente(auxCliente);

        String[] isbnLibros;
        if (data[2].contains(",")) {
            isbnLibros = data[2].replaceAll("[\\[\\]]", "").split(", ");
        } else {
            isbnLibros = new String[1];
            isbnLibros[0] = data[2].replaceAll("[\\[\\]]", "");
        }
        ArrayList<Libro> librosPrestados = new ArrayList<>();

        for (String bnLibro : isbnLibros) {
            Libro auxLibro = new Libro();
            auxLibro.setIsbn(bnLibro);
            Libro libroBuscado = archivoLibro.buscarLibro(auxLibro);
            librosPrestados.add(libroBuscado);
        }

        LocalDate fechaPrestamo = LocalDate.parse(data[3]);
        LocalDate fechaRegreso = LocalDate.parse(data[4]);

        Prestamo prestamo = new Prestamo(clienteBuscado, librosPrestados, fechaPrestamo, fechaRegreso);
        return prestamo;
    }

    public ArrayList<Prestamo> listarPrestamos() throws ExcepcionArchivo {
        ArrayList<Prestamo> lista;
        try {
            this.modoLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.modoLectura.hasNext()) {

                String datos[] = this.modoLectura.nextLine().split(";");
                Prestamo pt = this.cargarDatos(datos);
                lista.add(pt);
            }
            return lista;

        } catch (FileNotFoundException ioe) {
            throw new ExcepcionArchivo("Archivo prestamos no existe");
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    public Prestamo buscarPrestamo(Prestamo prestamo) throws ExcepcionArchivo {
        Prestamo prestamoBuscado = null;

        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String datos[] = this.modoLectura.nextLine().split(";");
                Prestamo aux = this.cargarDatos(datos);

                if (aux.getCliente().getCedula() == prestamo.getCliente().getCedula()) {
                    prestamoBuscado = aux;
                }
            }

            return prestamoBuscado;

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

    public void eliminarPrestamo(Prestamo prestamo) throws ExcepcionArchivo {
        ArchivoPrestamo archivoTmp = new ArchivoPrestamo("prestamos.tpm");
        int i = 0;

        try {

            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String datos[] = this.modoLectura.nextLine().split(";");
                Prestamo aux = this.cargarDatos(datos);

                if (aux.getCliente().getCedula() != prestamo.getCliente().getCedula()) {
                    archivoTmp.guardarPrestamo(aux);
                    i++;
                }
            }
            if (i == 0) {
                archivoTmp.guardarPrestamo(null);
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
    
    public void actualizarPrestamo(Prestamo prestamo) throws ExcepcionArchivo {
        this.eliminarPrestamo(prestamo);
        this.guardarPrestamo(prestamo);
    }
}
