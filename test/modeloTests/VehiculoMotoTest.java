package modeloTests;

import static org.junit.Assert.assertEquals;

import modelo.ObstaculoPiquete;
import modelo.Calle;
import modelo.Vector;
import modelo.VehiculoMoto;

import org.junit.Test;

public class VehiculoMotoTest {

		@Test
		public void testDeberiaPerderDosMovimientosPorPiquete() {
			VehiculoMoto moto = new VehiculoMoto(new Vector(2,2), 0);
			Calle calleATransitar = new Calle(new ObstaculoPiquete(), null);
			
			moto.pasarPorCalle(calleATransitar);
			assertEquals(2, moto.getCantidadDeMovimientos());
		}

}
