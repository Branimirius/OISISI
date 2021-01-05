package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oisisi.StudentJTable;

public class BazaOcena {
	
	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private List<Ocena> ocene;
	private List<String> kolone;

	private BazaOcena() {
		initOcena();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}
	
	public void initOcena() {
		
		
		int id = StudentJTable.getInstance().getSelectedRow();
		if(id < 0) {
			System.out.println("nije selektovan student");
			return;
		} 
		else {
		Student s = BazaStudenata.getInstance().getStudenti().get(id);
		ocene = s.getPolozeni();
		}
		
		
	}
	
	public List<Ocena> getOcene() {
		return ocene;
	}
	
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Ocena getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Ocena ocena = this.ocene.get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getIdPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getBrojEspbBodova());
		case 3:
			return Integer.toString(ocena.getOcena());
		case 4:
			return dateToString(ocena.getDatum());
		case 5:
			return null; 
		default:
			return null;
		}
	}
	
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	public void clearOcene() {
		this.ocene.clear();
		
	}
	
}
