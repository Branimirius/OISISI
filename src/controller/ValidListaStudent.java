package controller;

/**
 * Lista popunjenih polja unutar dijaloga, koristi se za evidenciju prilikom kontrole otkljucavanja/zakljucavanja 
 * dugmeta unutar dijaloga dodavanja/izmene studenta.
 * @author Branimir
 *
 */
public class ValidListaStudent {
	private static ValidListaStudent instance = null;

	/**
	 * Metoda za kreiranje odnosno poziv instance ValidListStudent
	 * @return instance
	 */
	public static ValidListaStudent getInstance() {
		if (instance == null) {
			instance = new ValidListaStudent();
		}
		return instance;
	}
	
	private Boolean[] listValid = new Boolean[8];
	
	/**
	 * Konstruktor liste popunjenih polja u dijalogu, false znaci da polje nije popunjeno,
	 *  true znaci da jeste popunjeno. Inicijalno je false.
	 */
	public ValidListaStudent() {
		this.listValid[0] = false;
		this.listValid[1] = false;
		this.listValid[2] = false;
		this.listValid[3] = false;
		this.listValid[4] = false;
		this.listValid[5] = false;
		this.listValid[6] = false;
		this.listValid[7] = false;
	}

	/**
	 * Geter valid liste.
	 * @return listValid
	 */
	public Boolean[] getListValid() {
		return listValid;
	}

	/**
	 * Seter valid liste.
	 * @param listValid
	 */
	public void setListValid(Boolean[] listValid) {
		this.listValid = listValid;
	}
	
	/**
	 * Metoda za validaciju odredjenog segmenta valid liste popunjenih polja.
	 * @param i indeks popunjenog polja
	 */
	public void validateList(int i) {
		this.listValid[i] = true;
	}
	
	/**
	 * Metoda koja nam daje informaciju da li je dijalog pravilno popunjen.
	 * Koristi se za otkljucavanje/zakljucavanje dugmeta.
	 * @return boolean vrednost u zavisnosti od validnosti popunjenih polja
	 */
	public Boolean listValid() {
		if (this.listValid[0] == true && this.listValid[1] == true && 
			this.listValid[2] == true && this.listValid[3] == true &&
			this.listValid[4] == true && this.listValid[5] == true &&
			this.listValid[6] == true && this.listValid[7] == true) return true;
		else return false;
	}

}
