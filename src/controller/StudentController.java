package controller;

import model.BazaStudenata;



public class StudentController {
private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void dodajStudenta() {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta("Neki", "Lik", "Ne znam", "nemam pojam", "nesto", "videcemo","broj indeksa",
				58, 5, null, 7.5);
		// azuriranje prikaza
		//MainFrame.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
}
