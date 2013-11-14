package modelo;

public class SorpresaFavorable extends Sorpresa {
    int porcentaje;

    public SorpresaFavorable() {
        porcentaje = -20;
    }

    @Override
    public void interactuarCon(VehiculoMoto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);

    }

    @Override
    public void interactuarCon(Vehiculo4x4 vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);

    }

    @Override
    public void interactuarCon(VehiculoAuto vehiculo) {
        vehiculo.aplicarPorcentajeAMovimientos(porcentaje);

    }

}
