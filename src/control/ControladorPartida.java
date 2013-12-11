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
import modelo.Posicion;
import modelo.avisos.PartidaGanadaAviso;
import modelo.avisos.PartidaPerdidaAviso;
import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.NoHayUsuariosCreadosException;
import modelo.excepciones.UsuarioInexistenteException;
import vista.PanelPartida;
import vista.PanelZonaDeJuego;

public class ControladorPartida extends Controlador {

    private PanelPartida panelPartida;
    private static Direccion norte = new Direccion(0, 1);
    private static Direccion sur = new Direccion(0, -1);
    private static Direccion este = new Direccion(1, 0);
    private static Direccion oeste = new Direccion(-1, 0);

    public ControladorPartida() {
        this.agregarPanelLocal();
        ventana.pack();
        ventana.repaint();
    }

    private void agregarPanelLocal() {
        this.panelPartida = new PanelPartida(juego.getJugadorActual().getNombre(), juego.getPartida());
        this.panelPartida.agregarEscuchaGuardar(new EscuchaGuardar());
        this.panelPartida.agregarEscuchaVolver(new EscuchaVolver());
        this.agregarEscuchaFlechas();
        ventana.add(panelPartida);
    }

    public class EscuchaGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                juego.getPartida().guardarPartida("src/jugadores/partida" + juego.getJugadorActual().getNombre() + ".xml");
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
            PanelZonaDeJuego panel = panelPartida.getPanelZonaDeJuego();
            String vehiculoAntesDeMover = Juego.getInstance().getPartida().getVehiculo().asString();
            boolean restarMovimientosDelPanel = true;
            try {
                switch (accion) {
                    case "UpArrow":
                        if (panel.vehiculoMoviendose() == false) {
                            System.out.println("Posicion antes de moverse" + juego.getVehiculo().getPosicion().asString());
                            juego.realizarJugadaEnDireccion(norte);
                            panel.girarHacia("Arriba");
                            if (panel.vehiculoMoviendose() == false) {
                                panel.verificarSiHuboCambioDeVehiculo(juego.getPartida().getVehiculo().asString(), "Arriba");
                            }
                            panel.nuevaPosicion(0, -1);
                        }
                        break;

                    case "DownArrow":
                        if (panel.vehiculoMoviendose() == false) {
                            System.out.println("Posicion antes de moverse" + juego.getVehiculo().getPosicion().asString());
                            juego.realizarJugadaEnDireccion(sur);
                            panel.girarHacia("Abajo");
                            if (panel.vehiculoMoviendose() == false) {
                                panel.verificarSiHuboCambioDeVehiculo(juego.getPartida().getVehiculo().asString(), "Abajo");
                            }
                            panel.nuevaPosicion(0, 1);
                        }
                        break;
                    case "LeftArrow":
                        if (panel.vehiculoMoviendose() == false) {
                            System.out.println("Posicion antes de moverse" + juego.getVehiculo().getPosicion().asString());
                            Posicion posicion = juego.getVehiculo().getPosicion();
                            juego.realizarJugadaEnDireccion(oeste);
                            panel.girarHacia("Izquierda");
                            if (panel.vehiculoMoviendose() == false) {
                                panel.verificarSiHuboCambioDeVehiculo(juego.getPartida().getVehiculo().asString(), "Izquierda");
                            }
                            panel.nuevaPosicion(-1, 0);
                        }
                        break;
                    case "RightArrow":
                        if (panel.vehiculoMoviendose() == false) {
                            System.out.println("Posicion antes de moverse" + juego.getVehiculo().getPosicion().asString());
                            juego.realizarJugadaEnDireccion(este);
                            panel.girarHacia("Derecha");

                            if (panel.vehiculoMoviendose() == false) {
                                panel.verificarSiHuboCambioDeVehiculo(juego.getPartida().getVehiculo().asString(), "Derecha");
                            }
                            panel.nuevaPosicion(1, 0);
                        }
                        break;
                }
            } catch (MovimientoInvalidoExcepcion ex) {
                restarMovimientosDelPanel = false;
                Logger.instance.log("A donde queres ir " + juego.getJugadorActual().getNombre() + " ?");
                panelPartida.mostrarMensajeMovimientoInvalido();
            } catch (PartidaGanadaAviso ex) {
                // System.out.print("EXCEPCION PARTIDA GANADA ATRAPADA.\n");
                panelPartida.mostrarMensajePartidaGanada();
                calcularYGuardarPuntaje();
                ventana.remove(panelPartida);
                ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
            } catch (PartidaPerdidaAviso ex) {
                // System.out.print("EXCEPCION PARTIDA PERDIDA ATRAPADA.\n");
                panelPartida.mostrarMensajePartidaPerdida();
                ventana.remove(panelPartida);
                ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
            } catch (CalleBloqueadaPorPiqueteExcepcion error) {
                restarMovimientosDelPanel = false;
                panelPartida.mostrarMensajeNoPodesMoverte();
                // panelPartida.escribirEnElLog("Cuidado! Calle bloqueada por Castells...");
            }
            if (restarMovimientosDelPanel)
                panelPartida.actualizarMovimientosDelPanel(juego.getPartida().getVehiculo().getCantidadDeMovimientos(), juego.getPartida().dificultad);

            String vehiculoDespuesDeMover = juego.getPartida().getVehiculo().asString();
            if (vehiculoAntesDeMover.compareTo(vehiculoDespuesDeMover) == 0) {
                panelPartida.actualizarLabelVechiulo(vehiculoDespuesDeMover);
            }
        }
    }

    private void calcularYGuardarPuntaje() {
        String nombre = juego.getJugadorActual().getNombre();
        int movRestantes = juego.getPartida().getCantidadDeMovimientosDisponibles() - juego.getVehiculo().getCantidadDeMovimientos();
        Integer puntaje = movRestantes * juego.getPartida().getDificultad();
        try {
            juego.guardarPuntaje(nombre, puntaje);
        } catch (UsuarioInexistenteException | NoHayUsuariosCreadosException e) {
            System.out.print("Usuario Inexistente");
            panelPartida.mostrarMensajeUsuarioInexistente();
        }
    }
}
