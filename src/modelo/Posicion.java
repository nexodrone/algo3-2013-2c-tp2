package modelo;

public class Posicion {

	private int fila,columna;
	
	public Posicion(int fil, int col) {
		this.fila = fil;
		this.columna = col;
	}

	public void setFila(int fil) {
		this.fila = fil;
	}
	
	public void setColumna(int col) {
		this.columna = col;
	}

	public int getFila(){
		return fila;
	}
	
	public int getColumna(){
		return columna;
	}

	public String asString(){
		String stringFila, stringColumna;
		stringFila = String.valueOf(this.fila);
		stringColumna = String.valueOf(this.columna);
		return stringFila+","+stringColumna;
	}
}