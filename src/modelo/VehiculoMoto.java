package modelo;

public class VehiculoMoto extends Vehiculo {

    public VehiculoMoto(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto vehiculo4x4 y vehiculoAuto
    }

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }

    public void pasarPorCalle(Calle calleAPasar) {
    	Obstaculo obstaculo = calleAPasar.getObstaculo();
    	if( obstaculo != null )
    			obstaculo.interactuarCon(this);
    }
    
    public static Vehiculo nuevoVehiculo(Vehiculo4x4 vehiculo) {
        Vehiculo nuevoAuto = new VehiculoMoto(vehiculo.getPosicion(), vehiculo.getCantidadDeMovimientos());
        return nuevoAuto;
    }
}