package model;

import java.util.List;

enum Semestar{letnji, zimski};

public class Predmet {

	private long id_predmeta;
	private String naziv_predmeta;
	private Semestar semestar;
	private Integer godina_izvodjenja;
	private Profesor predmetni_profesor;
	private Integer broj_espb_bodova;
	private list<Student> lista_polozili;
	private list<Student> lista_nisu_polozili;
	
	public Predmet() {}
	
	public Predmet(long id_predmeta, String naziv_predmeta, Semestar semestar, Integer godina_izvodjenja,
			Profesor predmetni_profesor, Integer broj_espb_bodova, list<Student> lista_polozili,
			list<Student> lista_nisu_polozili) {
		super();
		this.id_predmeta = id_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_izvodjenja = godina_izvodjenja;
		this.predmetni_profesor = predmetni_profesor;
		this.broj_espb_bodova = broj_espb_bodova;
		this.lista_polozili = lista_polozili;
		this.lista_nisu_polozili = lista_nisu_polozili;
	}

	public long getId_predmeta() {
		return id_predmeta;
	}

	public void setId_predmeta(long id_predmeta) {
		this.id_predmeta = id_predmeta;
	}

	public String getNaziv_predmeta() {
		return naziv_predmeta;
	}

	public void setNaziv_predmeta(String naziv_predmeta) {
		this.naziv_predmeta = naziv_predmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public Integer getGodina_izvodjenja() {
		return godina_izvodjenja;
	}

	public void setGodina_izvodjenja(Integer godina_izvodjenja) {
		this.godina_izvodjenja = godina_izvodjenja;
	}

	public Profesor getPredmetni_profesor() {
		return predmetni_profesor;
	}

	public void setPredmetni_profesor(Profesor predmetni_profesor) {
		this.predmetni_profesor = predmetni_profesor;
	}

	public Integer getBroj_espb_bodova() {
		return broj_espb_bodova;
	}

	public void setBroj_espb_bodova(Integer broj_espb_bodova) {
		this.broj_espb_bodova = broj_espb_bodova;
	}

	public list<Student> getLista_polozili() {
		return lista_polozili;
	}

	public void setLista_polozili(list<Student> lista_polozili) {
		this.lista_polozili = lista_polozili;
	}

	public list<Student> getLista_nisu_polozili() {
		return lista_nisu_polozili;
	}

	public void setLista_nisu_polozili(list<Student> lista_nisu_polozili) {
		this.lista_nisu_polozili = lista_nisu_polozili; 
	}
	
}
