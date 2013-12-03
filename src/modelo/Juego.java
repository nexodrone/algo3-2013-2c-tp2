package modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import modelo.excepciones.*;

public class Juego {

    private Partida partidaActual;
    private Jugador jugadorActual;
    private String path_jugadores;
    private static Juego INSTANCE = null;

    private Juego() {};
    
    public void inicializarPuntajes() {
    	Jugadores jugadoresVacio = new Jugadores();
    	try{
    		jugadoresVacio.guardar(path_jugadores);
    	}catch(Exception e) {
    		System.out.print("Error al creaar puntajes.\n");
    	}
    }
    
    public void setPathJugadores(String path) {
    	path_jugadores = path;
    }
    
    public void setJugadorActual(Jugador jugador) {
        this.jugadorActual = jugador;
    }

    public void setPartida(Partida partida) {
        this.partidaActual = partida;
    }

    public Jugador getJugadorActual() {
        return this.jugadorActual;
    }

    public static Juego getInstance() {
        createInstance();
        return INSTANCE;
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Juego();
        }
    }

    public Partida getPartida() {
        return this.partidaActual;
    }

    public void verificarEstadoDelJugador()
    		throws PartidaGanadaExcepcion, PartidaPerdidaExcepcion
    {
        if (partidaActual.esGanada()) {
        	System.out.print("Jugador gano el nivel. \n");
        	throw new PartidaGanadaExcepcion();
        }
        if (partidaActual.esPerdida()) {
            System.out.print("Jugador pi{erde el nivel. \n");
        	throw new PartidaPerdidaExcepcion();
    	}
    }

    public void realizarJugadaEnDireccion(Direccion direccion)
    		throws MovimientoInvalidoExcepcion, PartidaGanadaExcepcion, PartidaPerdidaExcepcion
    {
        if (this.partidaActual.esGanada() || this.partidaActual.esPerdida())
            System.out.print("Se termino la partida. \n");
        else
            jugarEnDireccion(direccion);
    }

    private void jugarEnDireccion(Direccion direccion)
    		throws MovimientoInvalidoExcepcion, PartidaGanadaExcepcion, PartidaPerdidaExcepcion
    {
        Posicion nuevaPosicion = partidaActual.getVehiculo().calcularSiguientePosicion(direccion);
        if (partidaActual.getTablero().posicionValida(nuevaPosicion)) {
            Bocacalle bocacalleActual = partidaActual.getTablero().getBocacalleEnPosicion(partidaActual.getVehiculo().getPosicion());
            Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
            try {
                partidaActual.getVehiculo().moverEnDireccion(direccion, calleATransitar);
            } catch (CalleBloqueadaPorPiqueteExcepcion e) {
                System.out.print("Imposible mover en esa direccion. \n");
            }
            verificarEstadoDelJugador();
        } else
            throw new MovimientoInvalidoExcepcion();
    }
    
    public void crearUsuario(String nombre)
    		throws UsuarioExistenteException,
			   	   NoHayUsuariosCreadosException
    {
    	Jugadores jugadores = new Jugadores();
    	jugadores = Jugadores.recuperar(path_jugadores);
    	jugadores.crearUsuario(nombre);
    	try{ 
    		jugadores.guardar(path_jugadores);
    	}catch(Exception e) {
    		System.out.print("Error al guardar los puntajes.\n");
    	}
    }
    
    public void guardarPuntaje(String nombre, Integer puntaje)
    		throws UsuarioInexistenteException,
    			   NoHayUsuariosCreadosException
    {
    	Jugadores jugadores = new Jugadores();
    	jugadores = Jugadores.recuperar(path_jugadores);

    	jugadores.sumarPuntaje(nombre, puntaje);
    	try{ 
    		jugadores.guardar(path_jugadores);
    	}catch(Exception e) {
    		System.out.print("Error al guardar los puntajes.\n");
    	}
    }

    public ArrayList<Jugador> getPuntajesOrdenados() throws Exception{
    	Jugadores jugadores = new Jugadores();
    	try{
    		jugadores = Jugadores.recuperar(path_jugadores);
    	}catch(Exception e) {
    		System.out.print("No hay jugadores creados.\n");
    		throw new Exception();
    	}
        return jugadores.getPuntajesOrdenados();
    }

    public void guardarPartida() throws Exception {
        String path = "src/jugadores/partida" + jugadorActual.getNickName() + ".xml";
        partidaActual.guardarPartida(path);
    }

    public void cargarPartida() throws Exception {
        String path = "src/jugadores/partida" + jugadorActual.getNickName() + ".xml";
        this.partidaActual = Partida.cargarPartida(path);
    }

    public void setVehiculo(Vehiculo vehiculo) {
        partidaActual.setVehiculo(vehiculo);

    }

    public Vehiculo getVehiculo() {
        return partidaActual.getVehiculo();
    }

}