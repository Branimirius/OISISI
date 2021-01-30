package model;

import java.util.List;

//enum Semestar{ZIMSKI, LETNJI};

/**
 * Klasa koja predstavlja model predmeta.
 * @author Filip
 *
 */
public class Predmet {

	private String idPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private Integer godinaIzvodjenja;
	private Profesor predmetniProfesor;
	private Integer brojEspbBodova;
	private List<Student> listaPolozili;
	private List<Student> listaNisuPolozili;
	
	/**
	 * prazan konstruktor
	 */
	public Predmet() {}
	
	/**
	 * Konstruktor predmeta, prima parametre za svako polje.
	 * @param idPredmeta
	 * @param nazivPredmeta
	 * @param semestar
	 * @param godinaIzvodjenja
	 * @param predmetniProfesor
	 * @param brojEspbBodova
	 * @param listPolozili
	 * @param listNisuPolozili
	 */
	public Predmet(String idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
			Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili,
			List<Student> listNisuPolozili) {
		super();
		this.idPredmeta = idPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaIzvodjenja = godinaIzvodjenja;
		this.predmetniProfesor = predmetniProfesor;
		this.brojEspbBodova = brojEspbBodova;
		this.listaPolozili = listPolozili;
		this.listaNisuPolozili = listNisuPolozili;
	}

	public String getIdPredmeta() {
		return idPredmeta;
	}

	public void setIdPredmeta(String idPredmeta) {
		this.idPredmeta = idPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public Integer getGodinaIzvodjenja() {
		return godinaIzvodjenja;
	}

	public void setGodinaIzvodjenja(Integer godinaIzvodjenja) {
		this.godinaIzvodjenja = godinaIzvodjenja;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public Integer getBrojEspbBodova() {
		return brojEspbBodova;
	}

	public void setBrojEspbBodova(Integer brojEspbEodova) {
		this.brojEspbBodova = brojEspbEodova;
	}

	public List<Student> getListPolozili() {
		return listaPolozili;
	}

	public void setListPolozili(List<Student> listPolozili) {
		this.listaPolozili = listPolozili;
	}

	public List<Student> getListNisuPolozili() {
		return listaNisuPolozili;
	}

	public void setListNisuPolozili(List<Student> listNisuPolozili) {
		this.listaNisuPolozili = listNisuPolozili; 
	}
	
}
