package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

public class holaMundoManuTest {

	@Test
	public void testSaludaCorrectamente() {
		holaMundoManu saludo = new holaMundoManu();
		assertEquals("Buenas", saludo.saludar());
	}
}
