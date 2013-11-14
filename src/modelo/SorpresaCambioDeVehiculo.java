package modelo;

public class SorpresaCambioDeVehiculo extends Sorpresa {

    public void interactuarCon(VehiculoMoto vehiculo) {
        // lo convierte a auto.
        Vehiculo nuevoVehiculo = VehiculoAuto.nuevoVehiculo(vehiculo);
        vehiculo.cambiarA(nuevoVehiculo);
    }

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        // a moto
        Vehiculo nuevoVehiculo = VehiculoMoto.nuevoVehiculo(vehiculo);
        vehiculo.cambiarA(nuevoVehiculo);

    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        // auto a 4x4
        Vehiculo nuevoVehiculo = Vehiculo4x4.nuevoVehiculo(vehiculo);
        vehiculo.cambiarA(nuevoVehiculo);
    }
	
}
