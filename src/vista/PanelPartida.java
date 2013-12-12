package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import control.Logger;
import modelo.Juego;
import modelo.Partida;

public class PanelPartida extends JPanel {

    private Boton botonGuardar = new Boton("Guardar");
    private Boton botonVolver = new Boton("Volver");

    private JLabel vehiculoActual = new JLabel();
    private int movimientosLimites;
    private JLabel movimientosLimitesLabel;
    private JLabel movimientosActualesLabel;
    private JLabel puntajeLabel;
    private JLabel vehiculoActualImagen = new JLabel();

    private PanelZonaDeJuego panelZonaDelJuego;
    private JPanel panelDeControl = new JPanel();
    private JPanel panelInfo = new JPanel();
    private LogPartida logPartida = new LogPartida();
    private JScrollPane scroll;

    private int anchoZonaDelJuego = 870; //ideal = 860
    private int largoZonaDelJuego = 610; //ideal = 580

    public PanelPartida(Partida partida) {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1180, 680));
        this.setBackground(new Color(255, 255, 255, 200));
        
        JLabel nombreUsuario = new JLabel("Jugador:  " + Juego.getInstance().getJugadorActual().getNombre());
        nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel dificultad = new JLabel("Dificultad:  " + recuperarStringDeDificultad(partida.dificultad));
        dificultad.setAlignmentX(CENTER_ALIGNMENT);

        this.vehiculoActual = new JLabel("Vehiculo:  " + partida.getVehiculo().asString());
        this.vehiculoActual.setAlignmentX(CENTER_ALIGNMENT);
        
        this.movimientosLimites = partida.getCantidadDeMovimientosDisponibles();
        this.movimientosLimitesLabel = new JLabel("Movimientos limites:  " + movimientosLimites);
        this.movimientosLimitesLabel.setForeground(Color.RED);
        this.movimientosLimitesLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        this.movimientosActualesLabel = new JLabel();
        this.movimientosActualesLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.puntajeLabel = new JLabel();
        this.puntajeLabel.setForeground(Color.GREEN);
        this.puntajeLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.actualizarMovimientosDelPanel(partida.getVehiculo().getCantidadDeMovimientos(), partida.dificultad);
        
		ImageIcon iconoVehiculo = new ImageIcon("src/vista/imagenes/Menu" + partida.getVehiculo().asString() + ".jpg");
		this.vehiculoActualImagen.setIcon(iconoVehiculo);
		this.vehiculoActualImagen.setPreferredSize(new Dimension(250,200));
		this.vehiculoActualImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.vehiculoActualImagen.setAlignmentX(CENTER_ALIGNMENT);
        
        this.panelDeControl.setPreferredSize(new Dimension(250,610));
        this.panelDeControl.setLayout(new BoxLayout(panelDeControl, BoxLayout.PAGE_AXIS));
        this.panelDeControl.setBackground(new Color(0,0,0,0));
        
        this.panelInfo.setMaximumSize(new Dimension(250,500));
        this.panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.PAGE_AXIS));
        this.panelInfo.setBackground(Color.WHITE);
        
		this.panelZonaDelJuego = new PanelZonaDeJuego(partida);
        this.inicializarZonaDelJuego();
        
        Logger.instance.addListener(logPartida);
        this.scroll = new JScrollPane(logPartida);
        this.scroll.setPreferredSize(new Dimension(250,100));
        this.scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.scroll.setAlignmentX(CENTER_ALIGNMENT);
        
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(nombreUsuario);
        this.panelInfo.add(Box.createVerticalStrut(5));
        this.panelInfo.add(dificultad);
        this.panelInfo.add(Box.createVerticalStrut(5));
        this.panelInfo.add(this.vehiculoActual);
        this.panelInfo.add(Box.createVerticalStrut(5));
        this.panelInfo.add(this.movimientosLimitesLabel);
        this.panelInfo.add(Box.createVerticalStrut(5));
        this.panelInfo.add(this.movimientosActualesLabel);
        this.panelInfo.add(Box.createVerticalStrut(5));
        this.panelInfo.add(this.puntajeLabel);
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(vehiculoActualImagen);
        this.panelInfo.add(Box.createVerticalStrut(10));
        this.panelInfo.add(scroll);
        
        this.panelDeControl.add(panelInfo);
        this.panelDeControl.add(Box.createVerticalStrut(20));
        this.panelDeControl.add(botonGuardar);
        this.panelDeControl.add(Box.createVerticalStrut(20));
        this.panelDeControl.add(botonVolver);

        this.add(panelDeControl);
        this.add(Box.createHorizontalStrut(20));
        this.add(panelZonaDelJuego);
    }

    public void inicializarZonaDelJuego() {
        this.panelZonaDelJuego.setLayout(null);
        this.panelZonaDelJuego.setPreferredSize(new Dimension(anchoZonaDelJuego,largoZonaDelJuego));
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

        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "FlechaArriba");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "FlechaAbajo");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "FlechaIzquierda");
        mapaDeEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "FlechaDerecha");

        this.addKeyListener(escuchaFlechas);
    }
    
    public void actualizarMovimientosDelPanel(int movimientosRealizados, int dificultad) {
    	this.movimientosActualesLabel.setText("Movimientos actuales:  " + movimientosRealizados);
    	int puntaje = (this.movimientosLimites - movimientosRealizados) * dificultad;
    	this.puntajeLabel.setText("Puntaje:  " + puntaje);
    }
    
	public void actualizarLabelVechiulo(String vehiculoDespuesDeMover) {
		this.vehiculoActual.setText("Vehiculo:   " + vehiculoDespuesDeMover);
		this.vehiculoActual.validate();
		ImageIcon iconoVehiculo = new ImageIcon("src/vista/imagenes/Menu" + vehiculoDespuesDeMover + ".jpg");
		this.vehiculoActualImagen.setIcon(iconoVehiculo);
		this.panelInfo.repaint();
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
        String nombre = Juego.getInstance().getJugadorActual().getNombre();
        int movimientosRestantes = Juego.getInstance().getPartida().getCantidadDeMovimientosDisponibles() - Juego.getInstance().getVehiculo().getCantidadDeMovimientos();
        int puntaje = movimientosRestantes * Juego.getInstance().getPartida().dificultad;
        JOptionPane.showMessageDialog(this, "Felicitaciones " + nombre + ", Ud gano el nivel!\n\n"
        										+ "Movimientos quedan:  " + String.valueOf(movimientosRestantes) + "\n"
        											+ "Puntaje obtenido:  " + String.valueOf(puntaje),
        												"Partida ganada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajePartidaPerdida() {
        String nombre = Juego.getInstance().getJugadorActual().getNombre();
        JOptionPane.showMessageDialog(this, nombre + ", Ud ha quedado sin movimientos.", "Partida perdida", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeUsuarioInexistente() {
        String nombre = Juego.getInstance().getJugadorActual().getNombre();
        JOptionPane.showMessageDialog(this, "El usuario '" + nombre + "' no existe. No se guardara el puntaje.", "Error", JOptionPane.ERROR_MESSAGE);
    }

}