package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import modelo.Vector;
import modelo.Vehiculo;

import org.junit.Test;

import excepciones.MovimientoInvalidoExcepcion;

public class VehiculoTest {

    @Test
    public void testDeberiaCrearVehiculo() {
        Vehiculo unVehiculo = new Vehiculo(new Vector(2,2), 0);
        assertNotNull(unVehiculo);
    }

    @Test
    public void testVehiculoDeberiaQuedarseEnPosicionIndicada() {
    	Vehiculo unVehiculo = new Vehiculo(new Vector(2,3), 0);
        assertEquals(unVehiculo.getPosicion().asString(), "2,3");
    }

    @Test
    public void testPoderMoverseEnTodasDireccionesPosibles() throws MovimientoInvalidoExcepcion {
    	Vehiculo unVehiculo = new Vehiculo(new Vector(2,3), 0);
    	Vector norte = new Vector(0,1);
    	Vector sur = new Vector(0,-1);
    	Vector este = new Vector(1,0);
    	Vector oeste = new Vector(-1,0);
        unVehiculo.moverEnDireccion(sur);
        unVehiculo.moverEnDireccion(este);
        unVehiculo.moverEnDireccion(sur);
        unVehiculo.moverEnDireccion(oeste);
        unVehiculo.moverEnDireccion(oeste);
        unVehiculo.moverEnDireccion(norte);
        assertEquals(unVehiculo.getPosicion().asString(), "1,2");
        assertEquals(unVehiculo.getCantidadDeMovimientos(), 6);
    }

}