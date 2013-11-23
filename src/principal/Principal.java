package principal;

import control.Controlador;
import modelo.Juego;

public class Principal {
	
	public static void main(String args[]) {
		
		Juego juego = new Juego();
		
		Controlador control = new Controlador(juego);
		
		
		
	}
}
