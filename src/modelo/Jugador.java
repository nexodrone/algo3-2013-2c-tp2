package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;

public class Jugador {

	private String nickName;
	private Vehiculo vehiculo;
	private int cantidadDeMovimientos;

	public Jugador(String nombre, Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		nickName = nombre;
		cantidadDeMovimientos = 0;
	}

	public String getNickName() {
		return this.nickName;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public int getCantidadDeMovimientos() {
		return this.cantidadDeMovimientos;
	}

	public void sumarMovimientos(int cantidad) {
		this.cantidadDeMovimientos = this.cantidadDeMovimientos + cantidad;		
	}

	public void realizarJugadaEnDireccion(char direccion) throws MovimientoInvalidoExcepcion {
		this.cantidadDeMovimientos = this.cantidadDeMovimientos + this.vehiculo.moverEnDireccion(direccion);
	}
	
}
