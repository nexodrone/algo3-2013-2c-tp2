package vista;

import java.awt.event.ActionListener;

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
	
		this.etiqueta.setBounds(510, 60, 200, 20);
		this.nombre.setBounds(500, 100, 200, 20);
		this.botonGuardar.setBounds(500, 150, 200, 30);
		this.botonVolver.setBounds(500, 200, 200, 30);
		
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
	
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Campo vacio", JOptionPane.WARNING_MESSAGE);
	}
	
}
