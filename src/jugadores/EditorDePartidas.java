package jugadores;

import modelo.Partida;
import modelo.Posicion;
import modelo.Tablero;
import modelo.VehiculoAuto;

public class EditorDePartidas {
	
	public static void main(String args[]) throws Exception {
	
		Tablero tablero = new Tablero(10,10);
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		Posicion posicionGanadora = new Posicion(4,4);
		Partida partida = new Partida(tablero, auto, posicionGanadora, 10);
		partida.guardarPartida("src/jugadores/partida.xml");
	}
}