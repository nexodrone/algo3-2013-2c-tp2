package vista;

import java.awt.Dimension;
import javax.swing.JButton;

public class Boton extends JButton {

	private Dimension dimension = new Dimension(200,30);

    public Boton(String texto) {
        super(texto);
        this.setMaximumSize(dimension);
    }
}
