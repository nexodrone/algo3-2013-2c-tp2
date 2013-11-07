package modelo;

public class DireccionDeMovimiento {
	private char direccion;
	
	public DireccionDeMovimiento(char direccion){
		this.direccion = direccion;
	}
	
	public char asChar(){
		return this.direccion;				
	}
}
