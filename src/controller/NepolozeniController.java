package controller;

import javax.swing.JOptionPane;

import dialog.UnosOceneDialog;
import model.BazaNepolozeniPredmeti;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import oisisi.MainFrame;
import oisisi.StudentJTable;
import oisisi.TabNepolozeniPredmeti;
import oisisi.TabPolozeniPredmeti;

/**
 * Kontroler za tabelu nepolozenih predmeta unutar studenta.
 * @author Filip
 *
 */
public class NepolozeniController {

private static NepolozeniController instance = null;
	
	/**
	 * Metoda koja vraca/pravi instancu klase kontrolera nepolozenih predmeta.
	 * @return instance
	 */
	public static NepolozeniController getInstance() {
		if(instance == null) {
			instance = new NepolozeniController();
		}
		return instance;
	}
	
	/**
	 * Prazan konstruktor.
	 */
	private NepolozeniController() {}
	
	/**
	 * Metoda koja inicaijalizuje tabelu nepolozenih predmeta tako sto uzima vrednosti iz liste unutar
	 * baze nepolozenih predmeta.
	 */
	public void initNepolozeni() {
		BazaNepolozeniPredmeti.getInstance().initNepolozeniPredmeti();
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
	}
	
	/**
	 * Metoda koja predstavlja polaganje predmeta jednog studenta,
	 *  prima ocenu, datum i indeks predmeta koji se polaze.
	 * @param o
	 * @param t
	 * @param id
	 */
	public void Polaganje(String o, String t, int id) {
		if (id < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali predmet.");
			return;
		}
		Predmet predmet = BazaNepolozeniPredmeti.getInstance().getRow(id);
		BazaStudenata.getInstance().PoloziIspit(predmet,o, t);
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
		MainFrame.getInstance().updateViewStudent();
		
	}
	/**
	 * Dodavanje studenta u listu(tabelu) nepolozenih predmeta kod studenta.
	 * @param id indeks predmeta (iz baze predmeta) koji se dodaje.
	 */
	public void dodajPredmet(int id) {
		Predmet predmet = BazaPredmeta.getInstance().getRow(id);
		int idS = StudentJTable.getInstance().getSelectedRow();
		BazaStudenata.getInstance().getRow(idS).addPredmet(predmet);
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		
	}
	
	/**
	 * Dodavanje predmeta u listu nepolozenih predmeta, bez indeksa, preko objekta iz modela.
	 * @param predmet objekat modela predmet
	 */
	public void dodajPredmetNoId(Predmet predmet) {
		int idS = StudentJTable.getInstance().getSelectedRow();
		BazaStudenata.getInstance().getRow(idS).addPredmet(predmet);
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
	}
	
	/**
	 * Uklanjanje predmeta iz liste(tabele) nepolozenih predmeta kod studenta.
	 * @param id indeks predmeta koji uklanjamo
	 */
	public void obrisiPredmet(int id) {
		if (id < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali predmet.");
			return;
		}
		Predmet predmet = BazaNepolozeniPredmeti.getInstance().getRow(id);
		BazaNepolozeniPredmeti.getInstance().izbrisiPredmet(predmet.getIdPredmeta());
		//azuriranje prikaza
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		
	}
}
