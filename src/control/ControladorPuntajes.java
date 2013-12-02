package control;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import vista.PanelPuntajes;
import vista.Ventana;
import modelo.Juego;
import modelo.Puntaje;

public class ControladorPuntajes extends Controlador {
	
	private PanelPuntajes elPanel;

	public ControladorPuntajes( Juego juego, Ventana ventana ) {
		try{
			juego.cargarPuntajes("src/jugadores/puntajes.xml");
		}catch(Exception e) {
			System.out.print("Puntajes inexistentes.\n");
		}
		elPanel = new PanelPuntajes(juego.getPuntajesOrdenados());
		elPanel.agregarVolverListener(new ListenerVolver());
		
		this.juego = juego;
		this.ventana = ventana;
		ventana.add(elPanel);
	}

	public class ListenerVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			elPanel.setVisible(false);
			ventana.remove(elPanel);
			ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(juego, ventana);
		}
	}	
}
