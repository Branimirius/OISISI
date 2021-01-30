package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Klasa koja reprezentuje model ocene.
 * Polja: student i predmet na koje se ocena odnosi, vrednost ocene i datum upisa ocene.
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
	 * @param student
	 * @param predmet
	 * @param ocena
	 * @param datum
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
