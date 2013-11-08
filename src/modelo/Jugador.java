package modelo;

import modelo.Vehiculo;

public class Jugador {
	private String nickName;
	private int cantidadDeMovimientos;
	private Vehiculo vehiculoActual;
	
	public Jugador(String nombre){
		nickName = nombre;
		cantidadDeMovimientos = 0;
		//por ahora la posicion donde se ubica el vehiculo esta harcodeada, luego podria ser pasada como parametro 
		// del constructor del jugador o de la forma que propongan
		vehiculoActual = new Vehiculo(new Posicion(0,0));
	}
	
	// Inicio de métodos referidos a vehiculo
	public String getPosicionDeVehiculoComoString(){
		return vehiculoActual.getPosicion().asString();
	}
	
	public Vehiculo getVehiculo(){
		return vehiculoActual;
	}
	
	public void cambiarDeVehiculo(Vehiculo vehiculoNuevo){
		vehiculoActual = vehiculoNuevo;
	}
	//Fin de métodos referidos a vehiculo
	
	public String getNickName(){
		return this.nickName;
	}
	
	public int getCantidadDeMovimientos(){
		return this.cantidadDeMovimientos;
	}
	
	public void sumarMovimientos(int cantidad){
		this.cantidadDeMovimientos = this.cantidadDeMovimientos + cantidad;		
	}

}
