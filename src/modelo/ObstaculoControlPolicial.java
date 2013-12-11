package modelo;

import org.simpleframework.xml.*;

import control.Logger;

@Root(name = "ControlPolicial" )
public class ObstaculoControlPolicial extends Obstaculo {

	private static int penalizacion = 3;

	public ObstaculoControlPolicial() {}
	
	public void interactuarCon(VehiculoAuto auto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.5) { 
			auto.sumarMovimientos(penalizacion);
			Logger.instance.log("Te paro la policia y te dio positivo el test de alcoholemia, perdiste 3 movimientos...");
		}else
			Logger.instance.log("Te paro la policia pero te dio negativo el test de alcoholemia, vaya suerte! No perdiste ningun movimiento!");
	}

	public void interactuarCon(Vehiculo4x4 todoterreno) {
		double probabilidad = Math.random();
		if (probabilidad<=0.3) { 
			todoterreno.sumarMovimientos(penalizacion);
			Logger.instance.log("Te paro la policia y te dio positivo el test de alcoholemia, perdiste 3 movimientos...");			
		}else
			Logger.instance.log("Te paro la policia pero te dio negativo el test de alcoholemia, vaya suerte! No perdiste ningun movimiento!");
	}

	public void interactuarCon(VehiculoMoto moto) {
		double probabilidad = Math.random();
		if (probabilidad<=0.8) { 
			moto.sumarMovimientos(penalizacion);
			Logger.instance.log("Te paro la policia y te dio positivo el test de alcoholemia, perdiste 3 movimientos...");
		}else
			Logger.instance.log("Te paro la policia pero te dio negativo el test de alcoholemia, vaya suerte! No perdiste ningun movimiento!");
	}

	public String asString(){
		return "ObstaculoControlPolicial";
	}
}
