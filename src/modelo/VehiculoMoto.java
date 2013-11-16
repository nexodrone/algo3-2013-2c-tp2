package modelo;

public class VehiculoMoto extends Vehiculo {

    public VehiculoMoto(Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto vehiculo4x4 y vehiculoAuto */
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);
    }

    public void pasarPorCalle(Calle calleAPasar) {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null) { obstaculo.interactuarCon(this); };
        Sorpresa sorpresa = calleAPasar.getSorpresa(); /* si llego hasta aca entonces no hay problema con obstaculo */
        if (sorpresa != null) { 
        	sorpresa.interactuarCon(this);
        	calleAPasar.setSorpresa(null); 
        };
        this.cantidadDeMovimientos++;
     }

    public static Vehiculo nuevoVehiculo(Vehiculo unVehiculo) {
        Vehiculo nuevoMoto = new VehiculoMoto(unVehiculo.getPosicion());
        nuevoMoto.setCantidadDeMovimientos(unVehiculo.getCantidadDeMovimientos());
        return nuevoMoto;
    }

}