package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class ObstaculoPiquete extends Obstaculo {

	private static int penalizacionMoto = 2;
	
	public void interactuarCon(VehiculoAuto auto) throws PasajeBloqueadoPorPiqueteExcepcion {
		throw new PasajeBloqueadoPorPiqueteExcepcion();
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) throws PasajeBloqueadoPorPiqueteExcepcion {
		throw new PasajeBloqueadoPorPiqueteExcepcion();
	}

	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(penalizacionMoto);
	}

}
