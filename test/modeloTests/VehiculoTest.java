package modeloTests;

import static org.junit.Assert.*;
import modelo.Vehiculo;
import org.junit.Test;

public class VehiculoTest {

	@Test
	public void testDeberiaCrearVehiculo(){
		Vehiculo unVehiculo = new Vehiculo();
		assertNotNull(unVehiculo);
	}
}