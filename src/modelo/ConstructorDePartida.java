package modelo;
import java.util.Random;

public class ConstructorDePartida {
	
	public static Posicion generarPosicionValida(Nivel nivel){
		Random rnd = new Random();
		int columnas = rnd.nextInt(nivel.tablero.getCantidadDeColumnas());		
		int filas = rnd.nextInt(nivel.tablero.getCantidadDeFilas());
		
		return new Posicion(columnas,filas);
	}
	

	public static Partida construirPartidaCon4x4(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo camioneta = new Vehiculo4x4(posicionInicial);
		Partida partida = new Partida(nivel.tablero, camioneta, posicionGanadora, nivel.movimientosDisponibles);
		partida.dificultad = nivel.dificultad;
		
		return partida;
	}
	
	public static Partida construirPartidaConMoto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo moto = new VehiculoMoto(posicionInicial);
		Partida partida = new Partida(nivel.tablero, moto, posicionGanadora, nivel.movimientosDisponibles);
		partida.dificultad = nivel.dificultad;
		
		return partida;
	}
		
	public static Partida construirPartidaConAuto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo auto = new VehiculoAuto(posicionInicial);
		Partida partida = new Partida(nivel.tablero, auto, posicionGanadora, nivel.movimientosDisponibles);
		partida.dificultad = nivel.dificultad;
		
		return partida;
	}

}
