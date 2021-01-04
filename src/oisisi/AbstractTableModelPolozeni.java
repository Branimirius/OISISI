package oisisi;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;
import model.BazaPredmeta;

public class AbstractTableModelPolozeni extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6624770498694003885L;

	@Override
	public int getRowCount() {
		return BazaOcena.getInstance().getOcene().size();
	}

	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
	}

	
	
}
