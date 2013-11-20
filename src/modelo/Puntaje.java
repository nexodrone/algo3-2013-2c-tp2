package modelo;

import org.simpleframework.xml.*;

@Root(name = "puntaje")
public class Puntaje {
	@Attribute
	private String nombre;
	@Element
	private int puntaje;
	
	public Puntaje(String nombre, int puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	
	public Puntaje(){}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
}
