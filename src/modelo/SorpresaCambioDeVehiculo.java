package modelo;

import org.simpleframework.xml.Root;

@Root(name = "SopresaCambioDeVehiculo")
public class SorpresaCambioDeVehiculo extends Sorpresa {

    public void interactuarCon(VehiculoMoto vehiculo) {
        /* moto a auto */
        Vehiculo nuevoVehiculo = VehiculoAuto.nuevoVehiculo(vehiculo);
        this.actualizarMovimiento(nuevoVehiculo, vehiculo);
        this.cambiarVehiculoEnJuego(nuevoVehiculo, vehiculo);
    }

    public void interactuarCon(VehiculoAuto vehiculo) {
        /* auto a 4x4 */
        Vehiculo nuevoVehiculo = Vehiculo4x4.nuevoVehiculo(vehiculo);
        this.actualizarMovimiento(nuevoVehiculo, vehiculo);
        this.cambiarVehiculoEnJuego(nuevoVehiculo, vehiculo);
    }

    public void interactuarCon(Vehiculo4x4 vehiculo) {
        /* 4x4 a moto */
        Vehiculo nuevoVehiculo = VehiculoMoto.nuevoVehiculo(vehiculo);
        this.actualizarMovimiento(nuevoVehiculo, vehiculo);
        this.cambiarVehiculoEnJuego(nuevoVehiculo, vehiculo);
    }

    // Metodos privados
    private void actualizarMovimiento(Vehiculo nuevoVehiculo, Vehiculo vehiculo) {
        nuevoVehiculo.setPosicion(vehiculo.calcularSiguientePosicion());
        nuevoVehiculo.sumarMovimientos(1);
    }

    private void cambiarVehiculoEnJuego(Vehiculo nuevoVehiculo, Vehiculo vehiculo) {
        vehiculo.cambiarA(nuevoVehiculo);
        nuevoVehiculo.setJuegoActual(vehiculo.getJuego());

    }

}
