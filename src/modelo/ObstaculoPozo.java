package modelo;

public class ObstaculoPozo extends Obstaculo {
	
	public void interactuarCon(VehiculoAuto auto) {
		auto.sumarMovimientos(4);
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		todoterreno.sumarMovimientos(1);
	}

	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(4);
	}

}
