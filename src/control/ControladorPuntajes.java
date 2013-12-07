package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Jugador;
import vista.PanelPuntajes;

public class ControladorPuntajes extends Controlador {

    private PanelPuntajes panelPuntajes;

    public ControladorPuntajes() throws Exception{
    	ArrayList<Jugador> jugadoresPorPuntajes = new ArrayList<Jugador>();
        try {
        	jugadoresPorPuntajes = juego.getPuntajesOrdenados();
        } catch (Exception e) {
            System.out.print("Puntajes inexistentes.\n");
            throw new Exception();
        }
        panelPuntajes = new PanelPuntajes(jugadoresPorPuntajes);
        panelPuntajes.agregarVolverListener(new ListenerVolver());

        ventana.add(panelPuntajes);
        ventana.pack();
        ventana.repaint();
    }

    public class ListenerVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelPuntajes);
            ControladorMenuPrincipal controlador = new ControladorMenuPrincipal();
        }
    }
}
