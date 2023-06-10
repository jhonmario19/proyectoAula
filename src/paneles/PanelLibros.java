package paneles;

import archivos.ArchivoLibro;
import archivos.ArchivoPrestamo;
import excepciones.ExcepcionArchivo;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Biblioteca;
import modelo.Cliente;
import modelo.Libro;
import modelo.Prestamo;
import personalizacion.ColorRowRenderer;

public class PanelLibros extends javax.swing.JPanel {

    private Biblioteca biblioteca;
    private ArchivoLibro archivoLibro;
    private ArchivoPrestamo archivoPrestamo;
    private DefaultTableModel modeloTabla;
    private boolean modificar;
    private TableRowSorter filtro;
    ColorRowRenderer renderTabla;

    public PanelLibros(Biblioteca biblioteca) {
        initComponents();

        this.modeloTabla = (DefaultTableModel) this.tablaLibros.getModel();
        this.modificar = false;

        renderTabla = new ColorRowRenderer();
        this.tablaLibros.setDefaultRenderer(Object.class, renderTabla);
        tablaLibros.setShowGrid(true);
        tablaLibros.setGridColor(Color.LIGHT_GRAY);

        this.biblioteca = biblioteca;
        this.archivoLibro = new ArchivoLibro("libros.txt");
        this.archivoPrestamo = new ArchivoPrestamo("prestamos.txt");

        this.cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JTabbedPane();
        panelAgregar = new javax.swing.JPanel();
        tituloAgregar = new javax.swing.JPanel();
        lbTituloAgregar = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        panelGrilla = new javax.swing.JPanel();
        labelIsbn = new javax.swing.JLabel();
        textIsbn = new javax.swing.JTextField();
        labelTitulo = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        labelEditorial = new javax.swing.JLabel();
        textEditorial = new javax.swing.JTextField();
        labelYear = new javax.swing.JLabel();
        textYear = new javax.swing.JTextField();
        labelAutor = new javax.swing.JLabel();
        textAutor = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelConsultar = new javax.swing.JPanel();
        tituloConsultar = new javax.swing.JPanel();
        lbTituloConsultar = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        labelBuscar = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        panelBotones1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 831));
        setLayout(new java.awt.GridLayout(1, 0));

        panelAgregar.setPreferredSize(new java.awt.Dimension(900, 800));
        panelAgregar.setLayout(new javax.swing.BoxLayout(panelAgregar, javax.swing.BoxLayout.Y_AXIS));

        tituloAgregar.setPreferredSize(new java.awt.Dimension(793, 100));

        lbTituloAgregar.setFont(new java.awt.Font("Noto Sans", 0, 40)); // NOI18N
        lbTituloAgregar.setText("Agregar libro");
        tituloAgregar.add(lbTituloAgregar);

        panelAgregar.add(tituloAgregar);

        contenido.setPreferredSize(new java.awt.Dimension(793, 500));
        contenido.setLayout(new javax.swing.BoxLayout(contenido, javax.swing.BoxLayout.Y_AXIS));

        panelDatos.setPreferredSize(new java.awt.Dimension(399, 150));
        panelDatos.setLayout(new java.awt.GridBagLayout());

        panelGrilla.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Libro"));
        panelGrilla.setMaximumSize(new java.awt.Dimension(100, 100));
        panelGrilla.setLayout(new java.awt.GridBagLayout());

        labelIsbn.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelIsbn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIsbn.setText("Isbn:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelIsbn, gridBagConstraints);

        textIsbn.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(textIsbn, gridBagConstraints);

        labelTitulo.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Titulo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelTitulo, gridBagConstraints);

        textTitulo.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(textTitulo, gridBagConstraints);

        labelEditorial.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelEditorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEditorial.setText("Editorial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelEditorial, gridBagConstraints);

        textEditorial.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(textEditorial, gridBagConstraints);

        labelYear.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelYear.setText("Año:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelYear, gridBagConstraints);

        textYear.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(textYear, gridBagConstraints);

        labelAutor.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAutor.setText("Autor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 10, 0);
        panelGrilla.add(labelAutor, gridBagConstraints);

        textAutor.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 10, 35);
        panelGrilla.add(textAutor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 41, 0, 41);
        panelDatos.add(panelGrilla, gridBagConstraints);

        contenido.add(panelDatos);

        panelBotones.setPreferredSize(new java.awt.Dimension(793, 80));
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        btnGuardar.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        btnGuardar.setText("Agregar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        panelBotones.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        panelBotones.add(btnCancelar);

        contenido.add(panelBotones);

        panelAgregar.add(contenido);

        panelPrincipal.addTab("Agregar", panelAgregar);

        panelConsultar.setPreferredSize(new java.awt.Dimension(900, 550));
        panelConsultar.setLayout(new javax.swing.BoxLayout(panelConsultar, javax.swing.BoxLayout.Y_AXIS));

        tituloConsultar.setPreferredSize(new java.awt.Dimension(793, 80));
        tituloConsultar.setLayout(new java.awt.GridLayout());

        lbTituloConsultar.setFont(new java.awt.Font("Noto Sans", 0, 40)); // NOI18N
        lbTituloConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloConsultar.setText("Consultar");
        tituloConsultar.add(lbTituloConsultar);

        panelBusqueda.setPreferredSize(new java.awt.Dimension(300, 50));
        panelBusqueda.setLayout(new java.awt.GridBagLayout());

        labelBuscar.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelBuscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 17);
        panelBusqueda.add(labelBuscar, gridBagConstraints);

        txtBusqueda.setPreferredSize(new java.awt.Dimension(200, 25));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });
        panelBusqueda.add(txtBusqueda, new java.awt.GridBagConstraints());

        tituloConsultar.add(panelBusqueda);

        panelConsultar.add(tituloConsultar);

        panelTabla.setPreferredSize(new java.awt.Dimension(652, 390));
        panelTabla.setLayout(new java.awt.GridBagLayout());

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Isbn", "Título", "Editorial", "Año", "Autor", "Reservado", "Ciente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLibros.setShowHorizontalLines(true);
        tablaLibros.setShowVerticalLines(true);
        tablaLibros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaLibros);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 35, 5, 35);
        panelTabla.add(jScrollPane1, gridBagConstraints);

        panelConsultar.add(panelTabla);

        panelBotones1.setPreferredSize(new java.awt.Dimension(793, 80));
        panelBotones1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        btnModificar.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        panelBotones1.add(btnModificar);

        btnEliminar.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        panelBotones1.add(btnEliminar);

        btnPrestar.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        btnPrestar.setText("Prestar");
        btnPrestar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrestarMouseClicked(evt);
            }
        });
        panelBotones1.add(btnPrestar);

        btnDevolver.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
        btnDevolver.setText("Devolver");
        btnDevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDevolverMouseClicked(evt);
            }
        });
        panelBotones1.add(btnDevolver);

        panelConsultar.add(panelBotones1);

        panelPrincipal.addTab("Consultar", panelConsultar);

        add(panelPrincipal);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        //Verificar que los cambos esten llenos
        if (textIsbn.getText().equals("")
                || textTitulo.getText().equals("")
                || textEditorial.getText().equals("")
                || textYear.getText().equals("")
                || textAutor.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Datos vacios, por favor verifique los campos",
                    "Error guardar", JOptionPane.ERROR_MESSAGE);
        } else {
            String isbn = textIsbn.getText();
            String titulo = textTitulo.getText();
            String editorial = textEditorial.getText();
            String autor = textAutor.getText();

            //Evitar que el formato del año sea incorrecto
            try {
                int year = Integer.parseInt(textYear.getText());

                int desicion = JOptionPane.showConfirmDialog(this,
                        "Seguro desea registrar el libro",
                        "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (desicion == 0) {
                    Libro libro = new Libro(isbn, titulo, autor, editorial, year);
                    String mensaje;

                    if (this.modificar) {

                        mensaje = this.biblioteca.modificarLibro(libro);
                        if (mensaje.equalsIgnoreCase("Libro modificado exitosamente")) {
                            try {

                                Libro auxLibro = this.biblioteca.buscarLibro(libro);
                                String estadoReserva = auxLibro.getEstadoReserva() ? "Reservado" : "No reservado";
                                String cliente = auxLibro.getClienteAsociado() != null
                                        ? String.valueOf(auxLibro.getClienteAsociado().getCedula()) : "Sin cliente";

                                Object[] datosFila = {isbn, titulo, editorial,
                                    year, autor, estadoReserva, cliente};

                                archivoLibro.actualizarLibro(libro);
                                int[] librosSeleccionados = this.tablaLibros.getSelectedRows();
                                int fila = librosSeleccionados[0];
                                for (int i = 0; i < this.tablaLibros.getColumnCount(); i++) {
                                    this.modeloTabla.setValueAt(datosFila[i], fila, i);
                                }

                            } catch (ExcepcionArchivo e) {
                                JOptionPane.showMessageDialog(this, e.getMessage(),
                                        "Error datos", JOptionPane.ERROR_MESSAGE);
                            }
                            this.modificar = false;
                        }
                        JOptionPane.showMessageDialog(this, mensaje,
                                "Operacion modificar", JOptionPane.PLAIN_MESSAGE);

                    } else {
                        mensaje = biblioteca.registrarLibro(libro);
                        if (mensaje.equalsIgnoreCase("Libro añadido exitosamente")) {
                            Object[] datosFila = {isbn, titulo, editorial,
                                year, autor, "No reservado", "Sin cliente"};
                            archivoLibro.guardarLibro(libro);
                            this.modeloTabla.addRow(datosFila);
                            this.tablaLibros.setModel(modeloTabla);
                        }
                        JOptionPane.showMessageDialog(this, mensaje,
                                "Operacion registrar", JOptionPane.PLAIN_MESSAGE);
                    }

                    if (mensaje.equalsIgnoreCase("Libro añadido exitosamente")
                            || mensaje.equalsIgnoreCase("Libro modificado exitosamente")) {
                        textIsbn.setText("");
                        textTitulo.setText("");
                        textEditorial.setText("");
                        textYear.setText("");
                        textAutor.setText("");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Año invalido, verifique el campo",
                        "Error guardar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int[] librosSeleccionados = this.tablaLibros.getSelectedRows();
        if (librosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro a "
                    + "eliminar", "Eliminar", JOptionPane.WARNING_MESSAGE);
        } else {

            int fila;
            boolean seguir = true;

            for (int i = librosSeleccionados.length - 1; i >= 0; i--) {
                fila = librosSeleccionados[i];
                String cedula = String.valueOf(this.tablaLibros.getValueAt(fila, 6));

                if (!cedula.equalsIgnoreCase("Sin cliente")) {
                    JOptionPane.showMessageDialog(this, "Los libros ya prestados no pueden ser eliminados",
                            "Error eliminar", JOptionPane.WARNING_MESSAGE);
                    seguir = false;
                    break;
                }
            }

            if (seguir) {
                int desicion = JOptionPane.showConfirmDialog(this,
                        "Seguro desea proceder con la operacion",
                        "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

                if (desicion == 0) {
                    for (int i = librosSeleccionados.length - 1; i >= 0; i--) {
                        fila = librosSeleccionados[i];
                        String isbn = String.valueOf(this.tablaLibros.getValueAt(fila, 0));
                        Libro libro = new Libro();
                        libro.setIsbn(isbn);

                        try {
                            archivoLibro.eliminarLibro(libro);
                            biblioteca.eliminarLibro(libro);
                            this.modeloTabla.removeRow(librosSeleccionados[i]);
                        } catch (ExcepcionArchivo e) {
                            JOptionPane.showMessageDialog(this, e.getMessage(),
                                    "Error datos", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    JOptionPane.showMessageDialog(this,
                            "Operacion exitosa",
                            "Eliminar libros", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked

        int[] librosSeleccionados = this.tablaLibros.getSelectedRows();
        if (librosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro por favor",
                    "Seleccionar libro", JOptionPane.WARNING_MESSAGE);
        } else if (librosSeleccionados.length > 1) {
            JOptionPane.showMessageDialog(this, "Solo se puede editar"
                    + " un libro a la vez",
                    "Error datos", JOptionPane.WARNING_MESSAGE);
        } else if (!this.modeloTabla.getValueAt(librosSeleccionados[0], 6).equals("Sin cliente")) {
            JOptionPane.showMessageDialog(this, "No se puede modificar "
                    + "un libro ya prestado",
                    "Error datos", JOptionPane.ERROR_MESSAGE);
        } else {

            this.modificar = true;
            int fila = librosSeleccionados[0];
            String[] data = new String[5];

            for (int i = 0; i < 5; i++) {
                data[i] = String.valueOf(this.modeloTabla.getValueAt(fila, i));
            }
            textIsbn.setText(data[0]);
            textTitulo.setText(data[1]);
            textEditorial.setText(data[2]);
            textYear.setText(data[3]);
            textAutor.setText(data[4]);

            this.panelPrincipal.setSelectedComponent(this.panelAgregar);
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed

        this.filtrarTabla(this.tablaLibros);
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked

        if (textIsbn.getText().equals("")
                && textTitulo.getText().equals("")
                && textEditorial.getText().equals("")
                && textYear.getText().equals("")
                && textAutor.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Sin informacion en los campos",
                    "Cancelar", JOptionPane.PLAIN_MESSAGE);

        } else {
            textIsbn.setText("");
            textTitulo.setText("");
            textEditorial.setText("");
            textYear.setText("");
            textAutor.setText("");

            if (this.modificar) {
                this.modificar = false;
                JOptionPane.showMessageDialog(this, "Modificacion cancelada",
                        "Cancelar", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Agregacion cancelada",
                        "Cancelar", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnPrestarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrestarMouseClicked
        int[] librosSeleccionados = this.tablaLibros.getSelectedRows();

        if (librosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione los libros a prestar",
                    "Pestar libro", JOptionPane.WARNING_MESSAGE);
        } else {

            boolean continuar = true;
            for (int i = librosSeleccionados.length - 1; i >= 0; i--) {
                if (!this.modeloTabla.getValueAt(librosSeleccionados[i], 6).equals("Sin cliente")) {
                    continuar = false;
                    break;
                }
            }

            if (!continuar) {
                JOptionPane.showMessageDialog(this, "Libro no valido para prestamo",
                        "Prestar", JOptionPane.WARNING_MESSAGE);
            } else {
                while (true) {
                    String cedula = JOptionPane.showInputDialog(this,
                            "Digite la cedula del cliente a prestar",
                            "Prestar libro", JOptionPane.PLAIN_MESSAGE);

                    if (cedula != null) {

                        try {
                            int cedulaCliente = Integer.parseInt(cedula);
                            Cliente auxCliente = new Cliente();
                            auxCliente.setCedula(cedulaCliente);

                            Cliente cliente = this.biblioteca.buscarCliente(auxCliente);

                            if (cliente != null) {
                                while (true) {
                                    String fr = JOptionPane.showInputDialog(this,
                                            "Digite la fecha de regreso (dd/MM/yyyy)",
                                            "Prestar libro", JOptionPane.PLAIN_MESSAGE);

                                    if (fr != null) {
                                        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        try {

                                            LocalDate fechaRegreso = LocalDate.parse(fr, formatoFecha);
                                            LocalDate fechaPrestamo = LocalDate.now();

                                            if (fechaRegreso.isBefore(fechaPrestamo)) {

                                                JOptionPane.showMessageDialog(this, "La fecha no es valida",
                                                        "Fecha invalida", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                ArrayList<Libro> listaLibros = new ArrayList<>();
                                                Libro auxLibro;

                                                for (int i = librosSeleccionados.length - 1; i >= 0; i--) {
                                                    int fila = librosSeleccionados[i];
                                                    String isbn = String.valueOf(this.modeloTabla.getValueAt(fila, 0));

                                                    auxLibro = new Libro();
                                                    auxLibro.setIsbn(isbn);
                                                    Libro libroBuscado = this.biblioteca.buscarLibro(auxLibro);
                                                    listaLibros.add(libroBuscado);
                                                }

                                                Prestamo prestamo = new Prestamo(cliente, listaLibros, fechaPrestamo, fechaRegreso);
                                                String mensaje = this.biblioteca.registrarPrestamo(prestamo);

                                                if (mensaje.equalsIgnoreCase("Prestamo guardado exitosamente")) {
                                                    int i = 0;
                                                    for (Libro libro : listaLibros) {

                                                        Object[] datosFila = {cliente.getCedula(), libro.getIsbn(),
                                                            fechaPrestamo.format(formatoFecha), fechaRegreso.format(formatoFecha)};
                                                        try {
                                                            this.archivoLibro.actualizarLibro(libro);
                                                            this.modeloTabla.setValueAt("Reservado", librosSeleccionados[i], 5);
                                                            this.modeloTabla.setValueAt(libro.getClienteAsociado().getCedula(), librosSeleccionados[i], 6);
                                                            PanelPrestamos.modeloTabla.addRow(datosFila);
                                                            i++;
                                                        } catch (ExcepcionArchivo ex) {
                                                            System.out.println(ex.getMessage());
                                                        }
                                                    }
                                                    this.archivoPrestamo.guardarPrestamo(prestamo);
                                                }
                                                JOptionPane.showMessageDialog(this, mensaje,
                                                        "Prestamo", JOptionPane.PLAIN_MESSAGE);

                                                break;
                                            }
                                        } catch (DateTimeParseException e) {
                                            JOptionPane.showMessageDialog(this,
                                                    "Formato de fecha invalido",
                                                    "Prestar libro", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(this,
                                        "Usuario no encontrado",
                                        "Pestar libro", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this,
                                    "Cedula invalida, intente nuevamente",
                                    "Pestar libro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_btnPrestarMouseClicked

    private void btnDevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDevolverMouseClicked
        int[] librosSeleccionados = this.tablaLibros.getSelectedRows();

        if (librosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione los libros a devolver",
                    "Devolver libro", JOptionPane.WARNING_MESSAGE);
        } else {

            int desicion = JOptionPane.showConfirmDialog(this, "Desea devolver los libros",
                    "Devolver libro", JOptionPane.YES_NO_OPTION);

            if (desicion == 0) {
                try {
                    int cedulaPrimaria = Integer.parseInt(String.valueOf(this.modeloTabla.getValueAt(
                            librosSeleccionados[0], 6)));
                    Cliente auxCliente = new Cliente();
                    auxCliente.setCedula(cedulaPrimaria);
                    Cliente clienteAtendido = this.biblioteca.buscarCliente(auxCliente);

                    ArrayList<Libro> librosDevolver = new ArrayList<>();
                    for (int i = librosSeleccionados.length - 1; i >= 0; i--) {
                        int fila = librosSeleccionados[i];
                        int cedula = Integer.parseInt(String.valueOf(this.modeloTabla.getValueAt(fila, 6)));

                        if (cedula != cedulaPrimaria) {
                            break;
                        }
                        String isbn = String.valueOf((this.modeloTabla.getValueAt(fila, 0)));
                        Libro auxLibro = new Libro();
                        auxLibro.setIsbn(isbn);
                        Libro libroDevolver = this.biblioteca.buscarLibro(auxLibro);
                        librosDevolver.add(libroDevolver);
                    }

                    if (librosSeleccionados.length == librosDevolver.size()) {
                        String mensaje = this.biblioteca.devolverLibros(clienteAtendido, librosDevolver);

                        int i = 0;
                        for (Libro libro : librosDevolver) {
                            try {
                                this.archivoLibro.actualizarLibro(libro);
                            } catch (ExcepcionArchivo ex) {
                                System.out.println("Error al actualizar");
                            }
                            this.modeloTabla.setValueAt("No reservado", librosSeleccionados[i], 5);
                            this.modeloTabla.setValueAt("Sin cliente", librosSeleccionados[i], 6);
                            i++;
                        }

                        Prestamo prestamoClienteAtendido = this.biblioteca.buscarPrestamo(clienteAtendido);
                        try {

                            if (prestamoClienteAtendido.getLibros().isEmpty()) {
                                this.biblioteca.eliminarPrestamo(prestamoClienteAtendido);
                                this.archivoPrestamo.eliminarPrestamo(prestamoClienteAtendido);
                            } else {
                                this.archivoPrestamo.actualizarPrestamo(prestamoClienteAtendido);
                            }
                        } catch (ExcepcionArchivo ex) {
                            System.out.println("Error al eliminar");
                        }

                        for (int j = PanelPrestamos.tablaPrestamos.getRowCount() - 1; j >= 0; j--) {
                            String isbnLibro = String.valueOf(PanelPrestamos.modeloTabla.getValueAt(j, 1));

                            for (int k = librosDevolver.size() - 1; k >= 0; k--) {
                                if (isbnLibro.equalsIgnoreCase(librosDevolver.get(k).getIsbn())) {
                                    PanelPrestamos.modeloTabla.removeRow(j);
                                    break;
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(this, mensaje,
                                "Devolver", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Error, algunos libros no pertenecen al "
                                + "primer cliente seleccionado",
                                "Devolver", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar libros con clientes reservados",
                            "Devolver", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDevolverMouseClicked

    private void filtrarTabla(JTable datos) {

        JTable tabla = datos;

        this.filtro = new TableRowSorter(tabla.getModel());
        tabla.setRowSorter(filtro);

        String filtrar = this.txtBusqueda.getText();
        this.filtro.setRowFilter(RowFilter.regexFilter(filtrar));
    }

    private void cargarDatos() {

        try {

            this.biblioteca.setLibros(archivoLibro.listarlibros());
            for (Libro lb : biblioteca.getLibros()) {

                String isbn = lb.getIsbn();
                String titulo = lb.getTitulo();
                String editorial = lb.getEditorial();
                int year = lb.getYearPublicacion();
                String autor = lb.getAutor();
                String estadoReserva = lb.getEstadoReserva()
                        ? "Reservado" : "No reservado";
                String cliente = lb.getClienteAsociado() == null
                        ? "Sin cliente" : String.valueOf(lb.getClienteAsociado().getCedula());

                Object[] datosFila = {isbn, titulo, editorial,
                    year, autor, estadoReserva, cliente};

                this.modeloTabla.addRow(datosFila);
                this.tablaLibros.setModel(modeloTabla);
            }
        } catch (ExcepcionArchivo e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error datos", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JPanel contenido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelEditorial;
    private javax.swing.JLabel labelIsbn;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelYear;
    private javax.swing.JLabel lbTituloAgregar;
    private javax.swing.JLabel lbTituloConsultar;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotones1;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelConsultar;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGrilla;
    private javax.swing.JTabbedPane panelPrincipal;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField textAutor;
    private javax.swing.JTextField textEditorial;
    private javax.swing.JTextField textIsbn;
    private javax.swing.JTextField textTitulo;
    private javax.swing.JTextField textYear;
    private javax.swing.JPanel tituloAgregar;
    private javax.swing.JPanel tituloConsultar;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
