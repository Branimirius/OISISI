package controller;

import model.BazaOcena;
import oisisi.TabPolozeniPredmeti;

public class OceneController {

private static OceneController instance = null;
	
	public static OceneController getInstance() {
		if(instance == null) {
			instance = new OceneController();
		}
		return instance;
	}
	
	private OceneController() {}
	
	public void initOcene() {
		BazaOcena.getInstance().initOcena();
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
	}

}
