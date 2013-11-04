package clasesDePruebaTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import clasesDePrueba.Prueba;

public class PruebaTest {
	
	@Test
	public void testDeberiaDevolverAtributo(){
		Prueba unaPrueba = new Prueba(15);
		assertEquals(15, unaPrueba.getContenido());
	}
}
