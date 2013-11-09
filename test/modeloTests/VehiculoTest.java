package modeloTests;

import static org.junit.Assert.*;
import modelo.Vehiculo;
import modelo.Posicion;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testDeberiaCrearVehiculo(){
		Vehiculo unVehiculo = new Vehiculo(new Posicion(0,0));
		assertNotNull(unVehiculo);
	}
}