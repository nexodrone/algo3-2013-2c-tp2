package modelo;

import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class ObstaculoPiquete extends Obstaculo {

	private static int penalizacionMoto = 2;
	
	public void interactuarCon(VehiculoAuto auto) throws PasajeBloqueadoPorPiqueteExcepcion {
		throw new PasajeBloqueadoPorPiqueteExcepcion();
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) throws PasajeBloqueadoPorPiqueteExcepcion {
		throw new PasajeBloqueadoPorPiqueteExcepcion();
	}

	//ESTE METODO NO ES COHERENTE CON EL SUPUESTO 2 YA QUE ESTAMOS DICIENDO QUE CUANDO UN VEHICULO 
	//PASA POR UNA CALLE CON OBSTACULOS LA PENALIZACION SERA DE X+1, EN ESTE CASO TENDRIA QUE SER 3 NO 2.
	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(penalizacionMoto+1);
	}

}
