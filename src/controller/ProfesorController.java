package controller;

import java.util.List;

import model.BazaProfesora;
import model.Predmet;
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
			Integer kontakt_telefon, String email_adresa, Integer broj_licne_karte, 
			Titula titula, Zvanje zvanje, List<Predmet> lista_predmeta ) {
		//izmena modela
		BazaProfesora.getInstance().dodajProfesora(prezime, ime, datum_rodjenja, adresa_stanovanja, 
				kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta);				
		//azuriranje prikaza
		MainFrame.getInstance().updateViewProfesor();
	    
	}
}