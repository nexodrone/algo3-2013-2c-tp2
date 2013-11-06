package modeloTests;

import static org.junit.Assert.*;
import modelo.Tablero;
import org.junit.Test;

public class TableroTest {

	@Test
	public void testDeberiaCrearTableroNoVacio(){
		Tablero unTablero = new Tablero(10,10);
		assertNotNull(unTablero);
	}

}
