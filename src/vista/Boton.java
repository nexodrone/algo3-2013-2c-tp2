package vista;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {

	private Dimension dimension = new Dimension(200,30);

    public Boton(String texto) {
        super(texto);
        
        ImageIcon icono = new ImageIcon("src/vista/imagenes/btn.png");
        this.setIcon(icono);
        
        ImageIcon iconoRoll = new ImageIcon("src/vista/imagenes/btn_roll.png");
        this.setRolloverIcon(iconoRoll);
        
        ImageIcon iconoPress = new ImageIcon("src/vista/imagenes/btn_press.png");
        this.setPressedIcon(iconoPress);
        
        this.setBorderPainted(false);
        
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
    }
}
