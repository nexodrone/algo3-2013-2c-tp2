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
		Logger.instance.log("Guarda los baches! Estas usando un auto, no una 4x4! Perdiste 3 movimientos...");
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		Logger.instance.log("La 4x4 tiene inmunidad contra pozos! No perdes ningun movimiento...");
	}

	public void interactuarCon(VehiculoMoto moto) {
		moto.sumarMovimientos(penalizacionMoto);
		Logger.instance.log("Guarda los baches! Estas usando una moto, no una 4x4! Perdiste 3 movimientos...");
	}

	public String asString(){
		return "ObstaculoPozo";
	}
	
}
