package modelo;

import modelo.Tablero;
import modelo.Vehiculo;

public class Juego {

	private Tablero tablero;
	private Vehiculo vehiculo;
	private int cantidadDeMovimientos;
	
	/*public void realizarJugadaEnDireccionNorte() {
	
	Solo usar la clases DireccionDeMovimiento.NORTE
	Y refactorizar el anterior
	
	}*/


	public Juego(int filasTablero, int columnasTablero, char tipoAuto) {
		tablero = new Tablero(filasTablero,columnasTablero);
		vehiculo = new Vehiculo(new Posicion(0,0));
		vehiculo.setPosicion(new Posicion(0,0));
		cantidadDeMovimientos = 0;
	}

	public String posicionDelVehiculo() {
		return this.vehiculo.getPosicion().asString();
	}
	
	public boolean jugadaValida(char direccion){
		Posicion nuevaPosicion = this.calcularSiguientePosicion(direccion);
		if(	(nuevaPosicion.getColumna()<0) ||
			(nuevaPosicion.getColumna()> this.tablero.getCantidadDeColumnas()) ||
			(nuevaPosicion.getFila()<0)||
			(nuevaPosicion.getFila()>this.tablero.getCantidadDeFilas())
			) return false;
		else return true;
	}
	
	public Posicion calcularSiguientePosicion(char direccion){
		int fila = this.vehiculo.getPosicion().getFila();
		int columna = this.vehiculo.getPosicion().getColumna();
		Posicion nuevaPosicion = new Posicion(fila,columna);
		switch (direccion){
			case 'N': 
					nuevaPosicion.setFila(fila-1);
					break;
			case 'S':
					nuevaPosicion.setFila(fila+1);
					break;
			case 'O': 
					nuevaPosicion.setColumna(columna-1);
					break;
			case 'E': 
					nuevaPosicion.setColumna(columna+1);
					break;
			}
			
		return nuevaPosicion;
	}

	public void realizarJugadaEnDireccion(char direccion) {
		if (jugadaValida(direccion)){
			Posicion nuevaPosicion = this.calcularSiguientePosicion(direccion);
			this.vehiculo.moverEnDireccion(direccion);
			this.vehiculo.setPosicion(nuevaPosicion);
			this.vehiculo.setBocacalle(this.tablero.bocacalleDeReferencia(nuevaPosicion));
		} //se lanza una excepcion 
	}

			
	public int movimientos() {
		return this.cantidadDeMovimientos;
	}

}
