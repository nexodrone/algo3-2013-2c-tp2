package modelo;

import modelo.Bocacalle;

import java.io.File;
import java.util.ArrayList;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ColumnaDeBocacalles {
	private ArrayList<Bocacalle> columna;
	
	public ColumnaDeBocacalles() {
		this.columna = new ArrayList<Bocacalle>();
	}
	
	public void add(Bocacalle nuevaBocacalle){
		columna.add(nuevaBocacalle);
	}
	
	public Bocacalle get(int index) {
		return columna.get(index);
	}
//	public void guardar(String path) throws Exception {
//		Serializer serializador = new Persister();
//		File resultado = new File(path);
//		serializador.write(this, resultado);
//	}
//
//	public static Tablero recuperar(String path) throws Exception{
//		Serializer deserializador = new Persister();
//		File src = new File(path);
//		return deserializador.read(Tablero.class, src);
//	}
}