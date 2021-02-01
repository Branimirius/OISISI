package oisisi;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * Singleton klasa koja nasledjuje JTable i predstavlja  predmeta u obliku tabele
 * @author Filip
 *
 */
public class PredmetJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static PredmetJTable instance = null;

	/**
	 * Metoda koja kreira i instancu klase PredmetJTable.
	 * @return instance
	 */
	public static PredmetJTable getInstance() {
		if (instance == null) {
			instance = new PredmetJTable();
		}
		return instance;
	}
	
	/**
	 * Konstruktor koji kreira tabelu predmeta koristeci metode iz JTable klase,
	 * direktno je povezana sa apstraktnom model klasom preko modela.
	 */
	public PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableModelPredmet());	
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
