package modeloTests;

import static org.junit.Assert.*;
import modelo.Bocacalle;
import modelo.Posicion;
import modelo.Tablero;
import org.junit.Test;

public class TableroTest {

	@Test
	public void testDeberiaCrearTableroNoVacio() {
		Tablero unTablero = new Tablero(10,10);
		assertNotNull(unTablero);
	}

	@Test
	public void testObtenerBocacalleATransitarDeUnaPosicionValidaNoDeberiaSerNula(){
		Tablero unTablero = new Tablero(10,10);
		Bocacalle unaBocacalle = unTablero.bocacalleDeReferencia(new Posicion(0,0));
		assertNotNull(unaBocacalle);
	}

	@Test
	public void testCalleEntreDosBocacallesAdyacentesDeberiaSerMismoObjeto() {
		Tablero unTablero = new Tablero(5,5);
		assertEquals(unTablero.getBocacalleEnPosicion(0,0).obtenerCalleEnDireccion('E'),unTablero.getBocacalleEnPosicion(0,1).obtenerCalleEnDireccion('O'));
		assertEquals(unTablero.getBocacalleEnPosicion(4,4).obtenerCalleEnDireccion('N'),unTablero.getBocacalleEnPosicion(3,4).obtenerCalleEnDireccion('S'));
		assertEquals(unTablero.getBocacalleEnPosicion(2,2).obtenerCalleEnDireccion('S'),unTablero.getBocacalleEnPosicion(3,2).obtenerCalleEnDireccion('N'));
	}

}
