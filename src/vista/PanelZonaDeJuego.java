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

import modelo.Tablero;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

	private Image star;
    Timer timer;
    int x, y, enX, enY, distancia;

    private int largoDePanel = 570;
    private int anchoDePanel = 830;
    private int longitudManzana = 20;
    private Tablero tableroActual;
    private JPanel zonaDeJuego = new JPanel();
    private String vehiculo;
    private Boolean dibujarTablero = true; //PARA QUE EL TABLERO SE DIBUJE SOLO UNA VEZ
  

    public PanelZonaDeJuego(Tablero tablero,String vehiculoSeleccionado) {
        this.tableroActual = tablero;
    	vehiculo =vehiculoSeleccionado;
        setBackground(Color.BLACK);
        this.girarHacia("Derecha"); // por defecto el vehiculo siempre empieza mirando hacia laderecha
        setDoubleBuffered(true);
        setFocusable(true);
        x = y = 10;
        int velocidad = 1;
        timer = new Timer(velocidad, this);
        this.add(zonaDeJuego);
    }

    public void paint(Graphics g) {
        //System.out.println("paint");
        this.configurarTableroEnZonaDeJuego();
        if (dibujarTablero) {
            this.dibujarTablero();
        }
        super.paint(g);
        Graphics2D grafico2D = (Graphics2D) g;
        grafico2D.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (distancia < 40) {
            x = (x + 2 * enX);
            y = (y + 2 * enY);
            distancia = distancia + 1;
            repaint();
            //System.out.print("pintando");
        } else {
            timer.stop(); // paro de dibujar
        }
    }

    public void configurarTableroEnZonaDeJuego() {
        this.zonaDeJuego.setLayout(null);
        this.zonaDeJuego.setBounds(centrarEnX(),centrarEnY(), anchoDePanel, largoDePanel);
        this.zonaDeJuego.setBackground(Color.black);
    }
    
    public void dibujarTablero() {
        dibujarTablero = false;
        int constanteFila = 0;
        int constanteColumna = 1;
        int posicionX = 0;
        int posicionY = 0;

        for (int i = 0; i < tableroActual.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < tableroActual.getCantidadDeFilas(); j++) {
                posicionY = longitudManzana * (j + constanteFila);
                JLabel manzana = crearUnaManzana(posicionX, posicionY, longitudManzana, longitudManzana);
                this.zonaDeJuego.add(manzana);
                constanteFila++;
            }
            constanteColumna++;
            posicionX = longitudManzana * (i + constanteColumna);
            posicionY = 0;
            constanteFila = 0;
        }
    }
    
    /*ESTE METODO ANDA MAL
     * public void dibujarTablero2() {
        dibujarTablero = false;
        System.out.println("dibujarTablero");
        zonaDeJuego.setVisible(true);
        int posicionCuadraX = 0;
        int posicionCuadraY = 0;
        int posicionTableroX = 0;
        int posicionTableroY = 0;
        int longitudCuadra = 60;
        int anchoCalle = 30;
        int distancia = longitudCuadra + anchoCalle;

        for (int i = 0; i < tablero.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < tablero.getCantidadDeFilas(); j++) {
                posicionCuadraY = (distancia) * j + posicionTableroX;
                posicionCuadraX = (distancia) * i + posicionTableroY;
                JLabel manzana = crearUnaManzana(posicionCuadraX, posicionCuadraY, longitudCuadra, longitudCuadra);
                this.zonaDeJuego.add(manzana);
            }
        }
    }*/

    public JLabel crearUnaManzana(int posX, int posY, int ancho, int alto) {
        JLabel manzana = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/manzana.png");
        manzana.setIcon(icono);
        manzana.setBounds(posX, posY, ancho, alto);
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
        ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
        star = imagenVehiculo.getImage();
    }
    
    public int centrarEnX(){
    	if(((anchoDePanel - tableroActual.getCantidadDeColumnas() * longitudManzana * 2)/2) < 0){
    		return 0;
    	}else{
    		return (anchoDePanel-tableroActual.getCantidadDeColumnas() * longitudManzana * 2)/2;
    	}
    }
  
    public int centrarEnY(){
    	if(((largoDePanel - tableroActual.getCantidadDeFilas() * longitudManzana * 2)/2) < 0){
    		return 0;
    	}else {
    		return (this.largoDePanel-tableroActual.getCantidadDeFilas() * this.longitudManzana * 2)/2;
    	}   		
    }
    
    public void dibujarVehiculoEnPosicion(){
    	
    }
    
}

