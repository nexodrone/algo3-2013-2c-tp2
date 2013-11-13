package modeloTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.SorpresaFavorable;
import modelo.Vector;
import modelo.VehiculoAuto;

public class SorpresaFavorableTest {

	@Test
	public void testDeberiaRestarCorrectamentePuntaje() {
		VehiculoAuto auto = new VehiculoAuto(new Vector(0,0), 76);
		SorpresaFavorable sf = new SorpresaFavorable();
		sf.interactuarCon(auto);
		assertEquals(auto.getCantidadDeMovimientos(),61);
	}
}
