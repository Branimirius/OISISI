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
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		/*
	 	this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA STANOVANJA");
		this.kolone.add("KONTAKT TELEFON");
		this.kolone.add("EMAIL ADRESA");
		
		this.kolone.add("GODINA UPISA");
		*/
		
		
		

	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		
		studenti.add(new Student("brIndeksa", "Marko ", "Markovic", 4567, Status.B,
				9.78, "0642345678", 1678,"12.3.1998" , "Neki Bulevar 14",
				"markomarkovic@"));
		studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", 4567,Status.S ,
				8.78, "067788666",  342, "14.5.2000", "Ulica neka 17",
				"eMail" ));
		studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", 4567,Status.S ,
				8.78, "067788666",  342, "14.5.2000", "Ulica neka 17",
				"eMail" ));
		studenti.add(new Student("brIndeksa", "Marko ", "Markovic", 4567, Status.B,
				9.78, "0642345678", 1678,"12.3.1998" , "Neki Bulevar 14",
				"markomarkovic@"));
		studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", 4567,Status.S ,
				8.78, "067788666",  342, "14.5.2000", "Ulica neka 17",
				"eMail" ));
		studenti.add(new Student("brIndeksa", "Marko ", "Markovic", 4567, Status.B,
				9.78, "0642345678", 1678,"12.3.1998" , "Neki Bulevar 14",
				"markomarkovic@"));
		studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", 4567,Status.S ,
				8.78, "067788666",  342, "14.5.2000", "Ulica neka 17",
				"eMail" ));
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
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
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getGodStudija());
		case 4:
			return (student.getStatusStudenta() == Status.B) ? "B" : "S";
		case 5:
			return Double.toString(student.getProsecnaOcena());
		case 6:
			return student.getKontaktTel();
		case 7:
			return Integer.toString(student.getGodUpisa());
		case 8:
			return student.getDatumRodjenja();
		case 9:
			return student.getAdresaStana();
		case 10:
			return student.geteMail();
		
			
		default:
			return null;
		}
		
	} 

	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, Integer godStudija, Status statusStudenta,
			double prosecnaOcena) {
		this.studenti.add(new Student(brIndeksa, ime, prezime, godStudija, statusStudenta, prosecnaOcena, kontaktTel, godUpisa, datumRodjenja, adresaStana,
				eMail));
		
	}

	

}


