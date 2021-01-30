package oisisi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja tabelu polozenih predmeta.
 * @author Branimir
 *
 */
public class PolozeniJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248959286707614944L;

	private static PolozeniJTable instance = null;
	
	/**
	 * Metoda koja vraca/pravi instancu klase polozeniJTable.
	 * @return instance
	 */
	public static PolozeniJTable getInstance() {
		if (instance == null) {
			instance = new PolozeniJTable();
		}
		return instance;
	}
	
	/**
	 * Konstruktor tabele polozenih predmeta, koristi metode iz JTable klase.
	 * Povezana je sa apstraktim modelom.
	 */
	public PolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelPolozeni());	
	}
}
