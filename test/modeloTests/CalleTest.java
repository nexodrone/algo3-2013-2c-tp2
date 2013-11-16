package modeloTests;

import static org.junit.Assert.*;
import modelo.Calle;
import modelo.Posicion;
import modelo.SorpresaFavorable;
import modelo.VehiculoAuto;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class CalleTest {

	@Test
	public void testDeberiaCrearCalleNoVacia(){
		Calle unaCalle = new Calle();
		assertNotNull(unaCalle);
	}

	@Test
	public void testPasarPorCalleConSorpresaDeberiaUsarlaUnicaVez() throws PasajeBloqueadoPorPiqueteExcepcion {
		Calle calle = new Calle();
		calle.setSorpresa(new SorpresaFavorable());
		VehiculoAuto auto = new VehiculoAuto(new Posicion(5,5));
		auto.setCantidadDeMovimientos(80);
		auto.pasarPorCalle(calle);
		auto.pasarPorCalle(calle);
		auto.pasarPorCalle(calle);
		assertEquals(auto.getCantidadDeMovimientos(),67);
	}
	
}
