package modelo;

import java.util.ArrayList;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

public class Juego {

    private Partida partidaActual;
    private Jugador jugadorActual;
    private Puntajes puntajes;

    public Juego() {
        puntajes = new Puntajes();
    };

    public void setJugador(Jugador jugador) {
        this.jugadorActual = jugador;
    }

    public void setPartida(Partida partida) {
        this.partidaActual = partida;
    }

    public Jugador getJugadorActual() {
        return this.jugadorActual;
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

    public ArrayList<Puntaje> getPuntajesOrdenados() throws Exception {
        return puntajes.getPuntajesOrdenados();
    }

    public void guardarPartida() throws Exception {
        String path = "partida" + jugadorActual.getNickName() + ".xml";
        partidaActual.guardar(path);
    }

    public void cargarPartida() throws Exception {
        String path = "partida" + jugadorActual.getNickName() + ".xml";
        this.partidaActual = Partida.recuperar(path);
    }

    public void setVehiculo(Vehiculo vehiculo) {
        partidaActual.setVehiculo(vehiculo);

    }

    public Vehiculo getVehiculo() {
        return partidaActual.getVehiculo();
    }
}