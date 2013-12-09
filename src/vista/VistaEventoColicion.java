package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VistaEventoColicion extends JLabel {

    public VistaEventoColicion(String direccionImagen, int posX, int posY, int tamX, int tamY) {
        ImageIcon icono = new ImageIcon(direccionImagen);
        this.setIcon(icono);
        this.setBounds(posX, posY, tamX, tamY);
    }
}
