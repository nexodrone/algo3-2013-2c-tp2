package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import control.Listener;
import control.Logger;
import modelo.Juego;
import modelo.Partida;

public class PanelPartida extends JPanel {

    private Boton botonGuardar = new Boton("Guardar");
    private Boton botonVolver = new Boton("Volver");
    private JLabel nombreUsuario;
    private JLabel dificultad;
    private JLabel vehiculoActual;
    private JLabel movimientosRestantes;
    private JLabel movimientosTotales;
    private PanelZonaDeJuego panelZonaDelJuego;
    private JPanel panelInfo = new JPanel();
    private LogPartida logPartida = new LogPartida();
    private JScrollPane scroll;
    private int anchoZonaDelJuego = 870; //ideal = 860
    private int largoZonaDelJuego = 610; //ideal = 580
    String nivelSeleccionado;
    Integer cantDeMovimientosIniciales;

    public PanelPartida(String nombre, Partida partida) {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1180, 680));
        this.setBackground(new Color(255, 255, 255, 200));
        this.nivelSeleccionado = recuperarStringDeDificultad(partida.dificultad);
        this.cantDeMovimientosIniciales = partida.getCantidadDeMovimientosDisponibles() - partida.getVehiculo().getCantidadDeMovimientos();
        
        this.panelInfo.setPreferredSize(new Dimension(250,610));
        this.panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.PAGE_AXIS));
        this.panelInfo.setBackground(new Color(255,255,255,255));
        
        this.nombreUsuario = new JLabel("Jugador:   " + nombre);
        this.nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
        
        this.dificultad = new JLabel("Dificultad:   " + recuperarStringDeDificultad(partida.dificultad));
        this.dificultad.setAlignmentX(CENTER_ALIGNMENT);
        
        this.vehiculoActual = new JLabel("Vehiculo:   " + partida.getVehiculo().asString());
        this.vehiculoActual.setAlignmentX(CENTER_ALIGNMENT);
        this.vehiculoActual.setBackground(Color.WHITE);
        
        this.movimientosTotales = new JLabel("Movimientos Realizados:  0");
        this.movimientosTotales.setAlignmentX(CENTER_ALIGNMENT);
        this.movimientosTotales.setBackground(Color.WHITE);
        
        this.movimientosRestantes = new JLabel("Movimientos Restantes:  " + cantDeMovimientosIniciales);
        this.movimientosRestantes.setAlignmentX(CENTER_ALIGNMENT);
        this.movimientosRestantes.setBackground(Color.WHITE);
        
		this.panelZonaDelJuego = new PanelZonaDeJuego(partida);
        this.panelZonaDelJuego.setPreferredSize(new Dimension(anchoZonaDelJuego,largoZonaDelJuego));

        this.botonGuardar.setAlignmentX(CENTER_ALIGNMENT);
        this.botonGuardar.setBackground(Color.WHITE);
        
        this.botonVolver.setAlignmentX(CENTER_ALIGNMENT);
        this.botonVolver.setBackground(Color.WHITE);
        
        this.logPartida.setAlignmentX(CENTER_ALIGNMENT);
        
        Logger.instance.addListener(logPartida);
        scroll = new JScrollPane(logPartida);
        
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(this.nombreUsuario);
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(this.dificultad);
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(this.vehiculoActual);
//        this.panelInfo.add(Box.createVerticalStrut(10));       
//        this.panelInfo.add(this.movimientosTotales);
        this.panelInfo.add(Box.createVerticalStrut(10));       
        this.panelInfo.add(this.movimientosRestantes);
        
        this.panelInfo.add(Box.createVerticalStrut(20));
        this.panelInfo.add(scroll);
        this.panelInfo.add(Box.createVerticalStrut(20));
        this.panelInfo.add(botonGuardar);
        this.panelInfo.add(Box.createVerticalStrut(20));
        this.panelInfo.add(botonVolver);

        this.add(panelInfo);
        this.add(Box.createHorizontalStrut(20));
        this.add(panelZonaDelJuego);
    }

    public void inicializarZonaDelJuego() {
        this.panelZonaDelJuego.setLayout(null);
        this.panelZonaDelJuego.setBounds(300, 50, anchoZonaDelJuego, largoZonaDelJuego);
        this.panelZonaDelJuego.setBackground(Color.black);
    }

    public void agregarEscuchaGuardar(ActionListener escuchaGuardar) {
        this.botonGuardar.addActionListener(escuchaGuardar);
    }

    public void agregarEscuchaVolver(ActionListener escuchaVolver) {
        this.botonVolver.addActionListener(escuchaVolver);
    }

    public PanelZonaDeJuego getPanelZonaDeJuego() {
        return this.panelZonaDelJuego;
    }

    public void agregarEscuchaFlechas(KeyListener escuchaFlechas) {
        InputMap mapaDeEntrada = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap mapaDeAcciones = this.getActionMap();

        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "FlechaArriba");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "FlechaAbajo");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "FlechaIzquierda");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "FlechaDerecha");

        this.addKeyListener(escuchaFlechas);
    }
    
    public void actualizarMovimientosDelPanel(int cantMovimientosActuales) {
    	Integer aRestar = cantDeMovimientosIniciales - cantMovimientosActuales;
    	movimientosRestantes.setText("Movimientos Restantes:  " + aRestar);
    	movimientosTotales.setText("Movimientos Realizados:  "+ cantMovimientosActuales);
    }
    
	public void actualizarLabelVechiulo(String vehiculoDespuesDeMover) {
		vehiculoActual.setText("Vehiculo:   " + vehiculoDespuesDeMover);
		vehiculoActual.validate();
	}
    
    private String recuperarStringDeDificultad(int dificultad) {
    	switch (dificultad) {
    	case 1:	return "Facil";
    	case 2: return "Intermedio";
    	default: return "Dificil";
    	}
    }
    
    public void mostrarMensajePartidaGuardada() {
        JOptionPane.showMessageDialog(this, "Su partida es guardada exitosamente.", "Partida guardada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeError() {
        JOptionPane.showMessageDialog(this, "Se ocurrio error!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeMovimientoInvalido() {
        JOptionPane.showMessageDialog(this, "Imposible escapar de la ciudad.", "A donde van?", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajePartidaGanada() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, "Felicitaciones " + nombre + ", ganaste el nivel!", "Partida ganada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajePartidaPerdida() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, nombre + ", te has quedado sin movimientos.", "Partida perdida", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeUsuarioInexistente() {
        String nombre = Juego.getInstance().getJugadorActual().getNickName();
        JOptionPane.showMessageDialog(this, "El usuario '" + nombre + "' no existe. No se guardara el puntaje.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeNoPodesMoverte() {
        JOptionPane.showMessageDialog(this, "Hay piquete", "Aaaaa", JOptionPane.ERROR_MESSAGE);

    }
}