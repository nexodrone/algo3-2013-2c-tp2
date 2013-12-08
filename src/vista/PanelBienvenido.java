package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.ControladorBienvenido.EscuchaNuevoUsuario;

public class PanelBienvenido extends JPanel {

	private JLabel bienvenido = new JLabel("BIENVENIDO A GPS CHALLENGE");
	private JButton botonNuevoUsuario = new JButton("Nuevo Usuario");
	private JButton botonUsuarioRegistrado = new JButton("Usuario Registrado");
	private JButton botonSalir = new JButton("Salir");
	
	public PanelBienvenido() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(300,400));
		this.bienvenido.setBounds(60,50,200,30);
		this.botonNuevoUsuario.setBounds(50,100,200,30);
		this.botonUsuarioRegistrado.setBounds(50,150,200,30);
		this.botonSalir.setBounds(50, 200, 200, 30);
		this.setBackground(new Color(255,255,255,150));
		this.add(bienvenido);
		this.add(botonNuevoUsuario);
		this.add(botonUsuarioRegistrado);
		this.add(botonSalir);
	}

	public void agregarEscuchaNuevoUsuario(EscuchaNuevoUsuario escuchaNuevoUsuario) {
		this.botonNuevoUsuario.addActionListener(escuchaNuevoUsuario);
	}
	
	public void agregarEscuchaUsuarioRegistrado(ActionListener escuchaUsuarioRegistrado) {
		this.botonUsuarioRegistrado.addActionListener(escuchaUsuarioRegistrado);
	}
	
	public void agregarEscuchaSalir(ActionListener escuchaSalir) {
		this.botonSalir.addActionListener(escuchaSalir);
	}
	
	public void mostrarMensajeErrorArchivoJugadores() {
		JOptionPane.showMessageDialog(this, "No se encontro el archivo de jugadores, cree un nuevo usuario para poder jugar.", "Error: Archivo de Jugadores", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensajeNoHayUsuariosCreados() {
		JOptionPane.showMessageDialog(this, "No hay usuarios creados, cree un nuevo usuario para poder jugar.", "Lista de usuarios vacia", JOptionPane.WARNING_MESSAGE);
	}
	
}
