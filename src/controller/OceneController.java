package controller;

import javax.swing.JOptionPane;


import model.BazaOcena;
import model.Ocena;
import model.Predmet;

import oisisi.TabPolozeniPredmeti;

/**
 * Kontroler za tabelu polozenih predmeta unutar studenta.
 * @author Branimir
 *
 */
public class OceneController {

private static OceneController instance = null;
	
	/**
	 * Metoda koja pravi i vraca instancu klase kontrolera polozenih predmeta.
	 * @return instance instanca ove klase
	 */
	public static OceneController getInstance() {
		if(instance == null) {
			instance = new OceneController();
		}
		return instance;
	}
	
	/**
	 * Prazan konstruktor.
	 */
	private OceneController() {}
	
	/**
	 * Metoda koja inicijalizuje tabelu nepolozenih predmeta pomocu podataka iz BazaOcena,
	 * i nakon inicijalizacije azurira izgled te tabele koja se nalazi na Tab-u polozenih predmeta
	 */
	public void initOcene() {
		BazaOcena.getInstance().initOcena();
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
	}
	/**
	 * Metoda koja ponistava ocenu, tj. brise je iz tabele polozenih kod studenta.
	 * @param id indeks ocene, iz liste polozenih predmeta (ocena) koju brisemo.
	 */
	public void ponistiOcenu(int id) {
		if (id < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali predmet.");
			return;
		}
		Ocena ocena = BazaOcena.getInstance().getRow(id);
		Predmet predmet = ocena.getPredmet();
		
		NepolozeniController.getInstance().dodajPredmetNoId(predmet);
		BazaOcena.getInstance().izbrisiOcenu(ocena);
		//azuriranje prikaza
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
		
	}
}
