package modelo;

import excepciones.MovimientoInvalidoExcepcion;
import excepciones.MovimientoNoRealizadoException;

public class Juego {

	private Tablero tablero;
	private Vehiculo vehiculo;
	private Vector posicionGanadora;

	public Juego(Tablero tablero, Vehiculo vehiculo, Vector posicionGanadora) {
		this.tablero = tablero;
		this.vehiculo = vehiculo;
		this.posicionGanadora = posicionGanadora;
	}
	
	public void setPosicionGanadora(Vector posicionGanadora) {
		this.posicionGanadora = posicionGanadora;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

    public void realizarJugadaEnDireccion(Vector direccion)
    		throws MovimientoInvalidoExcepcion
    {
    	Vector nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
    	Bocacalle bocacalleActual = tablero.getBocacalleEnPosicion(vehiculo.getPosicion());
    	
    	Calle calleATransitar = bocacalleActual.obtenerCalleEnDireccion(direccion);
    	if (tablero.posicionValida(nuevaPosicion)) {
    		try {
    			vehiculo.moverEnDireccion(direccion, calleATransitar);
    		}catch(MovimientoNoRealizadoException e) {
    			System.out.print("Perdió 1 movimiento.");
    		}
    	}
    	else throw new MovimientoInvalidoExcepcion();
    	
    	// POR ULTIMO, VERIFICAMOS SI LA JUGADA HIZO QUE HAYA GANADO.
    	if (posicionGanadora.equals(vehiculo.getPosicion())){
    		// GANO. ACA TERMINA LA JUGADA.
    	}   
    }
}