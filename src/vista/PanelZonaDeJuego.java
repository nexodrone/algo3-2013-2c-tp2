package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Tablero;
import control.MyKeyListener;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

    Image star;
    Timer timer;
    int x, y, enX, enY, distancia;

    private int largoDePanel;
    private int anchoDePanel;
    private Tablero tablero = new Tablero(10, 10);
    private JPanel zonaDeJuego = new JPanel();
    private String cadena;
    private Boolean dibujarTablero = true;
    int longitudManzana;

    public PanelZonaDeJuego(int ancho, int largo) {
        cadena = "moto";
        this.largoDePanel = largo;
        this.anchoDePanel = ancho;
        setBackground(Color.BLACK);
        KeyListener listener = new MyKeyListener(this);
        addKeyListener(listener);
        this.girarHacia("Derecha"); // por defecto el vehiculo siempre empieza mirando hacia la
                                    // derecha

        setDoubleBuffered(true);
        setFocusable(true);

        x = y = 10;
        int velocidad = 1;
        timer = new Timer(velocidad, this);
        // timer.start();
        zonaDeJuego.setVisible(false);
        this.add(zonaDeJuego);
        // this.configurarTablero();
        // this.dibujarTablero();
    }

    public void paint(Graphics g) {
        System.out.println("paint");
        this.configurarTablero();
        if (dibujarTablero) {
            this.dibujarTablero();
        }
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();

    }

    public void actionPerformed(ActionEvent e) {
        if (distancia < 40) {
            x = (x + 2 * enX);
            y = (y + 2 * enY);
            distancia = distancia + 1;
            repaint();
            System.out.print("pintando");
        } else {
            timer.stop(); // paro de dibujar
        }
    }

    public void dibujarTablero() {
        dibujarTablero = false;
        System.out.println("dibujarTablero");
        zonaDeJuego.setVisible(true);
        int constanteFila = 0;
        int constanteColumna = 1;
        int posicionX = 0;
        int posicionY = 0;
        longitudManzana = 40;

        for (int i = 0; i < tablero.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < tablero.getCantidadDeFilas(); j++) {
                posicionY = longitudManzana * (j + constanteFila);
                JLabel manzana = crearUnaManzana(posicionX, posicionY - 20, longitudManzana, longitudManzana);
                this.zonaDeJuego.add(manzana);
                constanteFila++;
            }
            constanteColumna++;
            posicionX = longitudManzana * (i + constanteColumna);
            posicionY = 0;
            constanteFila = 0;
        }
    }

    public void configurarTablero() {

        this.zonaDeJuego.setLayout(null);
        this.zonaDeJuego.setBounds(0, 0, anchoDePanel, largoDePanel);
        this.zonaDeJuego.setBackground(Color.black);
    }

    public JLabel crearUnaManzana(int posX, int posY, int ancho, int alto) {
        JLabel manzana = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/manzana.png");
        manzana.setIcon(icono);
        System.out.println("Posicion en X:" + posX);
        System.out.println("Posicion en Y:" + posY);
        System.out.println();
        manzana.setBounds(posX, posY, ancho, alto);
        return manzana;
    }

    int calcularLargoManzana() {
        // Tablero tablero = Juego.getInstance().getPartida().getTablero();
        return largoDePanel / (tablero.getCantidadDeFilas() * 2);
    }

    public int calcularAnchoManzana() {
        // Tablero tablero = Juego.getInstance().getPartida().getTablero();
        return anchoDePanel / (tablero.getCantidadDeColumnas() * 2);
    }

    public void nuevaPosicion(int x, int y) {
        enX = x;
        enY = y;
        distancia = 0;
        timer.start();
    }

    public void girarHacia(String sentido) {
        String direccion = "/vista/imagenes/" + cadena + "/" + cadena + sentido + ".png";
        System.out.println(direccion);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(direccion));
        star = ii.getImage();
    }
}
