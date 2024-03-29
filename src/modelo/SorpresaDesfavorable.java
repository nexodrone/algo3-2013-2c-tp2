package modelo;
import org.simpleframework.xml.*;

import control.Logger;

@Root( name = "SopresaDesfavorable")
public class SorpresaDesfavorable extends Sorpresa {

	private static int porcentaje = 25;

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Desfavorable! +%25 a los movimientos.\n");
    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Desfavorable! +%25 a los movimientos.\n");
    }

    public void interactuarCon(VehiculoMoto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
        Logger.instance.log("Desfavorable! +%25 a los movimientos.\n");
    }

}
