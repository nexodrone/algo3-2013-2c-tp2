package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConstructorDePartida;
import modelo.Nivel;
import modelo.Partida;
import vista.PanelElegirVehiculo;

public class ControladorElegirVehiculo extends Controlador{
	private PanelElegirVehiculo panelElegirVehiculo;
	
	public ControladorElegirVehiculo(String nivelSeleccionado){
		 this.agregarPanelLocal(nivelSeleccionado);
	     ventana.pack();
	     ventana.repaint();
	}
	
	private void agregarPanelLocal(String nivelSeleccionado) {
		this.panelElegirVehiculo = new PanelElegirVehiculo(nivelSeleccionado);
		this.panelElegirVehiculo.agregarEscuchaVolver(new EscuchaVolver());
		this.panelElegirVehiculo.agregarEscuchaAceptar(new EscuchaComenzarPartida());
		ventana.add(panelElegirVehiculo);
	}

	
	public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelElegirVehiculo);
            ControladorElegirNivel contolador = new ControladorElegirNivel();
        }
    }
	

	public class EscuchaComenzarPartida implements ActionListener {
		@Override
	    public void actionPerformed(ActionEvent e) {
			if(panelElegirVehiculo.ningunCampoSeleccionado()){
				panelElegirVehiculo.mostrarMensajeNadaSeleccionado();	            	
			}else{
				String nivelSeleccionado = panelElegirVehiculo.obtenerNivelSeleccionado();
				String vehiculoSeleccionado = panelElegirVehiculo.obtenerVehiculoSeleccionado();
				Nivel nivel = new Nivel();
				try {
					nivel = Nivel.cargarNivel("src/niveles/Nivel" + nivelSeleccionado + ".xml");
				} catch (Exception e1) {
					panelElegirVehiculo.mostrarMensajeError();
				};
				Partida partida = construirPartidaSeleccionada(vehiculoSeleccionado, nivel);
				juego.setPartida(partida);
				ventana.remove(panelElegirVehiculo);
				ControladorPartida controlador = new ControladorPartida();
			}
		}
	}

	public Partida construirPartidaSeleccionada(String vehiculoSeleccionado, Nivel nivel) {
		switch (vehiculoSeleccionado) {
		case "Moto":
			return ConstructorDePartida.construirPartidaConMoto(nivel);
		case "Auto":
			return ConstructorDePartida.construirPartidaConAuto(nivel);
		default:
			return ConstructorDePartida.construirPartidaCon4x4(nivel);
		}
	}

}
