package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Jugador;
import vista.PanelElegirNivel;

public class ControladorElegirNivel extends Controlador{
	
	private PanelElegirNivel panelElegirNivel;
	
	public ControladorElegirNivel(){
		 this.agregarPanelLocal();
	     ventana.pack();
	     ventana.repaint();
	}
		
	private void agregarPanelLocal() {
		this.panelElegirNivel = new PanelElegirNivel();
		this.panelElegirNivel.agregarEscuchaVolver(new EscuchaVolver());
		this.panelElegirNivel.agregarEscuchaAceptar(new EscuchaComenzarPartida());
		this.panelElegirNivel.agregarEscuchaEnter(new EscuchaEnter());
		ventana.add(panelElegirNivel);
	}

	
	public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelElegirNivel);
            ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
        }
    }
	
	  public class EscuchaEnter implements KeyListener {
	        @Override
	        public void keyPressed(KeyEvent evento) {
	        }

	        @Override
	        public void keyReleased(KeyEvent evento) {
	            if (evento.getKeyChar() == KeyEvent.VK_ENTER) {
	                if (panelElegirNivel.ningunCampoSeleccionado()) {
	                	panelElegirNivel.mostrarMensajeCampoVacio();
	                } else {
	                	String nivelSeleccionado = panelElegirNivel.obtenerNivelSeleccionado();
	        			ventana.remove(panelElegirNivel);
	        			ControladorElegirVehiculo controlador = new ControladorElegirVehiculo(nivelSeleccionado);
	                };
	            }
	        }
	        @Override
	        public void keyTyped(KeyEvent e) {
	        }
	  }
	
	public class EscuchaComenzarPartida implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if (panelElegirNivel.ningunCampoSeleccionado()){
				panelElegirNivel.mostrarMensajeCampoVacio();
			}else{
			String nivelSeleccionado = panelElegirNivel.obtenerNivelSeleccionado();
			ventana.remove(panelElegirNivel);
			ControladorElegirVehiculo controlador = new ControladorElegirVehiculo(nivelSeleccionado);
			}
		}
	}

	
}
