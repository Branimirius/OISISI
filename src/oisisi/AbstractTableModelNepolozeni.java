package oisisi;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozeniPredmeti;

/**
 * Klasa apstraknog modela, koja sluzi za kreiranje tabele prikaza Nepolozenih predmeta(NepolozeniJTable)
 * @author Branimir
 *
 */
public class AbstractTableModelNepolozeni  extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7790443882399741719L;

	@Override
	public int getRowCount() {
		return BazaNepolozeniPredmeti.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaNepolozeniPredmeti.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaNepolozeniPredmeti.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaNepolozeniPredmeti.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
