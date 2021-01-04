package oisisi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaStudenata;

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
		
		public TabPolozeniPredmeti() {
		
		setLayout(new BorderLayout());	
			
		PolozeniJTable tabelaPolozeni = PolozeniJTable.getInstance();
		JScrollPane scrollPolozeni = new JScrollPane(tabelaPolozeni);
		add(scrollPolozeni, BorderLayout.CENTER);
		}
}
