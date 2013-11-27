package principal;

import modelo.Juego;
import vista.Ventana;
import vista.VentanaBienvenido;
import control.ControladorVIEJO;
import control.ControladorBienvenido;

public class Principal {
	
	public static void main(String args[]) {
		
		Juego juego = new Juego();
		Ventana ventana = new Ventana();
		ControladorBienvenido control = new ControladorBienvenido(juego, ventana);
	}
}
