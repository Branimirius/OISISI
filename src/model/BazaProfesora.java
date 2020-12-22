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

		private long generator;

		private List<Profesor> Profesori;
		private List<String> kolone;

		private BazaProfesora() {
			generator = 0;
		
			initProfesore();

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
			

		}

		private void initProfesore() {
			this.Profesori = new ArrayList<Profesor>();
			Profesori.add(new Profesor("Mikic", "Mika", "10.11.1999.", "Strazilovska 26", 062345623, "email@gmail.com", 498293, "title", "doktor" ));
			Profesori.add(new Profesor("Zikic", "Zika", "23.04.1964.", ));
			Profesori.add(new Profesor("Peric", "Pera", "14.05.1958.", ));
		}

		public List<Profesor> getProfesori() {
			return Profesori;
		}

		public void setProfesori(List<Profesor> Profesori) {
			this.Profesori = Profesori;
		}

		public int getColumnCount() {
			return 10;
		}

		public String getColumnName(int index) {
			return this.kolone.get(index);
		}

		public Profesor getRow(int rowIndex) {
			return this.Profesori.get(rowIndex);
		}

		public String getValueAt(int row, int column) {
			Profesor Profesor = this.Profesori.get(row);
			switch (column) {
			case 0:
				return Long.toString(Profesor.getId());
			case 1:
				return Profesor.getIme();
			case 2:
				return Profesor.getPrezime();
			case 3:
				return Profesor.getKlub();
			default:
				return null;
			}
		}

		public void dodajProfesora(String ime, String prezime, String klub) {
			this.Profesori.add(new Profesor(generateId(), ime, prezime, klub));
		}

		public void izbrisiProfesora(long id) {
			for (Profesor i : Profesori) {
				if (i.getId() == id) {
					Profesori.remove(i);
					break;
				}
			}
		}

		public void izmeniProfesora(long id, String ime, String prezime, String klub) {
			for (Profesor i : Profesori) {
				if (i.getId() == id) {
					i.setIme(ime);
					i.setPrezime(prezime);
					i.setKlub(klub);
				}
			}
		}

	}

}
