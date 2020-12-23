package model;

import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}


	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudenata() {
	
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("PREZIME");
		this.kolone.add("IME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA STANOVANJA");
		this.kolone.add("KONTAKT TELEFON");
		this.kolone.add("EMAIL ADRESA");
		this.kolone.add("BROJ INDEKSA");
		this.kolone.add("GODINA UPISA");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");

	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		/*
		Studenti.add(new Profesor("Mikic", "Mika", "10.11.1999.", "Strazilovska 26", 062345623, "email@gmail.com", 498293, "title", "doktor" ));
		Studenti.add(new Profesor("Zikic", "Zika", "23.04.1964.", ));
		Studenti.add(new Profesor("Peric", "Pera", "14.05.1958.", ));
		*/
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 11;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		
		switch (column) {
		case 0:
			//return Long.toString(student.getId());
		case 1:
			return student.getPrezime();
		case 2:
			return student.getIme();
		case 3:
			return student.getDatumRodjenja();
		case 4:
			return student.getAdresaStana();
		case 5:
			return student.getKontaktTel();
		case 6:
			return student.getBrIndeksa();
		case 7:
			return student.geteMail();
		case 8:
			return Integer.toString(student.getGodStudija());
		case 9:
			return Integer.toString(student.getGodUpisa());
		case 10:
			return (student.getStatusStudenta() == status.B) ? "B" : "S";
		case 11:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
		
	} 

	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, Integer godStudija, status statusStudenta,
			double prosecnaOcena) {
		this.studenti.add(new Student(prezime, ime, datumRodjenja, adresaStana, kontaktTel, eMail, brIndeksa, godUpisa, godStudija, statusStudenta,
				prosecnaOcena));
		
	}

	

}


