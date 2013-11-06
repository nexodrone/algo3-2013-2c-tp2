package modeloTests;

import static org.junit.Assert.assertNotNull;
import modelo.Calle;
import org.junit.Test;

public class CalleTest {

	@Test
	public void testDeberiaCrearCalleNoVacia(){
		Calle unaCalle = new Calle();
		assertNotNull(unaCalle);
	}

}
