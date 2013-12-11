package modelo;

import org.simpleframework.xml.*;

import control.Logger;

@Root( name = "Pozo")
public class ObstaculoPozo extends Obstaculo {
	
	private static int penalizacionAuto = 3;
	private static int penalizacionMoto = 3;
	
	public ObstaculoPozo() {}
	
	public void interactuarCon(VehiculoAuto auto) {
		auto.sumarMovimientos(penalizacionAuto);
		Logger.instance.log("Pozo. Penalizacion: 3 movimientos.\n");
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		Logger.instance.log("Pozo. Usted esta en 4x4: no penalizacion.\n");
	}

	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(penalizacionMoto);
		Logger.instance.log("Pozo. Penalizacion: 3 movimientos.\n");
	}

	public String asString(){
		return "ObstaculoPozo";
	}
	
}
