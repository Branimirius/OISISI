package controller;



import javax.swing.JOptionPane;

import model.BazaStudenata;

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
	 * Metoda koja pravi i vraca instancu klase kontrolera studenata.
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
	 * potrebna za konstruktor studenta i dodavanje u listu unutar klase BazaStudenata.
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
	 * Metoda koja vrsi izmenu studenta iz BazaStudenata tako sto azurira informacije parametrima koje prima. 
	 * Ukoliko nije selektovan nijedan student iz tabele, iskocice dijalog upozorenja i nece biti omogucena izmena.
	 * @param rowSelectedIndex indeks selektovanog studenta
	 * @param prezime prezime u stringu
	 * @param ime ime u stringu
	 * @param datumRodjenja datum rodjenja u date-u
	 * @param adresaStana adresa stanovanja u stringu
	 * @param kontaktTel broj telfona u stringu 
	 * @param eMail email adresa u stringu 
	 * @param brIndeksa broj Indexa studenta u stringu - koristi se kao indentifikator za Studente
	 * @param godUpisa godina upisa 
	 * @param godStudija godina studija(od 1 do 4)
	 * @param statusStudenta vrednost iz enuma Status
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
	 * Metoda koja uklanja selektovanog studenta iz tabele studenata. 
	 * Ako nije selektovan student, iskocice dijalog upozorenja i izmena nece biti omogucena.
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
