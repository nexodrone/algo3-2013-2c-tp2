package modeloTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import modelo.Posicion;

import org.junit.Test;

public class PosicionTest {

    @Test
    public void testDeberiaInicializarseConPosicionDada() {
        Posicion unaPosicion = new Posicion(2, 3);
        assertEquals(unaPosicion.getFila(), 2);
        assertEquals(unaPosicion.getColumna(), 3);
        assertEquals(unaPosicion.asString(), "2,3");
        // Se esta probando 3 metodos en una sola prueba
    }

    @Test
    public void testParaComprobarQueDeberiaCambiarCorrectamenteElvalorDeLaFila() {
        Posicion unaPosicion = new Posicion(2, 3);
        unaPosicion.setFila(2);
        assertEquals(unaPosicion.getFila(), 2);
    }

    @Test
    public void testParaComprobarQueDeberiaCambiarCorrectamentelaColumna() {
        Posicion unaPosicion = new Posicion(2, 3);
        unaPosicion.setColumna(4);
        assertEquals(unaPosicion.getColumna(), 4);
    }

    @Test
    public void testParaComprobarQueCuandoSeCambiaLaColumnaNoAfectaLaFila() {
        Posicion unaPosicion = new Posicion(2, 3);
        unaPosicion.setColumna(4);
        assertEquals(unaPosicion.getFila(), 2);
    }

    @Test
    public void testParaComprobarQueCuandoSeCambiaLaFilaNoAfectaLaColumna() {
        Posicion unaPosicion = new Posicion(2, 3);
        unaPosicion.setFila(4);
        assertEquals(unaPosicion.getColumna(), 3);
    }

    @Test
    public void testParaComprobarQueDevuelvaUnaCopiaCorrectamente() {
        Posicion unaPosicion = new Posicion(2, 3);
        Posicion otraPosicion = unaPosicion.copy();
        assertEquals(otraPosicion.getColumna(), unaPosicion.getColumna());
        assertEquals(otraPosicion.getFila(), unaPosicion.getFila());
    }

    @Test
    public void testParaComprobarDevuelveOtroVector() {
        Posicion unaPosicion = new Posicion(2, 3);
        Posicion otraPosicion = unaPosicion.copy();
        assertFalse(unaPosicion == otraPosicion);
    }

    @Test
    public void testParaComprobarQueSumaCorrectamenteEnColumna() {
        Posicion unaPosicion = new Posicion(2, 3);
        int numeroASumar = 2;
        unaPosicion.sumarColumna(numeroASumar);
        assertEquals(unaPosicion.getColumna(), 5);
    }

    @Test
    public void testParaComprobarQueCuandoSumarEnColumnaNoAfectaLaFila() {
        Posicion unaPosicion = new Posicion(2, 3);
        int numeroASumar = 2;
        unaPosicion.sumarColumna(numeroASumar);
        assertEquals(unaPosicion.getFila(), 2);
    }

    @Test
    public void testParaComprobarQueSumaCorrectamenteEnFila() {
        Posicion unaPosicion = new Posicion(2, 3);
        int numeroASumar = 2;
        unaPosicion.sumarFila(numeroASumar);
        assertEquals(unaPosicion.getFila(), 4);
    }

    @Test
    public void testParaComprobarQueCuandoSumarEnFilaNoAfectaLaColumna() {
        Posicion unaPosicion = new Posicion(2, 3);
        int numeroASumar = 2;
        unaPosicion.sumarFila(numeroASumar);
        assertEquals(unaPosicion.getColumna(), 3);
    }
}
