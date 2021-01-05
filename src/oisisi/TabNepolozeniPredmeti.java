package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TabNepolozeniPredmeti extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static TabNepolozeniPredmeti instance = null;

	public static TabNepolozeniPredmeti getInstance() {
		if (instance == null) {
			instance = new TabNepolozeniPredmeti();
		}
		return instance;
	}
	
	JPanel nepolozeniPanel = new JPanel();
	NepolozeniJTable tabelaNepolozeni = NepolozeniJTable.getInstance();
	JScrollPane scrollNepolozeni = new JScrollPane(tabelaNepolozeni);
	
	public TabNepolozeniPredmeti() {		
		setLayout(new BorderLayout());
		
		JPanel buttonsPanel = new JPanel();
		JPanel buttonsPanelLeft = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		
		JButton dodaj = new JButton("Dodaj");
		dodaj.setBackground(Color.CYAN);
		
		JButton obrisi = new JButton("Obrisi");
		obrisi.setBackground(Color.CYAN);
		
		JButton polaganje = new JButton("Polaganje");
		polaganje.setBackground(Color.MAGENTA);
		
		buttonsPanelLeft.add(dodaj);
		buttonsPanelLeft.add(obrisi);
		buttonsPanelLeft.add(polaganje);
		
		buttonsPanel.add(buttonsPanelLeft, BorderLayout.WEST);
		
		nepolozeniPanel.setLayout(new BorderLayout());
		nepolozeniPanel.add(scrollNepolozeni, BorderLayout.CENTER);
		
		add(buttonsPanel, BorderLayout.NORTH);
		add(nepolozeniPanel, BorderLayout.SOUTH);
		
		updateViewNepolozeni();
	}
	
	public void updateViewNepolozeni() {
		
		AbstractTableModelNepolozeni modelNepolozeni = (AbstractTableModelNepolozeni) tabelaNepolozeni.getModel();
		modelNepolozeni.fireTableDataChanged();
		validate();
	}
	
}
