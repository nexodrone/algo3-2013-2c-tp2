package modeloTests;

import static org.junit.Assert.assertEquals;
import modelo.ObstaculoPozo;
import modelo.Vector;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import org.junit.Test;

public class ObstaculoPozoTest {
	
	@Test
	public void testDeberiaSumar1MovimientoA4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Vector(0,0));
		todoterreno.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(todoterreno);
		assertEquals(todoterreno.getCantidadDeMovimientos(),6);
	}

	@Test
	public void testDeberiaSumar4MovimientosAAuto() {
		VehiculoAuto auto = new VehiculoAuto(new Vector(0,0));
		auto.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(auto);
		assertEquals(auto.getCantidadDeMovimientos(),9);
	}

	@Test
	public void testDeberiaSumar4MovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Vector(0,0));
		moto.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(moto);
		assertEquals(moto.getCantidadDeMovimientos(),9);
	}
}
