
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {
    
    private Cliente cliente;
    private ArrayList<Libro> libros;
    private LocalDate fechaPrestamo;
    private LocalDate fechaRegreso;
    
    public Prestamo(){}
    public Prestamo(Cliente cliente, ArrayList<Libro> libros, 
            LocalDate fechaPrestamo, LocalDate fechaRegreso) {
        this.cliente = cliente;
        this.libros = libros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRegreso = fechaRegreso;
    }

    public Cliente getCliente() {return this.cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public ArrayList<Libro> getLibros() {return this.libros;}
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public LocalDate getFechaPrestamo() {return fechaPrestamo;}
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaRegreso() {return fechaRegreso;}
    public void setFechaRegreso(LocalDate fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }
    
    public String librosRegistrados() {
        
        ArrayList<String> isbnLibros = new ArrayList<>();
        for(Libro libro : this.libros) {
            isbnLibros.add(libro.getIsbn());
        }
        return isbnLibros.toString();
    }
    @Override
    public String toString() {
        return "P;" + this.cliente.getCedula() + ";" + this.librosRegistrados()
                + ";" + this.fechaPrestamo.toString() + ";" 
                + this.fechaRegreso.toString();
    }
    
    
}
