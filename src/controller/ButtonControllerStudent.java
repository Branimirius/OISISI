package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Klasa koja implementira DocumentListener,
 *  upotrebljena je za zakljucavanje dugmeta u dijalozima za izmenu i dodavanje studenta.
 *  
 * @author Branimir
 *
 */

public class ButtonControllerStudent implements DocumentListener{

	
	JButton button;
	  int br;
	
	  /**
	   * Konstruktor kontrolera zakljucavanja dugmeta u dijalozima za izmenu i dodavanje studenta
	   * Prima parametre: dugme na koje se odnosi i broj polja koje se popunjava, kada su sva polja popunjena
	   * dugme ce se otkljucati ili zakljucati ako je polje prazno.
	 * @param b
	 * @param i
	 */
	  
	  public ButtonControllerStudent(JButton b, int i) {
		    button = b;
		    br = i;
		  }  
	  
	@Override
	public void insertUpdate(DocumentEvent e) {
		disableIfEmpty(e);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		disableIfEmpty(e);
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		disableIfEmpty(e);
		
	}
	
	 /**
	   * Metoda koja zakljucava dugme za potvrdu ako je neko polje prazno,
	   * kao parametar uzima registrovani dogadjaj unutar dokumenta (polja).
	 * @param e registrovani dogadjaj unutar polja dijaloga
	 */
	public void disableIfEmpty(DocumentEvent e) {
		 if (e.getDocument().getLength() > 0) 
		  		ValidListaStudent.getInstance().validateList(br); 
	  if(ValidListaStudent.getInstance().listValid())
				button.setEnabled(e.getDocument().getLength() > 0);
	  }
}
