package modelo;

import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;


public class Vehiculo4x4 extends Vehiculo {

    public Vehiculo4x4(Posicion posicionInicial) {
        super(posicionInicial);
        // esta porcion de codigo esta tanto en VehiculoMoto y VehiculoAuto
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);
    }

    public static Vehiculo nuevoVehiculo(VehiculoAuto vehiculo) {
        Vehiculo nuevoVehiculo = new Vehiculo4x4(vehiculo.getPosicion());
      return nuevoVehiculo;
    }

    public void pasarPorCalle(Calle calleAPasar) throws PasajeBloqueadoPorPiqueteExcepcion {
        Obstaculo obstaculo = calleAPasar.getObstaculo();
        if (obstaculo != null)
            try {
                obstaculo.interactuarCon(this);
            } catch (PasajeBloqueadoPorPiqueteExcepcion e) {
              throw new PasajeBloqueadoPorPiqueteExcepcion();
             }
        Sorpresa unaSorpresa = calleAPasar.getSorpresa();
        if(unaSorpresa != null){
        	 unaSorpresa.interactuarCon(this);
        }else this.cantidadDeMovimientos++;
     }
    

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = new Vehiculo4x4(vehiculo.getPosicion());
        nuevoVehiculo.setCantidadDeMovimientos(vehiculo.getCantidadDeMovimientos());
        //System.out.println("devolvio una 4x4");
        return nuevoVehiculo;
    }
}
