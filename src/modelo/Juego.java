package modelo;

import excepciones.MovimientoInvalidoExcepcion;

public class Juego {

	private Tablero tablero;
	private Vehiculo vehiculo;
	private Vector posicionGanadora;

	public Juego(Tablero tablero, Vehiculo vehiculo, Vector posicionGanadora) {
		this.tablero = tablero;
		this.vehiculo = vehiculo;
		this.posicionGanadora = posicionGanadora;
	}
	
	public void setPosicionGanadora(Vector posicionGanadora) {
		this.posicionGanadora = posicionGanadora;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

    public void realizarJugadaEnDireccion(Vector direccion) throws MovimientoInvalidoExcepcion {
    	Vector nuevaPosicion = vehiculo.calcularSiguientePosicion(direccion);
    	if (!posicionGanadora.equals(nuevaPosicion)) { 
    		if (this.tablero.posicionValida(nuevaPosicion)){
    			//LE TENEMOS QUE PASAR LA CALLE A CIRCULAR AL VEHICULO PORQUE PUEDE ESTAR QUERIENDO PASAR POR UNA CALLE CON PIQUETE!
    			//Calle calleACircular = obtenerCalleACircular(vehiculo.getPosicion(),direccion);
    			//vehiculo.moverEnDireccion(direccion,calleACircular);
    			vehiculo.moverEnDireccion(direccion);
    		} else throw new MovimientoInvalidoExcepcion();
    	}else{
    		//la posicion ganadora siempre es válida
    		vehiculo.moverEnDireccion(direccion);
    	}
    }

    /*
	private Calle obtenerCalleACircular(Vector posicion, Vector direccion) {
		Bocacalle bocacalleACircular = tablero.getBocacalleEnPosicion(posicion);
		Calle calleACircular = bocacalleACircular.obtenerCalleEnDireccion(direccion);
		return calleAcircular;
	}*/
   
    
}