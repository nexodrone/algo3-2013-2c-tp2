package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.PanelPuntajes;
import vista.Ventana;

public class ControladorPuntajes extends Controlador {

    private PanelPuntajes elPanel;

    public ControladorPuntajes(Ventana ventana) {
        this.juego = Juego.getInstance();
        try {
            juego.cargarPuntajes("src/jugadores/puntajes.xml");
        } catch (Exception e) {
            System.out.print("Puntajes inexistentes.\n");
        }
        elPanel = new PanelPuntajes(juego.getPuntajesOrdenados());
        elPanel.agregarVolverListener(new ListenerVolver());

        this.ventana = ventana;
        ventana.add(elPanel);
    }

    public class ListenerVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            elPanel.setVisible(false);
            ventana.remove(elPanel);
            ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(ventana);
        }
    }
}
