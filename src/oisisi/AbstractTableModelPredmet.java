package oisisi;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

/**
 * Apstraktni model koji se koristi za kreiranje tabele.
 * Radjeno po uzoru na vezbe.
 * @author Filip
 *
 */
public class AbstractTableModelPredmet  extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7790443882399741719L;

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
