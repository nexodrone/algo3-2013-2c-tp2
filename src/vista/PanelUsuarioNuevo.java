package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUsuarioNuevo extends JPanel {

	private JLabel etiqueta = new JLabel("Por favor introduzca su nombre");
	private JButton botonVolver = new JButton("Volver");
	private JButton botonGuardar = new JButton("Guardar");
	private JTextField nombre = new JTextField();
	
	public PanelUsuarioNuevo() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(300,400));
		this.etiqueta.setBounds(60, 60, 200, 20);
		this.nombre.setBounds(50, 100, 200, 20);
		this.botonGuardar.setBounds(50, 150, 200, 30);
		this.botonVolver.setBounds(50, 200, 200, 30);
		this.setBackground(new Color(255,255,255,150));
		this.add(etiqueta);
		this.add(nombre);
		this.add(botonGuardar);
		this.add(botonVolver);
	}
	
	public String getNombreDelCampo() {
		return nombre.getText();
	}
	
	public void agregarEscuchaVolver(ActionListener escuchaVolver) {
		this.botonVolver.addActionListener(escuchaVolver);
	}
	
	public void agregarEscuchaGuardar(ActionListener escuchaGuardar){
		this.botonGuardar.addActionListener(escuchaGuardar);
	}
	
	public void agregarEscuchaEnter(KeyListener escuchaEnter) {
		this.nombre.addKeyListener(escuchaEnter);
	}
	
	public void mostrarMensajeCampoVacio() {
		JOptionPane.showMessageDialog(this, "Por favor ingrese nombre.", "Campo vacio", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostrarMensajeNombreNoDisponible() {
		JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese nombre, por favor eliga otro.", "Nombre no disponible", JOptionPane.WARNING_MESSAGE);
	}

	public void mostrarMensajeNoExisteArchivoDePuntajes() {
		JOptionPane.showMessageDialog(this, "No se encontro la lista de jugadores. Se creara una lista nueva.", "Archivo de jugadores inexistente", JOptionPane.WARNING_MESSAGE);
	}
	
}
