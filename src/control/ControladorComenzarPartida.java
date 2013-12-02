package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConstructorDePartida;
import modelo.Jugador;
import modelo.Nivel;
import modelo.Partida;
import vista.PanelComenzarPartida;

public class ControladorComenzarPartida extends Controlador {

    private PanelComenzarPartida panelComenzarPartida;
    private String nombre;

    public ControladorComenzarPartida() {
        this.nombre = juego.getJugadorActual().getNickName();
        this.agregarPanelLocal();
        ventana.setVisible(true);
    }

    private void agregarPanelLocal() {
        this.panelComenzarPartida = new PanelComenzarPartida();
        this.panelComenzarPartida.agregarEscuchaVolver(new EscuchaVolver());
        this.panelComenzarPartida.agregarEscuchaAceptar(new EscuchaComenzarPartida());
        ventana.add(panelComenzarPartida);
    }

    public class EscuchaVolver implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ventana.remove(panelComenzarPartida);
            ControladorMenuPrincipal contolador = new ControladorMenuPrincipal();
        }
    }

    public class EscuchaComenzarPartida implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            juego.setJugadorActual(new Jugador(nombre));
            String nivelSeleccionado = panelComenzarPartida.obtenerNivelSeleccionado();
            String vehiculoSeleccionado = panelComenzarPartida.obtenerVehiculoSeleccionado();
            Nivel nivel = new Nivel();
            try {
                nivel = Nivel.cargarNivel("src/niveles/Nivel" + nivelSeleccionado + ".xml");
            } catch (Exception e1) {
                panelComenzarPartida.mostrarMensajeError();
            };
            Partida partida = construirPartidaSeleccionada(vehiculoSeleccionado, nivel);
            // partida.getVehiculo().setJuegoActual(juego);
            juego.setPartida(partida);
            ventana.remove(panelComenzarPartida);
            ControladorPartida controlador = new ControladorPartida(ventana, nivelSeleccionado, vehiculoSeleccionado);
        }
    }

    public Partida construirPartidaSeleccionada(String vehiculoSeleccionado, Nivel nivel) {
        switch (vehiculoSeleccionado) {
            case "Moto":
                return ConstructorDePartida.construirPartidaConMoto(nivel);
            case "Auto":
                return ConstructorDePartida.construirPartidaConAuto(nivel);
            default:
                return ConstructorDePartida.construirPartidaCon4x4(nivel);
        }
    }

}
