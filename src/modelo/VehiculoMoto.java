package modelo;

import org.simpleframework.xml.Root;

@Root(name = "Moto")
public class VehiculoMoto extends Vehiculo {

    public VehiculoMoto(Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto vehiculo4x4 y vehiculoAuto */
    }

    public VehiculoMoto() {
    }

    public void aplicarEvento(EventoColicion evento) {
        evento.interactuarCon(this);
    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoMoto = new VehiculoMoto(vehiculo.getPosicion());
        nuevoMoto.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevoMoto;
    }

}