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
        System.out.println("no se puede mover por el piquete");
        Logger.instance.log("Cuidado o te van a romper el coche! Calle bloqueada por Castels...");
        throw new CalleBloqueadaPorPiqueteExcepcion();
    }

    public void interactuarCon(Vehiculo4x4 todoterreno) {
    	Logger.instance.log("Imposible atropellar a la plebe con tu 4x4! Calle bloqueada por el Frente Piquetero Revolucionario...");
        throw new CalleBloqueadaPorPiqueteExcepcion();
    }

    public void interactuarCon(VehiculoMoto moto) {
    	Logger.instance.log("Pudiste atravesar el piquete! Aunque se te descontaran 2 movimientos...");
        moto.sumarMovimientos(penalizacionMoto);
    }
    
	public String asString(){
		return "ObstaculoPiquete";
	}

}
