package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import oisisi.MainFrame;

/**
 * Kontroler tabele svih profesora.
 * Sadrzi metode za dodavanje, brisanje i izmenu profesora.
 * @author Filip
 *
 */

public class ProfesorController {

	private static ProfesorController instance = null;
	
	/**
	 * Metoda koja vraca/pravi instancu klase kontrolera svih profesora.
	 * @return instance
	 */
	public static ProfesorController getInstance() {
		if(instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	/**
	 * Metoda koja dodaje profesora u tabelu svih profesora, kao parametre prima polja iz modela profesora koja su 
	 * potrebna za konstruktor profesora i dodavanje u listu unutar baze profesora.
	 * @param prezime
	 * @param ime
	 * @param datum_rodjenja
	 * @param adresa_stanovanja
	 * @param kontakt_telefon
	 * @param email_adresa
	 * @param broj_licne_karte
	 * @param titula
	 * @param zvanje
	 * @param lista_predmeta
	 */
	public void dodajProfesora(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, 
			String kontakt_telefon, String email_adresa, String broj_licne_karte, 
			Titula titula, Zvanje zvanje, List<Predmet> lista_predmeta ) {
		//izmena modela
		BazaProfesora.getInstance().dodajProfesora(prezime, ime, datum_rodjenja, adresa_stanovanja, 
				kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta);				
		//azuriranje prikaza
		MainFrame.getInstance().updateViewProfesor();
	    
	}
	
	/**
	 * Metoda koja vrsi izmenu pofesora u bazi profesora tako sto azurira informacije parametrima koje prima. Ukoliko nije selektovan
	 * nijedan profesor iz tabele, iskocice dijalog upozorenja i nece biti moguca izmena.
	 * @param prof
	 * @param prezime
	 * @param ime
	 * @param datum_rodjenja
	 * @param adresa_stanovanja
	 * @param kontakt_telefon
	 * @param email_adresa
	 * @param broj_licne_karte
	 * @param titula
	 * @param zvanje
	 * @param lista_predmeta
	 */
	public void izmeniProfesora(Profesor prof, String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, 
			String kontakt_telefon, String email_adresa, String broj_licne_karte, 
			Titula titula, Zvanje zvanje, List<Predmet> lista_predmeta) {
		
		BazaProfesora.getInstance().izmeniProfesora(prof.getBrLicneKarte(), prezime, ime, datum_rodjenja, adresa_stanovanja, 
				kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta);
		//azuriranje prikaza
		MainFrame.getInstance().updateViewProfesor();
		JOptionPane.showMessageDialog(null, ("Izmena je izvrsena"));
	}
	/**
	 * Metoda koja uklanja selektovanog profesora iz tabele profesora. Ako nije selektovan profesor,
	 * iskocice dijalog upozorenja i izmena nece biti moguca.
	 * @param rowSelectedIndex indeks selektovanog profesora
	 */
	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali profesora.");
			return;
		}
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfesora(profesor.getBrLicneKarte());
		//azuriranje prikaza
		MainFrame.getInstance().updateViewProfesor();
		
	}
}