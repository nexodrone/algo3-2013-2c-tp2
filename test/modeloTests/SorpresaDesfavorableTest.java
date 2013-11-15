package modeloTests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.SorpresaDesfavorable;
import modelo.Posicion;
import modelo.VehiculoAuto;

public class SorpresaDesfavorableTest {

	@Test
	public void testDeberiaSumarCorrectamentePuntaje() {
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		auto.setCantidadDeMovimientos(77);
		SorpresaDesfavorable sdf = new SorpresaDesfavorable();
		sdf.interactuarCon(auto);
		assertEquals(auto.getCantidadDeMovimientos(),96);
	}
}