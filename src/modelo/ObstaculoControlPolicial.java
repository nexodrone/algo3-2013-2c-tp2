package modelo;

public class ObstaculoControlPolicial extends Obstaculo {

	private static int penalizacion = 3;	
	public void interactuarCon(VehiculoAuto auto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.5) { 
			auto.sumarMovimientos(penalizacion+1); 
		}else{ 
			auto.sumarMovimientos(1); 
		}
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		double probabilidad = Math.random();
		if (probabilidad<=0.3) { 
			todoterreno.sumarMovimientos(penalizacion+1); 
		}else{ 
				todoterreno.sumarMovimientos(1); 
		}
	}

	public void interactuarCon(VehiculoMoto moto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.8) { 
			moto.sumarMovimientos(penalizacion+1); 
		}else{ moto.sumarMovimientos(1); }
	}

}
