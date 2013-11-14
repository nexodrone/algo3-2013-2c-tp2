package modelo;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class VehiculoAuto extends Vehiculo {

    public VehiculoAuto(Vector posicionInicial, int puntajeInicial) {
        super();
        this.posicion = posicionInicial;
        this.cantidadDeMovimientos = puntajeInicial;
        // esta porcion de codigo esta tanto en vehiculo4x4 y vehiculoMoto
    }

    public void pasarPorCalle(Calle calleAPasar) throws ImposiblePasarPorCalleException  {
    	Obstaculo obstaculo = calleAPasar.getObstaculo();
    	if( obstaculo != null )
    		try {
    			obstaculo.interactuarCon(this);
    		}catch(PasajeBloqueadoPorPiqueteExcepcion e){
    			System.out.print("Calle bloqueada por el Frente Piqueteros Revolucionarios.\n");
    			throw new ImposiblePasarPorCalleException();
    		}
    }    

    public void aplicarEvento(Sorpresa sorpresa) {
        sorpresa.interactuarCon(this);

    }

    public static Vehiculo nuevoVehiculo(Vehiculo vehiculo) {
        Vehiculo nuevoAuto = new VehiculoAuto(vehiculo.getPosicion(), vehiculo.getCantidadDeMovimientos());
        return nuevoAuto;
    }

}