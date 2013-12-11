package modelo;
import org.simpleframework.xml.*;

import control.Logger;

@Root ( name = "SopresaFavorable")
public class SorpresaFavorable extends Sorpresa {

	private static int porcentaje = -20;

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Favorable! -%20 a los movimientos!");
    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Favorable! -%20 a los movimientos!");
    }

    public void interactuarCon(VehiculoMoto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Favorable! -%20 a los movimientos!");
    }

}
