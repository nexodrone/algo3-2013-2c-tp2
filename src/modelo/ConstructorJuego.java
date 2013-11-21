package modelo;

public class ConstructorJuego {
	
	public Posicion generarPosicionValida(){
		return new Posicion();
	}
	

	public Juego construirJuegoCon4x4(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida();
		Posicion posicionInicial = generarPosicionValida();
		Vehiculo camioneta = new Vehiculo4x4(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
		return new Juego(nuevoTablero,camioneta,posicionGanadora);
	}
	
	public Juego construirJuegoConMoto(Nivel nivel){
			Posicion posicionGanadora = generarPosicionValida();
			Posicion posicionInicial = generarPosicionValida();
			Vehiculo moto = new VehiculoMoto(posicionInicial);
			Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
			return new Juego(nuevoTablero,moto,posicionGanadora);
	}
		
	public Juego construirJuegoConAuto(Nivel nivel){
		Posicion posicionGanadora = generarPosicionValida();
		Posicion posicionInicial = generarPosicionValida();
		Vehiculo auto = new VehiculoAuto(posicionInicial);
		Tablero nuevoTablero = new Tablero(nivel.getCantidadDeColumnas(),nivel.getCantidadDeFilas()); 
		return new Juego(nuevoTablero,auto,posicionGanadora);
	}

}
