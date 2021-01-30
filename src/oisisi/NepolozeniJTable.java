package oisisi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja tabelu nepolozenih predmeta.
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
	 * Metoda koja vraca/pravi instancu klase nepolozeniJTable.
	 * @return instance
	 */
	public static NepolozeniJTable getInstance() {
		if (instance == null) {
			instance = new NepolozeniJTable();
		}
		return instance;
	}
	
	/**
	 * Konstruktor tabele nepolozenih predmeta, koristi metode iz JTable klase.
	 * Povezana je sa apstraktim modelom.
	 */
	public NepolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelNepolozeni());	
	}
	
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