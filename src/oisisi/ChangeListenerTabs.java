package oisisi;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klasa koja change listener, sadrzi akcionu metodu koja registruje promenu taba, 
 * Koristi se za cuvanje informacije o selektovanom tabu u promenljivoj sel, da bi
 * se na osnovu toga otvarali odgovarajuci dijalozi.
 * @author brani
 *
 */
public class ChangeListenerTabs implements ChangeListener {
	
	
	public static int sel;
	
	
	

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane pane = (JTabbedPane) e.getSource();
		sel = pane.getSelectedIndex();
		System.out.println(pane.getSelectedIndex());
		
	}




	/**
	 * Geter metoda koja vraca indeks selektovanog taba.
	 * @return selektovani tab id
	 */
	public int getSel() {
		return sel;
	}




	public void setSel(int sel) {
		ChangeListenerTabs.sel = sel;
	}

	

}
