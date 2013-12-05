package niveles;

import modelo.Nivel;
import modelo.Tablero;

public class EditorDeNiveles {
	
	public static void main(String args[]) throws Exception {
		
		Nivel nivel = new Nivel();
		nivel.tablero = new Tablero(21,14);
		nivel.movimientosDisponibles = 25;
		nivel.dificultad = 3;
		nivel.guardarNivel("src/niveles/NivelDificil.xml");
	}
}
