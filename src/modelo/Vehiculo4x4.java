package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto en VehiculoMoto y VehiculoAuto */
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);
    }

    public void pasarPorCalle(Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null) { obstaculo.interactuarCon(this); };
        Sorpresa sorpresa = calleAPasar.getSorpresa(); /* si llego hasta aca entonces no hay problema con obstaculo */
        if (sorpresa != null) { sorpresa.interactuarCon(this);
								calleAPasar.setSorpresa(null); };
        this.cantidadDeMovimientos++;
     }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevo4x4 = new Vehiculo4x4(vehiculo.getPosicion());
        nuevo4x4.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevo4x4;
    }

}
