package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Jugador;
import modelo.Partida;
import modelo.excepciones.PartidaInexistente;
import vista.PanelMenuPrincipal;

public class ControladorMenuPrincipal extends Controlador {

    private PanelMenuPrincipal panelMenuPrincipal;

    public ControladorMenuPrincipal() {
        this.agregarPanelLocal();
        ventana.setVisible(true);
    }

    private void agregarPanelLocal() {
        this.panelMenuPrincipal = new PanelMenuPrincipal(nombreJugadorActual);
        this.panelMenuPrincipal.agregarEscuchaComenzarPartida(new EscuchaComenzarPartida());
        this.panelMenuPrincipal.agregarEscuchaSalir(new EscuchaSalir());
        this.panelMenuPrincipal.agregarEscuchaVerPuntajes(new EscuchaPuntajes());
        this.panelMenuPrincipal.agregarEscuchaRetomarPartida(new EscuchaRetomarPartida());
        ventana.add(panelMenuPrincipal);
    }

    public class EscuchaComenzarPartida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreJugador = panelMenuPrincipal.getNombreUsuario();
            ventana.remove(panelMenuPrincipal);
            ControladorComenzarPartida controlador = new ControladorComenzarPartida(nombreJugador);
        }
    }

    public class EscuchaRetomarPartida implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Partida partida = Partida.cargarPartida("src/jugadores/partida" + nombreJugadorActual + ".xml");
	            juego.setJugador(new Jugador(nombreJugadorActual));
	            juego.setPartida(partida);
	            ventana.remove(panelMenuPrincipal);
	            String vehiculoSeleccionado = partida.getVehiculo().asString();
	            String nivelSeleccionado = recuperarStringDeDificultad(partida.dificultad);
	            ControladorPartida controlador = new ControladorPartida(ventana, nivelSeleccionado, vehiculoSeleccionado);
			} catch (PartidaInexistente e1) {	panelMenuPrincipal.mostrarMensajeNoHayPartida();	}
		}
    	
    }
    
    private String recuperarStringDeDificultad(int dificultad) {
    	switch (dificultad) {
    	case 1:	return "Facil";
    	case 2: return "Intermedio";
    	default: return "Dificil";
    	}
    }
    
    
    public class EscuchaSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.setVisible(false);
            ventana.dispose();
        }
    }

    public class EscuchaPuntajes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            panelMenuPrincipal.setVisible(false);
            ventana.remove(panelMenuPrincipal);
            ControladorPuntajes controlador = new ControladorPuntajes();
        }
    }

}
