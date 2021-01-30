package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Status;
import model.Student;
import oisisi.MainFrame;


/**
 * Kontroler tabele svih studenata.
 * Sadrzi metode za dodavanje, brisanje i izmenu studenata.
 * @author Branimir
 *
 */

public class StudentController {
private static StudentController instance = null;
	
	/**
	 * Metoda koja vraca/pravi instancu klase kontrolera svih studenata.
	 * @return instance
	 */
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	/**
	 * Metoda koja dodaje studenta u tabelu svih studenata, kao parametre prima polja iz modela studenta koja su 
	 * potrebna za konstruktor studenta i dodavanje u listu unutar baze studenata.
	 * @param prezime
	 * @param ime
	 * @param datumRodjenja
	 * @param adresaStana
	 * @param kontaktTel
	 * @param eMail
	 * @param brIndeksa
	 * @param godUpisa
	 * @param godStudija
	 * @param statusStudenta
	 * @param prosecnaOcena
	 */
	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta,
			double prosecnaOcena) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(prezime, ime, datumRodjenja, adresaStana, kontaktTel, eMail, brIndeksa,
				godUpisa, godStudija, statusStudenta, prosecnaOcena);
		// azuriranje prikaza		
		MainFrame.getInstance().updateViewStudent();
	}
	
	/**
	 * Metoda koja vrsi izmenu studenta u bazi studenata tako sto azurira informacije parametrima koje prima. Ukoliko nije selektovan
	 * nijedan student iz tabele, iskocice dijalog upozorenja i nece biti moguca izmena.
	 * @param rowSelectedIndex indeks selektovanog studenta
	 * @param prezime
	 * @param ime
	 * @param datumRodjenja
	 * @param adresaStana
	 * @param kontaktTel
	 * @param eMail
	 * @param brIndeksa
	 * @param godUpisa
	 * @param godStudija
	 * @param statusStudenta
	 */
	public void izmeniStudenta(int rowSelectedIndex, String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali studenta.");
			return;
		}
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izmeniStudenta(student.getBrIndeksa(), prezime, ime, datumRodjenja, adresaStana, kontaktTel, eMail, brIndeksa, godUpisa, godStudija, statusStudenta);
		//azuriranje prikaza
		MainFrame.getInstance().updateViewStudent();
		JOptionPane.showMessageDialog(null, ("Izmena je izvrsena"));
	}
	
	/**
	 * Metoda koja uklanja selektovanog studenta iz tabele studenata. Ako nije selektovan student,
	 * iskocice dijalog upozorenja i izmena nece biti moguca.
	 * @param rowSelectedIndex indeks selektovanog studenta
	 */
	public void izbrisiStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali studenta.");
			return;
		}
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izbrisiStudenta(student.getBrIndeksa());
		//azuriranje prikaza
		MainFrame.getInstance().updateViewStudent();
		
	}
	
}
