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



public class BazaStudenata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7339228090521864855L;
	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}


	private List<Student> studenti;
	private List<String> kolone;

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
	public void PoloziIspit(String s, String d) {
		int id = NepolozeniJTable.getInstance().getSelectedRow();
		int ids = StudentJTable.getInstance().getSelectedRow();
		if(id < 0 || ids <0) {
			return;
		}
		else {
		Predmet p = BazaNepolozeniPredmeti.getInstance().getPredmeti().get(id);
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

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	
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

	public void dodajStudenta(String prezime, String ime, String datumRodjenja, String adresaStana, String kontaktTel,
			String eMail, String brIndeksa, Integer godUpisa, String godStudija, Status statusStudenta,
			double prosecnaOcena) {
		this.studenti.add(new Student(brIndeksa, ime, prezime, godStudija, statusStudenta, prosecnaOcena, kontaktTel, godUpisa, datumRodjenja, adresaStana,
				eMail));		
		
	}
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	
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
	public void izbrisiStudenta(String ID) {
		for (Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				studenti.remove(s);
				break;
			}
		}
	}
	public boolean indexPostoji(String ID){
		for(Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				System.out.println(s.getBrIndeksa());
				return true;
				
			}							
		}
		return false;
			
	}
	public Student getStudent(String ID) {
		for(Student s : studenti) {
			if(s.getBrIndeksa() == ID) {
				return s;
				
			}
		}
		return null;
	}
	

}


