package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;


public abstract class Vehiculo {

    protected Posicion posicion;
    protected int cantidadDeMovimientos;
    protected Juego juego;

    public Vehiculo(Posicion nuevaPosicion) {
        posicion = nuevaPosicion;
        this.cantidadDeMovimientos = 0;
     }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getCantidadDeMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverEnDireccion(Direccion direccion, Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
        try{
            pasarPorCalle(calleAPasar);
        } catch (PasajeBloqueadoPorPiqueteExcepcion e) {
            throw new PasajeBloqueadoPorPiqueteExcepcion();
        }
      this.posicion = calcularSiguientePosicion(direccion);
    }

    public Posicion calcularSiguientePosicion(Direccion direccion) {
        Posicion nuevaPosicion = this.posicion.copy();
        nuevaPosicion.incrementarY(direccion.y());
        nuevaPosicion.incrementarX(direccion.x());
        return nuevaPosicion;
    }

    public void sumarMovimientos(int movimientos) {
        this.cantidadDeMovimientos = this.cantidadDeMovimientos + movimientos;
    }

    protected abstract void pasarPorCalle(Calle calle) throws PasajeBloqueadoPorPiqueteExcepcion;

    public void aplicarPorcentajeAMovimientos(int porcentaje) {
        float movimientosResultantes = this.cantidadDeMovimientos + this.cantidadDeMovimientos * porcentaje / 100;
        this.cantidadDeMovimientos = Math.round(movimientosResultantes);
    }

    public void cambiarA(Vehiculo vehiculo) {
        juego.cambiarVehiculo(vehiculo);
    }

    public boolean tienenElMismoEstado(Vehiculo vehiculo) {
        boolean cantidad = (cantidadDeMovimientos == vehiculo.getCantidadDeMovimientos());
        boolean posicionesIguales = posicion.equals(vehiculo.getPosicion());
        return (cantidad && posicionesIguales);

    }

    public void setJuegoActual(Juego juegoActual) {
        juego = juegoActual;
    }

    public void setCantidadDeMovimientos(int cantidad){
    	cantidadDeMovimientos = cantidad;
    }
    
}
