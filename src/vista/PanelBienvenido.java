package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControladorBienvenido.EscuchaNuevoUsuario;

public class PanelBienvenido extends JPanel {

	private JLabel bienvenido = new JLabel("BIENVENIDO A GPS CHALLENGE");
	private JButton botonNuevoUsuario = new JButton("Nuevo Usuario");
	private JButton botonUsuarioRegistrado = new JButton("Usuario Registrado");
	private JButton botonSalir = new JButton("Salir");
	
	public PanelBienvenido() {
		this.setLayout(null);
		this.bienvenido.setBounds(510,50,200,30);
		this.botonNuevoUsuario.setBounds(500,100,200,30);
		this.botonUsuarioRegistrado.setBounds(500,150,200,30);
		this.botonSalir.setBounds(500, 200, 200, 30);
		
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
	
}
