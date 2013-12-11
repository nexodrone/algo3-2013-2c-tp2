package modelo;

import java.util.ArrayList;

import modelo.avisos.PartidaGanadaAviso;
import modelo.avisos.PartidaPerdidaAviso;
import modelo.excepciones.ErrorArchivoJugadoresException;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.NoHayUsuariosCreadosException;
import modelo.excepciones.UsuarioExistenteException;
import modelo.excepciones.UsuarioInexistenteException;

public class Juego {

    private Partida partidaActual;
    private Jugador jugadorActual;
    private String path_jugadores;
    private static Juego INSTANCE = null;

    private Juego() {
    };

    public void inicializarPuntajes() {
        Jugadores jugadoresVacio = new Jugadores();
        try {
            jugadoresVacio.guardar(path_jugadores);
        } catch (Exception e) {
            System.out.print("Error al creaar puntajes.\n");
        }
    }

    public void inicializarPuntajesCon(String nombre) {
        Jugadores jugadoresVacio = new Jugadores();
        try {
            jugadoresVacio.guardar(path_jugadores);
        } catch (Exception e) {
            System.out.print("Error al creaar puntajes.\n");
        }
        try {
            crearUsuario(nombre);
        } catch (NoHayUsuariosCreadosException | UsuarioExistenteException ex) {
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

    public void verificarEstadoDelJugador() throws PartidaGanadaAviso, PartidaPerdidaAviso {
        if (partidaActual.esGanada()) {
            System.out.print("Jugador gano el nivel. \n");
            throw new PartidaGanadaAviso();
        }
        if (partidaActual.esPerdida()) {
            System.out.print("Jugador pi{erde el nivel. \n");
            throw new PartidaPerdidaAviso();
        }
    }

    public void realizarJugadaEnDireccion(Direccion direccion)
    		throws MovimientoInvalidoExcepcion, PartidaGanadaAviso, PartidaPerdidaAviso {
    	
        if (this.partidaActual.esGanada() || this.partidaActual.esPerdida())
            System.out.print("Se termino la partida. \n");
        else
            jugarEnDireccion(direccion);
    }

    private void jugarEnDireccion(Direccion direccion)
    		throws MovimientoInvalidoExcepcion, PartidaGanadaAviso, PartidaPerdidaAviso {
    	
        Posicion nuevaPosicion = partidaActual.getVehiculo().calcularSiguientePosicion(direccion);
        System.out.println("jugarEnDireccion");
        System.out.println(nuevaPosicion.asString());
        if (partidaActual.getTablero().posicionValida(nuevaPosicion)) {
            Bocacalle bocacalleActual = partidaActual.getTablero().getBocacalleEnPosicion(partidaActual.getVehiculo().getPosicion());
            Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
            partidaActual.getVehiculo().moverEnDireccion(direccion, calleATransitar);
            verificarEstadoDelJugador();
        } else
            throw new MovimientoInvalidoExcepcion();
    }

    public void crearUsuario(String nombre) throws UsuarioExistenteException, NoHayUsuariosCreadosException {
        Jugadores jugadores = new Jugadores();
        jugadores = Jugadores.recuperar(path_jugadores);
        jugadores.crearUsuario(nombre);
        try {
            jugadores.guardar(path_jugadores);
        } catch (Exception e) {
            System.out.print("Error al guardar los puntajes.\n");
        }
    }

    public void guardarPuntaje(String nombre, Integer puntaje) throws UsuarioInexistenteException, NoHayUsuariosCreadosException {
        Jugadores jugadores = new Jugadores();
        jugadores = Jugadores.recuperar(path_jugadores);

        jugadores.sumarPuntaje(nombre, puntaje);
        try {
            jugadores.guardar(path_jugadores);
        } catch (Exception e) {
            System.out.print("Error al guardar los puntajes.\n");
        }
    }

    public ArrayList<Jugador> getPuntajesOrdenados() throws ErrorArchivoJugadoresException, NoHayUsuariosCreadosException {
        Jugadores jugadores = new Jugadores();
        try {
            jugadores = Jugadores.recuperar(path_jugadores);
        } catch (Exception e) {
            System.out.print("No hay jugadores creados.\n");
            throw new ErrorArchivoJugadoresException();
        }
        if (jugadores.getPuntajesOrdenados().isEmpty())
            throw new NoHayUsuariosCreadosException();
        return jugadores.getPuntajesOrdenados();
    }

    public void setVehiculo(Vehiculo vehiculo) {
        partidaActual.setVehiculo(vehiculo);

    }

    public Vehiculo getVehiculo() {
        return partidaActual.getVehiculo();
    }

}