package modelo;

import java.util.ArrayList;
import modelo.Bocacalle;

public class Tablero {

	private ArrayList<ArrayList<Bocacalle>> bocacalles;
	private int cantidadDeFilas;
	private int cantidadDeColumnas;

	public Tablero(int filas, int columnas) {
		this.cantidadDeFilas = filas;
		this.cantidadDeColumnas = columnas;
		this.bocacalles = new ArrayList<ArrayList<Bocacalle>>();
		for (int i=0; i<filas; i++) {
			ArrayList<Bocacalle> unArray = new ArrayList<Bocacalle>();
			for (int j=0; j<columnas; j++) {
				unArray.add(new Bocacalle());
			}
			this.bocacalles.add(unArray);
		}
		unificarCalles();
	}

	private void unificarCalles() {
		for (int i=0; i<cantidadDeFilas; i++) {
			for (int j=1; j<cantidadDeColumnas; j++) {	// unificar calles horizontales
				this.bocacalles.get(i).get(j).setCalleOeste(this.bocacalles.get(i).get(j-1).obtenerCalleEste());
			}
		}
		for (int i=1; i<cantidadDeFilas; i++) {
			for (int j=0; j<cantidadDeColumnas; j++) {	// unificar calles verticales
				this.bocacalles.get(i).get(j).setCalleNorte(this.bocacalles.get(i-1).get(j).obtenerCalleSur());
			}
		}
	}

	public Bocacalle getBocacalleEnPosicion(Posicion posicion){
		return bocacalles.get(posicion.getFila()).get(posicion.getColumna());
	}

	public int getCantidadDeFilas(){
		return cantidadDeFilas;
	}

	public int getCantidadDeColumnas(){
		return cantidadDeColumnas;
	}

}
