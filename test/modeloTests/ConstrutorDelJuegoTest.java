package modeloTests;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.ConstructorJuego;
import modelo.Juego;
import modelo.Nivel;


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

}
