package vista;

import javax.swing.JFrame;

public class Auto2 extends JFrame {

    PanelZonaDeJuego board;
    int largoDeVentana = 1000;
    int anchoDeVentana = 1000;

    public Auto2() {

        board = new PanelZonaDeJuego();

        this.setBounds(0, 0, 1000, 1000);
        this.add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(1000, largoDeVentana);
        setLocationRelativeTo(null);
        setTitle("Star");
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Auto2();
    }

}