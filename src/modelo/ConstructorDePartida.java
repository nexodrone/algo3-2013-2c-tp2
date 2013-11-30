package modelo;
import java.util.Random;

public class ConstructorDePartida {
	
	public Posicion generarPosicionValida(Nivel nivel){
		Random rnd = new Random();
		int columnas = rnd.nextInt(nivel.tablero.getCantidadDeColumnas());		
		int filas = rnd.nextInt(nivel.tablero.getCantidadDeFilas());
		
		return new Posicion(columnas,filas);
	}
	

	public Partida construirPartidaCon4x4(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo camioneta = new Vehiculo4x4(posicionInicial);
		int movimientosDisponibles = nivel.movimientosDisponibles;
		
		return new Partida(nivel.tablero, camioneta, posicionGanadora, movimientosDisponibles);
	}
	
	public Partida construirPartidaConMoto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo moto = new VehiculoMoto(posicionInicial);
		int movimientosDisponibles = nivel.movimientosDisponibles;
		
		return new Partida(nivel.tablero, moto, posicionGanadora, movimientosDisponibles);
	}
		
	public Partida construirPartidaConAuto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo auto = new VehiculoAuto(posicionInicial);
		int movimientosDisponibles = nivel.movimientosDisponibles;

		return new Partida(nivel.tablero, auto, posicionGanadora, movimientosDisponibles);
	}

}
