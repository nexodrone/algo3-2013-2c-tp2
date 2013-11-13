package modelo;

public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Vector posicionInicial, int puntajeInicial) {
    	super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
    }

    protected void pasarPorCalle(Calle calle) {}
    
}
