package modelo;

import modelo.Jugador;

public class Partida{
	
	private int cantidadDeMovimientosTotales;
	private int nivel;
	private Jugador jugador;
	
	public Partida(String nombre){
		this.cantidadDeMovimientosTotales=0;
		this.nivel=0;
		this.jugador= new Jugador(nombre);
	}
	
	public void actualizarMovimientosTotales(){
		this.cantidadDeMovimientosTotales = this.cantidadDeMovimientosTotales + jugador.getCantidadDeMovimientos();		
	}
	
	public int getCantidadDeMovimientosTotales(){
		return this.cantidadDeMovimientosTotales;
	}
	
	public void cambiarSiguienteNivel(){
		this.nivel++;
	}
	
	public int getNivelActual(){
		return this.nivel;
	}
	
	public Jugador getJugador(){
		return this.jugador;
	}
	
	/*public void continuarUltimaPartida(){	
	}
	*/

}
		