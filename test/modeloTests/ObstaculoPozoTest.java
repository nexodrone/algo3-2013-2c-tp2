package modeloTests;

import static org.junit.Assert.assertEquals;
import modelo.ObstaculoPozo;
import modelo.Posicion;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import org.junit.Test;

public class ObstaculoPozoTest {
	
	@Test
	public void testNoDeberiaSumarMovimientosA4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(0,0));
		todoterreno.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(todoterreno);
		assertEquals(todoterreno.getCantidadDeMovimientos(),5);
	}

	@Test
	public void testDeberiaSumar3MovimientosAAuto() {
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		auto.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(auto);
		assertEquals(auto.getCantidadDeMovimientos(),8);
	}

	@Test
	public void testDeberiaSumar3MovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setCantidadDeMovimientos(5);
		ObstaculoPozo pozo = new ObstaculoPozo();
		pozo.interactuarCon(moto);
		assertEquals(moto.getCantidadDeMovimientos(),8);
	}
}
