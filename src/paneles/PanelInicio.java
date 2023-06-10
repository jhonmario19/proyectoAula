package paneles;

import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicio extends JPanel{
    
    private final JLabel bienvenido;
    public PanelInicio() {
        super(new GridBagLayout());
        this.bienvenido = new JLabel("Bienvenido");
        this.bienvenido.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.bienvenido.setFont(new Font("Serif", Font.PLAIN, 100));
        this.add(bienvenido);
    }
}
