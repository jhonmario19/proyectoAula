package ventana;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Biblioteca;
import paneles.PanelClientes;
import paneles.PanelInicio;
import paneles.PanelLibros;
import paneles.PanelPrestamos;

public class VentanaPrincipal extends JFrame {

    //Adaptadores para usar los eventos que se encuentran al final
    MouseAdapter eventoOpciones = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent evt) {
            efectoOpciones(evt);
        }

        @Override
        public void mouseExited(MouseEvent evt) {
            efectoOpciones(evt);
        }

        @Override
        public void mouseClicked(MouseEvent evt) {
            cambioPaneles(evt);
        }
    };

    MouseAdapter eventoPaneles = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent evt) {
            efectoOpciones(evt);
        }

        @Override
        public void mouseExited(MouseEvent evt) {
            efectoOpciones(evt);
        }
    };

    //Paneles que controlan el contenido
    private JPanel panelOpciones, panelPrincipal;

    //Paneles donde interactuamos con los datos
    private PanelLibros panelLibros;
    private PanelClientes panelCLientes;
    private PanelPrestamos panelPrestamos;
    private PanelInicio panelInicio;

    //Propiedades de posicionamiento del JFrame
    private GridBagConstraints propiedades;

    //Opcines del sistema
    private JLabel opciones[];
    private String[] txtOpciones = {"Inicio", "Libros", "Clientes", "Prestamos"};
    
    //Objeto que imita la biblioteca
    private Biblioteca biblioteca;

    public VentanaPrincipal(String titulo) {

        this.setTitle(titulo);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);

        this.propiedades = new GridBagConstraints();
        this.propiedades.gridy = 0;
        this.propiedades.weighty = 1.0;
        this.propiedades.fill = GridBagConstraints.BOTH;
        
        iniciarComponentes();

        this.setLocationRelativeTo(null);
    }

    //Llamado a iniciar los componentes
    private void iniciarComponentes() {
        this.getContentPane().setLayout(new GridBagLayout());

        this.opciones = new JLabel[4];
        
        this.biblioteca = new Biblioteca();
        this.panelInicio = new PanelInicio();
        this.panelLibros = new PanelLibros(this.biblioteca);
        this.panelCLientes = new PanelClientes(this.biblioteca);
        this.panelPrestamos = new PanelPrestamos(this.biblioteca);

        iniciarPanelOpciones();
        iniciarPanelPrincipal();
    }

    //Crea el panel de opciones y le añade contenido
    private void iniciarPanelOpciones() {

        GridBagConstraints propiedadesOpciones = new GridBagConstraints();
        propiedadesOpciones.gridx = 0;
        propiedadesOpciones.gridy = 0;
        propiedadesOpciones.insets = new Insets(30, 30, 30, 30);

        ImageIcon image = new ImageIcon("src/imagenes/logoOpciones.png");
        JLabel imagenOpciones = new JLabel(image);

        this.panelOpciones = new JPanel();
        this.panelOpciones.setLayout(new GridBagLayout());
        this.panelOpciones.setBackground(new Color(42, 43, 42));
        this.panelOpciones.add(imagenOpciones, propiedadesOpciones);

        this.propiedades.gridx = 0;

        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new BoxLayout(panelLabels, BoxLayout.Y_AXIS));
        panelLabels.setBackground(new Color(42, 43, 42));

        propiedadesOpciones.gridy = 1;
        propiedadesOpciones.insets = new Insets(0, 0, 0, 0);
        propiedadesOpciones.fill = GridBagConstraints.BOTH;
        propiedadesOpciones.weightx = 1.0;
        propiedadesOpciones.weighty = 1.0;

        this.panelOpciones.add(panelLabels, propiedadesOpciones);

        panelLabels.add(Box.createVerticalStrut(100));
        for (int i = 0; i < txtOpciones.length; i++) {

            this.opciones[i] = new JLabel(txtOpciones[i]);
            this.opciones[i].setFont(new Font("Serif", Font.PLAIN, 20));
            this.opciones[i].setForeground(Color.WHITE);
            this.opciones[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
            this.opciones[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            this.opciones[i].addMouseListener(eventoOpciones);

            panelLabels.add(this.opciones[i]);
            panelLabels.add(Box.createVerticalStrut(10));
        }
        this.panelOpciones.addMouseListener(eventoPaneles);
        this.add(this.panelOpciones, this.propiedades);
    }
    //Crea el panel principal y le añade los paneles que en el se van a mostrar
    private void iniciarPanelPrincipal() {
        
        this.panelPrincipal = new JPanel(new CardLayout());
        this.panelPrincipal.add(this.panelInicio, "Panel inicio");
        this.panelPrincipal.add(this.panelLibros, "Panel libros");
        this.panelPrincipal.add(this.panelCLientes, "Panel clientes");
        this.panelPrincipal.add(this.panelPrestamos, "Panel prestamos");

        this.propiedades.gridx = 1;
        this.propiedades.weightx = 1.0;
        this.panelPrincipal.addMouseListener(eventoPaneles);
        this.add(this.panelPrincipal, this.propiedades);
    }

    /*Efectos de entrada y salida en las letras (actuan como botones)
    este metodo tambien se usa en los paneles*/
    private void efectoOpciones(MouseEvent e) {

        for (JLabel label : this.opciones) {
            if (e.getSource() == label) {
                label.setFont(new Font("Serif", Font.PLAIN, 25));
            } else {
                label.setFont(new Font("Serif", Font.PLAIN, 20));
            }
        }
    }

    //Evento para cambiar entre los distintos paneles
    private void cambioPaneles(MouseEvent e) {
        CardLayout layoutPrincipal = (CardLayout) this.panelPrincipal.getLayout();
        
        if(e.getSource() == this.opciones[0]) {
            layoutPrincipal.show(this.panelPrincipal, "Panel inicio");
        }else if (e.getSource() == this.opciones[1]) {
            layoutPrincipal.show(this.panelPrincipal, "Panel libros");
        } else if (e.getSource() == this.opciones[2]) {
            layoutPrincipal.show(this.panelPrincipal, "Panel clientes");
        } else if (e.getSource() == this.opciones[3]) {
            layoutPrincipal.show(this.panelPrincipal, "Panel prestamos");
        }
    }
}
