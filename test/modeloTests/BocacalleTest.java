package modeloTests;

import static org.junit.Assert.*;
import modelo.Bocacalle;
import modelo.Calle;
import org.junit.Test;

public class BocacalleTest {

	@Test
	public void testDeberiaCrearBocacalleNoVacia(){
		Bocacalle unaBocacalle = new Bocacalle();
		assertNotNull(unaBocacalle);
	}

	@Test
	public void testDeberiaDevloverCalle(){
		Bocacalle unaBocacalle = new Bocacalle();
		Calle unaCalle = unaBocacalle.obtenerCalleEnDireccion('N');
		assertNotNull(unaCalle);
	}
}
