package model;


public class Student {
	
	
	private String prezime;
	private String ime;
	private String datumRodjenja;
	private String adresaStana;
	private String kontaktTel;
	private String eMail;
	private String brIndeksa;
	private Integer godUpisa;
	private String godStudija;
	private Status statusStudenta;
	private double prosecnaOcena;
	
	public Student(String brIndeksa, String ime, String prezime, String godStudija, Status statusStudenta,
			double prosecnaOcena, String kontaktTel, Integer godUpisa, String datumRodjenja, String adresaStana,
			String eMail) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStana = adresaStana;
		this.kontaktTel = kontaktTel;
		this.eMail = eMail;
		this.brIndeksa = brIndeksa;
		this.godUpisa = godUpisa;
		this.godStudija = godStudija;
		this.statusStudenta = statusStudenta;
		this.prosecnaOcena = prosecnaOcena;
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

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
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
	
	
}
