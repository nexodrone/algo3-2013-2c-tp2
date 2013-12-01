package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Juego;
import vista.PanelPartida;
import vista.Ventana;

public class ControladorPartida extends Controlador {
	
	private PanelPartida panelPartida;
	
	public ControladorPartida(Juego juego, Ventana ventana, String dificultad, String vehiculo) {
		this.juego = juego;
		this.ventana = ventana;
		this.agregarPanelLocal(juego.getJugadorActual().getNickName(), vehiculo, dificultad);
		this.ventana.setVisible(true);
	}
	
	private void agregarPanelLocal(String nombre, String dificultad, String vehiculo) {
		this.panelPartida = new PanelPartida(nombre, vehiculo, dificultad);
		this.panelPartida.inicializarZonaDelJuego(juego.getPartida().getTablero().getCantidadDeColumnas(), juego.getPartida().getTablero().getCantidadDeFilas());
		this.panelPartida.agregarEscuchaGuardar(new EscuchaGuardar());
		this.panelPartida.agregarEscuchaVolver(new EscuchaVolver());
		ventana.add(panelPartida);
	}
	
	public class EscuchaGuardar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {	juego.getPartida().guardarPartida("src/jugadores/partida"+nombreJugadorActual+".xml");
					panelPartida.mostrarMensajePartidaGuardada();
				} catch (Exception e1) { panelPartida.mostrarMensajeError(); };
		}
	}
	
	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelPartida);
			ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana);
		}
	}
	
	public class EscuchaNorte implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
