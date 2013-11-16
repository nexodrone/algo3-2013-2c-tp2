package modelo;

public class ObstaculoPozo extends Obstaculo {
	
	private static int penalizacionAuto = 3;
	private static int penalizacion4x4 = 0;
	private static int penalizacionMoto = 3;
	
	public void interactuarCon(VehiculoAuto auto) {
		auto.sumarMovimientos(penalizacionAuto);
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		todoterreno.sumarMovimientos(penalizacion4x4);
	}

	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(penalizacionMoto);
	}

}
