package oisisi;


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;




/**
 * Tabbed pane koji sadrzi tabove za izmenu studenta, ukljucuje: tab za informacije (osnovne informacije),
 * tab sa tabelom polozenih predmeta, tab sa tabelom nepolozenih premdeta. Kod tabele polozenih se nalaze dugmici za
 * ponistavanje ocene i labela sa prosekom. Kod tabele nepolozenih se nalaze dugmici za polaganje, uklanjanje i dodavanje predmeta.
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
	 * Metoda koja vraca/pravi instancu tabbed pane a za izmenu studenta.
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
	 * Konstruktor za tabbed pane za izmenu studenta, sadrzi: tab za informacije (osnovne informacije),
	 * tab sa tabelom polozenih predmeta, tab sa tabelom nepolozenih premdeta. Kod tabele polozenih se nalaze dugmici za
	 * ponistavanje ocene i labela sa prosekom. Kod tabele nepolozenih se nalaze dugmici za polaganje, uklanjanje i dodavanje predmeta. 
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
