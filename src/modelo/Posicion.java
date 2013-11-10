package modelo;

public class Posicion {

	private int fila,columna;

	public Posicion(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public String asString() {
		String stringFila, stringColumna;
		stringFila = String.valueOf(this.fila);
		stringColumna = String.valueOf(this.columna);
		return stringFila + "," + stringColumna;
	}

}
