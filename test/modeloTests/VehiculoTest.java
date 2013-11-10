package modeloTests;

import static org.junit.Assert.*;
import modelo.Tablero;
import modelo.Vehiculo;
import modelo.excepciones.MovimientoInvalidoExcepcion;

import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testDeberiaCrearVehiculo() {
		Vehiculo unVehiculo = new Vehiculo(new Tablero(5,5),2,3);
		assertNotNull(unVehiculo);
	}

	@Test
	public void testVehiculoDeberiaQuedarseEnPosicionIndicada() {
		Vehiculo unVehiculo = new Vehiculo(new Tablero(5,5),2,3);
		assertEquals(unVehiculo.getPosicion().asString(),"2,3");
	}

	@Test
	public void testPoderMoverseEnTodasDireccionesPosibles() throws MovimientoInvalidoExcepcion {
		Vehiculo unVehiculo = new Vehiculo(new Tablero(5,5),1,2);
		int movimientosRealizados = 0;
		movimientosRealizados += unVehiculo.moverEnDireccion('S');
		movimientosRealizados += unVehiculo.moverEnDireccion('O');
		movimientosRealizados += unVehiculo.moverEnDireccion('S');
		movimientosRealizados += unVehiculo.moverEnDireccion('E');
		movimientosRealizados += unVehiculo.moverEnDireccion('E');
		movimientosRealizados += unVehiculo.moverEnDireccion('N');
		assertEquals(unVehiculo.getPosicion().asString(),"2,3");
		assertEquals(movimientosRealizados,6);
	}

	@Test
	public void testDeberiaTirarExcepcionAlMoverEnDireccionInvalida() throws MovimientoInvalidoExcepcion {
		Vehiculo unVehiculo = new Vehiculo(new Tablero(5,5),0,0);
		int num = 0;
		try {	num = unVehiculo.moverEnDireccion('N');
				fail ("Excepcion esperada");
			} catch (MovimientoInvalidoExcepcion expect) {};
		assertEquals(num,0);		/* se comprueba que al intentar a mover en direccion invalida NO SE SUMAN MOVIMIENTOS */
	}
	
	 @Test
	public void testDeberiaMoversePorLimites() throws MovimientoInvalidoExcepcion {
		Vehiculo unVehiculo = new Vehiculo(new Tablero(5,5),0,3);
		int movimientosRealizados = 0;
		movimientosRealizados += unVehiculo.moverEnDireccion('E');
		movimientosRealizados += unVehiculo.moverEnDireccion('S');
		movimientosRealizados += unVehiculo.moverEnDireccion('S');
		movimientosRealizados += unVehiculo.moverEnDireccion('S');
		movimientosRealizados += unVehiculo.moverEnDireccion('S');
		movimientosRealizados += unVehiculo.moverEnDireccion('O');
		assertEquals(unVehiculo.getPosicion().asString(),"4,3");
		assertEquals(movimientosRealizados,6);
	}
	
	
}