package oisisi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja tabelu profesora.
 * @author Filip
 *
 */
public class ProfesorJTable extends JTable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ProfesorJTable instance = null;

	/**
	 * Metoda koja vraca/pravi instancu klase ProfesorJTable.
	 * @return instance
	 */
	public static ProfesorJTable getInstance() {
		if (instance == null) {
			instance = new ProfesorJTable();
		}
		return instance;
	}

	/**
	 * Konstruktor tabele profesora, koristi metode iz JTable klase.
	 * Povezana je sa apstraktim modelom.
	 */
	public ProfesorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableModelProfesor());	
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
