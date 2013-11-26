package modelo;

import org.simpleframework.xml.*;

@Root(name = "ControlPolicial" )
public class ObstaculoControlPolicial extends Obstaculo {

	private static int penalizacion = 3;

	public ObstaculoControlPolicial() {}
	
	public void interactuarCon(VehiculoAuto auto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.5) { 
			auto.sumarMovimientos(penalizacion); 
		};
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		double probabilidad = Math.random();
		if (probabilidad<=0.3) { 
			todoterreno.sumarMovimientos(penalizacion); 
		};
	}

	public void interactuarCon(VehiculoMoto moto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.8) { 
			moto.sumarMovimientos(penalizacion); 
		};
	}

}
