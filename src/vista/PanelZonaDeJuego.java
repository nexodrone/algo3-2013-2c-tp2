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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Direccion;
import modelo.Juego;
import modelo.Obstaculo;
import modelo.Partida;
import modelo.Posicion;
import modelo.Tablero;

public class PanelZonaDeJuego extends JPanel implements ActionListener {

    private Image star;
    // private Image prueba;
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
    private TransparentPanel zonaDeJuego;
    private String vehiculo;
    private JLabel imagenDeLlegada;
    private Posicion posicionDeVehiculo;
    private Posicion posicionDeLlegada;
    private Boolean dibujarTablero = true; // PARA QUE EL TABLERO SE DIBUJE SOLO UNA VEZ
    private ArrayList<ElementoDeTablero> listaDeSorpresas = new ArrayList<ElementoDeTablero>();
    private ArrayList<ElementoDeTablero> listaDeObstaculos = new ArrayList<ElementoDeTablero>();

    public PanelZonaDeJuego(Partida partidaActual) {
    	int velocidad = 1;
        timer = new Timer(velocidad, this);
    	setLayout(null);
    	setBackground(Color.BLACK);
    	setOpaque(true);
        this.tableroActual = partidaActual.getTablero();
        this.posicionDeLlegada = partidaActual.getPosicionGanadora();
        this.posicionDeVehiculo = partidaActual.getVehiculo().getPosicion();

        // System.out.println("Posicion del Vehiculo:" + posicionDeVehiculo.asString());
        vehiculo = partidaActual.getVehiculo().asString();
        this.girarHacia("Derecha"); // por defecto el vehiculo siempre empieza mirando hacia
                                    // laderecha

        this.cantidadAAA = 0;
        agregarTodasLasSorpresasALista();
        agregarTodosLosObstaculosALista();
        setDoubleBuffered(true);
        // setFocusable(true);
        posicionDelTableroX = this.centrarEnX();
        posicionDelTableroY = this.centrarEnY();
        this.calcularPosicionVehiculoVista();
        this.asignarValoresInicialesMovimientos();

        

        zonaDeJuego = new TransparentPanel(radioClip);
        JLabel imagenDeLlegada = this.obtenerImagen(this.posicionInicialDeVehiculoEnX(this.posicionDeLlegada)+this.centrarEnX(), this.posicionDeUnObjetoEnY(this.posicionDeLlegada)+this.centrarEnY(), "meta", 0, 0);
        this.add(imagenDeLlegada);
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
        // SE DIBUJA LAS SORPRESAS EN TABLERO
        for (int i = 0; i < this.listaDeSorpresas.size(); i++) {
            ElementoDeTablero unElementoDeTablero = listaDeSorpresas.get(i);
            Image imagen = unElementoDeTablero.getImagen();
            Posicion posicionDeElemento = unElementoDeTablero.getPosicion();
            String direccion = unElementoDeTablero.getDireccion();
            if ( dibujarElemento(posicionDeElemento, direccion, 0) )
            	grafico2D.drawImage(imagen, this.calcularPosicionDeElementoEnX(posicionDeElemento,direccion,0), this.calcularPosicionDeELementoEnY(posicionDeElemento, direccion,0), this);
        }
        // SE DIBUJA LOS OBSTACULOS EN TABLERO
        for (int j = 0; j < this.listaDeObstaculos.size(); j++) {
        	ElementoDeTablero unElementoDeTablero = listaDeObstaculos.get(j);
        	Image imagenObstaculo = unElementoDeTablero.getImagen();
        	Posicion posicionDeObstaculo = unElementoDeTablero.getPosicion();
        	String direccion = unElementoDeTablero.getDireccion();
        	if ( dibujarElemento(posicionDeObstaculo, direccion, -10) ) 
        		grafico2D.drawImage(imagenObstaculo, this.calcularPosicionDeElementoEnX(posicionDeObstaculo,direccion,-10), this.calcularPosicionDeELementoEnY(posicionDeObstaculo, direccion,-10), this);
        }
        grafico2D.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private boolean dibujarElemento(Posicion posicionDeElemento, String direccion, int corrimiento) {
    	boolean dibujar = true;
    	int posX = calcularPosicionDeElementoEnX(posicionDeElemento, direccion, corrimiento);
    	int posY = calcularPosicionDeELementoEnY(posicionDeElemento, direccion, corrimiento);
    	
    	double d = Math.sqrt( Math.pow(posX-x, 2) + Math.pow( posY-y, 2) );
    	
    	if ( d > radioClip)
    		dibujar = false;
    	return dibujar;
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
        // System.out.println("configurarTableroEnZonaDeJuego");
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

    public void agregarTodasLasSorpresasALista() {
        Direccion sur = new Direccion(0, -1);
        Direccion oeste = new Direccion(-1, 0);
        for (int i = 0; i < this.tableroActual.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < this.tableroActual.getCantidadDeFilas(); j++) {
                Posicion posicionActual = new Posicion(i, j);
                if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(sur).getSorpresa() != null) {
                    Image imagenSorpresaSur = this.obtenerImagen("sorpresa");
                    ElementoDeTablero unElementoDeTablero = new ElementoDeTablero(imagenSorpresaSur, posicionActual, "sur");
                    this.listaDeSorpresas.add(unElementoDeTablero);
                }
                if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(oeste).getSorpresa() != null) {
                    Image imagenSorpresaOeste = this.obtenerImagen("sorpresa");
                    ElementoDeTablero otroElementoDeTablero = new ElementoDeTablero(imagenSorpresaOeste, posicionActual, "oeste");
                    this.listaDeSorpresas.add(otroElementoDeTablero);
                }
            }
        }
    }

    private void agregarTodosLosObstaculosALista() {
        Direccion sur = new Direccion(0, -1);
        Direccion oeste = new Direccion(-1, 0);

        for (int i = 0; i < this.tableroActual.getCantidadDeColumnas(); i++) {
            for (int j = 0; j < this.tableroActual.getCantidadDeFilas(); j++) {
                Posicion posicionActual = new Posicion(i, j);

                if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(sur).getObstaculo() != null) {
                    Image imagenSorpresaSur = this.obtenerImagenObtstaculo(tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(sur).getObstaculo());
                    ElementoDeTablero unElementoDeTablero = new ElementoDeTablero(imagenSorpresaSur, posicionActual, "sur");
                    this.listaDeObstaculos.add(unElementoDeTablero);
                }
                if (this.tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(oeste).getObstaculo() != null) {
                    Image imagenSorpresaOeste = this.obtenerImagenObtstaculo(tableroActual.getBocacalleEnPosicion(posicionActual).getCalleEnDireccion(oeste).getObstaculo());
                    ElementoDeTablero otroElementoDeTablero = new ElementoDeTablero(imagenSorpresaOeste, posicionActual, "oeste");
                    this.listaDeObstaculos.add(otroElementoDeTablero);
                }
            }
        }
    }

    public int calcularPosicionDeElementoEnX(Posicion posicion, String direccion, int corrimientoX) {
        if (direccion == "sur") {
            int posicionSorpresaSurX = longitudManzana + posicion.x() * 2 * longitudManzana + this.centrarEnX();
            return posicionSorpresaSurX;
        } else {
            int posicionSorpresaOesteX = longitudManzana + posicion.x() * 2 * longitudManzana - 10 + this.centrarEnX() + corrimientoX;
            return posicionSorpresaOesteX;
        }
    }

    public int calcularPosicionDeELementoEnY(Posicion posicion, String direccion, int corrimientoY) {
        if (direccion == "sur") {
            int posicionSorpresaSurY = this.posicionDeUnObjetoEnY(posicion) + 30 + this.centrarEnY() + corrimientoY;
            return posicionSorpresaSurY;
        } else {
            int posicionSorpresaOesteY = this.posicionDeUnObjetoEnY(posicion) + this.centrarEnY();
            return posicionSorpresaOesteY;
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
            System.out.println("-------------------------------");
            String direccion = "/vista/imagenes/" + vehiculo + "/" + vehiculo + sentido + ".png";
            ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
            star = imagenVehiculo.getImage();
            star = star.getScaledInstance(18, 18, 1);
            Posicion posicion = Juego.getInstance().getVehiculo().getPosicion();
            System.out.println("Posicion en el modelo:" + posicion.asString());
            System.out.println("sentido de giro" + sentido);
            Posicion unaPosicion = this.obtenerPosicionAnterior(sentido);
            System.out.println("lo que tiro posicion anterior" + unaPosicion.asString());
            String unaDireccion = this.pasarSentidoADireccion(sentido);
            System.out.println("la direccion" + unaDireccion);
            this.sacarSorpresa(unaPosicion, unaDireccion);
        }
    }

    private Posicion obtenerPosicionAnterior(String sentido) {
        Posicion unaPosicion = Juego.getInstance().getVehiculo().getPosicion().copy();
        if (sentido == "Derecha") {
            unaPosicion.incrementarX(-1);
        }
        if (sentido == "Izquierda") {
            unaPosicion.incrementarX(1);
        }

        if (sentido == "Arriba") {
            unaPosicion.incrementarY(-1);
        }

        if (sentido == "Abajo") {
            unaPosicion.incrementarY(1);
        }
        return unaPosicion;
    }

    public void verificarSiHuboCambioDeVehiculo(String vehiculoEnPartida, String sentido) {
        if (vehiculo != vehiculoEnPartida) {
            this.vehiculo = vehiculoEnPartida;
            String direccion = "/vista/imagenes/" + vehiculo + "/" + vehiculo + sentido + ".png";
            ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
            star = imagenVehiculo.getImage();
            star = star.getScaledInstance(18, 18, 1);
        }
    }

    public Image obtenerImagen(String elemento) {
        String direccion = "/vista/imagenes/" + elemento + ".png";
        ImageIcon imagenVehiculo = new ImageIcon(this.getClass().getResource(direccion));
        Image prueba = imagenVehiculo.getImage().getScaledInstance(10, 10, 1);
        return prueba;
    }

    public Image obtenerImagenObtstaculo(Obstaculo obstaculo) {
        if (obstaculo.asString() == "ObstaculoPiquete") {
            Image imagenPiquete = obtenerImagen("obstaculoPiquete");
            return imagenPiquete;
        } else if (obstaculo.asString() == "ObstaculoControlPolicial") {
            Image imagenControlPolicial = obtenerImagen("obstaculoControlPolicial");
            return imagenControlPolicial;
        } else {
            Image imagenObstaculoPozo = obtenerImagen("obstaculoPozo");
            return imagenObstaculoPozo;
        }
    }

    private boolean seEstaMoviendo() {
        // System.out.println("seEstaMoviendo");
        // System.out.println("cantidad de paso" + cantidadDePasos);
        if (timer.isRunning()) {
            // System.out.println("Si se esta moviendo");
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
        // System.out.println("Tamaño del tablero:" + tableroActual.getCantidadDeColumnas() + "," +
        // tableroActual.getCantidadDeFilas());
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
        System.out.println("PosicionDeVehiculo" + this.posicionDeVehiculo.asString());
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

    private void sacarSorpresaEnPosicionYSentido(Posicion posicion, String sentido) {
        for (int i = 0; i < this.listaDeSorpresas.size(); i++) {
            ElementoDeTablero elemento = listaDeSorpresas.get(i);
            if (elemento.getPosicion().equals(posicion) && elemento.getDireccion() == sentido) {
                listaDeSorpresas.remove(i);
            }
        }

    }

    public void sacarSorpresa(Posicion posicion, String sentido) {
        Posicion otraPosicion = posicion.copy();
        if (sentido == "norte") {
            sentido = "sur";
            otraPosicion.incrementarY(1);
        }
        if (sentido == "este") {
            sentido = "oeste";
            otraPosicion.incrementarX(1);
        }
        this.sacarSorpresaEnPosicionYSentido(otraPosicion, sentido);
    }

    public String pasarSentidoADireccion(String sentido) {
        String direccion = "";
        if (sentido == "Arriba") {
            direccion = "norte";
        }
        if (sentido == "Abajo") {
            direccion = "sur";
        }
        if (sentido == "Derecha") {
            direccion = "este";
        }
        if (sentido == "Izquierda") {
            direccion = "oeste";
        }
        return direccion;
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
