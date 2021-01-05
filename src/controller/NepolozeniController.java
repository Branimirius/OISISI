package controller;

import model.BazaNepolozeniPredmeti;
import oisisi.TabNepolozeniPredmeti;

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
}
