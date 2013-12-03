package modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.UsuarioExistenteException;
import modelo.excepciones.UsuarioInexistenteException;

public class Juego {

    private Partida partidaActual;
    private Jugador jugadorActual;
    private Puntajes puntajes;
    private static Juego INSTANCE = null;

    private Juego() {
        puntajes = new Puntajes();
    };

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

    public void verificarEstadoDelJugador() {
        if (partidaActual.esGanada())
            System.out.print("Jugador gano el nivel. \n");
        if (partidaActual.esPerdida())
            System.out.print("Jugador pierde el nivel. \n");
    }

    public void realizarJugadaEnDireccion(Direccion direccion) throws MovimientoInvalidoExcepcion {
        if (this.partidaActual.esGanada() || this.partidaActual.esPerdida())
            System.out.print("Se termino la partida. \n");
        else
            jugarEnDireccion(direccion);
    }

    private void jugarEnDireccion(Direccion direccion) throws MovimientoInvalidoExcepcion {
        Posicion nuevaPosicion = partidaActual.getVehiculo().calcularSiguientePosicion(direccion);
        if (partidaActual.getTablero().posicionValida(nuevaPosicion)) {
            Bocacalle bocacalleActual = partidaActual.getTablero().getBocacalleEnPosicion(partidaActual.getVehiculo().getPosicion());
            Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
            try {
                partidaActual.getVehiculo().moverEnDireccion(direccion, calleATransitar);
                verificarEstadoDelJugador();
            } catch (CalleBloqueadaPorPiqueteExcepcion e) {
                System.out.print("Imposible mover en esa direccion. \n");
            }
        } else
            throw new MovimientoInvalidoExcepcion();
    }

    public void guardarPuntaje(String nombre, Integer puntaje) {
        this.puntajes.agregarPuntaje(nombre, puntaje);
    }

    public void guardarPuntajes(String path) throws Exception {
        puntajes.guardar(path);
    }

    public void cargarPuntajes(String path) throws Exception {
        this.puntajes = Puntajes.recuperar(path);
    }

    public ArrayList<Puntaje> getPuntajesOrdenados() {
        return puntajes.getPuntajesOrdenados();
    }
    
    public void crearUsuario(String nombre) {
    	Jugadores jugadores = new Jugadores();
    	try{
    		jugadores = Jugadores.recuperar("src/jugadores/jugadores.xml");
    	}catch(Exception e) {
    		System.out.print("No hay jugadores creados.\n");
    	}
    	try{
    		jugadores.crearUsuario(nombre);
    	}catch(UsuarioExistenteException e) {
    		System.out.print("Imposible crear usuario ya existente.\n");
    	}
    	try{ 
    		jugadores.guardar("src/jugadores/jugadores.xml");
    	}catch(Exception e) {
    		System.out.print("Error al guardar los puntajes.\n");
    	}
    }
    
    public void guardarPuntaje222(String nombre, Integer puntaje) {
    	Jugadores jugadores = new Jugadores();
    	try{
    		jugadores = Jugadores.recuperar("src/jugadores/jugadores.xml");
    	}catch(Exception e) {
    		System.out.print("No hay jugadores creados.\n");
    	}
    	try{
    		jugadores.sumarPuntaje(nombre, puntaje);
    	}catch(UsuarioInexistenteException e) {
    		System.out.print("Usuario Inexistente.\n");
    	}
    	try{ 
    		jugadores.guardar("src/jugadores/jugadores.xml");
    	}catch(Exception e) {
    		System.out.print("Error al guardar los puntajes.\n");
    	}
    }

    public ArrayList<Jugador> getPuntajesOrdenados222() {
    	Jugadores jugadores = new Jugadores();
    	try{
    		jugadores = Jugadores.recuperar("src/jugadores/jugadores.xml");
    	}catch(Exception e) {
    		System.out.print("No hay jugadores creados.\n");
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