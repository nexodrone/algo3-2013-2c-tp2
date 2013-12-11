package modelo;
import org.simpleframework.xml.*;

import control.Logger;

@Root ( name = "SopresaFavorable")
public class SorpresaFavorable extends Sorpresa {

	private static int porcentaje = -20;

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Favorable! Se te restaron el %20 de tus movimientos realizados, bien ahi!");
    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Favorable! Se te restaron el %20 de tus movimientos realizados, bien ahi!");
    }

    public void interactuarCon(VehiculoMoto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Favorable! Se te restaron el %20 de tus movimientos realizados, bien ahi!");
    }

}
