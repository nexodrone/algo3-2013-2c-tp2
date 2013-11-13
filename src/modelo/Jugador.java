package modelo;

import excepciones.MovimientoInvalidoExcepcion;

public class Jugador {

    private String nickName;
    private Juego juegoActual;

    public Jugador(String nombre) {
        nickName = nombre;
    }

    public void asignarJuego(Juego juego) {
    	juegoActual = juego;
    }

    public String getNickName() {
        return this.nickName;
    }

    public Juego getJuegoActual() {
    	return juegoActual;
    }
    
    public void jugar(Vector direccion) throws MovimientoInvalidoExcepcion {
    	this.juegoActual.realizarJugadaEnDireccion(direccion);
    }
}
