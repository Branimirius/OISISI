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
	 * Metoda koja vraca/pravi instancu klase kontrolera svih predmeta.
	 * @return instance
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
	 * potrebna za konstruktor predmeta i dodavanje u listu unutar baze predmeta.
	 * @param idPredmeta
	 * @param nazivPredmeta
	 * @param semestar
	 * @param godinaIzvodjenja
	 * @param predmetniProfesor
	 * @param brojEspbBodova
	 * @param listPolozili
	 * @param listNisuPolozili
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
	 * Metoda koja vrsi izmenu predmeta u bazi predmeta tako sto azurira informacije parametrima koje prima. Ukoliko nije selektovan
	 * nijedan predmet iz tabele, iskocice dijalog upozorenja i nece biti moguca izmena.
	 * @param rowSelectedIndex selektovani predmet
	 * @param nazivPredmeta
	 * @param brojEspbBodova
	 * @param semestar
	 * @param godinaIzvodjenja
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
	 * Metoda koja uklanja selektovani predmet iz tabele predmeta. Ako nije selektovan predmet,
	 *  iskocice dijalog upozorenja i izmena nece biti moguca.
	 * @param rowSelectedIndex selektovani predmet
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
