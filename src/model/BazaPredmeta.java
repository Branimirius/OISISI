package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private String idPredmeta;
	
	private List<Student> studentiPolozili;
	private List<Student> studentiNisuPolozili;
	private List<Predmet> predmeti;
	private List<String> kolone;
	private List<Ocena> polozeni;
	private Profesor profesor;

	public List<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(List<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public List<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(List<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

	private BazaPredmeta() {
		
	
		initPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR");

		//this.kolone.add("PREDMETNI PROFESOR");
		//this.kolone.add("LISTA STUDENATA KOJI SU POLOZILI");
		//this.kolone.add("LISTA STUDENATA KOJI NISU POLOZILI");
		
	}

	private void initPredmeta() {
		/*this.studentiPolozili = new ArrayList<Student>();
		studentiPolozili.add(new Student("RA174", "Filip", "Pinjuh", "3", Status.B, 7, "51235124", 2018, "10/11/99", "Strz 25", "email", polozeni, predmeti));
		studentiPolozili.add(new Student("RA174", "Bane", "Carina", "3", Status.B, 7, "51235124", 2018,"10/11/99", "Strz 25", "email", polozeni, predmeti));
		
		this.studentiNisuPolozili = new ArrayList<Student>();
		studentiPolozili.add(new Student("RA174", "Mihajlo", "Kisic", "3", Status.B, 7, "51235124", 2018, "10/11/99", "Strz 25", "email", polozeni, predmeti));
		
		this.profesor = new Profesor("Mikic", "Mika", "10/11/1999.", "Strazilovska 26", "062345623", "pajta@gmail.com", "498293", Titula.MR, Zvanje.REDOVNI_PROFESOR, predmeti);
		
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("SE3", "OISISI", Semestar.ZIMSKI, 3, profesor, 8, studentiPolozili, studentiNisuPolozili));
		predmeti.add(new Predmet("PP", "PROGRAMSKI PREVODIOCI", Semestar.ZIMSKI, 3, profesor, 8, studentiPolozili, studentiNisuPolozili));
		predmeti.add(new Predmet("MO", "METODE OPTIMIZACIJE", Semestar.ZIMSKI, 3, profesor, 8, studentiPolozili, studentiNisuPolozili));
		predmeti.add(new Predmet("N3", "NANS", Semestar.ZIMSKI, 3, profesor, 8, studentiPolozili, studentiNisuPolozili));
		
	
		this.polozeni = new ArrayList<Ocena>();*/
		
	

	        this.predmeti = new ArrayList<Predmet>();
	       

	        String kolone[];
	        String naredni;
	        BufferedReader reader = null;

	        try {
	            reader = new BufferedReader(new InputStreamReader(new FileInputStream("predmeti.txt")));
	        } catch (FileNotFoundException exception) {
	            exception.printStackTrace();
	        }


	        try {
	            while((naredni = reader.readLine()) != null) {
	                if(naredni.equals(""))    continue;

	                kolone = naredni.split(",");

	                Semestar semestar1;
	                if(kolone[5].trim().equals("ZIMSKI"))
	                    semestar1 = Semestar.ZIMSKI;
	                else
	                    semestar1 = Semestar.LETNJI;
	                Profesor objProfesor = null;
	                String profLicnaKarta = kolone[4].trim();
	                if(profLicnaKarta.contains("null")) {
	                    objProfesor = null;
	                }else {
	                    for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
	                        if(p.getBrLicneKarte().equals(profLicnaKarta) == true) {
	                            objProfesor = p;
	                        }
	                    }
	                }
	                Predmet pred = new Predmet( kolone[0].trim(), kolone[1].trim(), semestar1, Integer.parseInt(kolone[2].trim()), objProfesor, Integer.parseInt(kolone[3].trim()), null, null  );
	                predmeti.add(pred);
	                //String idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
	    			//Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili,
	    			//List<Student> listNisuPolozili
	               

	                if(objProfesor != null)
	                    objProfesor.getListaPredmeta().add(pred);
	            }

	            reader.close();
	        } catch(IOException exception) {
	            exception.printStackTrace();
	        }
	    
	          
	          
		
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
	
	public void dodajPredmet(String idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
			Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili, List<Student> listNisuPolozili ) {
		this.predmeti.add(new Predmet(idPredmeta, nazivPredmeta, semestar, godinaIzvodjenja,
				predmetniProfesor, brojEspbBodova,  listPolozili, listNisuPolozili));
	}
	public void izmeniPredmet(String idPredmeta, String nazivPredmeta, Integer brojEspbBodova, Semestar semestar, Integer godinaIzvodjenja ) {
		for(Predmet p : predmeti) {
			if(p.getIdPredmeta() == idPredmeta) {
				p.setNazivPredmeta(nazivPredmeta);
				p.setSemestar(semestar);
				p.setGodinaIzvodjenja(godinaIzvodjenja);
				p.setBrojEspbBodova(brojEspbBodova);
			}
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
	public Predmet getPredmet(String ID) {
		for (Predmet p : predmeti) {
			if(p.getIdPredmeta() == ID) {
				return p;
			}
		}
		return null;
	}
}
