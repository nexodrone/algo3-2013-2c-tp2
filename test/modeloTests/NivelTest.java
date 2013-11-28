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
	
	@Test
	public void testGuardarYCargarNivelCorrectamente() throws Exception {
		Nivel nivel = new Nivel();
		
		nivel.movimientosDisponibles = 50;
		nivel.filasTablero = 50;
		nivel.columnasTablero = 50;
		nivel.cantidadDeSorpresas = 50;
		nivel.cantidadDeObstaculos = 50;
		
		nivel.guardarNivel(1);
		
		Nivel otroNivel = Nivel.setearNivel(1);
		
		assertEquals(otroNivel.movimientosDisponibles,50);
		assertEquals(otroNivel.filasTablero,50);
		assertEquals(otroNivel.columnasTablero,50);
		assertEquals(otroNivel.cantidadDeSorpresas,50);
		assertEquals(otroNivel.cantidadDeObstaculos,50);		
	}
	
}