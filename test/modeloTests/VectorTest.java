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
    public void testEquals() {
        Vector vector1 = new Vector(5, 5);
        Vector vector2 = new Vector(5, 5);
        assertTrue(vector1.equals(vector2));
    }

    @Test
    public void testNoEquals() {
        Vector vector1 = new Vector(5, 5);
        Vector vector2 = new Vector(5, 3);
        assertFalse(vector1.equals(vector2));
    }

}
