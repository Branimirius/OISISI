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
	 * Metoda koja pravi i vraca instancu klase kontrolera profesora.
	 * @return instance instanca ove klase
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
	 * potrebna za konstrukciju profesora i dodavanje istog u listu profesora unutar klase BazaProfesora.
	 * @param prezime prezime u stringu
	 * @param ime ime u stringu
	 * @param datum_rodjenja daturm rodjenja u date-u
	 * @param adresa_stanovanja adresa u stringu
	 * @param kontakt_telefon broj telefona u stringu
	 * @param email_adresa email adresa u stringu
	 * @param broj_licne_karte broj licne karte u stringu - koristi se kao indentifikator za profesora
	 * @param titula vrednost iz enuma Titula
	 * @param zvanje vrednost iz enuma Zvanje
	 * @param lista_predmeta lista Predmeta na kojima Profesor predaje
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
	 * Metoda koja vrsi izmenu pofesora iz BazaProfesora tako sto azurira informacije parametrima koje prima. 
	 * Ukoliko nije selektovan nijedan profesor iz tabele, iskocice dijalog upozorenja i nece biti omogucena izmena.
	 * @param prof Profesor koga izmenjujemo
	 * @param prezime prezime u stringu
	 * @param ime ime u stringu
	 * @param datum_rodjenja daturm rodjenja u date-u
	 * @param adresa_stanovanja adresa u stringu
	 * @param kontakt_telefon broj telefona u stringu
	 * @param email_adresa email adresa u stringu
	 * @param broj_licne_karte broj licne karte u stringu - koristi se kao indentifikator za profesora
	 * @param titula vrednost iz enuma Titula
	 * @param zvanje vrednost iz enuma Zvanje
	 * @param lista_predmeta Predmeta na kojima Profesor predaje
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
	 * Metoda koja uklanja selektovanog profesora iz tabele profesora. 
	 * Ako nije selektovan profesor, iskocice dijalog upozorenja i izmena nece biti omogucena.
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