package modelo;

import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

import org.simpleframework.xml.Root;

import control.Logger;

@Root(name = "Piquete")
public class ObstaculoPiquete extends Obstaculo {

    private static int penalizacionMoto = 2;

    public ObstaculoPiquete() {
    }

    public void interactuarCon(VehiculoAuto auto) {
        Logger.instance.log("Piquete. No se puede pasar!");
        throw new CalleBloqueadaPorPiqueteExcepcion();
    }

    public void interactuarCon(Vehiculo4x4 todoterreno) {
    	Logger.instance.log("Piquete. No se puede pasar!");
        throw new CalleBloqueadaPorPiqueteExcepcion();
    }

    public void interactuarCon(VehiculoMoto moto) {
    	Logger.instance.log("Piquete. Penalizacion: 2 movimientos.");
        moto.sumarMovimientos(penalizacionMoto);
    }
    
	public String asString(){
		return "ObstaculoPiquete";
	}

}
