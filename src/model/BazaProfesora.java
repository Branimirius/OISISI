package model;

import java.util.ArrayList;
import java.util.List;

import model.Profesor;
import oisisi.Tab;

public class BazaProfesora {

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
			List<Predmet> predmeti1 = new ArrayList<Predmet>();
			predmeti1.add(new Predmet());
			predmeti1.add(new Predmet());
			
			this.profesori = new ArrayList<Profesor>();
			profesori.add(new Profesor("Mikic", "Mika", "10.11.1999.", "Strazilovska 26", 62345623, "pajta@gmail.com", 498293, Titula.DR, Zvanje.ASISTENT_SA_DOKTORATOM, predmeti1 ));
			profesori.add(new Profesor("Zikic", "Zika", "23.04.1964.", "Strazilovska 54", 62377553, "bata@gmail.com", 497893, Titula.DR, Zvanje.DOCENT, predmeti1));
			profesori.add(new Profesor("Peric", "Pera", "14.05.1958.", "Strazilovska 77", 62424253, "lik@gmail.com", 808845, Titula.MR, Zvanje.REDOVNI_PROFESOR, predmeti1));
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
				return null;//profesor.getTitula();
			case 3:
				return null;//profesor.getZvanje();
			case 4:
				return Integer.toString(profesor.getKontakt_telefon());
			case 5:
				return profesor.getEmail_adresa();
			case 6:
				return Integer.toString(profesor.getBroj_licne_karte());
			case 7 :
				return profesor.getDatum_rodjenja();
			case 8:
				return profesor.getAdresa_stanovanja();
			case 9:
				return null;  //Profesor.getLista_predmeta();
			default:
				return null;
			}
		}

		public void dodajProfesora(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, 
				Integer kontakt_telefon, String email_adresa, Integer broj_licne_karte, Titula titula, Zvanje zvanje, List<Predmet> lista_predmeta ) {
			this.profesori.add(new Profesor(prezime, ime, datum_rodjenja, adresa_stanovanja, 
					kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta));
			System.out.println("Profesor dodat");
		}

}


