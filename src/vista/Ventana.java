package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;
    JFrame frame;

    public Ventana() {
        this.setTitle("GPS Challenge");
        this.setLocationRelativeTo(null);
        this.setResizable(false);//evita que la ventana se maximize ni cambia su tamanio
        this.setLocation(250,250);//dibuja a 250px de distancia del monitor
      	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 800);
		this.setIconImage(new ImageIcon(getClass().getResource("imagenes/gps.png")).getImage());
        frame = this;
    }
    
    public Ventana(String titulo) {
        this.setTitle(titulo);
        this.setLocationRelativeTo(null);
        this.setResizable(false);//evita que la ventana se maximize ni cambia su tamanio
        this.setLocation(250,250);//dibuja a 250px de distancia del monitor
      	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 800);
		this.setIconImage(new ImageIcon(getClass().getResource("imagenes/gps.png")).getImage());
        frame = this;
    }
    
    public void addImagenDeFondo(String direccion) {
        ImageIcon iconoNuevaPartida = new ImageIcon(direccion);
        JLabel icono = new JLabel(iconoNuevaPartida);
        icono.setBounds(0, 0, 800, 481);
        this.getContentPane().add(icono);
    }
    
}