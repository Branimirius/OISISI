package controller;

import model.BazaStudenata;
import model.Status;
import oisisi.MainFrame;




public class StudentController {
private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta,
			double prosecnaOcena) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(prezime, ime, datumRodjenja, adresaStana, kontaktTel, eMail, brIndeksa,
				godUpisa, godStudija, statusStudenta, prosecnaOcena);
		// azuriranje prikaza		
		MainFrame.getInstance().updateViewStudent();
	}
	
}
