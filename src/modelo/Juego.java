package modelo;

import excepciones.MovimientoInvalidoExcepcion;

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

    public void realizarJugadaEnDireccion(Vector direccion) throws MovimientoInvalidoExcepcion {
    	Vector nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
    	boolean posicionValida = true;
    	if (!posicionGanadora.equals(nuevaPosicion)) { posicionValida = this.tablero.posicionValida(nuevaPosicion); };
    	if (posicionValida) { vehiculo.moverEnDireccion(direccion); } else throw new MovimientoInvalidoExcepcion();
    }

}