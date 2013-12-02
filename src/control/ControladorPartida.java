package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import modelo.Direccion;
import modelo.Juego;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import vista.PanelPartida;
import vista.Ventana;

public class ControladorPartida extends Controlador {

    private PanelPartida panelPartida;
    private static Direccion norte = new Direccion(0, 1);
    private static Direccion sur = new Direccion(0, -1);
    private static Direccion este = new Direccion(1, 0);
    private static Direccion oeste = new Direccion(-1, 0);

    public ControladorPartida(Ventana ventana, String dificultad, String vehiculo) {
        this.juego = Juego.getInstance();
        this.ventana = ventana;
        this.agregarPanelLocal(juego.getJugadorActual().getNickName(), vehiculo, dificultad);
        this.ventana.setVisible(true);
    }

    private void agregarPanelLocal(String nombre, String dificultad, String vehiculo) {
        this.panelPartida = new PanelPartida(nombre, vehiculo, dificultad);
        this.panelPartida.inicializarZonaDelJuego(juego.getPartida().getTablero().getCantidadDeColumnas(), juego.getPartida().getTablero().getCantidadDeFilas());
        this.panelPartida.agregarEscuchaGuardar(new EscuchaGuardar());
        this.panelPartida.agregarEscuchaVolver(new EscuchaVolver());
        this.agregarEscuchaFlechas();
        ventana.add(panelPartida);
    }

    public class EscuchaGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                juego.getPartida().guardarPartida("src/jugadores/partida" + nombreJugadorActual + ".xml");
                panelPartida.mostrarMensajePartidaGuardada();
            } catch (Exception e1) {
                panelPartida.mostrarMensajeError();
            };
        }
    }

    public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelPartida);
            ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
        }
    }

    private void agregarEscuchaFlechas() {
        InputMap mapaDeEntrada = this.panelPartida.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap mapaDeAcciones = this.panelPartida.getActionMap();

        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");

        mapaDeAcciones.put("RightArrow", new EscuchaFlechas("RightArrow"));
        mapaDeAcciones.put("LeftArrow", new EscuchaFlechas("LeftArrow"));
        mapaDeAcciones.put("UpArrow", new EscuchaFlechas("UpArrow"));
        mapaDeAcciones.put("DownArrow", new EscuchaFlechas("DownArrow"));
    }

    public class EscuchaFlechas extends AbstractAction {
        private String accion;

        public EscuchaFlechas(String accion) {
            this.accion = accion;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                switch (accion) {
                    case "UpArrow": // System.out.println("The up arrow was pressed!");
                        juego.realizarJugadaEnDireccion(norte);
                        break;
                    case "DownArrow": // System.out.println("The down arrow was pressed!");
                        juego.realizarJugadaEnDireccion(sur);
                        break;
                    case "LeftArrow": // System.out.println("The left arrow was pressed!");
                        juego.realizarJugadaEnDireccion(oeste);
                        break;
                    case "RightArrow": // System.out.println("The right arrow was pressed!");
                        juego.realizarJugadaEnDireccion(este);
                        break;
                }
            } catch (MovimientoInvalidoExcepcion ex) {
                panelPartida.mostrarMensajeMovimientoInvalido();
            };
        }
    }

}
