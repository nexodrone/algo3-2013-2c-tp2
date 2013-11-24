package modelo;

import org.simpleframework.xml.*;

@Root(name="Moto")
public class VehiculoMoto extends Vehiculo {

    public VehiculoMoto(Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto vehiculo4x4 y vehiculoAuto */
    }

    public VehiculoMoto(){}
    
    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);
    }

    public void pasarPorCalle(Calle calleAPasar) {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null) { obstaculo.interactuarCon(this); };
        Sorpresa sorpresa = calleAPasar.getSorpresa(); /* si llego hasta aca entonces no hay problema con obstaculo */
        if (sorpresa != null) { sorpresa.interactuarCon(this);
        						calleAPasar.setSorpresa(null); };
        this.cantidadDeMovimientos++;
     }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoMoto = new VehiculoMoto(vehiculo.getPosicion());
        nuevoMoto.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevoMoto;
    }

}