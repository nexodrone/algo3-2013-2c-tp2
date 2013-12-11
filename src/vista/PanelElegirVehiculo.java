package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import modelo.Juego;

public class PanelElegirVehiculo extends JPanel {
	
	private Boton botonAceptar = new Boton("Aceptar");
	private Boton botonVolver = new Boton("Volver");
	private PanelImgBtn panelConImagenesYBotones = new PanelImgBtn();
	private String nivel;
	
	public PanelElegirVehiculo(String nivelSeleccionado) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(1000,650));
		this.setBackground(new Color(255,255,255,200));
		this.nivel = nivelSeleccionado;
		
		JLabel nombreUsuario = new JLabel(Juego.getInstance().getJugadorActual().getNombre());
		nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
		JLabel seleVeh = new JLabel("Por favor seleccione vehiculo");
		seleVeh.setAlignmentX(CENTER_ALIGNMENT);
		this.panelConImagenesYBotones.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createVerticalStrut(15));
		this.add(nombreUsuario);
		this.add(Box.createVerticalStrut(15));
		this.add(seleVeh);
		this.add(Box.createVerticalStrut(20));
		this.add(panelConImagenesYBotones);
		this.add(Box.createVerticalStrut(20));
		this.add(botonAceptar);
		this.add(Box.createVerticalStrut(20));
		this.add(botonVolver);
	}

	public void agregarEscuchaAceptar(ActionListener escuchaAceptar) {
		this.botonAceptar.addActionListener(escuchaAceptar);
	}

	public void agregarEscuchaVolver(ActionListener escuchaVolver) {
		this.botonVolver.addActionListener(escuchaVolver);
	}

	public void mostrarMensajeNadaSeleccionado() {
		JOptionPane.showMessageDialog(this, "Por favor seleccione un vehiculo.", "Vehiculo no seleccionado", JOptionPane.WARNING_MESSAGE);
	}

	public void mostrarMensajeArchivoDaniado() {
		JOptionPane.showMessageDialog(this, "Archivo con nivel no se encontro o esta roto :(\nSe va a cargar nivel por defecto.", "Archivo roto", JOptionPane.ERROR_MESSAGE);
	}

	public String obtenerVehiculoSeleccionado() {
		if (this.panelConImagenesYBotones.botonAuto.isSelected()){
			return "Auto";
		}else if (this.panelConImagenesYBotones.boton4x4.isSelected()){
			return "4x4";
		}else{
			return "Moto";
		}
	}

	public boolean ningunCampoSeleccionado() {
		return (panelConImagenesYBotones.bgroup.getSelection() == null);
	}

	public String obtenerNivelSeleccionado() {
		return nivel;
	}
	
	private class PanelImgBtn extends JPanel {
		
		public JPanel panelAuto = new JPanel();
		public JPanel panelMoto = new JPanel();
		public JPanel panel4x4 = new JPanel();
		public JLabel imagenAuto = new JLabel();
		public JLabel imagenMoto = new JLabel();
		public JLabel imagen4x4 = new JLabel();
		private ButtonGroup bgroup = new ButtonGroup();
		public JRadioButton botonAuto = new JRadioButton("Auto");
		public JRadioButton botonMoto = new JRadioButton("Moto");
		public JRadioButton boton4x4 = new JRadioButton("4x4");
		
		public PanelImgBtn() {
			
			this.setLayout(new FlowLayout());
			this.setAlignmentX(CENTER_ALIGNMENT);
			this.setBackground(new Color(0,0,0,0));
			this.setMaximumSize(new Dimension(900,400));

			this.agregarPanelConAuto();
			this.add(Box.createHorizontalStrut(20));
			this.agregarPanelConMoto();
			this.add(Box.createHorizontalStrut(20));
			this.agregarPanelCon4x4();
		}

		private void agregarPanelConAuto() {
			prepararPanelConVehiculo(panelAuto);
			prepararImagenIlustrativa(imagenAuto, "src/vista/imagenes/MenuAuto.jpg");
			prepararBoton(botonAuto);
			
			JLabel texto1 = new JLabel("Pozo: penaliza 3 movimientos.");
			JLabel texto2 = new JLabel("Piquete: no puede pasar.");
			JLabel texto3 = new JLabel("Control: penaliza 3, chanse: 50%.");
			JLabel texto4 = new JLabel("Cambio de vehiculo: a 4x4.");
			texto1.setAlignmentX(CENTER_ALIGNMENT);
			texto2.setAlignmentX(CENTER_ALIGNMENT);
			texto3.setAlignmentX(CENTER_ALIGNMENT);
			texto4.setAlignmentX(CENTER_ALIGNMENT);
			
			agregarComponentes(panelAuto, imagenAuto, texto1, texto2, texto3, texto4, botonAuto);

			this.add(panelAuto);
		}
		
		private void agregarPanelConMoto() {
			prepararPanelConVehiculo(panelMoto);
			prepararImagenIlustrativa(imagenMoto, "src/vista/imagenes/MenuMoto.jpg");
			prepararBoton(botonMoto);
			
			JLabel texto1 = new JLabel("Pozo: penaliza 3 movimientos.");
			JLabel texto2 = new JLabel("Piquete: penaliza 2 movimientos.");
			JLabel texto3 = new JLabel("Control: penaliza 3, chanse: 80%.");
			JLabel texto4 = new JLabel("Cambio de vehiculo: a Auto.");
			texto1.setAlignmentX(CENTER_ALIGNMENT);
			texto2.setAlignmentX(CENTER_ALIGNMENT);
			texto3.setAlignmentX(CENTER_ALIGNMENT);
			texto4.setAlignmentX(CENTER_ALIGNMENT);
			
			agregarComponentes(panelMoto, imagenMoto, texto1, texto2, texto3, texto4, botonMoto);
			
			this.add(panelMoto);
		}
		
		private void agregarPanelCon4x4() {
			prepararPanelConVehiculo(panel4x4);
			prepararImagenIlustrativa(imagen4x4, "src/vista/imagenes/Menu4x4.jpg");
			prepararBoton(boton4x4);
			
			JLabel texto1 = new JLabel("Pozo: no penaliza.");
			JLabel texto2 = new JLabel("Piquete: no puede pasar.");
			JLabel texto3 = new JLabel("Control: penaliza 3, chanse: 30%.");
			JLabel texto4 = new JLabel("Cambio de vehiculo: a Moto.");
			texto1.setAlignmentX(CENTER_ALIGNMENT);
			texto2.setAlignmentX(CENTER_ALIGNMENT);
			texto3.setAlignmentX(CENTER_ALIGNMENT);
			texto4.setAlignmentX(CENTER_ALIGNMENT);
			
			agregarComponentes(panel4x4, imagen4x4, texto1, texto2, texto3, texto4, boton4x4);
			
			this.add(panel4x4);
		}
		
		private void prepararPanelConVehiculo(JPanel panel) {
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setPreferredSize(new Dimension(250,400));
			panel.setBackground(Color.WHITE);
		}
		
		private void prepararImagenIlustrativa(JLabel label, String ruta) {
			ImageIcon icono = new ImageIcon(ruta);
			label.setIcon(icono);
			label.setPreferredSize(new Dimension(250,200));
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label.setAlignmentX(CENTER_ALIGNMENT);
		}
		
		private void prepararBoton(JRadioButton boton) {
			boton.setAlignmentX(CENTER_ALIGNMENT);
			boton.setBackground(Color.WHITE);
			this.bgroup.add(boton);
		}
		
		private void agregarComponentes(JPanel panel, JLabel imagen, JLabel label1, JLabel label2, JLabel label3, JLabel label4, JRadioButton boton) {
			panel.add(imagen);
			panel.add(Box.createVerticalStrut(20));
			panel.add(label1);
			panel.add(label2);
			panel.add(label3);
			panel.add(label4);
			panel.add(Box.createVerticalStrut(70));
			panel.add(boton);
		}
	}

}
