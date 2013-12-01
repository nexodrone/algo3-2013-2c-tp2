package modelo;

import org.simpleframework.xml.Root;

@Root(name = "Auto")
public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Posicion posicionInicial) {
        super(posicionInicial);
        /* esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto */
    }

    public VehiculoAuto() {
    }

    public void aplicarEvento(EventoColicion evento) {
        evento.interactuarCon(this);
    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoAuto = new VehiculoAuto(vehiculo.getPosicion());
        nuevoAuto.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        return nuevoAuto;
    }
}