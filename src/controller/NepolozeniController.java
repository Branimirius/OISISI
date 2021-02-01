package controller;

import javax.swing.JOptionPane;


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
	 * Metoda koja pravi i vraca instancu klase kontrolera nepolozenih predmeta.
	 * @return instance instanca ove klase
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
	 * Metoda koja inicijalizuje tabelu nepolozenih predmeta pomocu podataka iz BazaNepolozeniPredmeti,
	 * i nakon inicijalizacije azurira izgled te tabele koja se nalazi na Tab-u nepolozenih predmeta
	 */
	public void initNepolozeni() {
		BazaNepolozeniPredmeti.getInstance().initNepolozeniPredmeti();
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
	}
	
	/**
	 * Metoda koja predstavlja polaganje predmeta jednog studenta.
	 *  Nalazi izabranog studenta, dodaje ocenu u listupolozeni u studentu,
	 *  brise ispit iz liste nepolozenih . i na kraju azurira tabele (Nepolozeni, Polozeni, Student)
	 * @param o ocena na ispitu, u string formatu
	 * @param t datum polaganja ispita, u string formatu
	 * @param id index predmeta
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
	 * Dodavanje predmeta u listu nepolozenih predmeta studentu.
	 * preko "id" nalazimo izabran predmet i dodajemo ga studentu,
	 * koristimo lokalnu promenjivu "idS" da saznamo kom studentu dodajemo predmet
	 * @param id indeks izabranog reda iz tabele predmeta
	 */
	public void dodajPredmet(int id) {
		Predmet predmet = BazaPredmeta.getInstance().getRow(id);
		int idS = StudentJTable.getInstance().getSelectedRow();
		BazaStudenata.getInstance().getRow(idS).addPredmet(predmet);
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		
	}
	
	/**
	 * Dodavanje predmeta u listu nepolozenih predmeta studentu,
	 * bez koriscenja id-a, vec preko objekta iz modela.
	 * @param predmet objekat modela predmet
	 */
	public void dodajPredmetNoId(Predmet predmet) {
		int idS = StudentJTable.getInstance().getSelectedRow();
		BazaStudenata.getInstance().getRow(idS).addPredmet(predmet);
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
	}
	
	/**
	 * Uklanjanje nepolozenog predmeta iz liste nepolozenih predmeta kod studenta.
	 * Ova metoda ne pravi polozeni predmet, samo brise ne polozeni. 
	 * @param id indeks reda u tabli na kom se nalazi predmeta koji uklanjamo
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
