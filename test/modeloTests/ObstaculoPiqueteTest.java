package modeloTests;

import static org.junit.Assert.*;
import modelo.Calle;
import modelo.Direccion;
import modelo.ObstaculoPiquete;
import modelo.SorpresaFavorable;
import modelo.Posicion;
import modelo.Vehiculo;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

import org.junit.Test;

public class ObstaculoPiqueteTest {

	@Test
	public void testDeberiaTirarExcepcionSiPasa4x4() throws PasajeBloqueadoPorPiqueteExcepcion {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Posicion(0,0));
		todoterreno.setCantidadDeMovimientos(5);
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		try { 	piquete.interactuarCon(todoterreno);
				fail("Excepcion esperada");
			}	catch (PasajeBloqueadoPorPiqueteExcepcion esperada) {};
		assertEquals(todoterreno.getCantidadDeMovimientos(),5);
	}

	@Test
	public void testDeberiaTirarExcepcionSiPasaAuto() throws PasajeBloqueadoPorPiqueteExcepcion {
		VehiculoAuto auto = new VehiculoAuto(new Posicion(0,0));
		auto.setCantidadDeMovimientos(5);
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		try { 	piquete.interactuarCon(auto);
				fail("Excepcion esperada");
			}	catch (PasajeBloqueadoPorPiqueteExcepcion esperada) {};
		assertEquals(auto.getCantidadDeMovimientos(),5);
	}
	
	@Test
	public void testDeberiaSumar2DePenalizacionMovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Posicion(0,0));
		moto.setCantidadDeMovimientos(5);
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		piquete.interactuarCon(moto);
		assertEquals(moto.getCantidadDeMovimientos(),7);
	}

	@Test
	public void testSiPasamosPorUnaCalleConObstaculoYSorpresaPrimeroSeInteractuaConVehiculo() throws PasajeBloqueadoPorPiqueteExcepcion{
		Vehiculo todoterreno = new Vehiculo4x4(new Posicion(0,0));
		Calle calleATransitar = new Calle(new ObstaculoPiquete(),new SorpresaFavorable());
		todoterreno.setCantidadDeMovimientos(0);
		boolean excepcionCapturada = false;
		try{
			todoterreno.moverEnDireccion(new Direccion(1,0), calleATransitar);
			fail("Excepcion esperada");			
		} catch (PasajeBloqueadoPorPiqueteExcepcion esperada) {
			excepcionCapturada = true;			
		}
		assertTrue(excepcionCapturada);
		assertEquals(todoterreno.getCantidadDeMovimientos(),0);
	}

}
