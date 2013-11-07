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
		Calle calleATransitar;
		calleATransitar = this.tablero.calleATransitar(this.vehiculo.getPosicion(),direccion);
		this.vehiculo.moverPorCalle(calleATransitar);
		this.movimientos = this.movimientos + 1;
		Posicion pos = this.vehiculo.getPosicion();
		switch (direccion) {
        	case 'N': pos.setFila(pos.getFila() - 1);
                 break;
        	case 'S': pos.setFila(pos.getFila() + 1);
                 break;
        	case 'E': pos.setColumna(pos.getColumna() + 1);
                 break;
        	case 'O': pos.setColumna(pos.getColumna() - 1);
                 break;	
            }
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
