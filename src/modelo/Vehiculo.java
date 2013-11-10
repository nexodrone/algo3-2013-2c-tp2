package modelo;

public class Vehiculo {

	private Posicion posicion;
	private Bocacalle bocacalle;

	public Vehiculo(Posicion posInicial) {
		posicion = posInicial;
	}

	public void setPosicion(Posicion posNueva) {
		this.posicion = posNueva;
	}

	public void setBocacalle(Bocacalle bocacalleNueva) {
		this.bocacalle = bocacalleNueva;		
	}

	public Bocacalle getBocacalle() {
		return this.bocacalle;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void moverEnDireccion(char direccion){
		//este método va a hacer el coche se vea afectado por las sorpresas o 
		//obstaculos que haya en el sentido que se le indica que circule
	}

}
