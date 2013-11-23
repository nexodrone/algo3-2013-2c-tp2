package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Calle {
	
	private Obstaculo obstaculo;
	private Sorpresa sorpresa;
	
	public Calle() {
		obstaculo = null;
		sorpresa = null;
	}
	
	public Calle(Obstaculo obstaculo, Sorpresa sorpresa) {
		this.obstaculo = obstaculo;
		this.sorpresa = sorpresa;
	}
	
	public Obstaculo getObstaculo() {
		return this.obstaculo;
	}

	public Sorpresa getSorpresa() {
		return this.sorpresa;
	}

	public void setObstaculo(Obstaculo obstaculoAColocar){
		obstaculo = obstaculoAColocar;
	}
	
	public void setSorpresa(Sorpresa sorpresaAColocar){
		sorpresa = sorpresaAColocar;
	}
	
//    public void guardar(String path) throws Exception {
//    	Serializer serializador = new Persister();
//    	OutputStream resultado = new FileOutputStream(path);
//    	serializador.write(this, resultado);
//    }
//    
//    public static Calle recuperar(String path) throws Exception{
//    	Serializer deserializador = new Persister();
//    	InputStream src = new FileInputStream(path);
//    
//    	Calle x = new Calle();
//    	Calle devolver = deserializador.read(x, src);
//    	return devolver;
//    }
//	
}