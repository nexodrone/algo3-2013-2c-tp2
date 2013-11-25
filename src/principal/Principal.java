package principal;

import modelo.Juego;
import vista.VentanaBienvenido;
import control.Controlador;

public class Principal {
	
	public static void main(String args[]) {
		
		Juego juego = new Juego();
		Controlador control = new Controlador(juego);
	}
}
