package modelo;

import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import control.Logger;

public abstract class Vehiculo {

    @Element(name = "posicionActual")
    private Posicion posicion;
    @Attribute
    private int cantidadDeMovimientos;
    private Direccion direccion;

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

    public abstract String asString();

    public void moverEnDireccion(Direccion unaDireccion, Calle calleAPasar) throws CalleBloqueadaPorPiqueteExcepcion {
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

    public boolean tienenElMismoEstado(Vehiculo vehiculo) {
        boolean cantidad = (cantidadDeMovimientos == vehiculo.getCantidadDeMovimientos());
        boolean posicionesIguales = posicion.equals(vehiculo.getPosicion());
        return (cantidad && posicionesIguales);
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

    public Posicion calcularSiguientePosicion(Direccion unaDireccion) {
        Posicion nuevaPosicion = this.posicion.copy();
       /* System.out.println("calcularSiguientePosicion");
        System.out.println("Posicion actual" + posicion.asString());
        System.out.println("Direccion" + unaDireccion.x() + "," + unaDireccion.y());*/
        nuevaPosicion.incrementarY(unaDireccion.y());
        nuevaPosicion.incrementarX(unaDireccion.x());
        /*System.out.println("Nueva posicion" + nuevaPosicion.asString());*/
        return nuevaPosicion;
    }

    public void pasarPorCalle(Calle calleAPasar) {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null) {
        	Logger.instance.log("Obstaculo:");
            this.aplicarEvento(obstaculo);
        };
        Sorpresa sorpresa = calleAPasar.getSorpresa();
        if (sorpresa != null) {
        	Logger.instance.log("Sorpresa:");
            this.aplicarEvento(sorpresa);
            calleAPasar.setSorpresa(null);
        };
        this.sumarMovimientos(1);
    }

    public abstract void aplicarEvento(EventoColicion evento);
    // public void guardar(String path) throws Exception {
    // Serializer serializador = new Persister();
    // File resultado = new File(path);
    // serializador.write(this, resultado);
    // }

}
