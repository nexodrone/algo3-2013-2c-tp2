package modeloTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.*;

public class NivelTest {

	@Test
	public void testDeberiaSetearMovimientosDisponibles() {
		Nivel nivel = new Nivel();
		nivel.movimientosDisponibles = 50;
		assertEquals(nivel.movimientosDisponibles,50);
	}
	
	@Test
	public void testGuardarYCargarNivelCorrectamente() throws Exception {
		Nivel nivel = new Nivel();
		
		nivel.tablero = new Tablero(10,10);
		nivel.movimientosDisponibles = 15;
		
		nivel.guardarNivel("test/nivelTest.xml");
		Nivel otroNivel = Nivel.cargarNivel("test/nivelTest.xml");
		
		assertEquals(otroNivel.movimientosDisponibles, nivel.movimientosDisponibles);
		assertEquals(otroNivel.tablero.getCantidadDeColumnas(), nivel.tablero.getCantidadDeColumnas());
		assertEquals(otroNivel.tablero.getCantidadDeFilas(), nivel.tablero.getCantidadDeFilas());
	}
	
}