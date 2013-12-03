package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import modelo.Jugador;

public class PanelPuntajes extends JPanel {
	
	JTable table;
	JButton volver;
	JLabel nombre;
	JLabel puntaje;

	public PanelPuntajes(ArrayList<Jugador> puntajesOrdenados) {
		this.setLayout(null);
		TablaDePuntajes tablaModelo = new TablaDePuntajes(puntajesOrdenados);
		table = new JTable(tablaModelo);
		
        Render render = new Render();
        table.getColumnModel().getColumn(0).setCellRenderer(render);
        table.getColumnModel().getColumn(1).setCellRenderer(render);        
		
		volver = new JButton("Volver");
		
		nombre = new JLabel("Nombre");		
		puntaje = new JLabel("Puntaje");
		
		nombre.setBounds(130, 10, 100, 40);
		puntaje.setBounds(220, 10, 100, 40);
		table.setBounds(100, 40, 200, puntajesOrdenados.size()*16);
		volver.setBounds(150, puntajesOrdenados.size()*16 + 50, 80, 30);
		
		this.add(volver);
		this.add(table);
		this.add(nombre);
		this.add(puntaje);
	}
	
	public PanelPuntajes() {}
	
	public void agregarVolverListener(ActionListener volverListener) {
		volver.addActionListener(volverListener);
	}
	
	class Render implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            //Si values es nulo dara problemas de renderizado, por lo tanto se pone como vacio
            JLabel lbl = new JLabel(value == null? "": value.toString());
            lbl.setHorizontalAlignment(SwingConstants.CENTER); //alina a laizquierda
            lbl.setForeground(Color.BLUE);  //fuente azul
            lbl.setOpaque(true);
            lbl.setBackground(Color.YELLOW);
            return lbl;
        }
    };
	
	public class TablaDePuntajes extends AbstractTableModel {
		private List<Jugador> jugadores;
		
		public TablaDePuntajes(List<Jugador> jugs) {
			jugadores = new ArrayList<>(jugs);
		}
		
		@Override
		public int getRowCount() {
			return jugadores.size();
		}
		
		@Override
		public int getColumnCount() {
			return 2;
		}
		
		@Override
		public String getColumnName(int colum) {
			String name = "";
			switch(colum) {
			case 0:
				name = "Nombre";
				break;
			case 1:
				name = "Puntaje";
				break;
			}
			return name; 
		}
		
		@Override
		public Object getValueAt(int row, int column) {
			Jugador jugador = jugadores.get(row);
			Object value = null;
			switch (column) {
			case 0:
				value = jugador.getNombre(); break;
			case 1:
				value = jugador.getPuntaje(); break;
			}
			return value;
		}
	}	
}
