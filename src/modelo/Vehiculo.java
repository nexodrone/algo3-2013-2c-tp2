package modelo;

public class Vehiculo {

	private Posicion posicion;

	public void setPosicion(Posicion posNueva) {
		this.posicion = posNueva;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void moverPorCalle(Calle calleATransitar) {
		
	}

	public void actualizarPosicion(char direccion) {
		posicion.actualizar(direccion);
	}
}
