package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private long generator;
	
	private List<Student> studenti_polozili;
	private List<Student> studenti_nisu_polozili;
	private List<Predmet> predmeti;
	private List<String> kolone;
	private Profesor profesor;

	private BazaPredmeta() {
		
		generator = 0;
		initPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("ID");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("SEMESTAR");
		this.kolone.add("GODINA IZVODJENJA");
		//this.kolone.add("PREDMETNI PROFESOR");
		this.kolone.add("BROJ ESPB BODOVA");
		//this.kolone.add("LISTA STUDENATA KOJI SU POLOZILI");
		//this.kolone.add("LISTA STUDENATA KOJI NISU POLOZILI");
		
	}

	private void initPredmeta() {
		this.studenti_polozili = new ArrayList<Student>();
		studenti_polozili.add(new Student("Pinjuh", "Filip", "101199", "Strz 25", "51235124", "email", "RA174", 2018, 3, Status.B, 7));
		studenti_polozili.add(new Student("Bane", "Carina", "101199", "Strz 25", "51235124", "email", "RA174", 2018, 3, Status.B, 7));
		
		this.studenti_nisu_polozili = new ArrayList<Student>();
		studenti_polozili.add(new Student("Mihajlo", "Kisic", "101199", "Strz 25", "51235124", "email", "RA174", 2018, 3, Status.B, 7));
		
		this.profesor = new Profesor("Mikic", "Mika", "10.11.1999.", "Strazilovska 26", 062345623, "pajta@gmail.com", 498293, "doktor", "prof", predmeti);
		
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet(generateId(), "OISISI", Semestar.ZIMSKI, 3, profesor, 8, studenti_polozili, studenti_nisu_polozili));
	
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
	
	private long generateId() {
		return ++generator;
	}

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
			return Long.toString(predmet.getId_predmeta());
		case 1:
			return predmet.getNaziv_predmeta();
		case 2:
			return (predmet.getSemestar()== Semestar.LETNJI) ? "LETNJI" : "ZIMSKI";
		case 3:
			return Integer.toString(predmet.getGodina_izvodjenja());
		case 4:
			return predmet.getPredmetni_profesor().getPrezime();
		case 5:
			return Integer.toString(predmet.getBroj_espb_bodova());
		case 6:
			return null; //predmet.getLista_polozili
		case 7:
			return null; //predmet.getLista_nisu_polozili
		default:
			return null;
		}
	}
	
	public void dodajPredmet(long id_predmeta, String naziv_predmeta, Semestar semestar, Integer godina_izvodjenja,
			Profesor predmetni_profesor, Integer broj_espb_bodova, List<Student> list_polozili, List<Student> list_nisu_polozili ) {
		this.predmeti.add(new Predmet(id_predmeta, naziv_predmeta, semestar, godina_izvodjenja,
				predmetni_profesor, broj_espb_bodova,  list_polozili, list_nisu_polozili));
	}
	
}
