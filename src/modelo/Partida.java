package modelo;

public class Partida {

	private Posicion posicionGanadora;
	private int movimientosDisponibles;
	private Vehiculo vehiculo;
	private Tablero tablero;
	
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
}