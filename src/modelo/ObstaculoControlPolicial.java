package modelo;

public class ObstaculoControlPolicial extends Obstaculo {

	public void interactuarCon(VehiculoAuto auto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.5) { 
			auto.sumarMovimientos(4); 
		}else{ 
			auto.sumarMovimientos(1); 
		}
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		double probabilidad = Math.random();
		if (probabilidad<=0.3) { 
			todoterreno.sumarMovimientos(4); 
		}else{ 
				todoterreno.sumarMovimientos(1); 
		}
	}

	public void interactuarCon(VehiculoMoto moto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.8) { 
			moto.sumarMovimientos(4); 
		}else{ moto.sumarMovimientos(1); }
	}

}
