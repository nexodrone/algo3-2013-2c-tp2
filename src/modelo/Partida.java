package modelo;

public class Partida {

	private Tablero tablero;
	private Vehiculo vehiculo;
	private Posicion posicionGanadora;
	private int movimientosDisponibles;
	
	public Partida() {}

	public Partida(Tablero tablero, Vehiculo vehiculo, Posicion posicionGanadora, int movimientosDisponibles) {
		this.tablero = tablero;
		this.vehiculo = vehiculo;
		this.movimientosDisponibles = movimientosDisponibles;
		this.posicionGanadora = posicionGanadora;
	}

	public Tablero getTablero() {
		return this.tablero;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
    public Posicion getPosicionGanadora() {
        return this.posicionGanadora;
    }

	public Posicion posicionDelVehiculo() {
		return vehiculo.getPosicion();
	}

	public int getCantidadDeMovimientosDisponibles() {
		return movimientosDisponibles;
	}

	public boolean esGanada() {
		return (posicionGanadora.equals(vehiculo.posicion));
	}
	
	public boolean esPerdida() {
		return (movimientosDisponibles-vehiculo.cantidadDeMovimientos < 1);
	}

}