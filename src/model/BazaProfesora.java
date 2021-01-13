//reference https://stackoverflow.com/questions/34119441/how-to-initialize-a-variable-of-date-type-in-java/34119532
//reference https://www.javatpoint.com/java-date-to-string

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

import model.Profesor;


public class BazaProfesora implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = -3335280947264351732L;
		private static BazaProfesora instance = null;

		public static BazaProfesora getInstance() {
			if (instance == null) {
				instance = new BazaProfesora();
			}
			return instance;
		}
		
		private List<Profesor> profesori;
		private List<String> kolone;

		private BazaProfesora() {
		
			initProfesore();

			this.kolone = new ArrayList<String>();
			this.kolone.add("PREZIME");
			this.kolone.add("IME");
			this.kolone.add("TITULA");
			this.kolone.add("ZVANJE");
			
			//this.kolone.add("DATUM RODJENJA");
			//this.kolone.add("ADRESA STANOVANJA");
			//this.kolone.add("KONTAKT TELEFON");
			//this.kolone.add("EMAIL ADRESA");
			//this.kolone.add("BROJ LICNE KARTE");
			//this.kolone.add("LISTA PREDMETA NA KOJIMA JE PROFESOR");
		
		}

		private void initProfesore() {
			
			this.profesori = new ArrayList<Profesor>();
			String kolone[];
			String naredni;
			BufferedReader reader = null;
			
			
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream("profesori.txt")));
			} catch (FileNotFoundException exception) {
				exception.printStackTrace();
			}
			try {
	            while((naredni = reader.readLine()) != null) {
	                if(naredni.equals(""))    continue;

	                kolone = naredni.split("\\,");

	                Titula titula = null;
	                if(kolone[8].trim().equals("DR"))
	                    titula = Titula.DR;
	                else if(kolone[8].trim().equals("PROF_DR"))
	                    titula = Titula.PROF_DR;
	                else if(kolone[8].trim().equals("BSC"))
	                    titula = Titula.BSC;
	                else if(kolone[8].trim().equals("MSC"))
	                    titula = Titula.MSC;
	                
	                Zvanje zvanje = null;
	                if(kolone[9].trim().equals("REDOVNI_PROFESOR"))
	                    zvanje = Zvanje.REDOVNI_PROFESOR;
	                else if(kolone[9].trim().equals("VANREDNI_PROFESOR"))
	                	zvanje = Zvanje.VANREDNI_PROFESOR;
	                else if(kolone[9].trim().equals("DOCENT"))
	                	zvanje = Zvanje.DOCENT;
	                else if(kolone[9].trim().equals("ASISTENT"))
	                	zvanje = Zvanje.ASISTENT;
	                
	               profesori.add(new Profesor(kolone[2].trim(), kolone[1].trim(), kolone[3].trim(), kolone[4].trim(),
	            		   kolone[5].trim(), kolone[6].trim(), kolone[0].trim(), titula, zvanje,
	        			null));
	                
	                //String brIndeksa, String ime, String prezime, String godStudija, Status statusStudenta,
	   				//double prosecnaOcena, String kontaktTel, Integer godUpisa, String datumRodjenja, String adresaStana,
	   				//String eMail, List<Ocena> polozeni, List<Predmet> nepolozeni
	               

	                
	            }

	            reader.close();
	        } catch(IOException exception) {
	            exception.printStackTrace();
	        }
			
			
			/*List<Predmet> predmeti1 = new ArrayList<Predmet>();
			predmeti1.add(new Predmet());
			predmeti1.add(new Predmet());
			
			this.profesori = new ArrayList<Profesor>();
			profesori.add(new Profesor("Mikic", "Mika", "10/11/1999", "Strazilovska 26", "62345623", "pajta@gmail.com", "498293", Titula.DR, Zvanje.ASISTENT_SA_DOKTORATOM, predmeti1 ));
			profesori.add(new Profesor("Zikic", "Zika", "23/04/1964", "Strazilovska 54", "62377553", "bata@gmail.com", "497893", Titula.DR, Zvanje.DOCENT, predmeti1));
			profesori.add(new Profesor("Peric", "Pera", "14/05/1958", "Strazilovska 77", "62424253", "lik@gmail.com", "808845", Titula.MR, Zvanje.REDOVNI_PROFESOR, predmeti1));
		*/
		
		}
		
		public void Serializacija() throws Exception, IOException{
			BufferedWriter out = null;
			try {
			out =new  BufferedWriter(new FileWriter("profesori.txt"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				for (Profesor p : profesori){
						String titula = null;
						if(p.getTitula() == Titula.BSC) {
							titula = "BSC";
						}else if(p.getTitula() == Titula.DR) {
							titula = "DR";
						}else if(p.getTitula() == Titula.MR) {
							titula = "MR";
						}else if(p.getTitula() == Titula.MSC) {
							titula = "MSC";
						}else if(p.getTitula() == Titula.PROF_DR) {
							titula = "PROF_DR";
						}
						String zvanje = null;
						if(p.getZvanje() == Zvanje.ASISTENT) {
							zvanje = "ASISTENT";
						} else if(p.getZvanje() == Zvanje.ASISTENT_SA_DOKTORATOM){
							zvanje = "ASISTENT_SA_DOKTORATOM";
						}else if(p.getZvanje() == Zvanje.DOCENT) {
							zvanje = "DOCENT";
						}else if(p.getZvanje() == Zvanje.PROFESOR_EMERITUS){
							zvanje = "PROFESOR_EMERITUS";
						}else if(p.getZvanje() == Zvanje.REDOVNI_PROFESOR){
							zvanje = "REDOVNI_PROFESOR";
						}else if(p.getZvanje() == Zvanje.SARADNIK_U_NASTAVI){
							zvanje = "SARADNIK_NASTAVI";
						}else if(p.getZvanje() == Zvanje.VANREDNI_PROFESOR){
							zvanje = "VANREDNI_PROFESOR";
						}
						StringBuilder sb = new StringBuilder("");
						
						sb.append(p.getBrLicneKarte()+", " + p.getIme() + ", " + p.getPrezime() + ", " +  
										p.getDatumRodjString() + ", " + p.getAdresaStanovanja() + ", " + 
										p.getKontaktTelefon() + ", " + p.getEmailAdresa() + ", " +"    " + ", " + 
										titula+ ", " + zvanje);
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

		public List<Profesor> getProfesori() {
			return profesori;
		}

		public void setProfesori(List<Profesor> profesori) {
			this.profesori = profesori;
		}
		
		public int getColumnCount() {
			return 4;
		}

		public String getColumnName(int index) {
			return this.kolone.get(index);
		}

		public Profesor getRow(int rowIndex) {
			return this.profesori.get(rowIndex);
		}

		public String getValueAt(int row, int column) {
			Profesor profesor = this.profesori.get(row);
			
			switch (column) {
			case 0:
				return profesor.getPrezime();
			case 1:
				return profesor.getIme();
			case 2:
				return titulaToString(profesor.getTitula());
			case 3:
				return zvanjeToString(profesor.getZvanje());
			case 4:
				return profesor.getKontaktTelefon();
			case 5:
				return profesor.getEmailAdresa();
			case 6:
				return profesor.getBrLicneKarte();
			case 7 :
				return profesor.getDatumRodjString();
			case 8:
				return profesor.getAdresaStanovanja();
			case 9:
				return null;  //Profesor.getLista_predmeta();
			default:
				return null;
			}
		}

		public void dodajProfesora(String prezime, String ime, String datumRodjenja, String adresaStanovanja, 
				String kontaktTelefon, String emailAdresa, String brLicneKarte, Titula titula, Zvanje zvanje, List<Predmet> listaPredmeta ) {
			this.profesori.add(new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, 
					datumRodjenja, brLicneKarte, adresaStanovanja, titula, zvanje, listaPredmeta));
		}
		
		public void izmeniProfesora(String ID, String prezime, String ime, String datumRodjenja, String adresaStanovanja, 
				String kontaktTelefon, String emailAdresa, String brLicneKarte, Titula titula, Zvanje zvanje, List<Predmet> listaPredmeta) {
			for (Profesor p : profesori) {
				if (p.getBrLicneKarte() == ID) {
					p.setPrezime(prezime);
					p.setIme(ime);
					p.setDatumRodjenja(datumRodjenja);
					p.setAdresaStanovanja(adresaStanovanja);
					p.setKontaktTelefon(kontaktTelefon);
					p.setEmailAdresa(emailAdresa);
					p.setBrLicneKarte(brLicneKarte);
					p.setTitula(titula);
					p.setZvanje(zvanje);
					
				}
			}
		}
		
		public String titulaToString(Titula t) {
			switch(t) {
			case BSC:
				return "BSc";
			case MSC:
				return "MSc";
			case MR:
				return "mr";
			case DR:
				return "dr";
			case PROF_DR:
				return "prof. dr";
			default:
				return null;
			}
		}
		
		public String zvanjeToString(Zvanje z) {
			switch(z) {
			case SARADNIK_U_NASTAVI:
				return "Saradnik u nastavi";
			case ASISTENT:
				return "Asistent";
			case ASISTENT_SA_DOKTORATOM:
				return "Asistent sa doktoratom";
			case DOCENT:
				return "Docent";
			case VANREDNI_PROFESOR:
				return "Vandredni profesor";
			case REDOVNI_PROFESOR:
				return "Redovni profesor";
			case PROFESOR_EMERITUS:
				return "Profesor emeritus";
			default:
				return null;
			}
		}
		
		public void izbrisiProfesora(String ID) {
			for (Profesor p : profesori) {
				if(p.getBrLicneKarte() == ID) {
					profesori.remove(p);
					break;
				}
			}
		}

}


