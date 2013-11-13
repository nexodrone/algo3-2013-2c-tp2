package modelo;

public class VehiculoMoto extends Vehiculo {

    public VehiculoMoto(Vector posicionInicial, int puntajeInicial) {
    	super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
    }

    protected void pasarPorCalle(Calle calle) {}
    
}