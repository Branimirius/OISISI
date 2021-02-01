package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Model predmeta koji se koristi kao predstava polozenog predmeta u nasoj studentskoj sluzbi.
 * Ovaj model poseduje sva polja koja su potrebna da definisemo jedan polozeni predmet odnosno ocenu
 * @author Branimir
 *
 */
public class Ocena {
	
	private Student student;
	private Predmet predmet;
	private int ocena;
	private Date datum;
	
	/**
	 * Konstruktor ocene, kao parametre prima sva potrebna polja.
	 * @param student Student koji je polozio predmet
	 * @param predmet Predmet koji je polozen
	 * @param ocena tipa  Int (od 5 - 10) koju je Student ostvari na Predmetu
	 * @param datum tipa Date kog datuma je Student polozio Predmet
	 */
	public Ocena(Student student, Predmet predmet, int ocena, String datum) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datum = stringToDate(datum);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = stringToDate(datum);
	}
	
	/**
	 * Metoda koja pretvara tip datuma iz String u Date, koristi se da bi cuvali datum u obliku Date.
	 * @param datum String
	 * @return datum Date
	 */
	public Date stringToDate(String datum) {
		Date ret = new Date();
		try {
			ret = new SimpleDateFormat("dd/MM/yyyy").parse(datum);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
		
	}
	
	
}
