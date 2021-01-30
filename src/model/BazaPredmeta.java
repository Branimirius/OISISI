package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Baza svih predmeta. Ovde se nalazi lista svih predmeta na studentskoj sluzbi i koristi se za kreiranje   
 * odgovarajucih tabela.
 * @author Filip
 *
 */
public class BazaPredmeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4603675659213102682L;

	private static BazaPredmeta instance = null;

	/**
	 * Metoda koja vraca instancu baze predmeta.
	 * @return instance
	 */
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

	/**
	 * Lista studenata koji su polozili predmet.
	 * @return studentiPolozili
	 */
	public List<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(List<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	/**
	 * Lista studenata koji nisu polozili predmet.
	 * @return studentiNisuPolozili
	 */
	public List<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(List<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}

	/**
	 * Konstruktor koji se koristi za pravljenje instance, sastoji se od metode inicijalizacije baze predmeta i 
	 * definisanje kolona za tabelu predmeta.
	 */
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

	/**
	 * Metoda koja pomocu deserijalizacije ucitava vrednosti svih prdmeta iz datog fajla i rasporedjuje ih u 
	 * odgovarajuce liste.
	 */
	private void initPredmeta() {
	

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
	
	/**
	 * Metoda koja vrsi serijalizaciju trenutnog stanja u tabeli (nakon svih izmena) na taj nacin cuvamo stanje u tabeli za 
	 * sledecu upotrebu.
	 * @throws Exception
	 * @throws IOException
	 */
	public void Serializacija() throws Exception, IOException{
		BufferedWriter out = null;
		try {
		out =new  BufferedWriter(new FileWriter("predmeti.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			for (Predmet p : predmeti){
					String semestar= null;
					if(p.getSemestar() == Semestar.LETNJI) {
						semestar= "LETNJI";
					}else if(p.getSemestar() == Semestar.ZIMSKI) {
						semestar = "ZIMSKI";
					}
					
					
					StringBuilder sb = new StringBuilder("");
					
					sb.append(p.getIdPredmeta()+ ", " + p.getNazivPredmeta()+ ", " + Integer.toString(p.getGodinaIzvodjenja())+ ", " +  
									Integer.toString(p.getBrojEspbBodova())+ ", " + "null" + ", " + 
									semestar);
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
	 * @param rowIndex ciljani predmet iz tabele
	 * @return predmet sa datog indeksa iz liste predmeta
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
	 * Metoda koja se poziva iz kontrolera pri procesu dodavanja novog predmeta u listu predmeta.
	 * @param idPredmeta
	 * @param nazivPredmeta
	 * @param semestar
	 * @param godinaIzvodjenja
	 * @param predmetniProfesor
	 * @param brojEspbBodova
	 * @param listPolozili
	 * @param listNisuPolozili
	 */
	public void dodajPredmet(String idPredmeta, String nazivPredmeta, Semestar semestar, Integer godinaIzvodjenja,
			Profesor predmetniProfesor, Integer brojEspbBodova, List<Student> listPolozili, List<Student> listNisuPolozili ) {
		this.predmeti.add(new Predmet(idPredmeta, nazivPredmeta, semestar, godinaIzvodjenja,
				predmetniProfesor, brojEspbBodova,  listPolozili, listNisuPolozili));
	}
	
	/**
	 * Metoda koja se poziva iz kontrolera predmeta pri procesu izmene predmeta iz liste predmeta.
	 * @param idPredmeta
	 * @param nazivPredmeta
	 * @param brojEspbBodova
	 * @param semestar
	 * @param godinaIzvodjenja
	 */
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
	/**
	 * Metoda koja brise predmet sa zadatim indeksom iz liste predmeta (tabele)
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
	/**
	 * Metoda koja trazi predmet sa prosledjenim indeksom i vraca ga za dalju upotrebu.
	 * @param ID indeks ciljanog predmeta
	 * @return predmet
	 */
	public Predmet getPredmet(String ID) {
		for (Predmet p : predmeti) {
			if(p.getIdPredmeta() == ID) {
				return p;
			}
		}
		return null;
	}
}
