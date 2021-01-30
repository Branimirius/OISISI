package oisisi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.BazaStudenata;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja tabelu studenata.
 * @author Branimir
 *
 */
public class StudentJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7678717758337523861L;
	
	private static StudentJTable instance = null;

	/**
	 * Metoda koja vraca/pravi instancu klase StudentJTable.
	 * @return instance
	 */
	public static StudentJTable getInstance() {
		if (instance == null) {
			instance = new StudentJTable();
		}
		return instance;
	}
	
	/**
	 * Konstruktor tabele studenata, koristi metode iz JTable klase.
	 * Povezana je sa apstraktim modelom.
	 */
	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelStudent());
		
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
