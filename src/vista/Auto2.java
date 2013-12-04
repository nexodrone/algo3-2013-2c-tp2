package vista;

import javax.swing.JFrame;

import modelo.Tablero;

public class Auto2 extends JFrame {

    PanelZonaDeJuego board;
    int largoDeVentana = 570;
    int anchoDeVentana = 830;

    public Auto2() {
    	Tablero tablero = new Tablero(20,14);
        board = new PanelZonaDeJuego(tablero);
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