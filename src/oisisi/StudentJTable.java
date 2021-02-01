package oisisi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import model.BazaStudenata;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja prikaz studenata u obliku tabele.
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
	 * Metoda koja kreira i instancu klase  StudentJTable.
	 * @return instance
	 */
	public static StudentJTable getInstance() {
		if (instance == null) {
			instance = new StudentJTable();
		}
		return instance;
	}
	
	/**
	* Konstruktor koji kreira tabelu studenata koristeci metode iz JTable klase,
	 * direktno je povezana sa apstraktnom model klasom preko modela.
	 */
	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelStudent());
		
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
