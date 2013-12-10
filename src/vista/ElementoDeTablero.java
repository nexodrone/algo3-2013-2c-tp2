package vista;

import java.awt.Image;

import modelo.Posicion;

public class ElementoDeTablero {
	private Image imagen;
	private Posicion posicionEnTablero;
	private String direccion;
	
	public ElementoDeTablero(Image imagenARepresentar,Posicion posicion,String direccionEnTablero){
		this.imagen = imagenARepresentar;
		this.posicionEnTablero = posicion;
		this.direccion = direccionEnTablero;
	}
	
	public Image getImagen(){
		return this.imagen;
	}
	
	public Posicion getPosicion(){
		return this.posicionEnTablero;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
}
