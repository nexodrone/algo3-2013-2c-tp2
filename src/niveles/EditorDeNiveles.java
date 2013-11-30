package niveles;

import modelo.Nivel;
import modelo.Tablero;

public class EditorDeNiveles {
	
	public static void main(String args[]) throws Exception {
		
		Nivel nivel = new Nivel();
		nivel.tablero = new Tablero(10,10);
		nivel.movimientosDisponibles = 20;
		
		nivel.guardarNivel("src/niveles/nivel1.xml");
	}
}
