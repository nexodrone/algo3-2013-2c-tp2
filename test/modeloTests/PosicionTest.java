package modeloTests;

import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Posicion;


public class PosicionTest {

	@Test
	public void testDeberiaInicializarseConPosicionDada(){
		Posicion unaPosicion = new Posicion(2,3);
		assertEquals(unaPosicion.getFila(),2);
		assertEquals(unaPosicion.getColumna(),3);
		assertEquals(unaPosicion.asString(),"2,3");
	}
}
