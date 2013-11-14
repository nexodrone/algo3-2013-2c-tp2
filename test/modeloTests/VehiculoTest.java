package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import modelo.Bocacalle;
import modelo.Calle;
import modelo.ObstaculoPiquete;
import modelo.Vector;
import modelo.Vehiculo;
import modelo.VehiculoAuto;

import org.junit.Test;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.MovimientoInvalidoExcepcion;
import excepciones.MovimientoNoRealizadoException;

public class VehiculoTest {

    @Test
    public void testDeberiaCrearVehiculo() {
    	Vehiculo vehiculo = new VehiculoAuto(new Vector(2,2), 0);
        assertNotNull(vehiculo);
    }

    @Test
    public void testVehiculoDeberiaQuedarseEnPosicionIndicada() {
    	Vehiculo unVehiculo = new VehiculoAuto(new Vector(2,3), 0);
        assertEquals(unVehiculo.getPosicion().asString(), "2,3");
    }

    @Test
    public void testPoderMoverseEnTodasDireccionesPosibles() throws MovimientoInvalidoExcepcion {
    	Vehiculo unVehiculo = new VehiculoAuto(new Vector(2,3), 0);
    	Bocacalle bocacalleNeutral = new Bocacalle();
    	Vector norte = new Vector(0,1);
    	Vector sur = new Vector(0,-1);
    	Vector este = new Vector(1,0);
    	Vector oeste = new Vector(-1,0);
        try {unVehiculo.moverEnDireccion(sur, bocacalleNeutral.obtenerCalleEnDireccion(sur));}
        catch(MovimientoNoRealizadoException e) {};
        try {unVehiculo.moverEnDireccion(este, bocacalleNeutral.obtenerCalleEnDireccion(este));}
        catch(MovimientoNoRealizadoException e){};
        try {unVehiculo.moverEnDireccion(sur, bocacalleNeutral.obtenerCalleEnDireccion(sur));}
        catch(MovimientoNoRealizadoException e){};
        try {unVehiculo.moverEnDireccion(oeste, bocacalleNeutral.obtenerCalleEnDireccion(oeste));}
        catch(MovimientoNoRealizadoException e){};
        try {unVehiculo.moverEnDireccion(oeste, bocacalleNeutral.obtenerCalleEnDireccion(oeste));}
        catch(MovimientoNoRealizadoException e){};
        try {unVehiculo.moverEnDireccion(norte, bocacalleNeutral.obtenerCalleEnDireccion(norte));}
        catch(MovimientoNoRealizadoException e){};
        assertEquals(unVehiculo.getPosicion().asString(), "1,2");
        assertEquals(unVehiculo.getCantidadDeMovimientos(), 6);
    }
}