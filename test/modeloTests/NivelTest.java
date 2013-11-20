package modeloTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Nivel;

public class NivelTest {

	@Test
	public void testDeberiaSetearMovimientosDisponibles() {
		Nivel nivel = new Nivel();
		nivel.movimientosDisponibles = 50;
		assertEquals(nivel.movimientosDisponibles,50);
	}
	
	@Test
	public void testDeberiaSetearFilasTablero() {
		Nivel nivel = new Nivel();
		nivel.filasTablero = 50;
		assertEquals(nivel.filasTablero,50);
	}

	@Test
	public void testDeberiaSetearColumnasTablero() {
		Nivel nivel = new Nivel();
		nivel.columnasTablero = 50;
		assertEquals(nivel.columnasTablero,50);
	}
	
	@Test
	public void testDeberiaSetearCantidadDeSorpresas() {
		Nivel nivel = new Nivel();
		nivel.cantidadDeSorpresas = 50;
		assertEquals(nivel.cantidadDeSorpresas,50);
	}
	
	@Test
	public void testDeberiaSetearCantidadDeObstaculos() {
		Nivel nivel = new Nivel();
		nivel.cantidadDeObstaculos = 50;
		assertEquals(nivel.cantidadDeObstaculos,50);
	}
	
}