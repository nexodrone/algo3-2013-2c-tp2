package modelo;

public class Juego {

	private Partida partida;
	
	public void crearPartidaConJugador(String nombre) {
		partida = new Partida(nombre,10,10);
	}

	public Partida getPartidaActual() {
		return this.partida;
	}

}
