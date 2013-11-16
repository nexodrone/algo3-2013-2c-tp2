package modeloTests;

import static org.junit.Assert.assertTrue;
import modelo.ObstaculoControlPolicial;
import modelo.Posicion;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import org.junit.Test;

public class ObstaculoControlPolicialTest {

	@Test
	public void testDeberiaSumar0o3MovimientoA4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(0,0));
		todoterreno.setCantidadDeMovimientos(5);
		ObstaculoControlPolicial cp = new ObstaculoControlPolicial();
		cp.interactuarCon(todoterreno);
		boolean resultado = (todoterreno.getCantidadDeMovimientos() == 5) || (todoterreno.getCantidadDeMovimientos() == 8);
		assertTrue(resultado);
	}

	@Test
	public void testDeberiaSumar0o3MovimientosAAuto() {
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		auto.setCantidadDeMovimientos(5);
		ObstaculoControlPolicial cp = new ObstaculoControlPolicial();
		cp.interactuarCon(auto);
		boolean resultado = (auto.getCantidadDeMovimientos() == 5) || (auto.getCantidadDeMovimientos() == 8);
		assertTrue(resultado);
	}

	@Test
	public void testDeberiaSumar0o3MovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setCantidadDeMovimientos(5);
		ObstaculoControlPolicial cp = new ObstaculoControlPolicial();
		cp.interactuarCon(moto);
		boolean resultado = (moto.getCantidadDeMovimientos() == 5) || (moto.getCantidadDeMovimientos() == 8);
		assertTrue(resultado);
	}
}
