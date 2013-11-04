package clasesDePruebaTests;


import static org.junit.Assert.*;

import org.junit.Test;

import clasesDePrueba.PruebaJorge;

public class PruebaJorgeTest {
	
	@Test
	public void testgetNombreDeberiaDevolverNombre(){
		PruebaJorge unaPersona = new PruebaJorge("Jorge",21);
		assertEquals("Jorge", unaPersona.getNombre());
	}

	@Test
	public void testgetEdadDeberiaDevolverEdad(){
		PruebaJorge unaPersona = new PruebaJorge ("Jorge",21);
		assertEquals(21,unaPersona.getEdad());	
	}
}
