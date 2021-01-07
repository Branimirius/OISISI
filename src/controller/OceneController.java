package controller;

import javax.swing.JOptionPane;

import model.BazaNepolozeniPredmeti;
import model.BazaOcena;
import model.Ocena;
import model.Predmet;
import oisisi.TabNepolozeniPredmeti;
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
	public void ponistiOcenu(int id) {
		if (id < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali predmet.");
			return;
		}
		Ocena ocena = BazaOcena.getInstance().getRow(id);
		Predmet predmet = ocena.getPredmet();
		
		NepolozeniController.getInstance().dodajPredmetNoId(predmet);
		BazaOcena.getInstance().izbrisiOcenu(ocena);
		//azuriranje prikaza
		TabPolozeniPredmeti.getInstance().updateViewPolozeni();
		
	}
}
