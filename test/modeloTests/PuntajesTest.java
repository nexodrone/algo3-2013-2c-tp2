package modeloTests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import modelo.Puntajes;
import modelo.Puntaje;
import java.util.*;

public class PuntajesTest {
	
	@Test
	public void testAgregarPuntajesYObtenerlosOrdenadosCorrectamente() {
		Puntajes puntajes = new Puntajes();
		puntajes.agregarPuntaje("Charito", 22);
		puntajes.agregarPuntaje("Chocha", 48);
		puntajes.agregarPuntaje("Checho", 5);
		puntajes.agregarPuntaje("Carolito", 125);
		
		ArrayList<Puntaje> otrosPtjes = puntajes.getPuntajesOrdenados();
		
		assertEquals(otrosPtjes.get(0).getPuntaje(), 125);
		assertEquals(otrosPtjes.get(1).getPuntaje(), 48);
		assertEquals(otrosPtjes.get(2).getPuntaje(), 22);
		assertEquals(otrosPtjes.get(3).getPuntaje(), 5);		
	}
	
	@Test
	public void testGuardarPuntajeCorrectamente() throws Exception {
		Puntajes puntajes = new Puntajes();
		
		puntajes.agregarPuntaje("Carloncho", 30);
		puntajes.agregarPuntaje("Roberto", 40);
		
		puntajes.guardar("test/puntajesTest.xml");
		
		Puntajes otrosPuntajes = Puntajes.recuperar("test/puntajesTest.xml");
		
		List<Puntaje> ordenados = otrosPuntajes.getPuntajesOrdenados();
		assertEquals(ordenados.get(0).getPuntaje(), 40);
		assertEquals(ordenados.get(0).getNombre(), "Roberto");
				
		assertEquals(ordenados.get(1).getPuntaje(), 30);
		assertEquals(ordenados.get(1).getNombre(), "Carloncho");
	}
}
