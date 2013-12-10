package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import modelo.Jugador;

public class PanelPuntajes extends JPanel {
	
	private JTable tabla;
	private Boton botonVolver = new Boton("Volver");
	private JLabel etiqueta = new JLabel("Puntajes de jugadores registrados");

	public PanelPuntajes(ArrayList<Jugador> puntajesOrdenados) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(300,600));
		this.setBackground(new Color(255,255,255,200));
		
		this.etiqueta.setAlignmentX(CENTER_ALIGNMENT);
		this.botonVolver.setAlignmentX(CENTER_ALIGNMENT);
		TablaDePuntajes tablaModelo = new TablaDePuntajes(puntajesOrdenados);
		this.tabla = new JTable(tablaModelo);
        Render render = new Render();
        this.tabla.getColumnModel().getColumn(0).setCellRenderer(render);
        this.tabla.getColumnModel().getColumn(1).setCellRenderer(render);
        this.tabla.getColumnModel().getColumn(1).setMaxWidth(50);
        this.tabla.setAlignmentX(CENTER_ALIGNMENT);
        this.tabla.setOpaque(false);
        this.tabla.setShowVerticalLines(false);
        this.tabla.setGridColor(Color.CYAN);

		this.add(Box.createVerticalStrut(15));
		this.add(etiqueta);
		this.add(Box.createVerticalStrut(20));
		this.add(botonVolver);
		this.add(Box.createVerticalStrut(20));
		this.add(tabla);
	}
	
	public PanelPuntajes() {}
	
	public void agregarVolverListener(ActionListener volverListener) {
		botonVolver.addActionListener(volverListener);
	}
	
	class Render implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            //Si values es nulo dara problemas de renderizado, por lo tanto se pone como vacio
            JLabel lbl = new JLabel(value == null? "": value.toString());
            lbl.setHorizontalAlignment(SwingConstants.CENTER); //alina a laizquierda
            lbl.setForeground(Color.BLACK);  //fuente azul
            lbl.setOpaque(false);
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
