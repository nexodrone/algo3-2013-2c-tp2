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
}
