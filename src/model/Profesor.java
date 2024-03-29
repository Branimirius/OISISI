package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Titula;
import model.Zvanje;

/**
 * Model profesora koji se koristi kao predstava profesora u nasoj studenskoj sluzbi.
 * Ovaj model poseduje sva polja koja su potrebna da definisemo jednog profesora.
 * @author Filip
 *
 */
public class Profesor {

	private String datumRodjString;
     private String prezime;
	 private String ime;
	 private Date datumRodjenja;
     private String adresaStanovanja;
     private String kontaktTelefon;
     private String emailAdresa;
     private String brLicneKarte;
     private Titula titula;
     private  Zvanje zvanje;
     private List<Predmet> listaPredmeta;
	
     
     /**
     * Prazan konstruktor
     */
    public Profesor() {}

	/**
	 * Konstruktor sa parametrima za objekat profesora. Sva potrebna polja dobija kroz parametre
	 * @param prezime tipa String
	 * @param ime tipa String
	 * @param datumRodjenja tipa Date, koristi se metoda StringToDate da prebaci String vrednost i u modelu je sacuva kao Date
	 * @param adresaStanovanja tipa String
	 * @param kontaktTelefon tipa String
	 * @param emailAdresa tipa String
	 * @param brLicneKarte indetifikator za profesore, tipa String
	 * @param titula enum Titula
	 * @param zvanje enum Zvanje
	 * @param listaPredmeta lista Predmeta na kojima Profesor predaje
	 */
	public Profesor(String prezime, String ime, String datumRodjenja, String adresaStanovanja,
			String kontaktTelefon, String emailAdresa, String brLicneKarte, Titula titula, Zvanje zvanje,
			List<Predmet> listaPredmeta) {
		super();
		this.setDatumRodjString(datumRodjenja);
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = stringToDate(datumRodjenja);
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.listaPredmeta = listaPredmeta;
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
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = stringToDate(datumRodjenja);
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getKontaktTelefon() {
		return kontaktTelefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}
	public String getEmailAdresa() {
		return emailAdresa;
	}
	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}
	public String getBrLicneKarte() {
		return brLicneKarte;
	}
	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}
	public Titula getTitula() {
		return titula;
	}
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	public List<Predmet> getListaPredmeta() {
		return listaPredmeta;
	}
	public void setListaPredmeta(List<Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}
	
	/**
	 * Metoda koja pretvara tip datuma iz String u Date, koristi se za cuvanje datuma kao Date.
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

	public String getDatumRodjString() {
		return datumRodjString;
	}

	public void setDatumRodjString(String datumRodjString) {
		this.datumRodjString = datumRodjString;
	}
	
}
