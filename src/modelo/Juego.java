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

	public void realizarJugadaEnDireccion(char direccion) {
		Calle calleATransitar = this.tablero.calleATransitar(this.vehiculo.getPosicion(),direccion);
		this.vehiculo.moverPorCalle(calleATransitar);
		this.cantidadDeMovimientos++;
		/*Posicion pos = this.vehiculo.getPosicion();*/
		this.vehiculo.actualizarPosicion(direccion);
		// Antes de actualizar la posicion, se debe verificar que ningun obstaculo
		// impida el movimiento.
	}

			
	public int movimientos() {
		return this.cantidadDeMovimientos;
	}

}
