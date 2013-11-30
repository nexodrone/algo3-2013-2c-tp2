package modelo;

import java.io.File;

import org.simpleframework.xml.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root (name = "Nivel")
public class Nivel {
	
	@Attribute
	public int movimientosDisponibles;
	@Element
	public Tablero tablero;
	
	public Nivel() {

		this.movimientosDisponibles = 30;
		this.tablero = new Tablero(10,10);
	}
	
	public void guardarNivel(String path) throws Exception {
		Serializer serializador = new Persister();
		File archivoXML = new File(path);
		serializador.write(this, archivoXML);
	}
	
	public static Nivel setearNivel(String path) throws Exception {
		Serializer deserializador = new Persister();
		File archivoXML = new File(path);
		return deserializador.read(Nivel.class, archivoXML);
	}	
}
