package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dialog.EditStudentDialog;
import dialog.UnosOceneDialog;
import oisisi.MainFrame;
import oisisi.NepolozeniJTable;
import oisisi.StudentJTable;

public class BazaNepolozeniPredmeti {
	
	private static BazaNepolozeniPredmeti instance = null;

	public static BazaNepolozeniPredmeti getInstance() {
		if (instance == null) {
			instance = new BazaNepolozeniPredmeti();
		}
		return instance;
	}
	
	
	private List<Predmet> predmeti;
	private List<Ocena> ocene;
	private List<String> kolone;
	private Student s;

	private BazaNepolozeniPredmeti() {
		
		initNepolozeniPredmeti();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR");
	}
	
	public void initNepolozeniPredmeti() {
		
		
		this.predmeti = new ArrayList<Predmet>();
		this.ocene = new ArrayList<Ocena>();
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("nepolozeni.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		try {
            while((naredni = reader.readLine()) != null) {
                if(naredni.equals(""))    continue;

                kolone = naredni.split("\\,");
                Student student = null;
                Predmet predmet = null; 
                for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
                	if(p.getIdPredmeta().equals(kolone[1].trim()) == true) {
                		predmet = p;
                	}
                }
                for(Student s : BazaStudenata.getInstance().getStudenti()) {
                	if(s.getBrIndeksa().equals(kolone[0].trim() ) == true) {
                		student = s;
                	}
                }
                
                Ocena ocena = new Ocena(student, predmet, Integer.parseInt(kolone[2].trim()), kolone[3].trim());
                ocene.add(ocena);
                predmeti.add(predmet);
               
                //String brIndeksa, String ime, String prezime, String godStudija, Status statusStudenta,
   				//double prosecnaOcena, String kontaktTel, Integer godUpisa, String datumRodjenja, String adresaStana,
   				//String eMail, List<Ocena> polozeni, List<Predmet> nepolozeni
               

                
            }

            reader.close();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
		for(Student s : BazaStudenata.getInstance().getStudenti()) {
			 ArrayList<Predmet> spisakNepolozenih = new ArrayList<Predmet>();
			 
			 for(Ocena o: ocene) {
				 if(o.getStudent() == s) {
					 spisakNepolozenih.add(o.getPredmet());
				 }
			 }
			 s.setNepolozeni(spisakNepolozenih);
			 
		 }
		
		/*int id = StudentJTable.getInstance().getSelectedRow();
		if(id < 0) {
			System.out.println("nije selektovan student");
			return;
		} 
		else {
		s = BazaStudenata.getInstance().getStudenti().get(id);
		predmeti = s.getNepolozeni();
		}*/
	}
	
	public void NepolozeniUOcene(String s, String t) {
		int id = NepolozeniJTable.getInstance().getSelectedRow();
		if(id < 0) {
			return;
		}
		else {
		Predmet p = predmeti.get(id);
		this.s.getNepolozeni().remove(p);
		this.s.addOcena(p, Integer.parseInt(s), t);
		}
	}

	public void clearPredmeti() {
		predmeti.clear();
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> Predmeti) {
		this.predmeti = Predmeti;
	}

	public int getColumnCount() {
		return 5;
	}
	
	/*public long generateId() {
		return ++generator;
	}*/

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getIdPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojEspbBodova());
		case 3:
			return Integer.toString(predmet.getGodinaIzvodjenja());
		case 4:
			return (predmet.getSemestar()== Semestar.LETNJI) ? "LETNJI" : "ZIMSKI";
		case 5:
			return predmet.getPredmetniProfesor().getPrezime();
		case 6:
			return null; //predmet.getLista_polozili
		case 7:
			return null; //predmet.getLista_nisu_polozili
		default:
			return null;
		}
	}
	public void izbrisiPredmet(String ID) {
		for (Predmet p : predmeti) {
			if(p.getIdPredmeta() == ID) {
				predmeti.remove(p);
				break;
			}
		}
	}
}
