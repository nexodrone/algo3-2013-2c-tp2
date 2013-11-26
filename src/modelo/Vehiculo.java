package modelo;

import org.simpleframework.xml.*;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public abstract class Vehiculo {
	
	@Element(name="posicionActual")
    protected Posicion posicion;
	@Attribute
    protected int cantidadDeMovimientos;

    protected Juego juego;
    
    public Vehiculo(Posicion nuevaPosicion) {
        posicion = nuevaPosicion;
        this.cantidadDeMovimientos = 0;
     }

    public Vehiculo() {}
    
    public Posicion getPosicion() {
        return this.posicion;
    }

    public int getCantidadDeMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public void moverEnDireccion(Direccion direccion, Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
    	pasarPorCalle(calleAPasar);
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

    public void aplicarPorcentajeAMovimientos(int porcentaje) {
        float movimientosResultantes = this.cantidadDeMovimientos + (float) this.cantidadDeMovimientos * porcentaje / 100;
        this.cantidadDeMovimientos = Math.round(movimientosResultantes);
    }

    protected abstract void pasarPorCalle(Calle calle) throws PasajeBloqueadoPorPiqueteExcepcion;
    
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
    
//    public void guardar(String path) throws Exception {
//    	Serializer serializador = new Persister();
//    	File resultado = new File(path);
//    	serializador.write(this, resultado);
//    }
    
 }
