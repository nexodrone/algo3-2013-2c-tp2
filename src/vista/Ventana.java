package vista;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

    private static final long serialVersionUID = 1L;
    JFrame frame;

    public Ventana() {
        this.setTitle("GPS Challenge");
        this.setLocationRelativeTo(null);
        this.setResizable(false);	/* evita que la ventana se maximize ni cambia su tamanio */
        this.setLocation(50,50);	/* dibuja a 50px de distancia del monitor */
      	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setContentPane(new JLabel(new ImageIcon("src/vista/imagenes/bkgrd.jpg")));
		this.setLayout(new FlowLayout());
		this.setIconImage(new ImageIcon(getClass().getResource("imagenes/gps.png")).getImage());
        this.setVisible(true);
        frame = this;
    }

}