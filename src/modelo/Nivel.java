package modelo;

import java.io.File;

import org.simpleframework.xml.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@Root( name = "Nivel" )
public class Nivel {
	
	@Element
	public int movimientosDisponibles;
	@Element
	public int filasTablero;
	@Element
	public int columnasTablero;
	@Element
	public int cantidadDeSorpresas;
	@Element
	public int cantidadDeObstaculos;
	
	public Nivel() {

		this.movimientosDisponibles = 30;
		this.filasTablero = 10;
		this.columnasTablero = 10;
		this.cantidadDeSorpresas = 5;
		this.cantidadDeObstaculos = 5;
	}
	
	public void guardarNivel(Integer nivel) throws Exception {
		Serializer serializador = new Persister();
		String path = "test/nivel" + nivel.toString() + "Test.xml";
		serializador.write(this, new File(path));
	}
	
	public static Nivel setearNivel(Integer nivel) throws Exception {
		Serializer deserializador = new Persister();
		String path = "test/nivel" + nivel.toString() + "Test.xml";
		return deserializador.read(Nivel.class, new File(path));
	}	
}
