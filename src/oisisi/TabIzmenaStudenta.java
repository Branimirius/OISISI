package oisisi;


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;




/**
 * JTabbedPane koji sadrzi sve potrebne tabove za izmenu studenta:
 * Tab polozneih predmeta i Tab nepolozenih predmeta 
 * Tab polozenih predmeta: dugmici za ponistavanje ocena i labela sa prosekom.
 * Tab nepolozenih predmeta: dugmici za polaganje, uklanjanje  i  dodavanje predmeta.
 * @author Branimir
 *
 */
public class TabIzmenaStudenta extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492311871537969696L;
	
	private static TabIzmenaStudenta instance = null;

	/**
	 * Metoda koja kreira i  vraca instancu tabbed pane-a za izmenu studenta.
	 * @param dim dimenzija tabbed pane a, zadaje se iz roditeljskog frejma.
	 * @return instance
	 */
	public static TabIzmenaStudenta getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabIzmenaStudenta(dim);
		}
		return instance;
	}
	
	//private TabPolozeniPredmeti polozeniPanel;
	
	/**
	 * Konstruktor za tabbed pane sa svim potrebnim tabovima za izmenu studenta
	 * @param dim dimenzija za tabbed pane, prosledjuje se iz roditeljskog frejma
	 */
	public TabIzmenaStudenta(Dimension dim) {
				
		
		JPanel infoPanel = TabInformacijeStudent.getInstance(dim);
		JPanel polozeniPanel = TabPolozeniPredmeti.getInstance();
		JPanel nepolozeniPanel = TabNepolozeniPredmeti.getInstance();
		add("Informacije", infoPanel);
		add("Polozeni Predmeti", polozeniPanel);
		add("Nepolozeni Predmeti", nepolozeniPanel);
		
		
	}
	
	
	
}
