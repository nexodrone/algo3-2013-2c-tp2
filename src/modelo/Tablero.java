package modelo;

import java.util.ArrayList;
import modelo.Bocacalle;

public class Tablero {

	private ArrayList<ArrayList<Bocacalle>> bocacalles;
	private int cantidadDeFilas;
	private int cantidadDeColumnas;
	

	public Tablero(int filas, int columnas) {
		cantidadDeFilas = filas;
		cantidadDeColumnas = columnas;
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
		int filas = this.bocacalles.size();
		int columnas = this.bocacalles.get(0).size();
		for (int i=0; i<filas; i++) {
			for (int j=1; j<columnas; j++) {	// unificar calles horizontales
				this.bocacalles.get(i).get(j).setCalleOeste(this.bocacalles.get(i).get(j-1).obtenerCalleEnDireccion('E'));
			}
		}
		for (int i=1; i<filas; i++) {
			for (int j=0; j<columnas; j++) {	// unificar calles verticales
				this.bocacalles.get(i).get(j).setCalleNorte(this.bocacalles.get(i-1).get(j).obtenerCalleEnDireccion('S'));
			}
		}
	}

	public Bocacalle getBocacalleEnPosicion(int fila, int columna) {
		return this.bocacalles.get(fila).get(columna);
	}

	/*ESTE METODO CREO QUE NO LO VAMOS A USAR MAS AHORA EL VEHICULO CONOCE LA BOCACALLE DONDE ESTA POR LO QUE NO VA A NECESITAR 
	 * OBTENER DEL TABLERO LA CALLE A TRANSITAR, LO PUEDE HACER DIRECTAMENTE DESDE LA BOCACALLE.
	public Calle calleATransitar(Posicion posicion, char direccion) {
		int fila = posicion.getFila();
		int columna = posicion.getColumna();
		return bocacalles.get(fila).get(columna).obtenerCalleEnDireccion(direccion);
	}*/
	
	public Bocacalle bocacalleDeReferencia(Posicion posicion){
		int fila = posicion.getFila();
		int columna = posicion.getColumna();
		return bocacalles.get(fila).get(columna);
	}
	
	public int getCantidadDeFilas(){
		return cantidadDeFilas;
	}
	
	public int getCantidadDeColumnas(){
		return cantidadDeColumnas;
	}
	
}
