package paneles;

import archivos.ArchivoPrestamo;
import excepciones.ExcepcionArchivo;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Biblioteca;
import modelo.Libro;
import modelo.Prestamo;
import personalizacion.ColorRowRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class PanelPrestamos extends javax.swing.JPanel {

    ArchivoPrestamo archivoPrestamo;
    private TableRowSorter filtro;
    private Biblioteca biblioteca;

    public static DefaultTableModel modeloTabla;
    ColorRowRenderer renderTabla;

    public PanelPrestamos(Biblioteca biblioteca) {
        initComponents();

        PanelPrestamos.modeloTabla = (DefaultTableModel) PanelPrestamos.tablaPrestamos.getModel();
        PanelPrestamos.tablaPrestamos.setShowGrid(true);
        PanelPrestamos.tablaPrestamos.setGridColor(Color.LIGHT_GRAY);

        renderTabla = new ColorRowRenderer();
        PanelPrestamos.tablaPrestamos.setDefaultRenderer(Object.class, renderTabla);
        this.biblioteca = biblioteca;
        this.archivoPrestamo = new ArchivoPrestamo("prestamos.txt");
        
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tituloConsultar = new javax.swing.JPanel();
        lbTituloConsultar = new javax.swing.JLabel();
        panelBusqueda = new javax.swing.JPanel();
        labelBuscar = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        tituloConsultar.setPreferredSize(new java.awt.Dimension(793, 80));
        tituloConsultar.setLayout(new java.awt.GridLayout(1, 0));

        lbTituloConsultar.setFont(new java.awt.Font("Noto Sans", 0, 40)); // NOI18N
        lbTituloConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloConsultar.setText("Prestamos");
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

        add(tituloConsultar);

        panelTabla.setPreferredSize(new java.awt.Dimension(652, 390));
        panelTabla.setLayout(new java.awt.GridBagLayout());

        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Libro", "Fecha prestamo", "Fecha regreso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPrestamos.setShowHorizontalLines(true);
        tablaPrestamos.setShowVerticalLines(true);
        tablaPrestamos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaPrestamos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 53, 40);
        panelTabla.add(jScrollPane1, gridBagConstraints);

        add(panelTabla);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed

        this.filtrarTabla(PanelPrestamos.tablaPrestamos);
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
            this.biblioteca.setPrestamos(archivoPrestamo.listarPrestamos());
            for (Prestamo pt : this.biblioteca.getPrestamos()) {
                String cliente = String.valueOf(pt.getCliente().getCedula());

                ArrayList<String> isbnLibros = new ArrayList<>();
                for (Libro libro : pt.getLibros()) {
                    isbnLibros.add(libro.getIsbn());
                }
                
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaPrestamo = pt.getFechaPrestamo().format(formatoFecha);
                String fechaRegreso = pt.getFechaRegreso().format(formatoFecha);

                for (int i = 0; i < isbnLibros.size(); i++) {
                    Object[] datosFila = {cliente, isbnLibros.get(i), fechaPrestamo, fechaRegreso};
                    PanelPrestamos.modeloTabla.addRow(datosFila);
                    PanelPrestamos.tablaPrestamos.setModel(modeloTabla);
                }
            }
        } catch (ExcepcionArchivo e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel lbTituloConsultar;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelTabla;
    public static javax.swing.JTable tablaPrestamos;
    private javax.swing.JPanel tituloConsultar;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
