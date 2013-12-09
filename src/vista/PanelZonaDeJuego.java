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
import modelo.Posicion;
import modelo.Tablero;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

    private Image star;
    Timer timer;
    int enX, enY, paso, distancia, cantidad, cantidadDePasos;

    private int x, y;
    private int radioClip = 60;
    private int largoDePanel = 610;
    private int anchoDePanel = 870;
    private int longitudManzana = 20;
    private int posicionDelTableroX; // = this.centrarEnX();
    private int posicionDelTableroY;// = this.centrarEnY();
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
        // setFocusable(true);
        posicionDelTableroX = this.centrarEnX();
        posicionDelTableroY = this.centrarEnY();
        this.calcularPosicionVehiculoVista();
        this.asignarValoresInicialesMovimientos();

        int velocidad = 1;
        timer = new Timer(velocidad, this);

        zonaDeJuego = new TransparentPanel(radioClip);
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
            this.dibujarTodosObstaculosYSorpresas();
            this.dibujarTablero();
            actionPerformed(null);
            cantidadDePasos = 0;
        }

        super.paint(g);
        Graphics2D grafico2D = (Graphics2D) g;
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
            zonaDeJuego.setClipPos(x - posicionDelTableroX, y - posicionDelTableroY);
            repaint();
            // System.out.print("pintando");
        } else {
            timer.stop(); // paro de dibujar
            cantidadDePasos = 0;
        }
    }

    public void configurarTableroEnZonaDeJuego() {
        System.out.println("configurarTableroEnZonaDeJuego");
        this.zonaDeJuego.setLayout(null);
        this.zonaDeJuego.setBounds(posicionDelTableroX, posicionDelTableroY, this.calcularAnchoPanelZonaDeJuego(), this.calcularLargoPanelZonaDeJuego());
        this.zonaDeJuego.setBackground(Color.lightGray);
    }

    public void dibujarTablero() {
        // System.out.println("dibujarTablero");
        dibujarTablero = false;
        int constanteFila = 0;
        int constanteColumna = 1;
        int posicionX = 0;
        int posicionY = 0;
        // System.out.println("Tamanio del tablero:" + tableroActual.getCantidadDeColumnas() + "," +
        // tableroActual.getCantidadDeFilas());

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

    public void dibujarTodosObstaculosYSorpresas() {
        Direccion norte = new Direccion(0, 1);
        Direccion sur = new Direccion(0, -1);
        Direccion este = new Direccion(1, 0);
        Direccion oeste = new Direccion(-1, 0);

        for (int i = 0; i < tableroActual.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < tableroActual.getCantidadDeFilas(); j++) {
                Posicion posicionActual = new Posicion(i, j);
                Bocacalle bocacalleActual = tableroActual.getBocacalleEnPosicion(posicionActual);
                if (bocacalleActual.getCalleEnDireccion(sur).getSorpresa() != null) {
                    JLabel sorpresaSur = dibujarSorpresaEnDireccion(posicionActual, "sur");
                    this.zonaDeJuego.add(sorpresaSur);
                }
                if (bocacalleActual.getCalleEnDireccion(norte).getSorpresa() != null) {
                    JLabel sorpresaNorte = dibujarSorpresaEnDireccion(posicionActual, "norte");
                    this.zonaDeJuego.add(sorpresaNorte);
                }
                if (bocacalleActual.getCalleEnDireccion(oeste).getSorpresa() != null) {
                    JLabel sorpresaOeste = dibujarSorpresaEnDireccion(posicionActual, "oeste");
                    this.zonaDeJuego.add(sorpresaOeste);
                }
                if (bocacalleActual.getCalleEnDireccion(este).getSorpresa() != null) {
                    JLabel sorpresaEste = dibujarSorpresaEnDireccion(posicionActual, "este");
                    this.zonaDeJuego.add(sorpresaEste);
                }
                if (bocacalleActual.getCalleEnDireccion(sur).getObstaculo() != null) {
                    JLabel obstaculoSur = dibujarObstaculosEnDireccion(posicionActual, sur, 0, 32);
                    this.zonaDeJuego.add(obstaculoSur);
                }
                if (bocacalleActual.getCalleEnDireccion(este).getObstaculo() != null) {
                    JLabel obstaculoEste = dibujarObstaculosEnDireccion(posicionActual, este, 30, 0);
                    this.zonaDeJuego.add(obstaculoEste);
                }
                if (bocacalleActual.getCalleEnDireccion(norte).getObstaculo() != null) {
                    JLabel obstaculoNorte = dibujarObstaculosEnDireccion(posicionActual, norte, 0, -12);
                    this.zonaDeJuego.add(obstaculoNorte);
                }
                if (bocacalleActual.getCalleEnDireccion(oeste).getObstaculo() != null) {
                    JLabel obstaculoOeste = dibujarObstaculosEnDireccion(posicionActual, oeste, -9, 0);
                    this.zonaDeJuego.add(obstaculoOeste);
                }
            }
        }
    }

    private JLabel dibujarObstaculosEnDireccion(Posicion posicionActual, Direccion direccion, int corrimientoEnX, int corrimientoEnY) {
        int posicionObstaculoSurX = longitudManzana + posicionActual.x() * 2 * longitudManzana + corrimientoEnX;
        int posicionObstaculoSurY = longitudManzana + posicionActual.y() * 2 * longitudManzana + corrimientoEnY;
        Bocacalle bocacalleActual = this.tableroActual.getBocacalleEnPosicion(posicionActual);
        switch (bocacalleActual.getCalleEnDireccion(direccion).getObstaculo().toString()) {
            case "ObstaculoControlPolicial":
                JLabel obstaculoControlPolicial = crearObstaculoControlPolicial(posicionObstaculoSurX, posicionObstaculoSurY);
                return obstaculoControlPolicial;
            case "ObstaculoPozo":
                JLabel obstaculoPozo = crearObstaculoPozo(posicionObstaculoSurX, posicionObstaculoSurY);
                return obstaculoPozo;
            default:
                JLabel obstaculoPiquete = crearObstaculoPiquete(posicionObstaculoSurX, posicionObstaculoSurY);
                return obstaculoPiquete;
        }
    }

    private JLabel dibujarSorpresaEnDireccion(Posicion posicionActual, String direccion) {
        switch (direccion) {
            case "sur":
                int posicionSorpresaSurX = longitudManzana + posicionActual.x() * 2 * longitudManzana;
                int posicionSorpresaSurY = longitudManzana + posicionActual.y() * 2 * longitudManzana + 28;
                JLabel sorpresaSur = crearSorpresa(posicionSorpresaSurX, posicionSorpresaSurY);
                return sorpresaSur;
            case "norte":
                int posicionSorpresaNorteX = longitudManzana + posicionActual.x() * 2 * longitudManzana;
                int posicionSorpresaNorteY = longitudManzana + posicionActual.y() * 2 * longitudManzana - 5;
                JLabel sorpresaNorte = crearSorpresa(posicionSorpresaNorteX, posicionSorpresaNorteY);
                return sorpresaNorte;
            case "este":
                int posicionSorpresaEsteX = longitudManzana + posicionActual.x() * 2 * longitudManzana + 22;
                int posicionSorpresaEsteY = longitudManzana + posicionActual.y() * 2 * longitudManzana;
                JLabel sorpresaEste = crearSorpresa(posicionSorpresaEsteX, posicionSorpresaEsteY);
                return sorpresaEste;
            default:
                int posicionSorpresaOesteX = longitudManzana + posicionActual.x() * 2 * longitudManzana - 18;
                int posicionSorpresaOesteY = longitudManzana + posicionActual.y() * 2 * longitudManzana;
                JLabel sorpresaOeste = crearSorpresa(posicionSorpresaOesteX, posicionSorpresaOesteY);
                return sorpresaOeste;
        }
    }

    public JLabel crearUnaManzana(int posX, int posY) {
        // System.out.println("crearUnaManzana");

        // JLabel manzana = new JLabel("");
        // ImageIcon icono = new ImageIcon("src/vista/imagenes/manzana.png");
        // manzana.setIcon(icono);
        // manzana.setBounds(posX, posY, longitudManzana, longitudManzana);
        JLabel manzana = new Manzana(posX, posY);
        return manzana;
        // return manzana;
    }

    public JLabel crearSorpresa(int posX, int posY) {
        // System.out.println("crearSorpresa");

        JLabel sorpresa = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/sorpresa.png");
        sorpresa.setIcon(icono);
        sorpresa.setBounds(posX, posY, longitudManzana - 9, longitudManzana - 9);
        return sorpresa;
    }

    public JLabel crearObstaculoControlPolicial(int posX, int posY) {
        // System.out.println("crearObstaculoControlPolicial");

        JLabel obstaculo = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/obstaculoControlPolicial.png");
        obstaculo.setIcon(icono);
        obstaculo.setBounds(posX, posY, longitudManzana - 9, longitudManzana - 9);
        return obstaculo;
    }

    public JLabel crearObstaculoPozo(int posX, int posY) {
        // S//ystem.out.println("crearObstaculoPozo");

        JLabel obstaculo = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/obstaculoPozo.png");
        obstaculo.setIcon(icono);
        obstaculo.setBounds(posX, posY, longitudManzana - 9, longitudManzana - 9);
        return obstaculo;
    }

    public JLabel crearObstaculoPiquete(int posX, int posY) {
        // System.out.println("crearObstaculoPiquete");

        JLabel obstaculo = new JLabel("");
        ImageIcon icono = new ImageIcon("src/vista/imagenes/obstaculoPiquete.png");
        obstaculo.setIcon(icono);
        obstaculo.setBounds(posX, posY, longitudManzana - 9, longitudManzana - 9);
        return obstaculo;
    }

    public void nuevaPosicion(int x, int y) {
        // System.out.println("nuevaPosicion");
        // System.out.println("cantidadDePasos:" + cantidadDePasos);
        // System.out.println("nuevaPosicion");
        if (!this.seEstaMoviendo()) {
            enX = x;
            enY = y;
            cantidadDePasos = 0;
            timer.start();
        }
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

    private boolean seEstaMoviendo() {
        // System.out.println("seEstaMoviendo");

        if (cantidadDePasos == 13 || cantidadDePasos == 0) {
            return false;
        }
        return true;
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

    public int posicionInicialVehiculoEnX() {
        // System.out.println("posicionInicialVehiculoEnX");
        // System.out.println("pos X en el modelo:" + posicionDeVehiculo.x());
        int posicionInicialVehiculoEnX = posicionDeVehiculo.x();
        int nuevaPosicionX = longitudManzana + posicionInicialVehiculoEnX * 2 * longitudManzana;
        // System.out.println("posicion X :" + nuevaPosicionX);

        return nuevaPosicionX;
    }

    public int posicionInicialVehiculoEnY() {
        // System.out.println("posicionInicialVehiculoEnY");
        // System.out.println("pos Y en el modelo:" + posicionDeVehiculo.y());

        int posicionInicialVehiculoEnY = posicionDeVehiculo.y();
        int nuevaPosicionY = longitudManzana + posicionInicialVehiculoEnY * 2 * longitudManzana;
        // System.out.println("posicion Y :" + nuevaPosicionY);

        return nuevaPosicionY;
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
        x = this.posicionInicialVehiculoEnX() + posicionDelTableroX + 1;
        y = largoDePanel - posicionDelTableroY - this.posicionInicialVehiculoEnY() - 18 - longitudManzana - 1;
    }

    public void asignarValoresInicialesMovimientos() {
        // System.out.println("asignarValoresInicialesMovimientos");

        cantidadDePasos = 0;
        paso = 2; // que cada pasa se mueva 2 pixeles
        distancia = 40; // distancia = anchoManzana
        cantidad = (distancia / paso);
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
