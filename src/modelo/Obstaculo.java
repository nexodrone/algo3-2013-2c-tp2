package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public abstract class Obstaculo {

	public Obstaculo() {}
	
	public abstract void interactuarCon(VehiculoAuto auto) throws PasajeBloqueadoPorPiqueteExcepcion;
	public abstract void interactuarCon(Vehiculo4x4 todoterreno) throws PasajeBloqueadoPorPiqueteExcepcion;
	public abstract void interactuarCon(VehiculoMoto moto);

}
