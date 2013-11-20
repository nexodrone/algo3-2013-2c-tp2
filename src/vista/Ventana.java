package vista;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana() {
        super("GPS Challenge");
        this.setSize(400, 200); // tamanio
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // se cierra cuando haces click en la
                                                             // cruz
        this.setVisible(true); // visibilidad
    }

    public static void main(String[] arguments) {
        Ventana ventana = new Ventana();

    }
}
