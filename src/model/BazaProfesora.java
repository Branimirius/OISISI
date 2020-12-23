package model;

import java.util.ArrayList;
import java.util.List;
import model.Profesor;

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
		
			initProfesora();

			this.kolone = new ArrayList<String>();
			this.kolone.add("PREZIME");
			this.kolone.add("IME");
			this.kolone.add("DATUM RODJENJA");
			this.kolone.add("ADRESA STANOVANJA");
			this.kolone.add("KONTAKT TELEFON");
			this.kolone.add("EMAIL ADRESA");
			this.kolone.add("BROJ LICNE KARTE");
			this.kolone.add("TITULA");
			this.kolone.add("ZVANJE");
			this.kolone.add("LISTA PREDMETA NA KOJIMA JE PROFESOR");
		    
			//List<Predmet> lista1 = new 
		
		}

		private void initProfesora() {
			List<Predmet> predmeti1 = new ArrayList<Predmet>();
			predmeti1.add(new Predmet());
			predmeti1.add(new Predmet());
			
			this.profesori = new ArrayList<Profesor>();
			profesori.add(new Profesor("Mikic", "Mika", "10.11.1999.", "Strazilovska 26", 062345623, "pajta@gmail.com", 498293, "doktor", "prof", predmeti1 ));
			profesori.add(new Profesor("Zikic", "Zika", "23.04.1964.", "Strazilovska 54", 062377553, "bata@gmail.com", 497893, "master", "mr", predmeti1));
			profesori.add(new Profesor("Peric", "Pera", "14.05.1958.", "Strazilovska 77", 062424253, "lik@gmail.com", 808845, "doktor", "prof", predmeti1));
		}

		public List<Profesor> getProfesori() {
			return profesori;
		}

		public void setProfesori(List<Profesor> Profesori) {
			this.profesori = Profesori;
		}
		
		public int getColumnCount() {
			return 10;
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
				return profesor.getIme();
			case 1:
				return profesor.getPrezime();
			case 2:
				return profesor.getDatum_rodjenja();
			case 3:
				return profesor.getAdresa_stanovanja();
			case 4:
				return Integer.toString(profesor.getKontakt_telefon());
			case 5:
				return profesor.getEmail_adresa();
			case 6:
				return Integer.toString(profesor.getBroj_licne_karte());
			case 7:
				return profesor.getTitula();
			case 8:
				return profesor.getZvanje() ;
			case 9:
				return null;  //Profesor.getLista_predmeta();
			default:
				return null;
			}
		}

		public void dodajProfesora(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, 
				Integer kontakt_telefon, String email_adresa, Integer broj_licne_karte, String titula, String zvanje, List<Predmet> lista_predmeta ) {
			this.profesori.add(new Profesor(prezime, ime, datum_rodjenja, adresa_stanovanja, 
					kontakt_telefon, email_adresa, broj_licne_karte, titula, zvanje, lista_predmeta));
		}

}


