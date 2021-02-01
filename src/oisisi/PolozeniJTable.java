package oisisi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja prikaz polozenih predmeta u obliku tabele.
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
	 * Metoda koja kreira i instancu klase polozeniJTable.
	 * @return instance
	 */
	public static PolozeniJTable getInstance() {
		if (instance == null) {
			instance = new PolozeniJTable();
		}
		return instance;
	}
	
	/**
	 * Konstruktor koji kreira tabelu polozenih ispita koristeci metode iz JTable klase,
	 * direktno je povezana sa apstraktnom model klasom preko modela.
	 */
	public PolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelPolozeni());	
	}
}
