package modeloTests;

import static org.junit.Assert.*;
import modelo.Jugador;
import org.junit.Test;

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
    public void testGuardarYCargarCorrectamenteAlJugador() throws Exception{
    	Jugador unJugador = new Jugador("Chango");
    	unJugador.guardar("test/jugadorTest.xml");
        
        Jugador otroJugador = new Jugador("Matori");
        try {
        	otroJugador = Jugador.recuperar("test/jugadorTest.xml");
        }catch(Exception ex) {
        	System.out.print("No se pudo deserializar el objeto.\n");
        }

        assertEquals(otroJugador.getNickName(), "Chango");  
    }
    
}
