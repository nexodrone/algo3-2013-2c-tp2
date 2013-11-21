package modeloTests;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.ConstructorJuego;
import modelo.Juego;
import modelo.Nivel;
import modelo.Posicion;


public class ConstrutorDelJuegoTest {
	
	
	@Test
	public void testsJuegoCreadoNoDeberiaSerNulo(){
		Nivel nuevoNivel = new Nivel();
		ConstructorJuego constructor = new ConstructorJuego();
		constructor.construirJuegoCon4x4(nuevoNivel);
		assertNotNull(constructor);
	}
	
	@Test
	public void testJuegoCreadoConAutoNoDeberiaTenerVehiculoNulo(){
		Nivel nuevoNivel = new Nivel();
		ConstructorJuego constructor = new ConstructorJuego();
		Juego nuevoJuego = constructor.construirJuegoConAuto(nuevoNivel);
		assertNotNull(nuevoJuego.getVehiculo());
	}

	@Test
	public void testGenerarPosicionValidaDeberiaGenerarSiempreUnaPosicion(){
		Nivel nuevoNivel = new Nivel();
		boolean esValida = false;
		ConstructorJuego constructor = new ConstructorJuego();
		for(int i=0;i<=100;i++){
			Posicion nuevaPosicion = constructor.generarPosicionValida(nuevoNivel);
			if(nuevaPosicion.x() <= nuevoNivel.getCantidadDeColumnas() &&
				nuevaPosicion.y() <= nuevoNivel.getCantidadDeFilas()){
				esValida = true;				
			}else esValida = false;
		assertTrue(esValida);
		}
	}

}
