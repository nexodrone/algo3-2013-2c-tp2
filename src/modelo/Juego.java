package modelo;

import modelo.Tablero;
import modelo.Vehiculo;

public class Juego {

	private Tablero tablero;
	private Vehiculo vehiculo;
	private int movimientos;

	public Juego(int filasTablero, int columnasTablero, char tipoAuto) {
		tablero = new Tablero(filasTablero,columnasTablero);
		vehiculo = new Vehiculo();
		vehiculo.setPosicion(new Posicion(0,0));
		movimientos = 0;
	}

	public String posicionDelVehiculo() {
		return this.vehiculo.getPosicion().asString();
	}

	public void realizarJugadaEnDireccion(char direccion) {
		Calle calleATransitar = this.tablero.calleATransitar(this.vehiculo.getPosicion(),direccion);
		this.vehiculo.moverPorCalle(calleATransitar);
		this.movimientos++;
		Posicion pos = this.vehiculo.getPosicion();
		this.vehiculo.actualizarPosicion(direccion);
		// Antes de actualizar la posicion, se debe verificar que ningun obstaculo
		// impida el movimiento.
	}

	/*public boolean direccionInvalida(char direccion){
		boolean direccionInvalida = true;
		if(this.vehiculo.getPosicion().asString()== "0,0" && direccion == 'N')
			return direccionInvalida;
		else
			return false;
	}*/
	
		
	public int movimientos() {
		return this.movimientos;
	}

}
