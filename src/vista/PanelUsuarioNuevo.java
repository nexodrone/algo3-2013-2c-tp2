package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUsuarioNuevo extends JPanel {

	private JLabel introNom = new JLabel("Por favor introduzca su nombre");
	private Boton botonVolver = new Boton("Volver");
	private Boton botonGuardar = new Boton("Guardar");
	private JTextField nombre = new JTextField();
	
	public PanelUsuarioNuevo() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,400));
		this.setBackground(new Color(255,255,255,200));
		
		this.introNom.setAlignmentX(CENTER_ALIGNMENT);
		this.nombre.setMaximumSize(new Dimension(200,20));
		this.nombre.setAlignmentX(CENTER_ALIGNMENT);
		this.botonGuardar.setAlignmentX(CENTER_ALIGNMENT);
		this.botonVolver.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createVerticalStrut(15));
		this.add(introNom);
		this.add(Box.createVerticalStrut(30));
		this.add(nombre);
		this.add(Box.createVerticalStrut(20));
		this.add(botonGuardar);
		this.add(Box.createVerticalStrut(20));
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
