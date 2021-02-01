package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import oisisi.MainFrame;

/**
 * Kontroler tabele svih predmeta.
 * Sadrzi metode za dodavanje, brisanje i izmenu predmeta.
 * @author Filip
 *
 */
public class PredmetController {
	
private static PredmetController instance = null;
	
	/**
	 * /**
	 * Metoda koja pravi i vraca instancu klase kontrolera predmeta.
	 * @return instance instanca ove klase
	 */
	 
	public static PredmetController getInstance() {
		if(instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	/**
	 * Metoda koja dodaje predmet u tabelu svih predmeta, kao parametre prima polja iz modela predmeta koja su 
	 * potrebna za konstruktor predmeta i dodavanje u listu unutar klase BazaPredmeta.
	 * @param idPredmeta indentifikacioni broj predmeta u stringu 
	 * @param nazivPredmeta naziv predmeta u stringu 
	 * @param semestar semestar  odrzavanja predmeta
	 * @param godinaIzvodjenja godina na kojoj se premdet izvodi 
	 * @param predmetniProfesor ko je predmetni profesor (tipa  Profesor)
	 * @param brojEspbBodova broj ESPB bodova (tipa int)
	 * @param listPolozili lista studenata koji su polozili ovaj predmet
	 * @param listNisuPolozili lista studenata koji nisu polozili ovaj predmet
	 */
	public void dodajPredmet(String idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
			Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili,
			List<Student> listNisuPolozili) {
		//izmena modela
		BazaPredmeta.getInstance().dodajPredmet(idPredmeta, nazivPredmeta, semestar, godinaIzvodjenja, 
				predmetniProfesor, brojEspbBodova, listPolozili, listNisuPolozili);				
		//azuriranje prikaza
		MainFrame.getInstance().updateViewPredmet();
	    
	}
	
	/**
	 * Metoda koja vrsi izmenu predmeta iz klase BazaPredmeta  tako sto azurira informacije parametrima koje prima. 
	 * Ukoliko nije selektovan nijedan predmet iz tabele, iskocice dijalog upozorenja i nece biti omogucena izmena.
	 * @param rowSelectedIndex selektovani predmet
	 * @param nazivPredmeta naziv predmeta u stringu 
	 * @param brojEspbBodova broj ESPB bodova (tipa int)
	 * @param semestar semestar  odrzavanja predmeta
	 * @param godinaIzvodjenja godina na kojoj se premdet izvodi 
	 */
	public void izmeniPredmet(int rowSelectedIndex, String nazivPredmeta, Integer brojEspbBodova, Semestar semestar, Integer godinaIzvodjenja) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali predmet.");
			return;
		}
		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izmeniPredmet(predmet.getIdPredmeta(), nazivPredmeta, brojEspbBodova, semestar, godinaIzvodjenja);
		//azuriranje prikaza
		MainFrame.getInstance().updateViewPredmet();
		JOptionPane.showMessageDialog(null, ("Izmena je izvrsena"));
	}
	
	/**
	 * Metoda koja uklanja selektovani predmet iz tabele predmeta. 
	 * Ako nije selektovan predmet, iskocice dijalog upozorenja i izmena nece biti moguca.
	 * @param rowSelectedIndex indeks selektovanog predmeta
	 */
	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali studenta.");
			return;
		}
		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getIdPredmeta());
		//azuriranje prikaza
		MainFrame.getInstance().updateViewPredmet();
		
	}
	
}
