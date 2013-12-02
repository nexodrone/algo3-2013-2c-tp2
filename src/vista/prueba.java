package vista;

	import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
	 
	public class prueba extends JFrame {
	 
	 private JCheckBox check1;
	 private JCheckBox check2;
	 private JRadioButton radio1;
	 private JRadioButton radio2;
	 private JRadioButton radio3;
	 
	 public prueba() {

	  add(getLabel4());
	  add(getLabel5());
	  add(getLabel6());
	  add(getLabel7());
	  getButtonGroup(getRadio1(), getRadio2(),getRadio3());
	  add(this.radio1);
	  add(this.radio2);
	  add(this.radio3);
	  inicializador();
	 }
	 
	 private void inicializador() {
	  setSize(400, 300);
	  setLayout(null);
	  setTitle("Aprendiendo Checkbox");
	  setLocationRelativeTo(null);
	  setVisible(true);
	  setResizable(false);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
	 
	 
	 private JLabel getLabel4() {
	  JLabel etiqueta = new JLabel("Por favor seleccione dificultad");
	  etiqueta.setBounds(10, 80, 220, 10);
	  return etiqueta;
	 }
	 
	 private JLabel getLabel5() {
	  JLabel l = new JLabel("Facil");
	  l.setBounds(10, 100, 80, 30);
	  return l;
	 }
	 
	 private JLabel getLabel6() {
	  JLabel l = new JLabel("Intermedio");
	  l.setBounds(10, 120, 80, 30);
	  return l;
	 }
	 
	 private JLabel getLabel7() {
		  JLabel l = new JLabel("Dificil");
		  l.setBounds(10, 140, 80, 30);
		  return l;
	 }
	 
	 
	 private JRadioButton getRadio1() {
	  radio1 = new JRadioButton();
	  /*radio1.setSelected(true);*/
	  radio1.setBounds(80, 100, 20, 20);
	  return radio1;
	 }
	 
	 private JRadioButton getRadio2() {
	  radio2 = new JRadioButton();
	  radio2.setBounds(80, 120, 20, 20);
	  return radio2;
	 }
	 
	 private JRadioButton getRadio3() {
		 radio3 = new JRadioButton();
		 radio3.setBounds(80, 140, 20, 20);
		 return radio3;
	}
		  
	  
	 //Creación del grupo de botones recibe nuestro radiobutton creados
	 //anteriormente
	 private void getButtonGroup (JRadioButton radio1, JRadioButton radio2,JRadioButton radio3){
	  //creamos el objeto
	  ButtonGroup bgroup = new ButtonGroup();
	  //añadimos al grupo el primer radioButton
	  bgroup.add(radio1);
	  //añadimos al grupo el segundo radioButton
	  bgroup.add(radio2); 
	  bgroup.add(radio3);
		  
	 }
	 
	 public static void main(String[] args) {
	  new prueba();
	 }
	 
	}

