package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


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
		
		List<Ocena> polozeni1 = new ArrayList<Ocena>();	
		List<Ocena> polozeni2 = new ArrayList<Ocena>();
		
		List<Predmet> nepolozeni1 = new ArrayList<Predmet>();
		List<Predmet> nepolozeni2 = new ArrayList<Predmet>();
				
		this.studenti = new ArrayList<Student>();
		Predmet p1 = BazaPredmeta.getInstance().getRow(1);
		Predmet p2 = BazaPredmeta.getInstance().getRow(2);
		Predmet p3 = BazaPredmeta.getInstance().getRow(3);
		
		nepolozeni1.add(p3);
		
		nepolozeni2.add(p1);
		nepolozeni2.add(p2);
		
		Student s1 = new Student("RkeKoke", "Marko ", "Markovic", "4567", Status.B,
				9.78, "0642345678", 1678,"12/3/1998" , "Neki Bulevar 14",
				"markomarkovic@", polozeni1, nepolozeni1);
		s1.addOcena(p1, 8, "12/12/2001");
		s1.addOcena(p2, 9, "31/1/2012");
		
		Student s2 = new Student("RA-178/2018", "Ivan", "Ivanovic", "4567",Status.S ,
				8.78, "067788666",  342, "14/5/2000", "Ulica neka 17",
				"eMail", polozeni2, nepolozeni2);
		s2.addOcena(p3, 6, "31/2/2009");
		s2.addOcena(p3, 10, "3/10/1999");
		
		studenti.add(s1);
		studenti.add(s2);
		
		
		/*studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", "4567",Status.S ,
				8.78, "067788666",  342, "14/5/2000", "Ulica neka 17",
				"eMail", polozeni, nepolozeni ));
		studenti.add(new Student("brIndeksa", "Marko ", "Markovic", "4567", Status.B,
				9.78, "0642345678", 1678,"12/3/1998" , "Neki Bulevar 14",
				"markomarkovic@", polozeni, nepolozeni));
		studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", "4567",Status.S ,
				8.78, "067788666",  342, "14/5/2000", "Ulica neka 17",
				"eMail", polozeni, nepolozeni ));
		studenti.add(new Student("brIndeksa", "Marko ", "Markovic", "4567", Status.B,
				9.78, "0642345678", 1678,"12/3/1998" , "Neki Bulevar 14",
				"markomarkovic@", polozeni, nepolozeni));
		studenti.add(new Student("brIndeksa", "Ivan", "Ivanovic", "4567",Status.S ,
				8.78, "067788666",  342, "14/5/2000", "Ulica neka 17",
				"eMail", polozeni, nepolozeni )); */
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
			return student.getGodStudija();
		case 4:
			return (student.getStatusStudenta() == Status.B) ? "B" : "S";
		case 5:
			return Double.toString(student.getProsecnaOcena());
		case 6:
			return student.getKontaktTel();
		case 7:
			return Integer.toString(student.getGodUpisa());
		case 8:
			return dateToString(student.getDatumRodjenja());
		case 9:
			return student.getAdresaStana();
		case 10:
			return student.geteMail();
		
			
		default:
			return null;
		}
		
	} 

	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta,
			double prosecnaOcena, List<Ocena> polozeni, List<Predmet> nepolozeni) {
		this.studenti.add(new Student(brIndeksa, ime, prezime, godStudija, statusStudenta, prosecnaOcena, kontaktTel, godUpisa, datumRodjenja, adresaStana,
				eMail, polozeni, nepolozeni));		
		
	}
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	
	public void izmeniStudenta(String ID, String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta) {
		for (Student s : studenti) {
			if (s.getBrIndeksa() == ID) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStana(adresaStana);
				s.setKontaktTel(kontaktTel);
				s.seteMail(eMail);
				s.setBrIndeksa(brIndeksa);
				s.setGodUpisa(godUpisa);
				s.setGodStudija(godStudija);
				s.setStatusStudenta(statusStudenta);
			}
		}
	}
	public void izbrisiStudenta(String ID) {
		for (Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				studenti.remove(s);
				break;
			}
		}
	}
	public boolean indexPostoji(String ID){
		for(Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				System.out.println(s.getBrIndeksa());
				return true;
				
			}							
		}
		return false;
			
	}
	
	

}


