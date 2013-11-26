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
	
	public void guardarNivel1() throws Exception {
		Serializer serializador = new Persister();
		serializador.write(this, new File("test/nivel1Test.xml"));
	}
	
	public static Nivel setearNivel1() throws Exception {
		Serializer deserializador = new Persister();
		return deserializador.read(Nivel.class, new File("test/nivel1Test.xml"));
	}	
}
