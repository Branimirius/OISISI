package model;

import java.util.List;

public class Profesor {

     private String prezime;
	 private String ime;
	 private String datum_rodjenja;
     private String adresa_stanovanja;
     private Integer kontakt_telefon;
     private String email_adresa;
     private Integer broj_licne_karte;
     private String titula;
     private String zvanje;
     private List<Predmet> lista_predmeta;
	
     
     public Profesor() {}

	public Profesor(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja,
			Integer kontakt_telefon, String email_adresa, Integer broj_licne_karte, String titula, String zvanje,
			List<Predmet> lista_predmeta) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa_stanovanja = adresa_stanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.email_adresa = email_adresa;
		this.broj_licne_karte = broj_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.lista_predmeta = lista_predmeta;
	}
     
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}
	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}
	public String getAdresa_stanovanja() {
		return adresa_stanovanja;
	}
	public void setAdresa_stanovanja(String adresa_stanovanja) {
		this.adresa_stanovanja = adresa_stanovanja;
	}
	public Integer getKontakt_telefon() {
		return kontakt_telefon;
	}
	public void setKontakt_telefon(Integer kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}
	public String getEmail_adresa() {
		return email_adresa;
	}
	public void setEmail_adresa(String email_adresa) {
		this.email_adresa = email_adresa;
	}
	public Integer getBroj_licne_karte() {
		return broj_licne_karte;
	}
	public void setBroj_licne_karte(Integer broj_licne_karte) {
		this.broj_licne_karte = broj_licne_karte;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public List<Predmet> getLista_predmeta() {
		return lista_predmeta;
	}
	public void setLista_predmeta(List<Predmet> lista_predmeta) {
		this.lista_predmeta = lista_predmeta;
	}

}
