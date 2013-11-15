package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;


public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Posicion posicionInicial) {
        super(posicionInicial);
        // esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto
    }

    public void pasarPorCalle(Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null)
            try {
                obstaculo.interactuarCon(this);
            }catch (PasajeBloqueadoPorPiqueteExcepcion e) {throw new PasajeBloqueadoPorPiqueteExcepcion();}
        Sorpresa unaSorpresa = calleAPasar.getSorpresa();
        if(unaSorpresa != null) {
        	unaSorpresa.interactuarCon(this);
        }else if (obstaculo == null && unaSorpresa == null)this.cantidadDeMovimientos++;
    }
    

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoAuto = new VehiculoAuto(vehiculo.getPosicion());
        nuevoAuto.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevoAuto;
    }

}