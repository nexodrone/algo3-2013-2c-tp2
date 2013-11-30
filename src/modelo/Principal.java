package modelo;

import vista.Ventana;
import control.ControladorBienvenido;

public class Principal {
	
	public static void main(String args[]) {
		
		Juego juego = new Juego();
		Ventana ventana = new Ventana();
		ControladorBienvenido control = new ControladorBienvenido(juego, ventana);
	}
}
