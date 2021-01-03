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
	private List<Ocena> polozeni;
	private Profesor profesor;

	private BazaPredmeta() {
		
		generator = 0;
		initPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR");

		//this.kolone.add("PREDMETNI PROFESOR");
		//this.kolone.add("LISTA STUDENATA KOJI SU POLOZILI");
		//this.kolone.add("LISTA STUDENATA KOJI NISU POLOZILI");
		
	}

	private void initPredmeta() {
		this.studenti_polozili = new ArrayList<Student>();
		studenti_polozili.add(new Student("RA174", "Filip", "Pinjuh", "3", Status.B, 7, "51235124", 2018, "10/11/99", "Strz 25", "email", polozeni, predmeti));
		studenti_polozili.add(new Student("RA174", "Bane", "Carina", "3", Status.B, 7, "51235124", 2018,"10/11/99", "Strz 25", "email", polozeni, predmeti));
		
		this.studenti_nisu_polozili = new ArrayList<Student>();
		studenti_polozili.add(new Student("RA174", "Mihajlo", "Kisic", "3", Status.B, 7, "51235124", 2018, "10/11/99", "Strz 25", "email", polozeni, predmeti));
		
		this.profesor = new Profesor("Mikic", "Mika", "10/11/1999.", "Strazilovska 26", "062345623", "pajta@gmail.com", "498293", Titula.MR, Zvanje.REDOVNI_PROFESOR, predmeti);
		
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet(generateId(), "OISISI", Semestar.ZIMSKI, 3, profesor, 8, studenti_polozili, studenti_nisu_polozili));
		predmeti.add(new Predmet(generateId(), "PROGRAMSKI PREVODIOCI", Semestar.ZIMSKI, 3, profesor, 8, studenti_polozili, studenti_nisu_polozili));
		predmeti.add(new Predmet(generateId(), "METODE OPTIMIZACIJE", Semestar.ZIMSKI, 3, profesor, 8, studenti_polozili, studenti_nisu_polozili));
		predmeti.add(new Predmet(generateId(), "NANS", Semestar.ZIMSKI, 3, profesor, 8, studenti_polozili, studenti_nisu_polozili));
		predmeti.add(new Predmet(generateId(), "BAZE PODATAKA", Semestar.ZIMSKI, 3, profesor, 8, studenti_polozili, studenti_nisu_polozili));
	
		this.polozeni = new ArrayList<Ocena>();
		
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
	
	public long generateId() {
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
			return Long.toString(predmet.getIdPredmeta());
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
	
	public void dodajPredmet(long idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
			Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili, List<Student> listNisuPolozili ) {
		this.predmeti.add(new Predmet(idPredmeta, nazivPredmeta, semestar, godinaIzvodjenja,
				predmetniProfesor, brojEspbBodova,  listPolozili, listNisuPolozili));
	}
	public void izmeniPredmet(long idPredmeta, String nazivPredmeta, Integer brojEspbBodova, Semestar semestar, Integer godinaIzvodjenja ) {
		for(Predmet p : predmeti) {
			if(p.getIdPredmeta() == idPredmeta) {
				p.setNazivPredmeta(nazivPredmeta);
				p.setSemestar(semestar);
				p.setGodinaIzvodjenja(godinaIzvodjenja);
				p.setBrojEspbBodova(brojEspbBodova);
			}
		}
	}
	public void izbrisiPredmet(long ID) {
		for (Predmet p : predmeti) {
			if(p.getIdPredmeta() == ID) {
				predmeti.remove(p);
				break;
			}
		}
	}
}
