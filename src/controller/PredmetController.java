package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Status;
import model.Student;
import oisisi.MainFrame;

public class PredmetController {
	
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if(instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void dodajPredmet(long idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
			Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili,
			List<Student> listNisuPolozili) {
		//izmena modela
		BazaPredmeta.getInstance().dodajPredmet(idPredmeta, nazivPredmeta, semestar, godinaIzvodjenja, 
				predmetniProfesor, brojEspbBodova, listPolozili, listNisuPolozili);				
		//azuriranje prikaza
		MainFrame.getInstance().updateViewPredmet();
	    
	}
	
	public void izmeniPredmet(int rowSelectedIndex, String nazivPredmeta, Integer brojEspbBodova, Semestar semestar, Integer godinaIzvodjenja) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali predmet.");
			return;
		}
		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izmeniPredmet(predmet.getIdPredmeta(), nazivPredmeta, brojEspbBodova, semestar, godinaIzvodjenja);
		//azuriranje prikaza
		MainFrame.getInstance().updateViewPredmet();
		JOptionPane.showMessageDialog(null, ("Izmena je izvrsena"));
	}
	
	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			JOptionPane.showMessageDialog(null, "Niste izabrali studenta.");
			return;
		}
		Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		BazaPredmeta.getInstance().izbrisiPredmet(predmet.getIdPredmeta());
		//azuriranje prikaza
		MainFrame.getInstance().updateViewPredmet();
		
	}
	
}
