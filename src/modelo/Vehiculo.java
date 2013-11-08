package modelo;

public class Vehiculo {

	private Posicion posicion;
	
	//ESTE METODO LO AGREGO PARA QUE CUANDO SE CREE EL VEHICULO SE UBIQUE EN ALGUNA POSICION DESEADA
	public Vehiculo(Posicion posInicial){
		posicion = posInicial;
	}

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
