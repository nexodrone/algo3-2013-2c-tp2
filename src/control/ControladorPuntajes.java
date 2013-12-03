package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Juego;
import modelo.Jugador;
import vista.PanelPuntajes;
import vista.Ventana;

public class ControladorPuntajes extends Controlador {

    private PanelPuntajes elPanel;

    public ControladorPuntajes() throws Exception{
    	ArrayList<Jugador> jugadoresPorPuntajes = new ArrayList<Jugador>();
        try {
        	jugadoresPorPuntajes = juego.getPuntajesOrdenados();
        } catch (Exception e) {
            System.out.print("Puntajes inexistentes.\n");
            throw new Exception();
        }
        elPanel = new PanelPuntajes(jugadoresPorPuntajes);
        elPanel.agregarVolverListener(new ListenerVolver());

        this.ventana = ventana;
        ventana.add(elPanel);
    }

    public class ListenerVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            elPanel.setVisible(false);
            ventana.remove(elPanel);
            ControladorMenuPrincipal controlador = new ControladorMenuPrincipal();
        }
    }
}
