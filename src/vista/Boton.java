package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {

    private static final long serialVersionUID = 1L;
    int tamX = 218;
    int tamY = 54;

    public Boton(int posX, int posY, String direccionIm, String nombre) {
        super(nombre);
        ImageIcon icono = new ImageIcon(direccionIm);
        this.setIcon(icono);
        this.setBounds(posX, posY, tamX, tamY);
    }
}
