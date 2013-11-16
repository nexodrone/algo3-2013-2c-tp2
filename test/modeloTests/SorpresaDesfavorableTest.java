package modeloTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.SorpresaDesfavorable;
import modelo.Posicion;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;

public class SorpresaDesfavorableTest {

	@Test
	public void testDeberiaSumarCorrectamentePuntajeAlAuto() {
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		auto.setCantidadDeMovimientos(77);
		SorpresaDesfavorable sdf = new SorpresaDesfavorable();
		sdf.interactuarCon(auto);
		assertEquals(auto.getCantidadDeMovimientos(),96);
	}
	
	@Test
	public void testDeberiaSumarCorrectamentePuntajeAl4x4() {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(0,0));
		todoterreno.setCantidadDeMovimientos(11);
		SorpresaDesfavorable sdf = new SorpresaDesfavorable();
		sdf.interactuarCon(todoterreno);
		assertEquals(todoterreno.getCantidadDeMovimientos(),14);
	}
	
	@Test
	public void testDeberiaSumarCorrectamentePuntajeALaMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setCantidadDeMovimientos(43);
		SorpresaDesfavorable sdf = new SorpresaDesfavorable();
		sdf.interactuarCon(moto);
		assertEquals(moto.getCantidadDeMovimientos(),54);
	}
	
}