//https://www.geeksforgeeks.org/serialization-in-java/
//https://stackabuse.com/java-read-a-file-into-an-arraylist/
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

import javax.swing.JOptionPane;

import oisisi.NepolozeniJTable;
import oisisi.StudentJTable;
import oisisi.TabNepolozeniPredmeti;
import oisisi.TabPolozeniPredmeti;


/**
 * Baza  podataka koja cuva listu Studenata kao glavnu bazu podataka koriscenu za kreiranje 
 * svih potrebnih tabela u programu koje sadrze studente.
 * @author Branimir
 *
 */
public class BazaStudenata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7339228090521864855L;
	private static BazaStudenata instance = null;

	/**
	 * Metoda koja kreira i vraca instancu baze studenata.
	 * @return instance
	 */
	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}


	private List<Student> studenti;
	private List<String> kolone;

	
	/**
	 * Kontruktor koji se koristi za pravljenje instance baze studenata, sostoji se od metode koja inicijalizuje bazu studenata
	 * tj. stavlja pocetne vrednosti u bazu iz txt dokumenta.
	 */
	private BazaStudenata() {
	
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		/*
	 	this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA STANOVANJA");
		this.kolone.add("KONTAKT TELEFON");
		this.kolone.add("EMAIL ADRESA");
		
		this.kolone.add("GODINA UPISA");
		*/
		
		
		

	}

	/**
	 * Metoda koja pomocu deserijalizacije ucitava vrednosti svih studenata iz datog fajla i rasporedjuje ih u 
	 * bazu studenata, tj listu "studenti"
	 */
	private void initStudente() {
		
		this.studenti = new ArrayList<Student>();
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("studenti.txt")));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		try {
            while((naredni = reader.readLine()) != null) {
                if(naredni.equals(""))    continue;

                kolone = naredni.split("\\,");

                Status status;
                if(kolone[8].trim().equals("B"))
                    status = Status.B;
                else
                    status = Status.S;
               
                  
               studenti.add(new Student( kolone[0].trim(), kolone[1].trim(), kolone[2].trim(), kolone[3].trim(), status, Double.parseDouble(kolone[10].trim()),
            		   kolone[6].trim(),Integer.parseInt(kolone[9].trim()),kolone[4].trim(), kolone[5].trim(), kolone[7].trim()));             

            }

            reader.close();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
		
		
	}
	
	/**
	 * Metoda koja vrsi serijalizaciju, tj. sacuvava promene izvrsene nad studentima, poziva se pri zatvaranju programa preko menubar-a
	 * @throws Exception
	 * @throws IOException
	 */
	public void Serializacija() throws Exception, IOException{
		BufferedWriter out = null;
		try {
		out =new  BufferedWriter(new FileWriter("studenti.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			for (Student s : studenti){
					String status = null;
					if(s.getStatusStudenta() == Status.B) {
						status = "B";
					}else if(s.getStatusStudenta() == Status.S) {
						status = "S";
					}
					
					
					StringBuilder sb = new StringBuilder("");
					
					sb.append(s.getBrIndeksa() + ", " + s.getIme() + ", " + s.getPrezime() + ", " +  
									s.getGodStudija() + ", " + dateToString(s.getDatumRodjenja()) + ", " + 
									s.getAdresaStana() + ", " + s.getKontaktTel() + ", " + s.geteMail() + ", " + 
									status + ", " + s.getGodUpisa() + ", " + s.getProsecnaOcena());
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
	 * Metoda koja stvara ocenu, upisuje je kod izabranog studenta(preko ids) 
	 * dodaje ocenu u listu polozenih predmeta i a brise je iz liste nepolozenih predmeta
	 * @param p predmet
	 * @param s vrednost ocene
	 * @param d datum polaganja
	 */
	public void PoloziIspit(Predmet p, String s, String d) {
		int ids = StudentJTable.getInstance().getSelectedRow();
		if(ids <0) {
			return;
		}
		else {
		studenti.get(ids).getNepolozeni().remove(p);
		studenti.get(ids).addOcena(p, Integer.parseInt(s), d);
		
		}
	}
	
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Vraca studenta sa odabranog reda iz tabele
	 * @param rowIndex ciljani indeks studenta
	 * @return student sa datog indeksa iz liste profesora
	 */
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	/**
	 * Preuzimanje vrednosti iz specificnog polja unutar tabele tj liste "studenti"
	 * @param row red
	 * @param column kolona
	 * @return vrednost polja(red, kolona)
	 */
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		
		switch (column) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getGodStudija();
		case 4:
			return (student.getStatusStudenta() == Status.B) ? "B" : "S";
		case 5:
			return Double.toString(student.getProsecnaOcena());
		case 6:
			return student.getKontaktTel();
		case 7:
			return Integer.toString(student.getGodUpisa());
		case 8:
			return dateToString(student.getDatumRodjenja());
		case 9:
			return student.getAdresaStana();
		case 10:
			return student.geteMail();
		
			
		default:
			return null;
		}
		
	} 

	/**
	 * Metoda koja dodaje novog studenta u listu studenata. Poziva se iz kontrolera.
     * @param prezime tipa String
	 * @param ime tipa String 
	 * @param datumRodjenja tipa Date
	 * @param adresaStana tipa String 
	 * @param kontaktTel telefon studenta tipa String
	 * @param eMail email studenta tipa String
	 * @param brIndeksa Broj indeksa studenta  - koristi se kao idetifikator
	 * @param godUpisa godina u kojoj je upisao student fakultet tipa Int
	 * @param godStudija koju godinu studija student pohadja tipa String
	 * @param statusStudenta Boolean (Da li je na budzetu ili na samofinansiranju student)
	 */
	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta,
			double prosecnaOcena) {
		this.studenti.add(new Student(brIndeksa, ime, prezime, godStudija, statusStudenta, prosecnaOcena, kontaktTel, godUpisa, datumRodjenja, adresaStana,
				eMail));		
		
	}
	/**
	 * Metoda koja pretvara tip datuma iz Date u String, radi lakseg koriscenja.
	 * @param datum Date
	 * @return datum string
	 */
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	
	/**
	 * Metoda koja menja informacije o selektovanom studentu ciji se ID prosledjuje kao parametar.
	 * Kao parametre prima sva potrebna polja za konstrukciju studenta. Ubacuje ga u listu(tabelu) 
	 * @param ID indeks selektovanog studenta iz liste(tabele)
	 * @param prezime tipa String
	 * @param ime tipa String 
	 * @param datumRodjenja tipa Date
	 * @param adresaStana tipa String 
	 * @param kontaktTel telefon studenta tipa String
	 * @param eMail email studenta tipa String
	 * @param brIndeksa Broj indeksa studenta  - koristi se kao indetifikator
	 * @param godUpisa godina u kojoj je upisao student fakultet tipa Int
	 * @param godStudija koju godinu studija student pohadja tipa String
	 * @param statusStudenta Boolean (Da li je na budzetu ili na samofinansiranju student)
	 */
	public void izmeniStudenta(String ID, String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta) {
		for (Student s : studenti) {
			if (s.getBrIndeksa() == ID) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStana(adresaStana);
				s.setKontaktTel(kontaktTel);
				s.seteMail(eMail);
				s.setBrIndeksa(brIndeksa);
				s.setGodUpisa(godUpisa);
				s.setGodStudija(godStudija);
				s.setStatusStudenta(statusStudenta);
			}
		}
	}
	/**
	 * Metoda koja brise studenta iz liste studenata, studenta bira preko ID-a 
	 * @param ID indeks selektovanog studenta
	 */
	public void izbrisiStudenta(String ID) {
		for (Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				studenti.remove(s);
				break;
			}
		}
	}
	/**
	 * Da li postoji student sa prosledjenim ID-om, sprecava unos dva ista studenta(sa istim ID)
	 * @param ID indeks koji se uporedjuje
	 * @return istinitosna vrednost
	 */
	public boolean indexPostoji(String ID){
		for(Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				System.out.println(s.getBrIndeksa());
				return true;
				
			}							
		}
		return false;
			
	}
	/**
	 * Metoda koja trazi studenta sa datim indeksom i vraca ga kao izlaznu vrednost.
	 * @param ID indeks trazenog student
	 * @return student
	 */
	public Student getStudent(String ID) {
		for(Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				return s;
				
			}
		}
		return null;
	}
	

}


