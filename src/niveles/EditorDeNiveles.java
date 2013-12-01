package niveles;

import modelo.Nivel;
import modelo.Tablero;

public class EditorDeNiveles {
	
	public static void main(String args[]) throws Exception {
		
		Nivel nivel = new Nivel();
		nivel.tablero = new Tablero(30,30);
		nivel.movimientosDisponibles = 40;
		
		nivel.guardarNivel("src/niveles/NivelDificil.xml");
	}
}
