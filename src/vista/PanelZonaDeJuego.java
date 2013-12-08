package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Posicion;
import modelo.Tablero;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

    private Image star;
    Timer timer;
    int  enX, enY, paso, distancia, cantidad, cantidadDePasos;

    private int x, y;
    private int radioClip = 60;
    private int largoDePanel = 610;
    private int anchoDePanel = 870;
    private int longitudManzana = 20;
    private Tablero tableroActual;
    private TransparentPanel zonaDeJuego;
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

        setDoubleBuffered(true);
        setFocusable(true);
        int posicionDelTableroX = (anchoDePanel - this.calcularAnchoPanelZonaDeJuego()) / 2;
        int posicionDelTableroY = (largoDePanel - this.calcularLargoPanelZonaDeJuego()) / 2;
        x = this.posicionInicialVehiculoEnX() + posicionDelTableroX + 2;
        y = largoDePanel - posicionDelTableroY - this.posicionInicialVehiculoEnY();
        cantidadDePasos = 0;
        paso = 2; // que cada pasa se mueva 2 pixeles
        distancia = 40; // distancia = anchoManzana
        cantidad = (distancia / paso);
        int velocidad = 1;
        timer = new Timer(velocidad, this);
        
        
        
        zonaDeJuego = new TransparentPanel(radioClip);
        this.add(zonaDeJuego);
    }

    public void paint(Graphics g) {
        System.out.println("paint");
        this.configurarTableroEnZonaDeJuego();
        if (dibujarTablero) {
            this.dibujarTablero();
            actionPerformed(null);
            cantidadDePasos = 0;
        }
        super.paint(g);
        Graphics2D grafico2D = (Graphics2D) g;
        grafico2D.drawImage(star, x, y, this.zonaDeJuego);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (cantidadDePasos < cantidad) {
            x = (x + 2 * enX);
            y = (y + 2 * enY);
            cantidadDePasos = cantidadDePasos + 1;
            zonaDeJuego.setClipPos(x-centrarEnX(), y-centrarEnY());
            repaint();
            //System.out.print("pintando");
        } else {
            timer.stop(); // paro de dibujar
            cantidadDePasos = 0;
        }
    }

    public void configurarTableroEnZonaDeJuego() {
        this.zonaDeJuego.setLayout(null);
        this.zonaDeJuego.setBounds(centrarEnX(), centrarEnY(), this.calcularAnchoPanelZonaDeJuego(), this.calcularLargoPanelZonaDeJuego());
        this.zonaDeJuego.setBackground(Color.lightGray);
    }

    public void dibujarTablero() {
        dibujarTablero = false;
        int constanteFila = 0;
        int constanteColumna = 1;
        int posicionX = 0;
        int posicionY = 0;
        System.out.println("Tamanio del tablero:" + tableroActual.getCantidadDeColumnas() + "," + tableroActual.getCantidadDeFilas());

        for (int i = 0; i < tableroActual.getCantidadDeColumnas() + 1; i++) {
            for (int j = 0; j < tableroActual.getCantidadDeFilas() + 1; j++) {
                posicionY = longitudManzana * (j + constanteFila);
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

    public JLabel crearUnaManzana(int posX, int posY) {
        JLabel manzana = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/manzana.png");
        manzana.setIcon(icono);
        manzana.setBounds(posX, posY, longitudManzana, longitudManzana);
        return manzana;
    }

    public void nuevaPosicion(int x, int y) {
        System.out.println("cantidadDePasos:" + cantidadDePasos);
        System.out.println("nuevaPosicion");
        if (!this.seEstaMoviendo()) {
            enX = x;
            enY = y;
            cantidadDePasos = 0;
            timer.start();
        }
    }

    public void girarHacia(String sentido) {
        if (!this.seEstaMoviendo()) {
            String direccion = "/vista/imagenes/" + vehiculo + "/" + vehiculo + sentido + ".png";
            ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
            star = imagenVehiculo.getImage();
            star = star.getScaledInstance(18, 18, 1);
        }
    }

    private boolean seEstaMoviendo() {
        if (cantidadDePasos == 13 || cantidadDePasos == 0) {
            return false;
        }
        return true;
    }

    public int centrarEnX() {
        if (((anchoDePanel - tableroActual.getCantidadDeColumnas() * longitudManzana * 2) / 2) < 0) {
            return 0;
        } else {
            return (anchoDePanel - tableroActual.getCantidadDeColumnas() * longitudManzana * 2) / 2;
        }
    }

    public int centrarEnY() {
        if (((largoDePanel - tableroActual.getCantidadDeFilas() * longitudManzana * 2 - longitudManzana * 2) / 2) < 0) {
            return 0;
        } else {
            return (this.largoDePanel - tableroActual.getCantidadDeFilas() * this.longitudManzana * 2 - longitudManzana * 2) / 2;
        }
    }

    public int posicionInicialVehiculoEnX() {
        int posicionInicialVehiculoEnX = this.posicionDeVehiculo.x();
        int nuevaPosicionX = longitudManzana + posicionInicialVehiculoEnX * 2 * longitudManzana;
        return nuevaPosicionX;
    }

    public int posicionInicialVehiculoEnY() {
        int posicionInicialVehiculoEnY = this.posicionDeVehiculo.y();
        int nuevaPosicionY = longitudManzana + posicionInicialVehiculoEnY * 2 * longitudManzana;
        return nuevaPosicionY;
    }

    public int calcularAnchoPanelZonaDeJuego() {
        int algo = this.tableroActual.getCantidadDeColumnas() * this.longitudManzana * 2 + this.longitudManzana;
        return algo;
    }

    public int calcularLargoPanelZonaDeJuego() {
        int algo = this.tableroActual.getCantidadDeFilas() * this.longitudManzana * 2 + this.longitudManzana;
        return algo;
    }
    
    //CLASE PARA EL CIRCULO CLIP
    public class TransparentPanel extends JPanel {
    	
    	private int x,y;
    	int radioClip;
    	
        public TransparentPanel(int radioClip) {
            setDoubleBuffered(true);
            setFocusable(true);
        	this.radioClip = radioClip;
        }
        
        public void setClipPos(int x, int y) {
        	this.x = x;
        	this.y = y;
        }
        
        public void paint(Graphics g) {        	
        	Graphics2D grafico2D = (Graphics2D) g;
        	int centroX = x-radioClip+9;
        	int centroY = y-radioClip+9;
        	Ellipse2D zona = new Ellipse2D.Double(centroX, centroY, radioClip*2, radioClip*2);
            grafico2D.setClip(new Area(zona));
            super.paint(g);
            g.dispose();
            grafico2D.dispose();
        }
    }
}
