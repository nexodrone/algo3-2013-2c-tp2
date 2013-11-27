package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.PanelBienvenido;
import vista.Ventana;
import modelo.Juego;

public class ControladorBienvenido extends Controlador {

	private PanelBienvenido panelBienvenido;
	
	public ControladorBienvenido(Juego juego, Ventana ventana) {
		this.juego = juego;
		this.ventana = ventana;
		this.agragarPanelLocal();
		this.ventana.setVisible(true);
	}

	private void agragarPanelLocal() {
		this.panelBienvenido = new PanelBienvenido();
		this.panelBienvenido.agregarEscuchaNuevoUsuario(new EscuchaNuevoUsuario());
		ventana.add(panelBienvenido);
	}
	
	public class EscuchaNuevoUsuario implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ventana.remove(panelBienvenido);
			ControladorUsuarioNuevo contolador = new ControladorUsuarioNuevo(juego, ventana);
		}
	}
	
	public class EscuchaUsuarioRegistrado implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	
}