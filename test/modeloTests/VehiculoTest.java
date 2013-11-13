package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import modelo.Posicion;
import modelo.Tablero;
import modelo.Vector;
import modelo.Vehiculo;
import modelo.excepciones.MovimientoInvalidoExcepcion;

import org.junit.Test;

public class VehiculoTest {

    @Test
    public void testDeberiaCrearVehiculo() {
        Vehiculo unVehiculo = new Vehiculo(new Tablero(5, 5), new Posicion(2, 3));
        assertNotNull(unVehiculo);
    }

    @Test
    public void testVehiculoDeberiaQuedarseEnPosicionIndicada() {
        Vehiculo unVehiculo = new Vehiculo(new Tablero(5, 5), new Posicion(2, 3));
        assertEquals(unVehiculo.getPosicion().asString(), "2,3");
    }

    @Test
    public void testPoderMoverseEnTodasDireccionesPosibles() throws MovimientoInvalidoExcepcion {
        Vehiculo unVehiculo = new Vehiculo(new Tablero(5, 5), new Posicion(1, 2));
        int movimientosRealizados = 0;

        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(1,0));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(1,0));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(1,0));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(0,-1));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(-1,0));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(-1,0));
        assertEquals(unVehiculo.getPosicion().asString(), "0,3");
        //assertEquals(movimientosRealizados, 6);
    }

    @Test
    public void testDeberiaTirarExcepcionAlMoverEnDireccionInvalida() throws MovimientoInvalidoExcepcion {
        Vector norte = new Vector(0, 1);
        Vehiculo unVehiculo = new Vehiculo(new Tablero(5, 5), new Posicion(0, 0));
        int num = 0;
        try {
            num = unVehiculo.moverEnDireccion(norte);
            fail("Excepcion esperada");
        } catch (MovimientoInvalidoExcepcion expect) {
        };
        assertEquals(num, 0); /*
                               * se comprueba que al intentar a mover en direccion invalida NO SE
                               * SUMAN MOVIMIENTOS
                               */
     }

    @Test
    public void testDeberiaMoversePorLimites() throws MovimientoInvalidoExcepcion {
        Vehiculo unVehiculo = new Vehiculo(new Tablero(4, 5), new Posicion(0, 3));
        int movimientosRealizados = 0;
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(0,1));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector (1,0));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(0,1));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(-1,0));
        movimientosRealizados += unVehiculo.moverEnDireccion(new Vector(0,-1));
        assertEquals(unVehiculo.getPosicion().asString(), "1,3");
    //    assertEquals(movimientosRealizados, 6);
    }

}