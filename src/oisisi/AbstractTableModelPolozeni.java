package oisisi;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;
import model.BazaPredmeta;

/**
 * Apstraktni model koji se koristi za kreiranje tabele.
 * Radjeno po uzoru na vezbe.
 * @author Branimir
 *
 */
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
	
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaOcena.getInstance().getValueAt(rowIndex, columnIndex);
	}

	
	
}
