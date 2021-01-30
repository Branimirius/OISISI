package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dialog.EditStudentDialog;
import dialog.UnosOceneDialog;
import oisisi.MainFrame;
import oisisi.NepolozeniJTable;
import oisisi.StudentJTable;

/**
 * Baza nepolozenih predmeta studenata. Ovde se nalaze liste studenata i predmeta koje su neophodne za kreiranje 
 * odgovarajucih tabela.
 * @author Filip
 *
 */
public class BazaNepolozeniPredmeti implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -983853907984269259L;
	private static BazaNepolozeniPredmeti instance = null;

	/**
	 * Metoda koja vraca instancu baze nepolozenih predmeta.
	 * @return instance
	 */
	public static BazaNepolozeniPredmeti getInstance() {
		if (instance == null) {
			instance = new BazaNepolozeniPredmeti();
		}
		return instance;
	}
	
	
	private List<Predmet> predmeti;
	private List<Ocena> ocene;
	private List<String> kolone;
	private Student stud;

	/**
	 * Konstruktor koji se koristi za pravljenje instance, sastoji se od metode inicijalizacije baze nepolozenih predmeta i 
	 * definisanje kolona za tabelu nepolozenih.
	 */
	private BazaNepolozeniPredmeti() {
		
		initNepolozeniPredmeti();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR");
	}
	
	/**
	 * Metoda koja pomocu deserijalizacije ucitava vrednosti nepolozenih prdmeta iz datog fajla i rasporedjuje ih u 
	 * odgovarajuce liste.
	 */
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
				 if(o.getStudent().getBrIndeksa() == s.getBrIndeksa()) {
					 spisakNepolozenih.add(o.getPredmet());
				 }
			 }
			 s.setNepolozeni(spisakNepolozenih);
			 
		 }
		
	}
	
	/**
	 * Metoda koja vrsi serijalizaciju trenutnog stanja u tabeli(nakon svih izmena) na taj nacin cuvamo stanje u tabeli za 
	 * sledecu upotrebu.
	 * @throws Exception
	 * @throws IOException
	 */
	public void Serializacija() throws Exception, IOException{
		BufferedWriter out = null;
		try {
		out =new  BufferedWriter(new FileWriter("nepolozeni.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			for (Ocena o : ocene){
									
					StringBuilder sb = new StringBuilder("");
					
					sb.append(o.getStudent().getBrIndeksa()+ ", " + o.getPredmet().getIdPredmeta() + ", " + "5"+ ", " +  
									dateToString(o.getDatum()));
						out.write(sb.toString());
						out.write("\n");
							}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out!= null)
				try {
					out.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Metoda koja prebacuje predmete iz nepolozenih u polozene (ocene). Koristi se u funkciji polaganja ispita i
	 * unosa ocene.
	 * @param s vrednost ocene
	 * @param t datum polaganja
	 */
	public void NepolozeniUOcene(String s, String t) {
		int id = NepolozeniJTable.getInstance().getSelectedRow();
		if(id < 0) {
			return;
		}
		else {
		Predmet p = predmeti.get(id);
		stud.getNepolozeni().remove(p);
		stud.addOcena(p, Integer.parseInt(s), t);
		}
	}
	/**
	 * Metoda koja prebacuje datum iz tipa Date u tip String.
	 * Napravljena zbog jednostavnijeg rukovanja datumom.
	 * @param datum Date
	 * @return ret datum string
	 */
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	/**
	 * Brisanje liste nepolozenih predmeta.
	 */
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

	/**
	 * Odabir predmeta iz tabele.
	 * @param rowIndex
	 * @return
	 */
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	/**
	 * Preuzimanje vrednosti iz specificnog polja unutar tabele.
	 * @param row red
	 * @param column kolona
	 * @return vrednost polja(red, kolona)
	 */
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
	/**
	 * Brisanje predmeta prosledjenim indeksom iz liste nepolozenih predmeta.
	 * @param ID indeks ciljanog predmeta
	 */
	public void izbrisiPredmet(String ID) {
		for (Predmet p : predmeti) {
			if(p.getIdPredmeta() == ID) {
				predmeti.remove(p);
				break;
			}
		}
	}
}
