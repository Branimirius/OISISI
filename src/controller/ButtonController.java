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
 *  koristi se za zakljucavanje dugmeta "Potvrdi"u dijalozima za izmenu i dodavanje profesora, 
 *  stanje dugmeta zavisi od teksta koji se nalazi u txtField-ovima, tj da li je ValidList zapravo validna
 *  
 * @author Filip
 *
 */
public class ButtonController implements DocumentListener { 
	  JButton button;
	  int br;
	  
	 
	  /**
	   * Konstruktor kontrolera zakljucavanja dugmeta u dijalozima za izmenu i dodavanje profesora
	   * Parametri konstruktora su dugme na koje primenjujemo ovaj kontroler i broj txtField-ova od kojih nam zavisi validnost uslova,
	   * Dugme se otkljucava/zakljucava u zavisnosti od validnosti ValidList-e.
	 * @param b dugme na koje primenjujemo kontroler
	 * @param i  broj txtField-ova koriscenih za validaciju
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
	   * Metoda koja zakljucava dugme za potvrdu ako svi uslovi za validnost liste nisu ispunjeni.
	   * Sve moguce promene nad bilo kojim txtField-om pozivaju ovu funkciju (changedUpdate, insertUpdate, removeUpdate)
	 * @param e registrovani dogadjaj unutar polja dijaloga
	 */
	public void disableIfEmpty(DocumentEvent e) {
		  if (e.getDocument().getLength() > 1) 
			  		ValidLista.getInstance().validateList(br); 
		  if(ValidLista.getInstance().listValid())
					button.setEnabled(e.getDocument().getLength() > 1);
	  }

	}