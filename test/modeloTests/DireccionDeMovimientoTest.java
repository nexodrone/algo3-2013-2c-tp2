package modeloTests;

import static org.junit.Assert.*;
import modelo.DireccionDeMovimiento;
import org.junit.Test;

public class DireccionDeMovimientoTest {

	@Test
	public void testDeberiaCrearseEnEstadoValido(){
		DireccionDeMovimiento unaDireccion= new DireccionDeMovimiento('N');
		assertEquals(unaDireccion.asChar(),'N');
		assertNotNull(unaDireccion);
	}
	
	@Test
	public void testDeberiaMostrarLaDireccionComoChar(){
		DireccionDeMovimiento unaDireccion = new DireccionDeMovimiento('S');
		DireccionDeMovimiento otraDireccion = new DireccionDeMovimiento('E');
		DireccionDeMovimiento algunaDireccion = new DireccionDeMovimiento('O');
		assertEquals(unaDireccion.asChar(),'S');
		assertEquals(otraDireccion.asChar(),'E');
		assertEquals(algunaDireccion.asChar(),'O');
	}
}
