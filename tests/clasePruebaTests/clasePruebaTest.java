package clasePruebaTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.ejemplo1.Prueba;

public class clasePruebaTest {
	
	@Test
	public void testDeberiaDevolverAtributo(){
		Prueba unaPrueba = new Prueba(15);
		assertEquals(15, unaPrueba.getContenido());
	}
}
