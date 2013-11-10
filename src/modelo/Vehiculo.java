package modelo;

import modelo.excepciones.MovimientoInvalidoExcepcion;

public class Vehiculo {

	private Posicion posicion;
	private Tablero tablero;

	public Vehiculo() {
		this.posicion = new Posicion(0,0);
		this.tablero = new Tablero(5,5);
	}

	public Vehiculo(Tablero tablero, int filaInicial, int columnaInicial) {
		this.posicion = new Posicion(filaInicial,columnaInicial);
		this.tablero = tablero;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public int moverEnDireccion (char direccion) throws MovimientoInvalidoExcepcion {
		if (jugadaValida(direccion)) {

			Bocacalle bocacalleActual = this.tablero.getBocacalleEnPosicion(posicion);
			switch (direccion) {
			case 'N':
					procesarCalle(bocacalleActual.obtenerCalleNorte());
					this.posicion.setFila(this.posicion.getFila()-1);
					break;
			case 'S':
					procesarCalle(bocacalleActual.obtenerCalleSur());
					this.posicion.setFila(this.posicion.getFila()+1);
					break;
			case 'E':
					procesarCalle(bocacalleActual.obtenerCalleEste());
					this.posicion.setColumna(this.posicion.getColumna()+1);
					break;
			case 'O':
					procesarCalle(bocacalleActual.obtenerCalleOeste());
					this.posicion.setColumna(this.posicion.getColumna()-1);
					break;
			}
			return 1;

		} else { throw new MovimientoInvalidoExcepcion(); }
	}

	private boolean jugadaValida(char direccion) {
		Posicion nuevaPosicion = this.calcularSiguientePosicion(direccion);
		if(	(nuevaPosicion.getColumna() < 0) ||
			(nuevaPosicion.getColumna() > this.tablero.getCantidadDeColumnas()) ||
			(nuevaPosicion.getFila() < 0)||
			(nuevaPosicion.getFila() > this.tablero.getCantidadDeFilas())
			) return false;
		else return true;
	}

	private Posicion calcularSiguientePosicion(char direccion){
		int fila = this.posicion.getFila();
		int columna = this.posicion.getColumna();
		Posicion nuevaPosicion = new Posicion(fila, columna);
		switch (direccion) {
			case 'N':
					nuevaPosicion.setFila(fila-1);
					break;
			case 'S':
					nuevaPosicion.setFila(fila+1);
					break;
			case 'E':
					nuevaPosicion.setColumna(columna+1);
					break;
			case 'O':
					nuevaPosicion.setColumna(columna-1);
					break;
			}
		return nuevaPosicion;
	}

	private void procesarCalle(Calle calle) {
		
	}
	
}
