package modelo;

import vista.Ventana;
import control.ControladorBienvenido;

public class Principal {

    public static void main(String args[]) {

        // Juego juego = Juego.getInstance();
        Ventana ventana = new Ventana();
        ControladorBienvenido control = new ControladorBienvenido(ventana);
    }
}
