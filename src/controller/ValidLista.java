package controller;


/**
 * Lista uslova za svako txtField polje na Edit/New dialogu,
 * ako je svaka boolean vrednost unutar liste == true adekvatan ButtonController otkljucava dugme "Potvrdi"
 * @author Filip
 *
 */
public class ValidLista {
	
	private static ValidLista instance = null;

	/**
	 * Metoda za kreiranje odnosno poziv instance ValidList
	 * @return
	 */
	public static ValidLista getInstance() {
		if (instance == null) {
			instance = new ValidLista();
		}
		return instance;
	}
	
	private Boolean[] listValid = new Boolean[7];
	
	/**
	 * Konstruktor liste popunjenih polja u dijalogu, false znaci da polje nije adekvatno popunjeno,
	 *  true znaci da je adekvatno popunjeno. Posto su pri otvaranju dialoga sva polja prazna inicijalizujemo vrednosti liste na "false".
	 */
	public ValidLista() {
		this.listValid[0] = false;
		this.listValid[1] = false;
		this.listValid[2] = false;
		this.listValid[3] = false;
		this.listValid[4] = false;
		this.listValid[5] = false;
		this.listValid[6] = false;
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
	 * Metoda za validaciju odredjenog clana valid liste poziva se kada txtField postane adekvatno popunjen.
	 * @param i indeks popunjenog polja
	 */
	public void validateList(int i) {
		this.listValid[i] = true;
	}
	
	/**
	 * Metoda za ponistavanje validacije dredjenog clana valid liste, poziva se kada txtField vise nije adekvatno popunjen,
	 * @param i indeks polja koje nije validno popunjeno
	 */
	public void deValidateList(int i) {
		this.listValid[i] = false;
	}
	
	/**
	 * Metoda koja kljucna za kontrolu stanja dugmeta, ako su svi clanovi ValidListe popunjeni 
	 * to znaci da su sva txtField polja adekvatno ispunjena. Tj. Controller moze da otkljuca dugme "potvrdi".
	 * @return boolean vrednost u zavisnosti od validnosti popunjenih polja
	 */
	public Boolean listValid() {
		if (this.listValid[0] == true && this.listValid[1] == true && 
			this.listValid[2] == true && this.listValid[3] == true &&
			this.listValid[4] == true && this.listValid[5] == true &&
			this.listValid[6] == true) return true;
		else return false;
	}

}
