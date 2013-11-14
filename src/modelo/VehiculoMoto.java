package modelo;

public class VehiculoMoto extends Vehiculo {

    public VehiculoMoto(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto vehiculo4x4 y vehiculoAuto
    }

    protected void pasarPorCalle(Calle calle) {
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }
}