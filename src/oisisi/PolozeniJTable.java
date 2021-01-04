package oisisi;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PolozeniJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248959286707614944L;

	private static PolozeniJTable instance = null;
	
	public static PolozeniJTable getInstance() {
		if (instance == null) {
			instance = new PolozeniJTable();
		}
		return instance;
	}
	
	public PolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.setModel(new AbstractTableModelPolozeni());	
	}
}
