package modelo;

public class DireccionDeMovimiento {
	
	private char direccion;
	
	/*private static int NORTE = 1;
	private static int SUR = 2;
	private static int ESTE = 3;
	private static int OESTE = 4;*/

	
	public DireccionDeMovimiento(char direccion){
		this.direccion = direccion;
	}
	
	public char asChar(){
		return this.direccion;				
	}
}
