package modelo;

import modelo.Calle;

public class Vehiculo {

    private Vector posicion;
    private int cantidadDeMovimientos;

    public Vehiculo(Vector posicionNueva, int puntaje) {
        this.posicion = posicionNueva;
        this.cantidadDeMovimientos = puntaje;
    }

    public Vector getPosicion() {
        return this.posicion;
    }

    public int getCantidadDeMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverEnDireccion(Vector direccion) {
    	// Aca supuestamente pasa por calle (si puede),
    	// pero necesita la bocacalle. Como ahora no conoce a tablero,
    	// lo va a tener que pedir al juego
    	pasarPorCalle(new Calle());
    	cantidadDeMovimientos = cantidadDeMovimientos + 1;
    	this.posicion = calcularSiguientePosicion(direccion);
    }

    public Vector calcularSiguientePosicion(Vector direccion) {
        Vector nuevaPosicion = this.posicion.copy();
        nuevaPosicion.incrementarY(direccion.y());
        nuevaPosicion.incrementarX(direccion.x());
        return nuevaPosicion;
    }

    private void pasarPorCalle(Calle calle) {

    }

}
