package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStana;
	private String kontaktTel;
	private String eMail;
	private String brIndeksa;
	private Integer godUpisa;
	private String godStudija;
	private Status statusStudenta;
	private double prosecnaOcena;
	private List<Ocena> polozeni;
	private List<Predmet> nepolozeni;
	
	public Student(String brIndeksa, String ime, String prezime, String godStudija, Status statusStudenta,
			double prosecnaOcena, String kontaktTel, Integer godUpisa, String datumRodjenja, String adresaStana,
			String eMail) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = stringToDate(datumRodjenja);
		this.adresaStana = adresaStana;
		this.kontaktTel = kontaktTel;
		this.eMail = eMail;
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.godStudija = godStudija;
		this.statusStudenta = statusStudenta;
		this.prosecnaOcena = prosecnaOcena;
		this.polozeni = new ArrayList<Ocena>();
		this.nepolozeni = new ArrayList<Predmet>();
	}

	public List<Ocena> getPolozeni() {
		return polozeni;
	}

	public void setPolozeni(List<Ocena> polozeni) {
		this.polozeni = polozeni;
	}
	public void addOcena(Predmet p, int vr, String datum) {
		Ocena o = new Ocena(this, p, vr, datum);
		this.polozeni.add(o);
		
	}
	public void addOcena(Ocena o) {
		this.polozeni.add(o);
	}
	public void addPredmet(Predmet p) {
		this.nepolozeni.add(p);
	}

	public List<Predmet> getNepolozeni() {
		return nepolozeni;
	}

	public void setNepolozeni(List<Predmet> nepolozeni) {
		this.nepolozeni = nepolozeni;
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

	public String getAdresaStana() {
		return adresaStana;
	}

	public void setAdresaStana(String adresaStana) {
		this.adresaStana = adresaStana;
	}

	public String getKontaktTel() {
		return kontaktTel;
	}

	public void setKontaktTel(String kontaktTel) {
		this.kontaktTel = kontaktTel;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public Integer getGodUpisa() {
		return godUpisa;
	}

	public void setGodUpisa(Integer godUpisa) {
		this.godUpisa = godUpisa;
	}

	public String getGodStudija() {
		return godStudija;
	}

	public void setGodStudija(String godStudija) {
		this.godStudija = godStudija;
	}

	public Status getStatusStudenta() {
		return statusStudenta;
	}

	public void setStatusStudenta(Status statusStudenta) {
		this.statusStudenta = statusStudenta;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
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
