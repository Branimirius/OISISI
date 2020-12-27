package controller;

import model.BazaProfesora;

public class ProfesorController {

	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if(instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void dodajProfesora() {
		//izmena modela
		BazaProfesora.getInstance().dodajProfesora("Indjic", "Vladimir", "10.11.1980", "kralja petra 1 25", 63880548, "email_adresa", 333666, null, null, null);				
	    
	}
}