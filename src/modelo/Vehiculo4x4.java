package modelo;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Vector posicionInicial, int puntajeInicial) {
        super(posicionInicial, puntajeInicial);
        // esta porcion de codigo esta tanto en VehiculoMoto y VehiculoAuto
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);
    }

    public static Vehiculo nuevoVehiculo(VehiculoAuto vehiculo) {
        Vehiculo nuevoVehiculo = new Vehiculo4x4(vehiculo.getPosicion(), vehiculo.getCantidadDeMovimientos());
        return nuevoVehiculo;
    }

    public void pasarPorCalle(Calle calleAPasar) throws ImposiblePasarPorCalleException {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null)
            try {
                obstaculo.interactuarCon(this);
            } catch (PasajeBloqueadoPorPiqueteExcepcion e) {
                System.out.print("Calle bloqueada por Castells.\n");
                throw new ImposiblePasarPorCalleException();
            }
    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = new Vehiculo4x4(vehiculo.getPosicion(), vehiculo.getCantidadDeMovimientos());
        System.out.println("devolvio una 4x4");
        return nuevoVehiculo;
    }
}
