package modelo;

import java.util.ArrayList;
import modelo.Bocacalle;

public class Tablero {

	private ArrayList<ArrayList<Bocacalle>> bocacalles;
	
	public Tablero(int filas, int columnas) {
		this.bocacalles = new ArrayList<ArrayList<Bocacalle>>();
		for (int i=0; i<filas; i++){
			ArrayList<Bocacalle> unArray = new ArrayList<Bocacalle>();
			for (int j=0; j<columnas; j++){
				unArray.add(new Bocacalle());
			}
			this.bocacalles.add(unArray);
		}
	}

	public Calle calleATransitar(Posicion posicion, char direccion) {
		int fila = posicion.getFila();
		int columna = posicion.getColumna();
		return bocacalles.get(fila).get(columna).obtenerCalleEnDireccion(direccion);
	}
}
