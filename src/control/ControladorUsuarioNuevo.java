package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Juego;
import vista.PanelUsuarioNuevo;
import vista.Ventana;

public class ControladorUsuarioNuevo extends Controlador {

	private PanelUsuarioNuevo panelUsuarioNuevo;

	public ControladorUsuarioNuevo(Juego juego, Ventana ventana) {
		this.juego = juego;
		this.ventana = ventana;
		this.agregarPanelLocal();
		this.ventana.setVisible(true);
	}

	private void agregarPanelLocal() {
		this.panelUsuarioNuevo = new PanelUsuarioNuevo();
		this.panelUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
		this.panelUsuarioNuevo.agregarEscuchaGuardar(new EscuchaGuardar());
		this.panelUsuarioNuevo.agregarEscuchaEnter(new EscuchaEnter());
		ventana.add(panelUsuarioNuevo);
	}

	public class EscuchaVolver implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelUsuarioNuevo);
			ControladorBienvenido contolador = new ControladorBienvenido(juego, ventana);
		}
	}

	public class EscuchaGuardar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (panelUsuarioNuevo.getNombreDelCampo().isEmpty()) { panelUsuarioNuevo.mostrarMensajeCampoVacio(); }
			else {	ventana.remove(panelUsuarioNuevo);
					nombreJugadorActual = panelUsuarioNuevo.getNombreDelCampo();
					ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana);	};
		}			 
	}

	public class EscuchaEnter implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				if (panelUsuarioNuevo.getNombreDelCampo().isEmpty()) { panelUsuarioNuevo.mostrarMensajeCampoVacio(); }
				else {	ventana.remove(panelUsuarioNuevo);
						nombreJugadorActual = panelUsuarioNuevo.getNombreDelCampo();
						ControladorMenuPrincipal contolador = new ControladorMenuPrincipal(juego, ventana);	};
			}       
		}

		@Override
		public void keyTyped(KeyEvent e) {}
	}

}
