package controller;

import java.util.List;

import model.BazaPredmeta;
import model.Profesor;
import model.Semestar;
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
}
