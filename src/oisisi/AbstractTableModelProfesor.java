package oisisi;

import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

/**
* Klasa apstraknog modela, koja sluzi za kreiranje tabele prikaza Profesora (ProfesorJTable).
 * @author Filip
 *
 */
public class AbstractTableModelProfesor extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	public AbstractTableModelProfesor() {
		
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
