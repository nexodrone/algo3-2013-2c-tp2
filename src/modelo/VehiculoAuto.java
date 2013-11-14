package modelo;

public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto
    }

    protected void pasarPorCalle(Calle calle) {
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }
}