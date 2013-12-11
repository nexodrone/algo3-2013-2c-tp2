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

public class PanelElegirNivel extends JPanel {

	private Boton botonAceptar = new Boton("Aceptar");
	private Boton botonVolver = new Boton("Volver");
	private PanelImgBtn panelConImagenesYBotones = new PanelImgBtn();

	public PanelElegirNivel(String nombre) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(1000,650));
		this.setBackground(new Color(255,255,255,200));
		
		JLabel nombreUsuario = new JLabel(nombre);
		nombreUsuario.setAlignmentX(CENTER_ALIGNMENT);
		JLabel seleDif = new JLabel("Por favor seleccione dificultad");
		seleDif.setAlignmentX(CENTER_ALIGNMENT);
		this.panelConImagenesYBotones.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createVerticalStrut(15));
		this.add(nombreUsuario);
		this.add(Box.createVerticalStrut(15));
		this.add(seleDif);
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

	public String obtenerNivelSeleccionado() {
		if (this.panelConImagenesYBotones.botonFacil.isSelected()) {
			return "Facil";
		} else if(this.panelConImagenesYBotones.botonDificil.isSelected()) {
			return "Dificil";
		} else {
			return "Intermedio";
		}
	}

	public boolean ningunCampoSeleccionado() {
		return (panelConImagenesYBotones.bgroup.getSelection() == null);
	}

	public void mostrarMensajeNadaSeleccionado() {
		JOptionPane.showMessageDialog(this, "Por favor seleccione un nivel.", "Nivel no seleccionado", JOptionPane.WARNING_MESSAGE);
	}
	
	private class PanelImgBtn extends JPanel {
		
		public JPanel panelFacil = new JPanel();
		public JPanel panelIntermedio = new JPanel();
		public JPanel panelDificil = new JPanel();
		public JLabel imagenFacil = new JLabel();
		public JLabel imagenIntermedio = new JLabel();
		public JLabel imagenDificil = new JLabel();
		private ButtonGroup bgroup = new ButtonGroup();
		public JRadioButton botonFacil = new JRadioButton("Facil");
		public JRadioButton botonIntermedio = new JRadioButton("Intermedio");
		public JRadioButton botonDificil = new JRadioButton("Dificil");
		
		public PanelImgBtn() {
			
			this.setLayout(new FlowLayout());
			this.setAlignmentX(CENTER_ALIGNMENT);
			this.setBackground(new Color(0,0,0,0));
			this.setMaximumSize(new Dimension(900,400));

			this.agregarPanelConNivelFacil();
			this.add(Box.createHorizontalStrut(20));
			this.agregarPanelConNivelIntermedio();
			this.add(Box.createHorizontalStrut(20));
			this.agregarPanelConNivelDificil();
		}

		private void agregarPanelConNivelFacil() {
			prepararPanelConNivel(panelFacil);
			prepararImagenIlustrativa(imagenFacil, "src/vista/imagenes/nivelFacil.png");
			prepararBoton(botonFacil);
			
			JLabel texto1 = new JLabel("Tablero chico.");
			JLabel texto2 = new JLabel("Abundantes movimientos.");
			JLabel texto3 = new JLabel("1 puntos por movimiento sobrante.");
			texto1.setAlignmentX(CENTER_ALIGNMENT);
			texto2.setAlignmentX(CENTER_ALIGNMENT);
			texto3.setAlignmentX(CENTER_ALIGNMENT);
			
			agregarComponentes(panelFacil, imagenFacil, texto1, texto2, texto3, botonFacil);

			this.add(panelFacil);
		}
		
		private void agregarPanelConNivelIntermedio() {
			prepararPanelConNivel(panelIntermedio);
			prepararImagenIlustrativa(imagenIntermedio, "src/vista/imagenes/nivelIntermedio.png");
			prepararBoton(botonIntermedio);
			
			JLabel texto1 = new JLabel("Tablero intermedio.");
			JLabel texto2 = new JLabel("Sufucientes movimientos.");
			JLabel texto3 = new JLabel("2 puntos por movimiento sobrante.");
			texto1.setAlignmentX(CENTER_ALIGNMENT);
			texto2.setAlignmentX(CENTER_ALIGNMENT);
			texto3.setAlignmentX(CENTER_ALIGNMENT);
			
			agregarComponentes(panelIntermedio, imagenIntermedio, texto1, texto2, texto3, botonIntermedio);
			
			this.add(panelIntermedio);
		}
		
		private void agregarPanelConNivelDificil() {
			prepararPanelConNivel(panelDificil);
			prepararImagenIlustrativa(imagenDificil, "src/vista/imagenes/nivelDificil.png");
			prepararBoton(botonDificil);
			
			JLabel texto1 = new JLabel("Tablero grande.");
			JLabel texto2 = new JLabel("Escasos movimientos.");
			JLabel texto3 = new JLabel("3 puntos por movimiento sobrante.");
			texto1.setAlignmentX(CENTER_ALIGNMENT);
			texto2.setAlignmentX(CENTER_ALIGNMENT);
			texto3.setAlignmentX(CENTER_ALIGNMENT);
			
			agregarComponentes(panelDificil, imagenDificil, texto1, texto2, texto3, botonDificil);
			
			this.add(panelDificil);
		}
		
		private void prepararPanelConNivel(JPanel panel) {
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setPreferredSize(new Dimension(250,400));
			panel.setBackground(Color.WHITE);
		}
		
		private void prepararImagenIlustrativa(JLabel label, String ruta) {
			ImageIcon icono = new ImageIcon(ruta);
			label.setIcon(icono);
			label.setPreferredSize(new Dimension(250,250));
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label.setAlignmentX(CENTER_ALIGNMENT);
		}
		
		private void prepararBoton(JRadioButton boton) {
			boton.setAlignmentX(CENTER_ALIGNMENT);
			boton.setBackground(Color.WHITE);
			this.bgroup.add(boton);
		}
		
		private void agregarComponentes(JPanel panel, JLabel imagen, JLabel label1, JLabel label2, JLabel label3, JRadioButton boton) {
			panel.add(imagen);
			panel.add(Box.createVerticalStrut(20));
			panel.add(label1);
			panel.add(label2);
			panel.add(label3);
			panel.add(new JLabel(" "));
			panel.add(Box.createVerticalStrut(20));
			panel.add(boton);
		}
	}

}
