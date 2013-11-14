package modeloTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import modelo.Vector;

import org.junit.Test;

public class VectorTest {

    @Test
    public void testConstructor() {
        Vector vector = new Vector(2, 3);
        assertTrue(vector.x() == 2 && vector.y() == 3);
    }

    @Test
    public void testSonIguales() {
        Vector vector1 = new Vector(5, 5);
        Vector vector2 = new Vector(5, 5);
        assertTrue(vector1.sonIguales(vector2));
    }

    @Test
    public void testNoSonIguales() {
        Vector vector1 = new Vector(5, 5);
        Vector vector2 = new Vector(5, 3);
        assertFalse(vector1.equals(vector2));
    }

    @Test
    public void testAsignar() {
        Vector vector1 = new Vector(1, 1);
        Vector vector2 = new Vector(2, 3);
        vector1.asignar(vector2);
        assertTrue(vector1.x() == 2 && vector1.y() == 3);
    }

    @Test
    public void testSuma() {
        Vector vector1 = new Vector(1, 2);
        Vector vector2 = new Vector(5, 10);
        Vector suma = vector1.sumar(vector2);
        Vector otroVector = new Vector(6, 12);
        assertTrue(suma.sonIguales(otroVector));
    }

    @Test
    public void testPorEscalar0() {
        Vector vector = new Vector(5, 7);
        Vector nuevoVector = new Vector(0, 0);
        Vector otroVector = vector.porEscalar(0);

        assertTrue(otroVector.sonIguales(nuevoVector));
    }

    @Test
    public void testPorEscalar() {
        Vector vector = new Vector(5, 7);
        Vector nuevoVector = vector.porEscalar(3);
        Vector otroVector = new Vector(15, 21);

        assertTrue(otroVector.sonIguales(nuevoVector));
    }
}
