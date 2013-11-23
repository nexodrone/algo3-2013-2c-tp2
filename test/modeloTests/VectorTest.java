package modeloTests;

import static org.junit.Assert.*;
import modelo.Vector;
import org.junit.Test;

public class VectorTest {

    @Test
    public void testConstructor() {
        Vector vector = new Vector(2, 3);
        assertTrue(vector.x() == 2 && vector.y() == 3);
    }

    @Test
    public void testDeberiaDevolverCoordenadas() {
        Vector vector = new Vector(2, 3);
        assertEquals(vector.x(),2);
        assertEquals(vector.y(),3);
    }
    
    @Test
    public void testIncrementoX() {
        Vector vector = new Vector(-5, 1);
        vector.incrementarX(5);
        assertEquals(vector.x(),0);
    }
    
    @Test
    public void testIncrementoY() {
        Vector vector = new Vector(-5, 1);
        vector.incrementarY(-6);
        assertEquals(vector.y(),-5);
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

    @Test
    public void testAsString() {
        Vector vector = new Vector(5, 3);
        assertEquals(vector.asString(),"5,3");
    }
    
//    @Test
//    public void testDeberiaSerializarYDeserializar() throws Exception{
//    	Vector vector2 = new Vector(5, 3);
//    	vector2.guardar("test/vectorTest.xml");
//    	
//    	Vector otroVec = new Vector(1,1);
//    	otroVec = Vector.recuperar("test/vectorTest.xml");
//
//    	assertEquals(otroVec.asString(),"5,3");
//    }
    
}
