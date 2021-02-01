package oisisi;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klasa koja sluzi da registruje tab na kome se nalazi korisnik ("Student", "Profeosor", "Predmet").
 * ta infomacija nam je potrebna za otvaranje adekvatnog New/Edit/Delete Dialoga.
 * @author Branimir
 *
 */
public class ChangeListenerTabs implements ChangeListener {
	
	
	public static int sel;
	
	
	
	/**
	Metoda koja se aktivira pri promeni taba i tu informaciju cuva u statickoj promenjivoj sel
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane pane = (JTabbedPane) e.getSource();
		sel = pane.getSelectedIndex();
		System.out.println(pane.getSelectedIndex());
		
	}




	/**
	 * Geter metoda koja vraca indeks selektovanog taba tabbedPane-a
	 * @return selektovani tab id
	 */
	public int getSel() {
		return sel;
	}




	public void setSel(int sel) {
		ChangeListenerTabs.sel = sel;
	}

	

}
