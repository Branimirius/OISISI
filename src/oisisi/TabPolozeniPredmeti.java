package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import model.BazaStudenata;
import model.Ocena;
import model.Student;


public class TabPolozeniPredmeti extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5979608371285451597L;
	
	private static TabPolozeniPredmeti instance = null;

	public static TabPolozeniPredmeti getInstance() {
		if (instance == null) {
			instance = new TabPolozeniPredmeti();
		}
		return instance;
	}
	
	
	PolozeniJTable tabelaPolozeni = PolozeniJTable.getInstance();		
	JScrollPane scrollPolozeni = new JScrollPane(tabelaPolozeni);
		
		public TabPolozeniPredmeti() {
		
		
		setLayout(new BorderLayout());	
		//ChangeListenerIzmenaStudenta brt = new ChangeListenerIzmenaStudenta();
		
		JButton ponisti = new JButton("Ponisti ocenu");
			ponisti.setBackground(Color.GREEN);		
		JLabel stealthLab = new JLabel();
		JPanel stealthPan = new JPanel();
			stealthPan.add(stealthLab);
		
		JPanel dugmence = new JPanel();
			dugmence.setLayout(new BorderLayout());
			dugmence.add(ponisti, BorderLayout.WEST);

		JPanel tabela = new JPanel();		
		tabela.add(scrollPolozeni);
		
		
		
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(20));
			boxCentar.add(dugmence);
			boxCentar.add(Box.createVerticalStrut(20));
			boxCentar.add(tabela);
			boxCentar.add(Box.createGlue());
		
			add(boxCentar, BorderLayout.NORTH);
			
		}
		public void updateViewPolozeni() {
			
			AbstractTableModelStudent modelPolozeni = (AbstractTableModelStudent) this.tabelaPolozeni.getModel();
			modelPolozeni.fireTableDataChanged();
			validate();
			//System.out.println("azuriro iz mejna studente ");	
		}
		
		
			
		
}
