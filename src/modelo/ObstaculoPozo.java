package modelo;

public class ObstaculoPozo extends Obstaculo {
	
	private static int penalizacionAuto = 3;
	private static int penalizacionMoto = 3;
	
	public ObstaculoPozo() {}
	
	public void interactuarCon(VehiculoAuto auto) {
		auto.sumarMovimientos(penalizacionAuto);
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
	}

	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(penalizacionMoto);
	}

}
