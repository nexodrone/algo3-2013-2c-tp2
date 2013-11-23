package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Partida {

	private Tablero tablero;
	private Vehiculo vehiculo;
	private Posicion posicionGanadora;
	private int movimientosDisponibles;
	
	public Partida() {}

	public Partida(Tablero tablero, Vehiculo vehiculo, Posicion posicion, int movimientos) {
		this.tablero = tablero;
		this.vehiculo = vehiculo;
		this.movimientosDisponibles = movimientos;
		this.posicionGanadora = posicion;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public Posicion posicionPieza() {
		return vehiculo.getPosicion();
	}
	
	public int getCantidadDeMovimientosDisponibles() {
		return movimientosDisponibles;
	}
	
    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        // System.out.print("cambio de vehiculo");
        vehiculo = nuevoVehiculo;
    }
	
    public void moverPiezaEnDireccion(Direccion direccion)
    		throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion
    {
   		Posicion nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
   		if (this.tablero.posicionValida(nuevaPosicion)) {
			Bocacalle bocacalleActual = tablero.getBocacalleEnPosicion(vehiculo.getPosicion());
			Calle calleATransitar = bocacalleActual.getCalleEnDireccion(direccion);
			try {	
				vehiculo.moverEnDireccion(direccion, calleATransitar);
				//verificarEstadoJugador();
			}catch (PasajeBloqueadoPorPiqueteExcepcion e) {
					System.out.print("Imposible mover en esa direccion. \n");
				}
		}else throw new MovimientoInvalidoExcepcion();
   		
   		movimientosDisponibles--;
    }
}