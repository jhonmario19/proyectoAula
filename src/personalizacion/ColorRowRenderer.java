package personalizacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorRowRenderer extends DefaultTableCellRenderer {
    private static final Color HIGHLIGHT_COLOR = Color.BLUE; // Color de resaltado deseado

    public ColorRowRenderer() {
        setHorizontalAlignment(CENTER); // Alinear el texto al centro
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verificar si la fila está seleccionada o si tiene el foco
        if (isSelected || hasFocus) {
            c.setBackground(HIGHLIGHT_COLOR);
        } else {
            c.setBackground(table.getBackground());
        }

        return c;
    }
}

