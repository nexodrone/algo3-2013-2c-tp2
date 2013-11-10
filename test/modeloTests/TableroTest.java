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
		Bocacalle unaBocacalle = unTablero.bocacalleEnPosicion(new Posicion(0,0));
		assertNotNull(unaBocacalle);
	}

	@Test
	public void testCalleEntreDosBocacallesAdyacentesDeberiaSerMismoObjeto() {
		Tablero unTablero = new Tablero(5,5);
		assertEquals(unTablero.bocacalleEnPosicion(new Posicion(0,0)).obtenerCalleEste(),unTablero.bocacalleEnPosicion(new Posicion(0,1)).obtenerCalleOeste());
		assertEquals(unTablero.bocacalleEnPosicion(new Posicion(4,4)).obtenerCalleNorte(),unTablero.bocacalleEnPosicion(new Posicion(3,4)).obtenerCalleSur());
		assertEquals(unTablero.bocacalleEnPosicion(new Posicion(2,2)).obtenerCalleSur(),unTablero.bocacalleEnPosicion(new Posicion(3,2)).obtenerCalleNorte());
	}

}
