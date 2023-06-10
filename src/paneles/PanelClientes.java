package paneles;

import archivos.ArchivoCliente;
import excepciones.ExcepcionArchivo;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Biblioteca;
import modelo.Cliente;
import modelo.Prestamo;
import personalizacion.ColorRowRenderer;

public class PanelClientes extends javax.swing.JPanel {

    private ArchivoCliente archivoCliente;
    private DefaultTableModel modeloTabla;
    private boolean modificar;
    private TableRowSorter filtro;
    private Biblioteca biblioteca;

    ColorRowRenderer renderTabla;

    public PanelClientes(Biblioteca biblioteca) {
        initComponents();

        this.modeloTabla = (DefaultTableModel) this.tablaClientes.getModel();
        this.modificar = false;

        renderTabla = new ColorRowRenderer();
        this.tablaClientes.setDefaultRenderer(Object.class, renderTabla);
        this.tablaClientes.setShowGrid(true);
        this.tablaClientes.setGridColor(Color.LIGHT_GRAY);

        this.biblioteca = biblioteca;
        this.archivoCliente = new ArchivoCliente("clientes.txt");

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
        labelCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        labelEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
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
        tablaClientes = new javax.swing.JTable();
        panelBotones1 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 515));
        setLayout(new java.awt.GridLayout(1, 0));

        panelAgregar.setPreferredSize(new java.awt.Dimension(900, 800));
        panelAgregar.setLayout(new javax.swing.BoxLayout(panelAgregar, javax.swing.BoxLayout.Y_AXIS));

        tituloAgregar.setPreferredSize(new java.awt.Dimension(793, 100));

        lbTituloAgregar.setFont(new java.awt.Font("Noto Sans", 0, 40)); // NOI18N
        lbTituloAgregar.setText("Agregar Cliente");
        tituloAgregar.add(lbTituloAgregar);

        panelAgregar.add(tituloAgregar);

        contenido.setPreferredSize(new java.awt.Dimension(793, 500));
        contenido.setLayout(new javax.swing.BoxLayout(contenido, javax.swing.BoxLayout.Y_AXIS));

        panelDatos.setPreferredSize(new java.awt.Dimension(399, 200));
        panelDatos.setLayout(new java.awt.GridBagLayout());

        panelGrilla.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos cliente"));
        panelGrilla.setMaximumSize(new java.awt.Dimension(100, 100));
        panelGrilla.setLayout(new java.awt.GridBagLayout());

        labelCedula.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCedula.setText("Cedula:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelCedula, gridBagConstraints);

        txtCedula.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(txtCedula, gridBagConstraints);

        labelNombre.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelNombre, gridBagConstraints);

        txtNombre.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(txtNombre, gridBagConstraints);

        labelDireccion.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDireccion.setText("Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelDireccion, gridBagConstraints);

        txtDireccion.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(txtDireccion, gridBagConstraints);

        labelEdad.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEdad.setText("Edad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 0);
        panelGrilla.add(labelEdad, gridBagConstraints);

        txtEdad.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 35);
        panelGrilla.add(txtEdad, gridBagConstraints);

        labelTelefono.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        labelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTelefono.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 10, 0);
        panelGrilla.add(labelTelefono, gridBagConstraints);

        txtTelefono.setPreferredSize(new java.awt.Dimension(150, 27));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 10, 35);
        panelGrilla.add(txtTelefono, gridBagConstraints);

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
        tituloConsultar.setLayout(new java.awt.GridLayout(1, 0));

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

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Direccion", "Edad", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setShowHorizontalLines(true);
        tablaClientes.setShowVerticalLines(true);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaClientes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 31, 3, 31);
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

        panelConsultar.add(panelBotones1);

        panelPrincipal.addTab("Consultar", panelConsultar);

        add(panelPrincipal);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        int[] librosSeleccionados = this.tablaClientes.getSelectedRows();

        if (librosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente a "
                    + "eliminar", "Eliminar", JOptionPane.WARNING_MESSAGE);
        } else {

            boolean seguir = true;

            for (int i = librosSeleccionados.length - 1; i >= 0; i--) {

                int fila = librosSeleccionados[i];
                int cedula = (int) this.modeloTabla.getValueAt(fila, 0);
                Cliente auxCliente = new Cliente();
                auxCliente.setCedula(cedula);

                Prestamo prestamo = this.biblioteca.buscarPrestamo(auxCliente);
                if (prestamo != null) {
                    seguir = false;
                    break;
                }
            }

            if (!seguir) {
                JOptionPane.showMessageDialog(this,
                        "Error, ya los clientes tienen prestamos",
                        "Eliminar clientes", JOptionPane.ERROR_MESSAGE);
            } else {
                int desicion = JOptionPane.showConfirmDialog(this,
                        "Seguro desea proceder con la operacion",
                        "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

                if (desicion == 0) {
                    for (int i = librosSeleccionados.length - 1; i >= 0; i--) {

                        int fila = librosSeleccionados[i];
                        int cedula = Integer.parseInt(String.valueOf(this.tablaClientes.getValueAt(fila, 0)));
                        Cliente cliente = new Cliente();
                        cliente.setCedula(cedula);

                        try {
                            archivoCliente.eliminarCliente(cliente);
                            biblioteca.eliminarCliente(cliente);
                            this.modeloTabla.removeRow(librosSeleccionados[i]);

                            JOptionPane.showMessageDialog(this,
                                    "Operacion exitosa",
                                    "Eliminar clientes", JOptionPane.PLAIN_MESSAGE);
                        } catch (ExcepcionArchivo e) {
                            JOptionPane.showMessageDialog(this, e.getMessage(),
                                    "Error datos", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked

        int[] librosSeleccionados = this.tablaClientes.getSelectedRows();

        if (librosSeleccionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente por favor",
                    "Seleccionar cliente", JOptionPane.WARNING_MESSAGE);
        } else if (librosSeleccionados.length > 1) {
            JOptionPane.showMessageDialog(this, "Solo se puede editar"
                    + " un cliente a la vez",
                    "Error datos", JOptionPane.WARNING_MESSAGE);
        } else {

            this.modificar = true;
            int fila = librosSeleccionados[0];
            String[] data = new String[5];

            for (int i = 0; i < 5; i++) {
                data[i] = String.valueOf(this.modeloTabla.getValueAt(fila, i));
            }
            txtCedula.setText(data[0]);
            txtNombre.setText(data[1]);
            txtDireccion.setText(data[2]);
            txtEdad.setText(data[3]);
            txtTelefono.setText(data[4]);

            this.panelPrincipal.setSelectedComponent(this.panelAgregar);
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        if (txtCedula.getText().equals("")
                && txtNombre.getText().equals("")
                && txtDireccion.getText().equals("")
                && txtEdad.getText().equals("")
                && txtTelefono.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Sin informacion en los campos",
                    "Cancelar", JOptionPane.PLAIN_MESSAGE);

        } else {
            txtCedula.setText("");
            txtNombre.setText("");
            txtDireccion.setText("");
            txtEdad.setText("");
            txtTelefono.setText("");

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

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        //Verificar que los cambos esten llenos
        if (txtCedula.getText().equals("")
                || txtNombre.getText().equals("")
                || txtDireccion.getText().equals("")
                || txtEdad.getText().equals("")
                || txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Datos vacios, por favor verifique los campos",
                    "Error guardar", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();

            //Evitar que el formato del año sea incorrecto
            try {

                int cedula = Integer.parseInt(txtCedula.getText());
                byte edad = Byte.parseByte(txtEdad.getText());
                long telefono = Long.parseLong(txtTelefono.getText());

                int desicion = JOptionPane.showConfirmDialog(this,
                        "Seguro desea registrar el cliente",
                        "Confirmacion", JOptionPane.YES_NO_OPTION);

                if (desicion == 0) {
                    Cliente cliente = new Cliente(cedula, nombre, direccion, edad, telefono);
                    Object[] datosFila = {cedula, nombre, direccion,
                        edad, telefono};
                    String mensaje;

                    if (this.modificar) {

                        mensaje = this.biblioteca.modificarCliente(cliente);
                        if (mensaje.equalsIgnoreCase("Cliente modificado exitosamente")) {
                            try {

                                archivoCliente.actualizarCliente(cliente);
                                int[] clientesSeleccionados = this.tablaClientes.getSelectedRows();
                                int fila = clientesSeleccionados[0];

                                for (int i = 0; i < this.tablaClientes.getColumnCount(); i++) {
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
                        mensaje = biblioteca.registrarCliente(cliente);
                        if (mensaje.equalsIgnoreCase("Se ha agregado un nuevo cliente con cedula " + cedula)) {
                            archivoCliente.guardarCliente(cliente);
                            this.modeloTabla.addRow(datosFila);
                            this.tablaClientes.setModel(modeloTabla);
                        }
                        JOptionPane.showMessageDialog(this, mensaje,
                                "Operacion registrar", JOptionPane.PLAIN_MESSAGE);
                    }

                    if (mensaje.equalsIgnoreCase("Se ha agregado un nuevo cliente con cedula " + cedula)
                            || mensaje.equalsIgnoreCase("Cliente modificado exitosamente")) {
                        txtCedula.setText("");
                        txtNombre.setText("");
                        txtDireccion.setText("");
                        txtEdad.setText("");
                        txtTelefono.setText("");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Edad, cedula o telefono son incorrectos",
                        "Error guardar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed

        this.filtrarTabla(this.tablaClientes);
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void filtrarTabla(JTable datos) {

        JTable tabla = datos;

        this.filtro = new TableRowSorter(tabla.getModel());
        tabla.setRowSorter(filtro);

        String filtrar = this.txtBusqueda.getText();
        this.filtro.setRowFilter(RowFilter.regexFilter(filtrar));
    }

    private void cargarDatos() {

        try {

            this.biblioteca.setClientes(archivoCliente.listarClientes());
            for (Cliente cliente : biblioteca.getClientes()) {

                int cedula = cliente.getCedula();
                String nombre = cliente.getNombre();
                String direccion = cliente.getDireccion();
                byte edad = cliente.getEdad();
                Long telefono = cliente.getTelefono();

                Object[] datosFila = {cedula, nombre, direccion,
                    edad, telefono};

                this.modeloTabla.addRow(datosFila);
                this.tablaClientes.setModel(modeloTabla);
            }
        } catch (ExcepcionArchivo e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel contenido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
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
    private javax.swing.JTable tablaClientes;
    private javax.swing.JPanel tituloAgregar;
    private javax.swing.JPanel tituloConsultar;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
