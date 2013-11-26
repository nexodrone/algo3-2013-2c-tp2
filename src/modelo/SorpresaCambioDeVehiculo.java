package modelo;

import org.simpleframework.xml.*;

@Root( name = "SopresaCambioDeVehiculo" )
public class SorpresaCambioDeVehiculo extends Sorpresa {

    public void interactuarCon(VehiculoMoto vehiculo) {
        /* moto a auto */
        Vehiculo nuevoVehiculo = VehiculoAuto.nuevoVehiculo(vehiculo);
        vehiculo.cambiarA(nuevoVehiculo);
    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        /* auto a 4x4 */
        Vehiculo nuevoVehiculo = Vehiculo4x4.nuevoVehiculo(vehiculo);
        vehiculo.cambiarA(nuevoVehiculo);
    }

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        /* 4x4 a moto */
        Vehiculo nuevoVehiculo = VehiculoMoto.nuevoVehiculo(vehiculo);
        vehiculo.cambiarA(nuevoVehiculo);
    }

}
