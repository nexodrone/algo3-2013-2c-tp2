package modelo;


import excepciones.MovimientoInvalidoExcepcion;
import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

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
    
    public void jugar(Vector direccion) throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
    	this.juegoActual.realizarJugadaEnDireccion(direccion);
    }
}
