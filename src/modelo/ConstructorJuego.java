package modelo;
import java.util.Random;

public class ConstructorJuego {
	
	public Posicion generarPosicionValida(Nivel nivel){
		Random rnd = new Random();
		int columnas = rnd.nextInt(nivel.getCantidadDeFilas());		
		int filas = rnd.nextInt(nivel.getCantidadDeFilas());
		
		return new Posicion(columnas,filas);
	}
	

	public Juego construirJuegoCon4x4(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo camioneta = new Vehiculo4x4(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
		int movimientosDisponibles = nivel.getCantidadDeMovimientos();
		return new Juego(nuevoTablero,camioneta,posicionGanadora,movimientosDisponibles);
	}
	
	public Juego construirJuegoConMoto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo moto = new VehiculoMoto(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
		int movimientosDisponibles = nivel.getCantidadDeMovimientos();
		
		return new Juego(nuevoTablero,moto,posicionGanadora,movimientosDisponibles);
	}
		
	public Juego construirJuegoConAuto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida(nivel);
		Posicion posicionInicial = generarPosicionValida(nivel);
		
		Vehiculo auto = new VehiculoAuto(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas());
		int movimientosDisponibles = nivel.getCantidadDeMovimientos();
		
		return new Juego(nuevoTablero,auto,posicionGanadora,movimientosDisponibles);
	}

}
