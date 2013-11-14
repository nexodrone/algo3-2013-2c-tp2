package modelo;

public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto en VehiculoMoto y VehiculoAuto
    }

    protected void pasarPorCalle(Calle calle) {
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }
}
