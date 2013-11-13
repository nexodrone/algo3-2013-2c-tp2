package modelo;

public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Vector posicionInicial, int puntajeInicial) {
    	super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
    }

    protected void pasarPorCalle(Calle calle) {}
    
}