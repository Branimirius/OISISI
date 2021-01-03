package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.Titula;
import model.Zvanje;
import oisisi.MainFrame;

public class ProfesorController {

	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if(instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void dodajProfesora(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, 
			String kontakt_telefon, String email_adresa, String broj_licne_karte, 
			Titula titula, Zvanje zvanje, List<Predmet> lista_predmeta ) {
		//izmena modela
		BazaProfesora.getInstance().dodajProfesora(prezime, ime, datum_rodjenja, adresa_stanovanja, 
				kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta);				
		//azuriranje prikaza
		MainFrame.getInstance().updateViewProfesor();
	    
	}
	
	public void izmeniProfesora(int rowSelectedIndex, String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, 
			String kontakt_telefon, String email_adresa, String broj_licne_karte, 
			Titula titula, Zvanje zvanje, List<Predmet> lista_predmeta) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali profesora.");
			return;
		}
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izmeniProfesora(profesor.getBrLicneKarte(), prezime, ime, datum_rodjenja, adresa_stanovanja, 
				kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta);
		//azuriranje prikaza
		MainFrame.getInstance().updateViewProfesor();
		JOptionPane.showMessageDialog(null, ("Izmena je izvrsena"));
	}
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