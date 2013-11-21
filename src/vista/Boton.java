package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boton extends JButton {
    int tamX = 218;
    int tamY = 54;

    public Boton(int posX, int posY, String direccionIm, String nombre) {
        super(nombre);
        ImageIcon icono = new ImageIcon(direccionIm);
        thissetIcon(icono);
        this.setBounds(posX, posY, tamX, tamY);
    }
}
