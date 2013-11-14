package modelo;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.MovimientoNoRealizadoException;

public abstract class Vehiculo {

    protected Vector posicion;
    protected int cantidadDeMovimientos;
    protected Juego juego;

    public Vehiculo(Vector nuevaPosicion, int movimientos) {
        posicion = nuevaPosicion;
        cantidadDeMovimientos = movimientos;
    }

    public Vector getPosicion() {
        return this.posicion;
    }

    public int getCantidadDeMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverEnDireccion(Vector direccion, Calle calleAPasar) throws MovimientoNoRealizadoException {
        // Aca supuestamente pasa por calle (si puede),
        // pero necesita la bocacalle. Como ahora no conoce a tablero,
        // lo va a tener que pedir al juego
        try {
            pasarPorCalle(calleAPasar);
        } catch (ImposiblePasarPorCalleException e) {
            throw new MovimientoNoRealizadoException();
        }
        this.cantidadDeMovimientos = cantidadDeMovimientos + 1;
        this.posicion = calcularSiguientePosicion(direccion);
    }

    public Vector calcularSiguientePosicion(Vector direccion) {
        Vector nuevaPosicion = this.posicion.copy();
        nuevaPosicion.incrementarY(direccion.y());
        nuevaPosicion.incrementarX(direccion.x());
        return nuevaPosicion;
    }

    public void sumarMovimientos(int movimientos) {
        this.cantidadDeMovimientos = this.cantidadDeMovimientos + movimientos;
    }

    protected abstract void pasarPorCalle(Calle calle) throws ImposiblePasarPorCalleException;

    public void aplicarPorcentajeAMovimientos(int porcentaje) {
        float movimientosResultantes = this.cantidadDeMovimientos + this.cantidadDeMovimientos * porcentaje / 100;
        this.cantidadDeMovimientos = Math.round(movimientosResultantes);
    }

    public void cambiarA(Vehiculo vehiculo) {
        juego.cambiarVehiculo(vehiculo);
    }

    public boolean tienenElMismoEstado(Vehiculo vehiculo) {
        boolean cantidad = (cantidadDeMovimientos == vehiculo.getCantidadDeMovimientos());
        boolean posicionesIguales = posicion.sonIguales(vehiculo.getPosicion());
        return (cantidad && posicionesIguales);

    }

    public void setJuegoActual(Juego juegoActual) {
        juego = juegoActual;
    }

}
