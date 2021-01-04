package oisisi;


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;




public class TabIzmenaStudenta extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492311871537969696L;
	
	private static TabIzmenaStudenta instance = null;

	public static TabIzmenaStudenta getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabIzmenaStudenta(dim);
		}
		return instance;
	}
	
	
	public TabIzmenaStudenta(Dimension dim) {
		
					 		 		 		
		JPanel infoPanel = TabInformacijeStudent.getInstance(dim);
		JPanel polozeniPanel = TabPolozeniPredmeti.getInstance();
		JPanel nepolozeniPanel = TabNepolozeniPredmeti.getInstance(dim);
		add("Informacije", infoPanel);
		add("Polozeni Predmeti", polozeniPanel);
		add("Nepolozeni Predmeti", nepolozeniPanel);
	}
	
	
}
