package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Juego;
import vista.PanelMenuPrincipal;
import vista.Ventana;

public class ControladorMenuPrincipal extends Controlador {

    private PanelMenuPrincipal panelMenuPrincipal;

    public ControladorMenuPrincipal(Ventana ventana) {
        this.juego = Juego.getInstance();
        this.ventana = ventana;
        this.agregarPanelLocal();
        this.ventana.setVisible(true);
    }

    private void agregarPanelLocal() {
        this.panelMenuPrincipal = new PanelMenuPrincipal(nombreJugadorActual);
        this.panelMenuPrincipal.agregarEscuchaComenzarPartida(new EscuchaComenzarPartida());
        this.panelMenuPrincipal.agregarEscuchaSalir(new EscuchaSalir());
        this.panelMenuPrincipal.agregarEscuchaVerPuntajes(new EscuchaPuntajes());
        ventana.add(panelMenuPrincipal);
    }

    public class EscuchaComenzarPartida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreJugador = panelMenuPrincipal.getNombreUsuario();
            ventana.remove(panelMenuPrincipal);
            ControladorComenzarPartida controlador = new ControladorComenzarPartida(ventana, nombreJugador);
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
            ControladorPuntajes controlador = new ControladorPuntajes(ventana);
        }
    }

}
