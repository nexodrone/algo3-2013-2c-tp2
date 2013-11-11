package modelo;

import modelo.Jugador;

public class Partida {

	private Jugador jugador;
	private Tablero tablero;
	private int cantidadDeMovimientosTotales;

	public Partida(String nombre, int filasTablero, int columnasTablero) {
		this.tablero = new Tablero(filasTablero,columnasTablero);
		this.jugador = new Jugador(nombre, new Vehiculo(this.tablero,new Posicion(0,0)));
		this.cantidadDeMovimientosTotales = 0;
	}

	public String posicionDelVehiculo() {
		return this.jugador.getVehiculo().getPosicion().asString();
	}

	public void actualizarMovimientosTotales() {
		this.cantidadDeMovimientosTotales = this.cantidadDeMovimientosTotales + jugador.getCantidadDeMovimientos();		
	}

	public int movimientosRealizadosEnTotal() {
		return this.cantidadDeMovimientosTotales;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

}