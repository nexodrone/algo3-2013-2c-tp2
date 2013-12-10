package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Bocacalle;
import modelo.Direccion;
import modelo.Partida;
import modelo.Posicion;
import modelo.Tablero;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

    private Image star;
    private Image prueba;
    Timer timer;
    int enX, enY, paso, distancia, cantidad, cantidadDePasos;

    private int x, y;
    private int radioClip = 60;
    private int largoDePanel = 610; // ideal = 580
    private int anchoDePanel = 870; // ideal = 860
    private int longitudManzana = 20;
    private int posicionDelTableroX; // = this.centrarEnX();
    private int posicionDelTableroY;// = this.centrarEnY();
    private int cantidadAAA = 0;
    private Tablero tableroActual;
    private JPanel zonaDeJuego;
    private String vehiculo;
    private Posicion posicionDeVehiculo;
    private Posicion posicionDeLlegada;
    private Boolean dibujarTablero = true; // PARA QUE EL TABLERO SE DIBUJE SOLO UNA VEZ

    public PanelZonaDeJuego(Partida partidaActual) {
        this.tableroActual = partidaActual.getTablero();
        this.posicionDeLlegada = partidaActual.getPosicionGanadora();
        this.posicionDeVehiculo = partidaActual.getVehiculo().getPosicion();
        //System.out.println("Posicion del Vehiculo:" + posicionDeVehiculo.asString());
        vehiculo = partidaActual.getVehiculo().asString();
        setBackground(Color.BLACK);
        this.girarHacia("Derecha"); // por defecto el vehiculo siempre empieza mirando hacia
                                    // laderecha

        this.cantidadAAA = 0;
        this.prueba();
        setDoubleBuffered(true);
        // setFocusable(true);
        posicionDelTableroX = this.centrarEnX();
        posicionDelTableroY = this.centrarEnY();
        this.calcularPosicionVehiculoVista();
        this.asignarValoresInicialesMovimientos();

        int velocidad = 1;
        timer = new Timer(velocidad, this);

        // zonaDeJuego = new TransparentPanel(radioClip);
        zonaDeJuego = new JPanel();
        this.configurarTableroEnZonaDeJuego();
        MouseListener ml = new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // area.append("Solto la etiqueta\n");
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // area.append("Pulso la etiqueta\n");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // area.append("Salio de la etiqueta\n");
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // area.append("Entro a la etiqueta\n");
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println("Posicion click:" + arg0.getX() + "," + arg0.getY());
            }
        };
        this.addMouseListener(ml);

        this.add(zonaDeJuego);
    }

    public void paint(Graphics g) {
        // System.out.println("paint");
        // this.configurarTableroEnZonaDeJuego();

        if (dibujarTablero) {
            this.dibujarTablero();
            actionPerformed(null);
            cantidadDePasos = 0;
        }

        super.paint(g);
        Graphics2D grafico2D = (Graphics2D) g;
        if (this.cantidadAAA % 2 == 0) {
            grafico2D.drawImage(prueba, 200, 200, this);
        }
        grafico2D.drawImage(star, x, y, this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        // System.out.println("actionPerformed");
        if (cantidadDePasos < cantidad) {
            x = (x + 2 * enX);
            y = (y + 2 * enY);
            cantidadDePasos = cantidadDePasos + 1;
            // zonaDeJuego.setClipPos(x - posicionDelTableroX, y - posicionDelTableroY);
            repaint();
            // System.out.print("pintando");
        } else {
            timer.stop(); // paro de dibujar
            cantidadDePasos = 0;
        }
    }

    public void configurarTableroEnZonaDeJuego() {
        // System.out.println("configurarTableroEnZonaDeJuego");
        this.zonaDeJuego.setLayout(null);
        this.zonaDeJuego.setBounds(posicionDelTableroX, posicionDelTableroY, this.calcularAnchoPanelZonaDeJuego(), this.calcularLargoPanelZonaDeJuego());
        this.zonaDeJuego.setBackground(Color.lightGray);
    }

    public void dibujarTablero() {
        // System.out.println("dibujarTablero");
        dibujarTablero = false;
        Direccion sur = new Direccion(0, -1);
        Direccion oeste = new Direccion(-1, 0);
        int constanteFila = 0;
        int constanteColumna = 1;
        int posicionX = 0;
        int posicionY = 0;
        // System.out.println("Tamanio del tablero:" + tableroActual.getCantidadDeColumnas() + "," +
        // tableroActual.getCantidadDeFilas());

        for (int i = 0; i < tableroActual.getCantidadDeColumnas() + 1; i++) {
            for (int j = 0; j < tableroActual.getCantidadDeFilas() + 1; j++) {
                // DIBUJA MANZANAS
                posicionY = longitudManzana * (j + constanteFila);
                JLabel manzana = crearUnaManzana(posicionX, posicionY);
                this.zonaDeJuego.add(manzana);
                constanteFila++;
                // DIBUJA SORPRESAS Y OBSTACULOS SIEMPRE QUE ESTEMOS EN UNA POSICION VALIDA
                if (i < tableroActual.getCantidadDeColumnas() && j < tableroActual.getCantidadDeFilas()) {
                    Posicion posicionActual = new Posicion(i, j);
                    System.out.println("Posicion Actual:" + posicionActual.asString());
                    if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(sur).getObstaculo() != null) {
                        JLabel obstaculoSur = crearObstaculoEnDireccion(posicionActual, sur, 0, 20);
                        this.zonaDeJuego.add(obstaculoSur);
                    }
                    if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(oeste).getObstaculo() != null) {
                        JLabel obstaculoOeste = crearObstaculoEnDireccion(posicionActual, oeste, -10, 0);
                        this.zonaDeJuego.add(obstaculoOeste);
                    }
                    if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(sur).getSorpresa() != null) {
                        JLabel sorpresaSur = crearSorpresaEnDireccion(posicionActual, "sur");
                        this.zonaDeJuego.add(sorpresaSur);
                    }
                    if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(oeste).getSorpresa() != null) {
                        JLabel sorpresaOeste = crearSorpresaEnDireccion(posicionActual, "oeste");
                        this.zonaDeJuego.add(sorpresaOeste);
                    }
                }
            }
            constanteColumna++;
            posicionX = longitudManzana * (i + constanteColumna);
            posicionY = 0;
            constanteFila = 0;
        }
        JLabel meta = this.obtenerImagen(this.posicionInicialDeVehiculoEnX(this.posicionDeLlegada), this.posicionDeUnObjetoEnY(this.posicionDeLlegada), "meta", 0, 0);
        this.zonaDeJuego.add(meta);
    }

    private JLabel crearObstaculoEnDireccion(Posicion posicionActual, Direccion direccion, int corrimientoEnX, int corrimientoEnY) {
        int posicionObstaculoSurX = longitudManzana + posicionActual.x() * 2 * longitudManzana + corrimientoEnX;
        int posicionObstaculoSurY = this.posicionDeUnObjetoEnY(posicionActual) + corrimientoEnY;
        Bocacalle bocacalleActual = this.tableroActual.getBocacalleEnPosicion(posicionActual);
        switch (bocacalleActual.getCalleEnDireccion(direccion).getObstaculo().getClass().getName()) {
            case "ObstaculoControlPolicial":
                JLabel obstaculoControlPolicial = obtenerImagen(posicionObstaculoSurX, posicionObstaculoSurY, "obstaculoControlPolicial", 5, 5);
                return obstaculoControlPolicial;
            case "ObstaculoPozo":
                JLabel obstaculoPozo = obtenerImagen(posicionObstaculoSurX, posicionObstaculoSurY, "obstaculoPozo", 5, 5);
                return obstaculoPozo;
            default:
                JLabel obstaculoPiquete = obtenerImagen(posicionObstaculoSurX, posicionObstaculoSurY, "obstaculoPiquete", 5, 5);
                return obstaculoPiquete;
        }
    }

    private JLabel crearSorpresaEnDireccion(Posicion posicionActual, String direccion) {
        switch (direccion) {
            case "sur":
                int posicionSorpresaSurX = longitudManzana + posicionActual.x() * 2 * longitudManzana;
                int posicionSorpresaSurY = this.posicionDeUnObjetoEnY(posicionActual) + 30;
                JLabel sorpresaSur = obtenerImagen(posicionSorpresaSurX, posicionSorpresaSurY, "sorpresa", 10, 10);
                return sorpresaSur;
            case "norte":
                int posicionSorpresaNorteX = longitudManzana + posicionActual.x() * 2 * longitudManzana;
                int posicionSorpresaNorteY = this.posicionDeUnObjetoEnY(posicionActual) - 10;
                JLabel sorpresaNorte = obtenerImagen(posicionSorpresaNorteX, posicionSorpresaNorteY, "sorpresa", 10, 10);
                return sorpresaNorte;
            case "este":
                int posicionSorpresaEsteX = longitudManzana + posicionActual.x() * 2 * longitudManzana + 20;
                int posicionSorpresaEsteY = this.posicionDeUnObjetoEnY(posicionActual);
                JLabel sorpresaEste = obtenerImagen(posicionSorpresaEsteX, posicionSorpresaEsteY, "sorpresa", 10, 10);
                return sorpresaEste;
            default:
                int posicionSorpresaOesteX = longitudManzana + posicionActual.x() * 2 * longitudManzana - 10;
                int posicionSorpresaOesteY = this.posicionDeUnObjetoEnY(posicionActual);
                JLabel sorpresaOeste = obtenerImagen(posicionSorpresaOesteX, posicionSorpresaOesteY, "sorpresa", 10, 10);
                return sorpresaOeste;
        }
    }

    public JLabel crearUnaManzana(int posX, int posY) {
        // System.out.println("crearUnaManzana");
        JLabel manzana = new Manzana(posX, posY);
        return manzana;
    }

    public JLabel obtenerImagen(int posX, int posY, String figura, int valorEnX, int valorEnY) {
        // System.out.println("CREANDO IMAGEN " + figura);
        JLabel obstaculo = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/" + figura + ".png");
        obstaculo.setIcon(icono);
        obstaculo.setBounds(posX, posY, longitudManzana - valorEnX, longitudManzana - valorEnY);
        return obstaculo;
    }

    public void nuevaPosicion(int x, int y) {
        // System.out.println("nuevaPosicion");
        // System.out.println("cantidadDePasos:" + cantidadDePasos);
        // System.out.println("nuevaPosicion");
        if (this.seEstaMoviendo() == false) {
            enX = x;
            enY = y;
            // cantidadDePasos = 0;
            timer.start();
        }
        this.cantidadAAA++;
    }

    public void girarHacia(String sentido) {
        // System.out.println("girarHacia");
        if (!this.seEstaMoviendo()) {
            String direccion = "/vista/imagenes/" + vehiculo + "/" + vehiculo + sentido + ".png";
            ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
            star = imagenVehiculo.getImage();
            star = star.getScaledInstance(18, 18, 1);
        }
    }

   /*public void verificarSiHuboCambioDeVehiculo(String vehiculoEnPartida,String sentido){
	   if(vehiculo != vehiculoEnPartida){
		   String direccion = "/vista/imagenes/" + vehiculoEnPartida+ "/" + vehiculoEnPartida + sentido + ".png";
           ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
           star = imagenVehiculo.getImage();
           star = star.getScaledInstance(18, 18, 1);
	   }
   }*/

    public void prueba() {
        String direccion = "/vista/imagenes/sorpresa.png";
        ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
        prueba = imagenVehiculo.getImage().getScaledInstance(10, 10, 1);

    }

    private boolean seEstaMoviendo() {
        System.out.println("seEstaMoviendo");
        System.out.println("cantidad de paso" + cantidadDePasos);
        if (cantidadDePasos < cantidad && cantidadDePasos > 0) {
            System.out.println("Si se esta moviendo");
            return true;
        }
        return false;
    }

    public int centrarEnX() {
        // System.out.println("centrarEnX");
        if (((anchoDePanel - (tableroActual.getCantidadDeColumnas() + 1) * longitudManzana * 2) / 2) < 0) {
            return 0;
        } else {
            int algo = (anchoDePanel - (tableroActual.getCantidadDeColumnas() + 1) * longitudManzana * 2) / 2;
            // System.out.println("algo:" + algo);
            return algo;
        }
    }

    public int centrarEnY() {
        // System.out.println("centrarEnY");
        System.out.println("Tamaño del tablero:" + tableroActual.getCantidadDeColumnas() + "," + tableroActual.getCantidadDeFilas());
        if (((largoDePanel - (tableroActual.getCantidadDeFilas() + 1) * longitudManzana * 2) / 2) < 0) {
            return 0;
        } else {
            int algo = (this.largoDePanel - (tableroActual.getCantidadDeFilas() + 1) * this.longitudManzana * 2) / 2;
            // System.out.println("algo:" + algo);

            return algo;
        }
    }

    public int posicionInicialDeVehiculoEnX(Posicion posicion) {
        // System.out.println("posicionInicialVehiculoEnX");
        // System.out.println("pos X en el modelo:" + posicionDeVehiculo.x());
        int posicionInicialVehiculoEnX = posicion.x();
        int nuevaPosicionX = longitudManzana + posicionInicialVehiculoEnX * 2 * longitudManzana;
        // System.out.println("posicion X :" + nuevaPosicionX);

        return nuevaPosicionX;
    }

    public int posicionInicialDeVehiculoEnY(Posicion posicion) {
        // System.out.println("posicionInicialVehiculoEnY");
        // System.out.println("pos Y en el modelo:" + posicionDeVehiculo.y());

        int posicionInicialVehiculoEnY = posicion.y();
        int nuevaPosicionY = longitudManzana + posicionInicialVehiculoEnY * 2 * longitudManzana;
        // System.out.println("posicion Y :" + nuevaPosicionY);
        return nuevaPosicionY;
    }

    public int posicionDeUnObjetoEnY(Posicion posicion) {
        return (longitudManzana + (this.tableroActual.getCantidadDeFilas() - 1 - posicion.y()) * 2 * longitudManzana);
    }

    public int calcularAnchoPanelZonaDeJuego() {
        // System.out.println("calcularAnchoPanelZonaDeJuego");

        int algo = this.tableroActual.getCantidadDeColumnas() * this.longitudManzana * 2 + longitudManzana;
        return algo;
    }

    public int calcularLargoPanelZonaDeJuego() {
        // System.out.println("calcularLargoPanelZonaDeJuego");
        int algo = this.tableroActual.getCantidadDeFilas() * this.longitudManzana * 2 + longitudManzana;
        return algo;
    }

    public void calcularPosicionVehiculoVista() {
        // System.out.println("calcularPosicionVehiculoVista");
        // int posicionDelTableroX = (anchoDePanel - this.calcularAnchoPanelZonaDeJuego()) / 2;
        // int posicionTableroX = posicionDelTableroX;
        // int posicionDelTableroY = (largoDePanel - this.calcularLargoPanelZonaDeJuego()) / 2;
        // int posicionTableroY = posicionDelTableroY;
        // System.out.println("posicionDelTablero X:" + posicionDelTableroX);
        // System.out.println("posicionDelTablero Y:" + posicionDelTableroY);
        x = this.posicionInicialDeVehiculoEnX(this.posicionDeVehiculo) + posicionDelTableroX + 1;
        y = largoDePanel - posicionDelTableroY - this.posicionInicialDeVehiculoEnY(this.posicionDeVehiculo) - 18 - longitudManzana - 1;
    }

    public void asignarValoresInicialesMovimientos() {
        // System.out.println("asignarValoresInicialesMovimientos");

        cantidadDePasos = 0;
        paso = 2; // que cada pasa se mueva 2 pixeles
        distancia = 40; // distancia = anchoManzana
        cantidad = (distancia / paso);
    }

    public boolean vehiculoMoviendose() {
        return this.seEstaMoviendo();
    }

    // CLASE PARA EL CIRCULO CLIP
    public class TransparentPanel extends JPanel {

        private int x, y;
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
            int centroX = x - radioClip + 9;
            int centroY = y - radioClip + 9;
            Ellipse2D zona = new Ellipse2D.Double(centroX, centroY, radioClip * 2, radioClip * 2);
            grafico2D.setClip(new Area(zona));
            super.paint(g);
            g.dispose();
            grafico2D.dispose();
        }
    }

}
