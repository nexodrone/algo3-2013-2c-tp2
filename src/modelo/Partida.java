package modelo;

import modelo.Jugador;

public class Partida {

	private Jugador jugador;
	private int cantidadDeMovimientosTotales;

	public Partida(String nombre) {
		this.cantidadDeMovimientosTotales = 0;
		this.jugador = new Jugador(nombre);
	}

	public void actualizarMovimientosTotales() {
		this.cantidadDeMovimientosTotales = this.cantidadDeMovimientosTotales + jugador.getCantidadDeMovimientos();		
	}

	public int getCantidadDeMovimientosTotales() {
		return this.cantidadDeMovimientosTotales;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

}