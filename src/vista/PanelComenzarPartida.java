package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelComenzarPartida extends JPanel {

	private JLabel seleccioneNivel = new JLabel("Por favor seleccione un nivel");
	private JLabel seleccioneVehiculo = new JLabel("Por favor seleccione un vehiculo");
	private String[] listaDeNiveles = {"Facil","Intermedio","Dificil"};
	private String[] listaDeVehiculos = {"Auto","4x4","Moto"};
	private JComboBox<String> niveles;
	private JComboBox<String> vehiculos;
	private JButton botonAceptar = new JButton("Aceptar");
	private JButton botonVolver = new JButton("Volver");
	
	public PanelComenzarPartida() {
		this.setLayout(null);  
		  
		this.seleccioneNivel.setBounds(500, 60, 200, 20);
		this.niveles = new JComboBox<String>(listaDeNiveles);
		this.niveles.setBounds(500, 80, 100, 30);
		this.seleccioneVehiculo.setBounds(500, 130, 200, 20);
		this.vehiculos = new JComboBox<String>(listaDeVehiculos);
		this.vehiculos.setBounds(500, 150, 100, 30);
		this.botonAceptar.setBounds(500, 200, 200, 30); 
		this.botonVolver.setBounds(500, 250, 200, 30);
		
		this.add(seleccioneNivel);
		this.add(niveles);
		this.add(seleccioneVehiculo);
		this.add(vehiculos);
		this.add(botonAceptar);
		this.add(botonVolver);
	}
	  
	public void agregarEscuchaAceptar(ActionListener escuchaAceptar) {
		this.botonAceptar.addActionListener(escuchaAceptar);
	}

	public void agregarEscuchaVolver(ActionListener escuchaVolver) {
		this.botonVolver.addActionListener(escuchaVolver);		  
	}

	public String obtenerVehiculoSeleccionado() {
		Object e = vehiculos.getSelectedItem();
		String vehiculoSeleccionado = new String();
		vehiculoSeleccionado = String.valueOf(e);
		return vehiculoSeleccionado;
	}
	  
	public String obtenerNivelSeleccionado() {
		Object e = niveles.getSelectedItem();
		String nivelSeleccionado = new String();
		nivelSeleccionado = String.valueOf(e);
		return nivelSeleccionado;
	}
	  
	public void mostrarMensajeError() {
		JOptionPane.showMessageDialog(this, "Se ocurrio error!", "Error", JOptionPane.ERROR_MESSAGE);
	}

}
