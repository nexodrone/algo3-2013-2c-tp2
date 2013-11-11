package modeloTests;

import static org.junit.Assert.assertNotNull;
import modelo.Movimiento;
import modelo.Vector;

import org.junit.Test;

public class MovimientoTest {

    public class DireccionDeMovimientoTest {

        @Test
        public void testDeberiaCrearseEnEstadoValido() {
            Vector norte = new Vector(0, 1);
            Movimiento unaDireccion = new Movimiento(norte);
            assertNotNull(unaDireccion);
        }
    }
}
