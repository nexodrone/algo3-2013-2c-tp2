package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import modelo.Juego;
import modelo.Jugador;
import modelo.Tablero;
import modelo.Vector;
import modelo.Vehiculo;
import modelo.VehiculoAuto;

import org.junit.Test;

import excepciones.MovimientoInvalidoExcepcion;

public class JugadorTest {

	@Test
	public void testJugadorNuevoNoDebeSerNulo() {
		Jugador unJugador = new Jugador("Pepe");
		assertNotNull(unJugador);
	}
	
    @Test
    public void testDeberiaDevolverNombre() {
        Jugador unJugador = new Jugador("Juansito");
        assertEquals(unJugador.getNickName(),"Juansito");
    }

    @Test
    public void testJugadorDebePoderEntrarEnJuego() {
        Jugador unJugador = new Jugador("Juansito");
        unJugador.asignarJuego(new Juego(new Tablero(5,5), new VehiculoAuto(new Vector(0,0), 0), new Vector(3,5)));
        assertNotNull(unJugador.getJuegoActual());
    }
    
    @Test
    public void testJugadorDebePoderJugar() throws MovimientoInvalidoExcepcion {
        Jugador unJugador = new Jugador("Juansito");
        Vector norte = new Vector(0,1);
        Vehiculo vehiculo = new VehiculoAuto(new Vector(0,1), 0);
        unJugador.asignarJuego(new Juego(new Tablero(5,5), vehiculo, new Vector(3,5)));
        unJugador.jugar(norte);
        assertEquals(vehiculo.getPosicion().asString(),"0,2");
    }
}
