package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Jugador {

    private String nombre;
    private Juego juegoActual;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void asignarJuego(Juego juego) {
        juegoActual = juego;
    }

    public String getNickName() {
        return this.nombre;
    }

    public Juego getJuegoActual() {
        return juegoActual;
    }

    public void jugar(Direccion direccion) throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
        try {
            this.juegoActual.realizarJugadaEnDireccion(direccion);
        } catch (MovimientoInvalidoExcepcion e) {
            System.out.print("Debe realizar otro movimiento valido \n");
        }
    }

}
