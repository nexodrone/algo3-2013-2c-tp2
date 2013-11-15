package modelo;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Vector posicionInicial) {
        super(posicionInicial);
        // esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto
    }

    public void pasarPorCalle(Calle calleAPasar) throws ImposiblePasarPorCalleException {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null)
            try {
                obstaculo.interactuarCon(this);
            }catch (PasajeBloqueadoPorPiqueteExcepcion e) {throw new ImposiblePasarPorCalleException();}
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