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
        ventana.pack();
        ventana.repaint();
    }

    private void agregarPanelLocal() {
        this.panelMenuPrincipal = new PanelMenuPrincipal(juego.getJugadorActual().getNombre());
        this.panelMenuPrincipal.agregarEscuchaComenzarPartida(new EscuchaComenzarPartida());
        this.panelMenuPrincipal.agregarEscuchaSalir(new EscuchaSalir());
        this.panelMenuPrincipal.agregarEscuchaVerPuntajes(new EscuchaPuntajes());
        this.panelMenuPrincipal.agregarEscuchaRetomarPartida(new EscuchaRetomarPartida());
        ventana.add(panelMenuPrincipal);
    }

    public class EscuchaComenzarPartida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelMenuPrincipal);
            ControladorElegirNivel controlador = new ControladorElegirNivel();
        }
    }

    public class EscuchaRetomarPartida implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Partida partida = Partida.cargarPartida("src/jugadores/partida" + juego.getJugadorActual().getNombre() + ".xml");
				partida.getTablero().unificarCalles();
	            juego.setJugadorActual(new Jugador(juego.getJugadorActual().getNombre()));
	            juego.setPartida(partida);
	            ventana.remove(panelMenuPrincipal);
	            ControladorPartida controlador = new ControladorPartida();
			} catch (PartidaInexistente e1) {	
				panelMenuPrincipal.mostrarMensajeNoHayPartida();	
			}
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
            try{
            	ControladorPuntajes controlador = new ControladorPuntajes();
            	panelMenuPrincipal.setVisible(false);
            	ventana.remove(panelMenuPrincipal);
            }catch(Exception ex){
            	panelMenuPrincipal.mostrarMensajePuntajesInexistentes();
            }
        }
    }

}
