package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public abstract class Vehiculo {

    @Element(name = "posicionActual")
    protected Posicion posicion;
    @Attribute
    protected int cantidadDeMovimientos;
    protected Direccion direccion;
    protected Juego juego;

    public Vehiculo(Posicion nuevaPosicion) {
        posicion = nuevaPosicion;
        this.cantidadDeMovimientos = 0;
    }

    public Vehiculo() {
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getCantidadDeMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverEnDireccion(Direccion unaDireccion, Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
        direccion = unaDireccion;
        pasarPorCalle(calleAPasar);
        this.setPosicion(this.calcularSiguientePosicion());
    }

    public Posicion calcularSiguientePosicion() {
        if (direccion != null) {
            return this.calcularSiguientePosicion(direccion);
        }
        return posicion;
    }

    public void sumarMovimientos(int movimientos) {
        this.cantidadDeMovimientos = this.cantidadDeMovimientos + movimientos;
    }

    public void aplicarPorcentajeAMovimientos(int porcentaje) {
        float movimientosResultantes = this.cantidadDeMovimientos + (float) this.cantidadDeMovimientos * porcentaje / 100;
        this.cantidadDeMovimientos = Math.round(movimientosResultantes);
    }

    public void cambiarA(Vehiculo vehiculo) {
        juego.cambiarVehiculo(vehiculo);
    }

    public boolean tienenElMismoEstado(Vehiculo vehiculo) {
        boolean cantidad = (cantidadDeMovimientos == vehiculo.getCantidadDeMovimientos());
        System.out.println("la cantidad es:");
        System.out.println(cantidad);
        boolean posicionesIguales = posicion.equals(vehiculo.getPosicion());
        System.out.println("las posicion son:");
        System.out.println(posicionesIguales);
        System.out.println(posicion.asString());
        System.out.println(vehiculo.getPosicion().asString());
        return (cantidad && posicionesIguales);
    }

    public void setJuegoActual(Juego juegoActual) {
        juego = juegoActual;
    }

    public void setCantidadDeMovimientos(int cantidad) {
        cantidadDeMovimientos = cantidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setPosicion(Posicion unaPosicion) {
        posicion = unaPosicion;
    }

    public Juego getJuego() {
        return juego;
    }

    public Posicion calcularSiguientePosicion(Direccion unaDireccion) {
        Posicion nuevaPosicion = this.posicion.copy();
        nuevaPosicion.incrementarY(unaDireccion.y());
        nuevaPosicion.incrementarX(unaDireccion.x());
        return nuevaPosicion;
    }

    public void pasarPorCalle(Calle calleAPasar) {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null) {
            this.aplicarEvento(obstaculo);
        };
        Sorpresa sorpresa = calleAPasar.getSorpresa();
        if (sorpresa != null) {
            this.aplicarEvento(sorpresa);
            calleAPasar.setSorpresa(null);
        };
        this.sumarMovimientos(1);
    }

    public abstract void aplicarEvento(Evento evento);
    // public void guardar(String path) throws Exception {
    // Serializer serializador = new Persister();
    // File resultado = new File(path);
    // serializador.write(this, resultado);
    // }

}
