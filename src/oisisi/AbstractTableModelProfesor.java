package oisisi;

import java.util.ArrayList;
import java.util.List;

//import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

public class AbstractTableModelProfesor extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Boolean> koJeOtkacen;
	
	public AbstractTableModelProfesor() {
		this.koJeOtkacen = new ArrayList<>();
		for (int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
			koJeOtkacen.add(false);
		}
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

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 5) {
			return;
		}
		koJeOtkacen.set(rowIndex, !koJeOtkacen.get(rowIndex));
	}

	public void igracDodat() {
		this.koJeOtkacen.add(false);
	}
	

}
