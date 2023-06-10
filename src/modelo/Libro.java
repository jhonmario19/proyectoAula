package modelo;

import java.util.Objects;

public class Libro {

    private String isbn;
    private String titulo;
    private String editorial;
    private int yearPublicacion;
    private String autor;
    private boolean estadoReserva;
    private Cliente clienteAsociado;

    public Libro() {
    }

    ;
    public Libro(String isbn, String titulo, String autor,
            String editorial, int yearPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.yearPublicacion = yearPublicacion;
        this.estadoReserva = false;
        this.clienteAsociado = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getYearPublicacion() {
        return yearPublicacion;
    }

    public void setYearPublicacion(int year) {
        this.yearPublicacion = year;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(boolean estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Libro other = (Libro) obj;
        return Objects.equals(titulo, other.titulo);
    }

    @Override
    public String toString() {

        String cedula = this.clienteAsociado != null ? String.valueOf(this.clienteAsociado.getCedula()) : "null";
        return "L;" + this.isbn + ";" + this.titulo + ";"
                + this.editorial + ";" + this.yearPublicacion + ";"
                + this.autor + ";" + this.estadoReserva + ";"
                + cedula;
    }
}
