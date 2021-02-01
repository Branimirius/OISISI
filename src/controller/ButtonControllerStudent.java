package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Klasa koja implementira DocumentListener,
 *  koristi se za zakljucavanje dugmeta "Potvrdi"u dijalozima za izmenu i dodavanje studenta, 
 *  stanje dugmeta zavisi od teksta koji se nalazi u txtField-ovima, tj da li je ValidListStudent zapravo validna
 *  
 * @author Branimir
 *
 */

public class ButtonControllerStudent implements DocumentListener{

	
	JButton button;
	  int br;
	
	  /**
	   * Konstruktor kontrolera zakljucavanja dugmeta u dijalozima za izmenu i dodavanje studenta
	   * Parametri konstruktora su dugme na koje primenjujemo ovaj kontroler i broj txtField-ova od kojih nam zavisi validnost uslova,
	   * Dugme se otkljucava/zakljucava u zavisnosti od validnosti ValidListStudent.
	 * @param b dugme na koje primenjujemo kontroler
	 * @param i broj txtField-ova koriscenih za validaciju
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
	   * Metoda koja zakljucava dugme za potvrdu ako svi uslovi za validnost liste nisu ispunjeni.
	   * Sve moguce promene nad bilo kojim txtField-om pozivaju ovu funkciju (changedUpdate, insertUpdate, removeUpdate)
	 * @param e registrovani dogadjaj unutar polja dijaloga
	 */
	public void disableIfEmpty(DocumentEvent e) {
		 if (e.getDocument().getLength() > 0) 
		  		ValidListaStudent.getInstance().validateList(br); 
	  if(ValidListaStudent.getInstance().listValid())
				button.setEnabled(e.getDocument().getLength() > 0);
	  }
}
