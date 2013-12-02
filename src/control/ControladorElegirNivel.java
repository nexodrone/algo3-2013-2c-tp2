package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.PanelElegirNivel;

public class ControladorElegirNivel extends Controlador{
	
	private PanelElegirNivel panelElegirNivel;
	
	public ControladorElegirNivel(){
		 this.agregarPanelLocal();
	     ventana.setVisible(true);
	}
		
	private void agregarPanelLocal() {
		this.panelElegirNivel = new PanelElegirNivel();
		this.panelElegirNivel.agregarEscuchaVolver(new EscuchaVolver());
		this.panelElegirNivel.agregarEscuchaAceptar(new EscuchaComenzarPartida());
		ventana.add(panelElegirNivel);
	}

	
	public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelElegirNivel);
            ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
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
