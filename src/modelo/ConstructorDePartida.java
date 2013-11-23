package modelo;
import java.util.Random;

public class ConstructorDePartida {
	
	public Posicion generarPosicionValida(Nivel nivel){
		Random rnd = new Random();
		int columnas = rnd.nextInt(nivel.getCantidadDeFilas());		
		int filas = rnd.nextInt(nivel.getCantidadDeFilas());
		
		return new Posicion(columnas,filas);
	}
	

	public Partida construirPartidaCon4x4(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo camioneta = new Vehiculo4x4(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
		int movimientosDisponibles = nivel.getCantidadDeMovimientos();
		
		return new Partida(nuevoTablero,camioneta,posicionGanadora,movimientosDisponibles);
	}
	
	public Partida construirPartidaConMoto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo moto = new VehiculoMoto(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
		int movimientosDisponibles = nivel.getCantidadDeMovimientos();
		
		return new Partida(nuevoTablero,moto,posicionGanadora,movimientosDisponibles);
	}
		
	public Partida construirPartidaConAuto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo auto = new VehiculoAuto(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas());
		int movimientosDisponibles = nivel.getCantidadDeMovimientos();
		
		return new Partida(nuevoTablero,auto,posicionGanadora,movimientosDisponibles);
	}

}
