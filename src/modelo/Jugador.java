package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.PasajeBloqueadoPorPiqueteExcepcion;

public class Jugador {

    private String nombre;
    private Juego juegoActual;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void asignarJuego(Juego juego) {
        juegoActual = juego;
    }

    public String getNickName() {
        return this.nombre;
    }

    public Juego getJuegoActual() {
        return juegoActual;
    }

    public void jugar(Direccion direccion) throws PasajeBloqueadoPorPiqueteExcepcion, MovimientoInvalidoExcepcion {
        try {
            this.juegoActual.realizarJugadaEnDireccion(direccion);
        } catch (MovimientoInvalidoExcepcion e) {
            System.out.print("Debe realizar otro movimiento valido \n");
        }
    }
    
    public void guardar(String path) throws Exception {
    	Serializer serializador = new Persister();
    	OutputStream resultado = new FileOutputStream(path);
    	serializador.write(this, resultado);
    }
    
    public static Jugador recuperar(String path) throws Exception{
    Serializer deserializador = new Persister();
    InputStream src = new FileInputStream(path);
    
    Jugador x = new Jugador("Chango");
    Jugador devolver = deserializador.read(x, src);
    return devolver;
    }

}
