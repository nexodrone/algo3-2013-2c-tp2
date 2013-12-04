package control;

import java.awt.event.*;
import java.util.*;

import modelo.Jugador;
import vista.PanelUsuarioRegistrado;

public class ControladorUsuarioRegistrado extends Controlador{
	
	private PanelUsuarioRegistrado panelUsuarioRegistrado;
	
	public ControladorUsuarioRegistrado() {
		agregarPanelJugadores();
		panelUsuarioRegistrado.agregarEscuchadorAceptar(new EscuchaAceptar());
		panelUsuarioRegistrado.agregarEscuchadorVolver(new EscuchaVolver());
		ventana.setVisible(true);
	}
	
	private void agregarPanelJugadores() {
		panelUsuarioRegistrado = new PanelUsuarioRegistrado();
		int i = 1;
		ArrayList<Jugador> lista = new ArrayList<>();
		try{
			lista = juego.getPuntajesOrdenados();
		}catch(Exception ex){}
		
		Iterator<Jugador> it = lista.iterator();
		
		while ( it.hasNext() ) {
			String nombre = it.next().getNickName();
			panelUsuarioRegistrado.agregarJugador(i, nombre);
			i++;
		}
		ventana.add(panelUsuarioRegistrado);
	}

	public class EscuchaAceptar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if ( !panelUsuarioRegistrado.hayUnSeleccionado() ) {
                panelUsuarioRegistrado.mostrarMensajeNoHaySeleccionado();
            } else {
            	String nombreSeleccionado = panelUsuarioRegistrado.getSeleccion();
                juego.setJugadorActual(new Jugador(nombreSeleccionado));
                ventana.remove(panelUsuarioRegistrado);
            	ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
            }	
		}
	}
	
	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            ventana.remove(panelUsuarioRegistrado);
            ControladorBienvenido contolador = new ControladorBienvenido("volver");
		}
	}
}
