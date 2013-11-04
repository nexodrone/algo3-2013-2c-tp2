package clasesDePruebaTests;

import static org.junit.Assert.*;

import org.junit.Test;

import clasesDePrueba.HolaMundoManu;

public class HolaMundoManuTest {

	@Test
	public void testSaludaCorrectamente() {
		HolaMundoManu saludo = new HolaMundoManu();
		assertEquals("Buenas", saludo.saludar());
	}
}
