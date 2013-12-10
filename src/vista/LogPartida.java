package vista;

import java.awt.Color;

import javax.swing.JTextArea;

import control.Listener;

public class LogPartida extends JTextArea implements Listener {
	
	public LogPartida() {
		this.setBackground(new Color(200, 200, 220, 255));
		this.setFocusable(false);
		this.setLineWrap(true);
		this.setWrapStyleWord(true);
	}
	
	public void log(String mensaje) {
		this.append(mensaje + "\n");
	}
}