package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Status;
import model.Student;
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
