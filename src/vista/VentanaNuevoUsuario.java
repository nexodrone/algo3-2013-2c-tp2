package vista;


import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class VentanaNuevoUsuario extends JFrame{

	private final JLabel nombre = new JLabel("Por favor introduzca su nombre :");
	private final JTextField campo_nombre = new JTextField(10);	
	
	public VentanaNuevoUsuario(){
		
		setTitle("Nuevo Usuario");
		setSize(800,451);//crea la ventana de 800x481
        setLocation(250,250);//dibuja a 250px de distancia del monitor
        setResizable(false);//evita que la ventana se maximize
        setVisible(true);//permite mostrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Container contenedor = getContentPane();
		SpringLayout layout = new SpringLayout();
		contenedor.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, nombre, 50, SpringLayout.WEST, contenedor);//eje x
		layout.putConstraint(SpringLayout.NORTH, nombre, 50, SpringLayout.NORTH, contenedor);//eje y
		
		contenedor.add(nombre);
		contenedor.add(campo_nombre);
	}


	public static void main(String[] arguments){
		VentanaNuevoUsuario dialog = new VentanaNuevoUsuario(); 
		
	}
	
}
