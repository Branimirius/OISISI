package oisisi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja prikaz nepolozenih predmeta u obliku tabele.
 * @author Branimir
 *
 */
public class NepolozeniJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static NepolozeniJTable instance = null;

	/**
	 * Metoda koja kreira i instancu klase nepolozeniJTable.
	 * @return instance
	 */
	public static NepolozeniJTable getInstance() {
		if (instance == null) {
			instance = new NepolozeniJTable();
		}
		return instance;
	}
	
	/**
     * Konstruktor koji kreira tabelu nepolozenih preddmeta koristeci metode iz JTable klase,
	 * direktno je povezana sa apstraktnom model klasom preko modela.
	 */
	public NepolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelNepolozeni());	
	}
	
	/**
	 * Metoda koja sluzi da pripremi izgled tabele, i menja izgled u zavisnosti od korisnikovih radnji
	 */
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}