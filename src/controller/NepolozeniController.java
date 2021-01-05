package controller;

import model.BazaNepolozeniPredmeti;
import oisisi.TabNepolozeniPredmeti;
import oisisi.TabPolozeniPredmeti;

public class NepolozeniController {

private static NepolozeniController instance = null;
	
	public static NepolozeniController getInstance() {
		if(instance == null) {
			instance = new NepolozeniController();
		}
		return instance;
	}
	
	private NepolozeniController() {}
	
	public void initNepolozeni() {
		BazaNepolozeniPredmeti.getInstance().initNepolozeniPredmeti();
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
	}
	
	public void Polaganje() {
		BazaNepolozeniPredmeti.getInstance().NepolozeniUOcene();
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
		
	}
}
