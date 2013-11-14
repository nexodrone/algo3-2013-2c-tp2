package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import modelo.ObstaculoPiquete;
import modelo.Vector;
import modelo.Vehiculo4x4;
import modelo.VehiculoAuto;
import modelo.VehiculoMoto;
import org.junit.Test;
import excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class ObstaculoPiqueteTest {

	@Test
	public void testDeberiaTirarExcepcionSiPasa4x4() throws PasajeBloqueadoPorPiqueteExcepcion {
		Vehiculo4x4 todoterreno = new Vehiculo4x4(new Vector(0,0));
		todoterreno.setCantidadDeMovimientos(5);
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		try { 	piquete.interactuarCon(todoterreno);
				fail("Excepcion esperada");
			}	catch (PasajeBloqueadoPorPiqueteExcepcion esperada) {};
		assertEquals(todoterreno.getCantidadDeMovimientos(),5);
		/* se comprueba que al intentar a mover por piquete NO SE SUMAN MOVIMIENTOS */
	}

	@Test
	public void testDeberiaTirarExcepcionSiPasaAuto() throws PasajeBloqueadoPorPiqueteExcepcion {
		VehiculoAuto auto = new VehiculoAuto(new Vector(0,0));
		auto.setCantidadDeMovimientos(5);
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		try { 	piquete.interactuarCon(auto);
				fail("Excepcion esperada");
			}	catch (PasajeBloqueadoPorPiqueteExcepcion esperada) {};
		assertEquals(auto.getCantidadDeMovimientos(),5);
		/* se comprueba que al intentar a mover por piquete NO SE SUMAN MOVIMIENTOS */
	}
	
	@Test
	public void testDeberiaSumar2MovimientoAMoto() {
		VehiculoMoto moto = new VehiculoMoto(new Vector(0,0));
		moto.setCantidadDeMovimientos(5);
		ObstaculoPiquete piquete = new ObstaculoPiquete();
		piquete.interactuarCon(moto);
		assertEquals(moto.getCantidadDeMovimientos(),7);
	}

}
