package modelo;

import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

import org.simpleframework.xml.Root;

@Root(name = "Piquete")
public class ObstaculoPiquete extends Obstaculo {

    private static int penalizacionMoto = 2;

    public ObstaculoPiquete() {
    }

    public void interactuarCon(VehiculoAuto auto) {
        throw new CalleBloqueadaPorPiqueteExcepcion();
    }

    public void interactuarCon(Vehiculo4x4 todoterreno) {
        throw new CalleBloqueadaPorPiqueteExcepcion();
    }

    public void interactuarCon(VehiculoMoto moto) {
        moto.sumarMovimientos(penalizacionMoto);
    }

}
