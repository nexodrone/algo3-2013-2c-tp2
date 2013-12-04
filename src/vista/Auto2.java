package vista;

import javax.swing.JFrame;

public class Auto2 extends JFrame {

    PanelZonaDeJuego board;
    int largoDeVentana = 570;
    int anchoDeVentana = 830;

    public Auto2() {

        board = new PanelZonaDeJuego();
        this.setBounds(0, 0,anchoDeVentana,largoDeVentana);
        this.add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Star");
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Auto2();
    }

}