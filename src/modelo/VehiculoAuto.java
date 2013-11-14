package modelo;

import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto
    }

    protected void pasarPorCalle(Calle calle) {
    	Obstaculo obstaculoAAtravesar = calle.getObstaculo();
    	try {
    		obstaculoAAtravesar.interactuarCon(this);
    	} catch (PasajeBloqueadoPorPiqueteExcepcion esperada) {};
    }
    
    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoAuto = new VehiculoAuto(vehiculo.getPosicion(), vehiculo.getCantidadDeMovimientos());
        return nuevoAuto;
    }

}