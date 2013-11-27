package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.simpleframework.xml.Root;

@Root(name = "Piquete")
public class ObstaculoPiquete extends Obstaculo {

    private static int penalizacionMoto = 2;

    public ObstaculoPiquete() {
    }

    public void interactuarCon(VehiculoAuto auto) {
        throw new PasajeBloqueadoPorPiqueteExcepcion();
    }

    public void interactuarCon(Vehiculo4x4 todoterreno) {
        throw new PasajeBloqueadoPorPiqueteExcepcion();
    }

    public void interactuarCon(VehiculoMoto moto) {
        moto.sumarMovimientos(penalizacionMoto);
    }

}
