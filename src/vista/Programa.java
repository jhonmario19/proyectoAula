package vista;


import com.formdev.flatlaf.FlatLightLaf;
import ventana.VentanaPrincipal;

public class Programa {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        VentanaPrincipal ventana = new VentanaPrincipal("Biblioteca");
        ventana.setVisible(true);
    }
}
