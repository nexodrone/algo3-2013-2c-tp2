package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Posicion;
import modelo.Tablero;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

    private Image star;
    Timer timer;
    int x, y, enX, enY, paso, distancia, cantidad, cantidadDePasos;

    private int largoDePanel = 570;
    private int anchoDePanel = 830;
    private int longitudManzana = 20;
    private Tablero tableroActual;
    private JPanel zonaDeJuego = new JPanel();
    private String vehiculo;
    private Posicion posicionDeVehiculo;
    private Boolean dibujarTablero = true; // PARA QUE EL TABLERO SE DIBUJE SOLO UNA VEZ

    public PanelZonaDeJuego(Tablero tablero, String vehiculoSeleccionado, Posicion posicion) {
        this.tableroActual = tablero;
        this.posicionDeVehiculo = posicion;
        vehiculo = vehiculoSeleccionado;
        setBackground(Color.BLACK);
        this.girarHacia("Derecha"); // por defecto el vehiculo siempre empieza mirando hacia
                                    // laderecha

        // this.addMouseListener(this.zonaDeJuego);
        setDoubleBuffered(true);
        setFocusable(true);
        int posicionDelTableroX = (anchoDePanel - this.calcularAnchoPanelZonaDeJuego()) / 2;
        int posicionDelTableroY = (largoDePanel - this.calcularLargoPanelZonaDeJuego()) / 2;
        x = this.posicionInicialVehiculoEnX() + posicionDelTableroX;
        y = largoDePanel - posicionDelTableroY - this.posicionInicialVehiculoEnY();

        // System.out.println("Posicion del vehiculo:("this.);
        paso = 2; // que cada pasa se mueva 2 pixeles
        distancia = 20; // distancia = anchoManzana
        cantidad = (distancia / paso);
        int velocidad = 1;
        timer = new Timer(velocidad, this);
        this.add(zonaDeJuego);
    }

    public void paint(Graphics g) {
        System.out.println("paint");
        this.configurarTableroEnZonaDeJuego();
        if (dibujarTablero) {
            this.dibujarTablero();
        }
        super.paint(g);
        Graphics2D grafico2D = (Graphics2D) g;
        System.out.println("Posicion que llega en paint:" + x + "," + y);
        grafico2D.drawImage(star, x, y, this.zonaDeJuego);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (cantidadDePasos < cantidad) {
            x = (x + 2 * enX);
            y = (y + 2 * enY);
            cantidadDePasos = cantidadDePasos + 1;
            repaint();
            System.out.print("pintando");
        } else {
            timer.stop(); // paro de dibujar
        }
    }

    public void configurarTableroEnZonaDeJuego() {
        this.zonaDeJuego.setLayout(null);
        System.out.print("Centra el tablero:" + centrarEnX() + "," + centrarEnY());
        // System.out.print(centrarEnX()+","+);
        this.zonaDeJuego.setBounds(centrarEnX(), centrarEnY(), this.calcularAnchoPanelZonaDeJuego(), this.calcularLargoPanelZonaDeJuego());
        this.zonaDeJuego.setBackground(Color.green);
    }

    public void dibujarTablero() {
        dibujarTablero = false;
        int constanteFila = 0;
        int constanteColumna = 1;
        int posicionX = 0;
        int posicionY = 0;
        System.out.println("Tamanio del tablero:" + tableroActual.getCantidadDeColumnas() + "," + tableroActual.getCantidadDeFilas());

        for (int i = 0; i < tableroActual.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < tableroActual.getCantidadDeFilas(); j++) {
                posicionY = longitudManzana * (j + constanteFila);
                System.out.println("Posicion Manzana:" + posicionX + "," + posicionY);
                JLabel manzana = crearUnaManzana(posicionX, posicionY);
                this.zonaDeJuego.add(manzana);
                constanteFila++;
            }
            constanteColumna++;
            posicionX = longitudManzana * (i + constanteColumna);
            posicionY = 0;
            constanteFila = 0;
        }
    }

    /*
     * ESTE METODO ANDA MAL public void dibujarTablero2() { dibujarTablero = false;
     * System.out.println("dibujarTablero"); zonaDeJuego.setVisible(true); int posicionCuadraX = 0;
     * int posicionCuadraY = 0; int posicionTableroX = 0; int posicionTableroY = 0; int
     * longitudCuadra = 60; int anchoCalle = 30; int distancia = longitudCuadra + anchoCalle;
     * 
     * for (int i = 0; i < tablero.getCantidadDeColumnas(); i++) { for (int j = 0; j <
     * tablero.getCantidadDeFilas(); j++) { posicionCuadraY = (distancia) * j + posicionTableroX;
     * posicionCuadraX = (distancia) * i + posicionTableroY; JLabel manzana =
     * crearUnaManzana(posicionCuadraX, posicionCuadraY, longitudCuadra, longitudCuadra);
     * this.zonaDeJuego.add(manzana); } } }
     */

    public JLabel crearUnaManzana(int posX, int posY) {
        JLabel manzana = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/manzana.png");
        manzana.setIcon(icono);
        manzana.setBounds(posX, posY, longitudManzana, longitudManzana);
        return manzana;
    }

    public void nuevaPosicion(int x, int y) {
        enX = x;
        enY = y;
        distancia = 0;
        timer.start();
    }

    public void girarHacia(String sentido) {
        String direccion = "/vista/imagenes/" + vehiculo + "/" + vehiculo + sentido + ".png";
        System.out.print(direccion);
        ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
        star = imagenVehiculo.getImage();
        star = star.getScaledInstance(15, 15, 1);
    }

    public int centrarEnX() {
        if (((anchoDePanel - tableroActual.getCantidadDeColumnas() * longitudManzana * 2) / 2) < 0) {
            return 0;
        } else {
            return (anchoDePanel - tableroActual.getCantidadDeColumnas() * longitudManzana * 2) / 2;
        }
    }

    public int centrarEnY() {
        if (((largoDePanel - tableroActual.getCantidadDeFilas() * longitudManzana * 2) / 2) < 0) {
            return 0;
        } else {
            return (this.largoDePanel - tableroActual.getCantidadDeFilas() * this.longitudManzana * 2) / 2;
        }
    }

    public int posicionInicialVehiculoEnX() {
        // int posicionInicialVehiculoEnX = this.posicionDeVehiculo.x();
        int posicionInicialVehiculoEnX = 0;
        System.out.print("Posicion en X:");
        System.out.print(posicionInicialVehiculoEnX);
        int nuevaPosicionX = longitudManzana + posicionInicialVehiculoEnX * 2 * longitudManzana;
        System.out.print("posicion vehiculo vista en x:");
        x = nuevaPosicionX;
        System.out.println(nuevaPosicionX);
        return nuevaPosicionX;

    }

    public int posicionInicialVehiculoEnY() {
        // int posicionInicialVehiculoEnY = this.posicionDeVehiculo.y();
        int posicionInicialVehiculoEnY = 0;
        System.out.println("Posicion en Y:");
        System.out.print(posicionInicialVehiculoEnY);
        int nuevaPosicionY = longitudManzana + posicionInicialVehiculoEnY * 2 * longitudManzana;
        System.out.print("posicion vehiculo vista en y:");
        System.out.println(nuevaPosicionY);
        // y = nuevaPosicionY;
        // nuevaPosicionY = this.largoDePanel - nuevaPosicionY;
        return nuevaPosicionY;
    }

    public int calcularAnchoPanelZonaDeJuego() {
        int algo = this.tableroActual.getCantidadDeColumnas() * this.longitudManzana * 2;
        System.out.println("Tamanio de la zona Juego x:" + algo);
        return algo;
    }

    public int calcularLargoPanelZonaDeJuego() {
        int algo = this.tableroActual.getCantidadDeFilas() * this.longitudManzana * 2;
        System.out.println("Tamanio de la zona Juego y:" + algo);
        return algo;
    }
}
