package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Biblioteca;
import modelo.Cliente;
import modelo.Libro;
import modelo.Prestamo;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("1. Registrar libro");
            System.out.println("2. Gestionar información de clientes");
            System.out.println("3. Gestionar préstamos");
            System.out.println("4. Mostrar informe de inventario general");
            System.out.println("5. Salir\n");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese isbn del libro: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Ingrese título del libro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese autor del libro: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ingrese editorial del libro: ");
                    String editorial = scanner.nextLine();

                    System.out.print("Ingrese año del libro: ");
                    int yearPublicacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Libro libro = new Libro(isbn, titulo, autor, editorial, yearPublicacion);
                    System.out.println("\n" + biblioteca.registrarLibro(libro) + "\n");
                    break;

                case 2:
                    Cliente auxCliente = new Cliente();
                    System.out.println("\n1. Agregar cliente");
                    System.out.println("2. Mostrar información de clientes");
                    System.out.println("3. Modificar información de cliente");
                    System.out.println("4. Eliminar cliente");

                    System.out.print("\nSeleccione una opción: ");
                    int opcionClientes = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionClientes) {
                        case 1:

                            System.out.print("\nIngrese la cedula del cliente: ");
                            int cedula = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ingrese nombre del cliente: ");
                            String nombreCliente = scanner.nextLine();

                            System.out.print("Ingrese dirección del cliente: ");
                            String direccionCliente = scanner.nextLine();

                            System.out.print("Ingrese edad del cliente: ");
                            byte edadCliente = scanner.nextByte();
                            scanner.nextLine(); // Consumir el salto de línea

                            System.out.print("Ingrese teléfono del cliente: ");
                            long telefonoCliente = scanner.nextLong();

                            Cliente cliente = new Cliente(cedula, nombreCliente, direccionCliente, edadCliente, telefonoCliente);
                            System.out.println("\n" + biblioteca.registrarCliente(cliente) + "\n");
                            break;
                        case 2:

                            if (biblioteca.getClientes().isEmpty()) {
                                System.out.println("\nSin clientes registrados");
                            } else {
                                for (Cliente cl : biblioteca.getClientes()) {
                                    System.out.printf("\nCedula: %d\n", cl.getCedula());
                                    System.out.printf("Nombre: %s\n", cl.getNombre());
                                    System.out.printf("Edad: %d\n", cl.getEdad());
                                    System.out.printf("Telefono: %d\n", cl.getTelefono());
                                    System.out.printf("Direccion: %s\n", cl.getDireccion());
                                }
                            }
                            System.out.print("\n");
                            break;
                        case 3:
                            System.out.print("\nIngrese la cedula del cliente que desea modificar: ");
                            int cedulaCliente = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            auxCliente.setCedula(cedulaCliente);
                            Cliente clienteBuscado = biblioteca.buscarCliente(auxCliente);

                            if (clienteBuscado != null) {
                                System.out.println("\n1. Nombre");
                                System.out.println("2. Dirección");
                                System.out.println("3. Edad");
                                System.out.println("4. Teléfono");

                                System.out.print("\nSeleccione el dato que desea modificar: ");
                                int opcionModificarCliente = scanner.nextInt();
                                scanner.nextLine(); // Consumir el salto de línea

                                System.out.print("\n");
                                switch (opcionModificarCliente) {
                                    case 1:
                                        System.out.print("Ingrese el nuevo nombre: ");
                                        String nuevoNombre = scanner.nextLine();
                                        clienteBuscado.setNombre(nuevoNombre);
                                        break;
                                    case 2:
                                        System.out.println("Ingrese la nueva dirección:");
                                        String nuevaDireccion = scanner.nextLine();
                                        clienteBuscado.setDireccion(nuevaDireccion);
                                        break;
                                    case 3:
                                        System.out.println("Ingrese la nueva edad:");
                                        byte nuevaEdad = scanner.nextByte();
                                        scanner.nextLine(); // Consumir el salto de línea
                                        clienteBuscado.setEdad(nuevaEdad);
                                        break;
                                    case 4:
                                        System.out.println("Ingrese el nuevo teléfono:");
                                        long nuevoTelefono = scanner.nextLong();
                                        scanner.nextLine(); //Consumir el salto de linea
                                        clienteBuscado.setTelefono(nuevoTelefono);
                                        break;
                                    default:
                                        System.out.println("\nOpción inválida\n");
                                        break;
                                }
                                if (opcionModificarCliente >= 1 && opcionModificarCliente < 5) {
                                    System.out.println("\nModificacion exitosa\n");
                                }
                            } else {
                                System.out.println("\nCliente no registrado\n");
                            }
                            break;
                        case 4:
                            System.out.print("\nIngrese la cedula del cliente que desea eliminar: ");
                            int cedulaClienteEliminar = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            auxCliente.setCedula(cedulaClienteEliminar);
                            System.out.println("\n" + biblioteca.eliminarCliente(auxCliente) + "\n");
                            break;
                        default:
                            System.out.println("\nOpción inválida\n");
                            break;
                    }
                    break;

                case 3:
                    Cliente auxCliente2 = new Cliente();
                    System.out.println("\n1. Prestar libro");
                    System.out.println("2. Devolver libro");

                    System.out.print("\nSeleccione una opción: ");
                    int opcionPrestamos = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    switch (opcionPrestamos) {
                        case 1:
                            System.out.print("\nIngrese la cedula del cliente: ");
                            int cedulaCliente = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            auxCliente2.setCedula(cedulaCliente);
                            Cliente clienteBuscado = biblioteca.buscarCliente(auxCliente2);
                            if (clienteBuscado == null) {
                                System.out.println("\nCliente no registrado\n");
                                break;
                            }

                            ArrayList<Libro> libros = new ArrayList<>();
                            System.out.print("Ingrese isbn del libro: ");
                            int cantLibros = scanner.nextInt();
                            scanner.nextLine();
                            Libro auxlibro,
                             libroBuscado = null;

                            for (int i = 1; i <= cantLibros; i++) {
                                System.out.printf("Ingrese isbn del libro #%d: ", i);
                                String isbnLibro = scanner.nextLine();
                                auxlibro = new Libro();
                                auxlibro.setIsbn(isbnLibro);
                                libroBuscado = biblioteca.buscarLibro(auxlibro);

                                if (libroBuscado != null) {
                                    libros.add(libroBuscado);
                                }else {
                                    break;
                                }
                            }

                            if (libroBuscado == null) {
                                System.out.println("\nLibro no encontrado\n");
                                break;
                            }

                            System.out.print("Ingrese fecha de préstamo (en formato dd/mm/aaaa): ");
                            String fp = scanner.nextLine();

                            int day = Integer.parseInt(fp.split("/")[0]);
                            int month = Integer.parseInt(fp.split("/")[1]);
                            int year = Integer.parseInt(fp.split("/")[2]);
                            LocalDate fechaPrestamo = LocalDate.of(year, month, day);

                            System.out.print("Ingrese fecha de regreso (en formato dd/mm/aaaa): ");
                            String fr = scanner.nextLine();

                            int returnDay = Integer.parseInt(fr.split("/")[0]);
                            int returnMonth = Integer.parseInt(fr.split("/")[1]);
                            int returnYear = Integer.parseInt(fr.split("/")[2]);
                            LocalDate fechaRegreso = LocalDate.of(returnYear, returnMonth, returnDay);

                            Prestamo prestamo = new Prestamo(clienteBuscado, libros, fechaPrestamo, fechaRegreso);
                            System.out.println("\n" + biblioteca.registrarPrestamo(prestamo) + "\n");
                            break;
                        case 2:
                            System.out.print("\nIngrese la cedula del cliente: ");
                            int cedulaCliente2 = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            auxCliente2.setCedula(cedulaCliente2);
                            Cliente clienteBuscado2 = biblioteca.buscarCliente(auxCliente2);
                            if (clienteBuscado2 == null) {
                                System.out.println("\nCliente no registrado en el sistema\n");
                                break;
                            }

                            Prestamo prestamoCliente = biblioteca.buscarPrestamo(clienteBuscado2);

                            
                            System.out.println("\n" + biblioteca.devolverLibros(clienteBuscado2, prestamoCliente.getLibros()) + "\n");
                            break;
                        default:
                            System.out.println("\nOpción inválida\n");
                            break;
                    }
                    break;
                case 4:

                    if (biblioteca.getLibros().isEmpty()) {
                        System.out.println("\nSin libros registrados");
                    } else {
                        for (Libro lb : biblioteca.getLibros()) {
                            System.out.printf("\nIsbn: %s\n", lb.getIsbn());
                            System.out.printf("Titulo: %s\n", lb.getTitulo());
                            System.out.printf("Autor: %s\n", lb.getAutor());
                            System.out.printf("Editorial: %s\n", lb.getEditorial());
                            System.out.printf("Año de publicacion: %d\n", lb.getYearPublicacion());
                            String estadoReserva = lb.getEstadoReserva() ? "Reservado" : "No reservado";
                            System.out.println(estadoReserva);
                            String cliente = lb.getClienteAsociado() != null ? lb.getClienteAsociado().getNombre() : "sin cliente asociado";
                            System.out.println("Cliente: " + cliente);
                        }
                    }
                    System.out.print("\n");
                    break;
                case 5:
                    System.out.println("\nGracias por utilizar la biblioteca");
                    break;
                default:
                    System.out.println("\nOpción inválida\n");
                    break;
            }
        }
    }
}
