package model;

import java.util.ArrayList;
import java.util.List;

import oisisi.StudentJTable;

public class BazaNepolozeniPredmeti {
	
	private static BazaNepolozeniPredmeti instance = null;

	public static BazaNepolozeniPredmeti getInstance() {
		if (instance == null) {
			instance = new BazaNepolozeniPredmeti();
		}
		return instance;
	}
	
	
	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaNepolozeniPredmeti() {
		
		initNepolozeniPredmeti();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR");
	}
	
	public void initNepolozeniPredmeti() {
		int id = StudentJTable.getInstance().getSelectedRow();
		if(id < 0) {
			System.out.println("nije selektovan student");
			return;
		} 
		else {
		Student s = BazaStudenata.getInstance().getStudenti().get(id);
		predmeti = s.getNepolozeni();
		}
	}
	
	public void clearPredmeti() {
		predmeti.clear();
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> Predmeti) {
		this.predmeti = Predmeti;
	}

	public int getColumnCount() {
		return 5;
	}
	
	/*public long generateId() {
		return ++generator;
	}*/

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getIdPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojEspbBodova());
		case 3:
			return Integer.toString(predmet.getGodinaIzvodjenja());
		case 4:
			return (predmet.getSemestar()== Semestar.LETNJI) ? "LETNJI" : "ZIMSKI";
		case 5:
			return predmet.getPredmetniProfesor().getPrezime();
		case 6:
			return null; //predmet.getLista_polozili
		case 7:
			return null; //predmet.getLista_nisu_polozili
		default:
			return null;
		}
	}

}
