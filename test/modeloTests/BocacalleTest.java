package modeloTests;

import static org.junit.Assert.*;
import modelo.Bocacalle;
import modelo.Calle;
import org.junit.Test;

public class BocacalleTest {

	@Test
	public void testDeberiaCrearBocacalleNoVacia(){
		Bocacalle unaBocacalle = new Bocacalle();
		assertNotNull(unaBocacalle);
	}

	@Test
	public void testObtenerCalleEnLasDireccionesPosiblesDeberiaDevolverLaCalle(){
		Bocacalle unaBocacalle = new Bocacalle();
		Calle unaCalle = unaBocacalle.obtenerCalleNorte();
		Calle otraCalle = unaBocacalle.obtenerCalleSur();
		Calle algunaCalle = unaBocacalle.obtenerCalleEste();
		Calle unaCalleMas = unaBocacalle.obtenerCalleOeste();		
		assertNotNull(unaCalle);
		assertNotNull(otraCalle);
		assertNotNull(algunaCalle);
		assertNotNull(unaCalleMas);
	}
	
	@Test
	public void testObtenerCalleEnDireccionEquivocada(){
		
	}
}
