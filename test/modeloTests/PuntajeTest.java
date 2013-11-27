package modeloTests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import modelo.Puntaje;

public class PuntajeTest {
	
	@Test
	public void testDeberiaAsignarNombreCorrectamente() {
		Puntaje unPuntaje = new Puntaje();
		unPuntaje.setNombre("Kiko");
		
		assertEquals(unPuntaje.getNombre(), "Kiko");
	}
	
	@Test
	public void testDeberiaAsignarPuntajeCorrectamente() {
		Puntaje unPuntaje = new Puntaje();
		unPuntaje.setPuntaje(50);
		
		assertEquals(unPuntaje.getPuntaje(), 50);
	}
	
	@Test
	public void testDeberiaInicializarPuntajeCorrectamente() {
		Puntaje unPuntaje = new Puntaje("Kiko", 50);
		
		assertEquals(unPuntaje.getNombre(), "Kiko");
		assertEquals(unPuntaje.getPuntaje(), 50);
	}
}
