package modelo;
import org.simpleframework.xml.*;

@Root ( name = "SopresaFavorable")
public class SorpresaFavorable extends Sorpresa {

	private static int porcentaje = -20;

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
    }

    public void interactuarCon(VehiculoMoto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);
    }

}
