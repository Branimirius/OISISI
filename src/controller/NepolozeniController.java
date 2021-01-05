package controller;

import javax.swing.JOptionPane;

import model.BazaNepolozeniPredmeti;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import oisisi.MainFrame;
import oisisi.StudentJTable;
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
	public void dodajPredmet(int id) {
		Predmet predmet = BazaPredmeta.getInstance().getRow(id);
		int idS = StudentJTable.getInstance().getSelectedRow();
		BazaStudenata.getInstance().getRow(idS).addPredmet(predmet);
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		
	}
	public void obrisiPredmet(int id) {
		if (id < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali studenta.");
			return;
		}
		Predmet predmet = BazaNepolozeniPredmeti.getInstance().getRow(id);
		BazaNepolozeniPredmeti.getInstance().izbrisiPredmet(predmet.getIdPredmeta());
		//azuriranje prikaza
		TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
		
	}
}
