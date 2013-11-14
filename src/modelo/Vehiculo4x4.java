package modelo;

import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto en VehiculoMoto y VehiculoAuto
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

    public static Vehiculo nuevoVehiculo(VehiculoAuto vehiculo) {
        Vehiculo nuevoVehiculo = new Vehiculo4x4(vehiculo.getPosicion(), vehiculo.getCantidadDeMovimientos());
        return nuevoVehiculo;
    }

}
