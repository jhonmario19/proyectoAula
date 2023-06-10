package modelo;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Cliente buscarCliente(Cliente cliente) {
        for (Cliente cl : clientes) {
            if (cl.getCedula() == cliente.getCedula()) {
                return cl;
            }
        }
        return null;
    }

    public String registrarCliente(Cliente cliente) {

        if (this.buscarCliente(cliente) != null) {
            return "No se pudo añadir dicho cliente, ya existe en el sistema";
        }
        clientes.add(cliente);
        return "Se ha agregado un nuevo cliente con cedula " + cliente.getCedula();
    }

    public String eliminarCliente(Cliente cliente) {
        Cliente clienteEliminar = this.buscarCliente(cliente);

        if (clienteEliminar == null) {
            return "Cliente no registrado";
        }
        this.clientes.remove(clienteEliminar);
        return "Cliente eliminado con exito";
    }

    public String modificarCliente(Cliente cliente) {
        Cliente clienteBuscado = this.buscarCliente(cliente);

        if (clienteBuscado == null) {
            return "Cliente no encontrado en el sistema";
        }

        clienteBuscado.setCedula(cliente.getCedula());
        clienteBuscado.setNombre(cliente.getNombre());
        clienteBuscado.setDireccion(cliente.getDireccion());
        clienteBuscado.setEdad(cliente.getEdad());
        clienteBuscado.setTelefono(cliente.getTelefono());

        return "Cliente modificado exitosamente";
    }

    public Libro buscarLibro(Libro libro) {
        for (Libro lb : libros) {
            if (lb.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
                return lb;
            }
        }
        return null;
    }

    public String registrarLibro(Libro libro) {

        if (this.buscarLibro(libro) != null) {
            return "El libro ya se encuentra registrado en el sistema";
        }
        libros.add(libro);
        return "Libro añadido exitosamente";
    }

    public String eliminarLibro(Libro libro) {
        Libro libroBuscado = this.buscarLibro(libro);

        if (libroBuscado == null) {
            return "Libro no registrado";
        }

        this.libros.remove(libro);
        return "Libro eliminado exitosamente";
    }

    public String modificarLibro(Libro libro) {
        Libro libroBuscado = this.buscarLibro(libro);

        if (libroBuscado == null) {
            return "Libro no encontrado en el sistema";
        }

        libroBuscado.setIsbn(libro.getIsbn());
        libroBuscado.setTitulo(libro.getTitulo());
        libroBuscado.setEditorial(libro.getEditorial());
        libroBuscado.setYearPublicacion(libro.getYearPublicacion());
        libroBuscado.setAutor(libro.getAutor());
        libroBuscado.setEstadoReserva(libro.getEstadoReserva());
        libroBuscado.setClienteAsociado(libro.getClienteAsociado());

        return "Libro modificado exitosamente";
    }

    public String devolverLibros(Cliente cliente, ArrayList<Libro> librosDevolver) {
        //Buscar el respectivo prestamo
        Prestamo prestamo = this.buscarPrestamo(cliente);
        // Cambiar el estado del libro a disponible
        for (Libro libro : librosDevolver) {
            libro.setEstadoReserva(false);
            libro.setClienteAsociado(null);
            prestamo.getLibros().remove(libro);
        }
        return "Se han devuelto los libros con exito";
    }

    public Prestamo buscarPrestamo(Cliente cliente) {

        for (Prestamo p : this.prestamos) {
            if (p.getCliente().getCedula() == cliente.getCedula()) {
                return p;
            }
        }
        return null;
    }

    public String registrarPrestamo(Prestamo prestamo) {

        Prestamo prestamoBuscado = this.buscarPrestamo(prestamo.getCliente());

        boolean libres = true;
        for (Libro libro : prestamo.getLibros()) {
            if (libro.getEstadoReserva()) {
                libres = false;
                break;
            }
        }

        if (!libres || prestamoBuscado != null) {
            return "No se puede generar el prestamo, "
                    + "ya algunos libros estan prestados o el usuario tiene un prestamo no devuelto";
        }

        prestamos.add(prestamo);
        for (Libro libro : prestamo.getLibros()) {
            libro.setEstadoReserva(true);
            libro.setClienteAsociado(prestamo.getCliente());
        }
        return "Prestamo guardado exitosamente";
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }
}
