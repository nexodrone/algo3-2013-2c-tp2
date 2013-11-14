package modeloTests;

import excepciones.*;
import modelo.ObstaculoPiquete;
import modelo.Calle;
import modelo.Vector;
import modelo.VehiculoAuto;

import org.junit.Test;

public class VehiculoAutoTest {

	@Test(expected = ImposiblePasarPorCalleException.class)
	public void testAtraparExcepcionPorPiquete() throws ImposiblePasarPorCalleException {
		VehiculoAuto auto = new VehiculoAuto(new Vector(2,2), 0);
		Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
		
		auto.pasarPorCalle(calleATransitar);		
	}

}
