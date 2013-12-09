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
import modelo.excepciones.CalleBloqueadaPorPiqueteExcepcion;
import modelo.excepciones.MovimientoInvalidoExcepcion;
import modelo.excepciones.NoHayUsuariosCreadosException;
import modelo.excepciones.PartidaGanadaExcepcion;
import modelo.excepciones.PartidaPerdidaExcepcion;
import modelo.excepciones.UsuarioInexistenteException;
import vista.PanelPartida;
import vista.PanelZonaDeJuego;
import vista.Ventana;

public class ControladorPartida extends Controlador {

    private PanelPartida panelPartida;
    private static Direccion norte = new Direccion(0, 1);
    private static Direccion sur = new Direccion(0, -1);
    private static Direccion este = new Direccion(1, 0);
    private static Direccion oeste = new Direccion(-1, 0);
    private String path_jugadores;

    public ControladorPartida(Ventana ventana, String dificultad, String vehiculo) {
        this.agregarPanelLocal(juego.getJugadorActual().getNickName(), vehiculo, dificultad);
        ventana.pack();
        ventana.repaint();
        path_jugadores = "src/jugadores/jugadores.xml";
    }

    private void agregarPanelLocal(String nombre, String dificultad, String vehiculo) {
        this.panelPartida = new PanelPartida(nombre, vehiculo, dificultad, juego.getPartida().getTablero(), juego.getInstance().getVehiculo().getPosicion());
        this.panelPartida.inicializarZonaDelJuego();
        this.panelPartida.agregarEscuchaGuardar(new EscuchaGuardar());
        this.panelPartida.agregarEscuchaVolver(new EscuchaVolver());
        this.agregarEscuchaFlechas();
        ventana.add(panelPartida);
    }

    public class EscuchaGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                juego.getPartida().guardarPartida("src/jugadores/partida" + juego.getJugadorActual().getNickName() + ".xml");
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
            try {
                switch (accion) {
                    case "UpArrow": // System.out.println("The up arrow was pressed!");
                        juego.realizarJugadaEnDireccion(norte);
                        panel.girarHacia("Arriba");
                        panel.nuevaPosicion(0, -1);
                        break;
                    case "DownArrow": // System.out.println("The down arrow was pressed!");
                        juego.realizarJugadaEnDireccion(sur);
                        panel.girarHacia("Abajo");
                        panel.nuevaPosicion(0, 1);
                        break;
                    case "LeftArrow": // System.out.println("The left arrow was pressed!");
                        juego.realizarJugadaEnDireccion(oeste);
                        panel.girarHacia("Izquierda");
                        panel.nuevaPosicion(-1, 0);
                        break;
                    case "RightArrow": // System.out.println("The right arrow was pressed!");
                        juego.realizarJugadaEnDireccion(este);
                        panel.girarHacia("Derecha");
                        panel.nuevaPosicion(1, 0);
                        break;
                }
            } catch (MovimientoInvalidoExcepcion ex) {
                panelPartida.mostrarMensajeMovimientoInvalido();
            } catch (PartidaGanadaExcepcion ex) {
                System.out.print("EXCEPCION PARTIDA GANADA ATRAPADA.\n");
                panelPartida.mostrarMensajePartidaGanada();
                calcularYGuardarPuntaje();
                ventana.remove(panelPartida);
                ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
            } catch (PartidaPerdidaExcepcion ex) {
                System.out.print("EXCEPCION PARTIDA PERDIDA ATRAPADA.\n");
                panelPartida.mostrarMensajePartidaPerdida();
                ventana.remove(panelPartida);
                ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
            } catch (CalleBloqueadaPorPiqueteExcepcion error) {
                panelPartida.mostrarMensajeNoPodesMoverte();
            }
        }
    }

    private void calcularYGuardarPuntaje() {
        String nombre = juego.getJugadorActual().getNickName();
        int movRestantes = juego.getPartida().getCantidadDeMovimientosDisponibles() - juego.getVehiculo().getCantidadDeMovimientos();
        Integer puntaje = movRestantes * juego.getPartida().getDificultad();
        try {
            juego.guardarPuntaje(nombre, puntaje);
        } catch (UsuarioInexistenteException | NoHayUsuariosCreadosException e) {
            System.out.print("Usuario Inexistente");
            panelPartida.mostrarMensajeUsuarioInexistente();
        }
    }

    // public void guardarPuntaje(String nombre, Integer puntaje)
    // throws UsuarioInexistenteException,
    // NoHayUsuariosCreadosException
    // {
    // Jugadores jugadores = new Jugadores();
    // jugadores = Jugadores.recuperar(path_jugadores);
    //
    // jugadores.sumarPuntaje(nombre, puntaje);
    // try{
    // jugadores.guardar(path_jugadores);
    // }catch(Exception e) {
    // System.out.print("Error al guardar los puntajes.\n");
    // }
    // }
}
