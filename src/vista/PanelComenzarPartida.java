package vista;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComenzarPartida extends JPanel {

	
	private JLabel seleccioneNivel;
	private JLabel seleccioneVehiculo;
	private String[] listaDeNiveles = {"Facil","Intermedio","Dificil"};
	private String[] listaDeVehiculos = {"Auto","4x4","Moto"};
	private JComboBox<String> niveles;
	private JComboBox<String> vehiculos;
	private JButton botonAceptar = new JButton("Aceptar");
	
	  public PanelComenzarPartida(){
		  this.setLayout(null);  
		  
		  this.seleccioneNivel=new JLabel("Por favor seleccione el nivel");
		  this.seleccioneNivel.setBounds(200, 40, 200, 30);
		  this.niveles = new JComboBox<String>(listaDeNiveles);
		  this.niveles.setBounds(200, 80, 100, 30);
		  this.seleccioneVehiculo= new JLabel("Por favor seleccione un vehiculo");
		  this.seleccioneVehiculo.setBounds(200, 120, 200, 30);
		  this.vehiculos = new JComboBox<String>(listaDeVehiculos);
		  this.vehiculos.setBounds(200, 160, 100, 30);
		  this.botonAceptar.setBounds(200, 210, 200, 30); 
		  
		  this.add(seleccioneNivel);
		  this.add(niveles);
		  this.add(seleccioneVehiculo);
		  this.add(vehiculos);
		  this.add(botonAceptar);
	  }
	  
	  public void agregarEscucharAceptar(ActionListener escuchaAceptar){
		  this.botonAceptar.addActionListener(escuchaAceptar);
	  }	
	  
}
