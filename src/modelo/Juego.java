package modelo;

public class Juego {

	private Partida partida;
	//private Tablero tablero;
	//private Vehiculo vehiculo;
	
	public void crearPartidaConJugador(String nombre) {
		partida = new Partida(nombre,10,10);
	}

	public Partida getPartidaActual() {
		return this.partida;
	}

	//public void movete(direccion){
	//
	//
	//
	//}	
	
}
