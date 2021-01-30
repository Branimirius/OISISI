package controller;

import javax.swing.JOptionPane;

import model.BazaNepolozeniPredmeti;
import model.BazaOcena;
import model.Ocena;
import model.Predmet;
import oisisi.TabNepolozeniPredmeti;
import oisisi.TabPolozeniPredmeti;

/**
 * Kontroler za tabelu polozenih predmeta unutar studenta.
 * @author Branimir
 *
 */
public class OceneController {

private static OceneController instance = null;
	
	/**
	 * Metoda koja vraca/pravi instancu klase kontrolera polozenih predmeta.
	 * @return instance
	 */
	public static OceneController getInstance() {
		if(instance == null) {
			instance = new OceneController();
		}
		return instance;
	}
	
	private OceneController() {}
	
	/**
	 * Metoda za inicijalizaciju tabele polozenih predmeta kod studenta.
	 * Poziva listu iz baze ocena i azurira tabelu.
	 */
	public void initOcene() {
		BazaOcena.getInstance().initOcena();
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
	}
	/**
	 * Metoda koja ponistava ocenu, brise je iz tabele polozenih kod studenta.
	 * @param id indeks ocene, iz liste ocena, koju ponistavamo
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
