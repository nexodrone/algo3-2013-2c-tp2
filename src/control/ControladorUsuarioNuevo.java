package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Jugador;
import vista.PanelUsuarioNuevo;

public class ControladorUsuarioNuevo extends Controlador {

    private PanelUsuarioNuevo panelUsuarioNuevo;

    public ControladorUsuarioNuevo() {
        this.agregarPanelLocal();
        ventana.setVisible(true);
    }

    private void agregarPanelLocal() {
        this.panelUsuarioNuevo = new PanelUsuarioNuevo();
        this.panelUsuarioNuevo.agregarEscuchaVolver(new EscuchaVolver());
        this.panelUsuarioNuevo.agregarEscuchaGuardar(new EscuchaGuardar());
        this.panelUsuarioNuevo.agregarEscuchaEnter(new EscuchaEnter());
        ventana.add(panelUsuarioNuevo);
    }

    public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelUsuarioNuevo);
            ControladorBienvenido contolador = new ControladorBienvenido();
        }
    }

    public class EscuchaGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (panelUsuarioNuevo.getNombreDelCampo().isEmpty()) {
                panelUsuarioNuevo.mostrarMensajeCampoVacio();
            } else {
                ventana.remove(panelUsuarioNuevo);
                juego.setJugadorActual(new Jugador(panelUsuarioNuevo.getNombreDelCampo()));
                ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
            };
        }
    }

    public class EscuchaEnter implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                if (panelUsuarioNuevo.getNombreDelCampo().isEmpty()) {
                    panelUsuarioNuevo.mostrarMensajeCampoVacio();
                } else {
                    ventana.remove(panelUsuarioNuevo);
                    juego.setJugadorActual(new Jugador(panelUsuarioNuevo.getNombreDelCampo()));
                    ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
                };
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

}
