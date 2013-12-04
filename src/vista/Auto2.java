package vista;

import javax.swing.JFrame;

public class Auto2 extends JFrame {

    PanelZonaDeJuego board;
    int largoDeVentana = 500;
    int anchoDeVentana = 500;

    public Auto2() {

        board = new PanelZonaDeJuego(largoDeVentana, anchoDeVentana);

        this.setBounds(0, 0, anchoDeVentana, largoDeVentana);
        this.add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(anchoDeVentana, largoDeVentana);
        setLocationRelativeTo(null);
        setTitle("Star");
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Auto2();
    }

}