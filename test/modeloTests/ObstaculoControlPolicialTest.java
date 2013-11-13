package modeloTests;

import static org.junit.Assert.assertTrue;
import modelo.ObstaculoControlPolicial;
import modelo.Vector;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import org.junit.Test;

public class ObstaculoControlPolicialTest {

	@Test
	public void testDeberiaSumar1o4MovimientoA4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Vector(0,0), 5);
		ObstaculoControlPolicial cp = new ObstaculoControlPolicial();
		cp.interactuarCon(todoterreno);
		boolean resultado = (todoterreno.getCantidadDeMovimientos() == 6) || (todoterreno.getCantidadDeMovimientos() == 9);
		assertTrue(resultado);
	}

	@Test
	public void testDeberiaSumar1o4MovimientosAAuto() {
		VehiculoAuto auto = new VehiculoAuto(new Vector(0,0), 5);
		ObstaculoControlPolicial cp = new ObstaculoControlPolicial();
		cp.interactuarCon(auto);
		boolean resultado = (auto.getCantidadDeMovimientos() == 6) || (auto.getCantidadDeMovimientos() == 9);
		assertTrue(resultado);
	}

	@Test
	public void testDeberiaSumar1o4MovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Vector(0,0), 5);
		ObstaculoControlPolicial cp = new ObstaculoControlPolicial();
		cp.interactuarCon(moto);
		boolean resultado = (moto.getCantidadDeMovimientos() == 6) || (moto.getCantidadDeMovimientos() == 9);
		assertTrue(resultado);
	}
}
