//reference: http://www.java2s.com/Tutorials/Java/Swing/JButton/Enable_or_disable_a_JButton_based_on_JTextField_content_in_Java.htm
//ref : https://stackoverflow.com/questions/23856818/set-enable-button-if-text-field-is-fill

/**
 * controller je paket koji sadrzi sve kontrolere koji posreduju izmedju akcija korisnika i
 *  baze podataka.
 */
package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * Klasa koja implementira DocumentListener,
 *  upotrebljena je za zakljucavanje dugmeta u dijalozima za izmenu i dodavanje profesora.
 *  
 * @author Filip
 *
 */
public class ButtonController implements DocumentListener { 
	  JButton button;
	  int br;
	  
	 
	  /**
	   * Konstruktor kontrolera zakljucavanja dugmeta u dijalozima za izmenu i dodavanje profesora
	   * Prima parametre: dugme na koje se odnosi i broj polja koje se popunjava, kada su sva polja popunjena
	   * dugme ce se otkljucati ili zakljucati ako je polje prazno.
	 * @param b
	 * @param i
	 */
	public ButtonController(JButton b, int i) {
	    button = b;
	    br = i;
	  }

	  public void changedUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void insertUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void removeUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  /**
	   * Metoda koja zakljucava dugme za potvrdu ako je neko polje prazno,
	   * kao parametar uzima registrovani dogadjaj unutar dokumenta (polja).
	 * @param e registrovani dogadjaj unutar polja dijaloga
	 */
	public void disableIfEmpty(DocumentEvent e) {
		  if (e.getDocument().getLength() > 1) 
			  		ValidLista.getInstance().validateList(br); 
		  if(ValidLista.getInstance().listValid())
					button.setEnabled(e.getDocument().getLength() > 1);
	  }

	}