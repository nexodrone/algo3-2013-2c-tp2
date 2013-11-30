package modeloTests;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.ConstructorDePartida;
import modelo.Nivel;
import modelo.Partida;
import modelo.Posicion;


public class ConstrutorDePartidaTest {
	
	
	@Test
	public void testPartidaCreadaNoDeberiaSerNula() {
		Nivel nuevoNivel = new Nivel();
		ConstructorDePartida constructor = new ConstructorDePartida();
		constructor.construirPartidaCon4x4(nuevoNivel);
		assertNotNull(constructor);
	}
	
	@Test
	public void testPartidaCreadaConAutoNoDeberiaTenerVehiculoNulo() {
		Nivel nuevoNivel = new Nivel();
		ConstructorDePartida constructor = new ConstructorDePartida();
		Partida nuevaPartida = constructor.construirPartidaConAuto(nuevoNivel);
		assertNotNull(nuevaPartida.getVehiculo());
	}

	@Test
	public void testGenerarPosicionValidaDeberiaGenerarSiempreUnaPosicion() {
		Nivel nuevoNivel = new Nivel();
		boolean esValida = false;
		ConstructorDePartida constructor = new ConstructorDePartida();
		for (int i=0; i<=100; i++) {
			Posicion nuevaPosicion = constructor.generarPosicionValida(nuevoNivel);
			if (nuevaPosicion.x() <= nuevoNivel.tablero.getCantidadDeColumnas() &&
				nuevaPosicion.y() <= nuevoNivel.tablero.getCantidadDeFilas())
					esValida = true;				
				else esValida = false;
		assertTrue(esValida);
		}
	}

}