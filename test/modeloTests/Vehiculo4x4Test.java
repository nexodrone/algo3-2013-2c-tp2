package modeloTests;

import static org.junit.Assert.assertEquals;
import modelo.Calle;
import modelo.ObstaculoPiquete;
import modelo.Vector;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;

import org.junit.Test;

import excepciones.ImposiblePasarPorCalleException;
import excepciones.MovimientoInvalidoExcepcion;
import excepciones.MovimientoNoRealizadoException;

public class Vehiculo4x4Test {

	@Test(expected = ImposiblePasarPorCalleException.class)
	public void testAtraparExcepcionPorPiquete() throws ImposiblePasarPorCalleException {
		Vehiculo4x4 auto = new Vehiculo4x4(new Vector(2,2), 0);
		Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
		
		auto.pasarPorCalle(calleATransitar);		
	}
	
    @Test( expected = MovimientoNoRealizadoException.class)
    public void testAtraparExcepcionYQuedarseEnElLugarYSumarUnMovimiento() 
    throws MovimientoNoRealizadoException
    {
    	Vector vectorInicial = new Vector(2,3);
    	Vehiculo4x4 unVehiculo = new Vehiculo4x4(vectorInicial, 0);
    	
    	Calle calleSur = new Calle(new ObstaculoPiquete(), null);
    	Vector sur = new Vector(0,-1);
    	try {unVehiculo.moverEnDireccion(sur, calleSur);}
    	catch( MovimientoNoRealizadoException e){
    		Vector vectorFinal = unVehiculo.getPosicion();
    		assertEquals(1, unVehiculo.getCantidadDeMovimientos());
    		assertEquals(vectorInicial.asString(), vectorFinal.asString());
    		throw new MovimientoNoRealizadoException();
    	}
    }
}
