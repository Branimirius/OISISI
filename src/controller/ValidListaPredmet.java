package controller;

/**
 * Lista popunjenih polja unutar dijaloga, koristi se za evidenciju prilikom kontrole otkljucavanja/zakljucavanja 
 * dugmeta unutar dijaloga dodavanja/izmene predmeta.
 * @author Filip
 *
 */
public class ValidListaPredmet {

	private static ValidListaPredmet instance = null;

	/**
	 * Metoda za kreiranje odnosno poziv instance ValidListPredmet
	 * @return instance
	 */
	public static ValidListaPredmet getInstance() {
		if (instance == null) {
			instance = new ValidListaPredmet();
		}
		return instance;
		
	}
	
	private Boolean[] listValid = new Boolean[3];
	
	/**
	 * Konstruktor liste popunjenih polja u dijalogu, false znaci da polje nije popunjeno,
	 *  true znaci da jeste popunjeno. Inicijalno je false.
	 */
	public ValidListaPredmet() {
		this.listValid[0] = false;
		this.listValid[1] = false;
		this.listValid[2] = false;
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
	 * Metoda za ponistavanje validacije segmenta valid liste popunjenih polja.
	 * @param i indeks polja koje nije validno popunjeno
	 */
	public void deValidateList(int i) {
		this.listValid[i] = false;
	}
	
	/**
	 * Metoda koja nam daje informaciju da li je dijalog pravilno popunjen.
	 * Koristi se za otkljucavanje/zakljucavanje dugmeta.
	 * @return boolean vrednost u zavisnosti od validnosti popunjenih polja
	 */
	public Boolean listValid() {
		if (this.listValid[0] == true && this.listValid[1] == true && 
			this.listValid[2] == true) return true;
		else return false;
	}
	
}
