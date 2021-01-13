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

import oisisi.StudentJTable;

public class BazaOcena implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8649203947466713456L;
	private static BazaOcena instance = null;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}
	
	private List<Ocena> ocene;
	private List<String> kolone;

	private BazaOcena() {
		initOcena();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}
	
	public void initOcena() {
		
		this.ocene = new ArrayList<Ocena>();
		String kolone[];
		String naredni;
		BufferedReader reader = null;
		
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("ocene.txt")));
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
               
              // student.addOcena(predmet, Integer.parseInt(kolone[2].trim()), datum);
                //String brIndeksa, String ime, String prezime, String godStudija, Status statusStudenta,
   				//double prosecnaOcena, String kontaktTel, Integer godUpisa, String datumRodjenja, String adresaStana,
   				//String eMail, List<Ocena> polozeni, List<Predmet> nepolozeni
               

                
            }

            reader.close();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
		 for(Student s : BazaStudenata.getInstance().getStudenti()) {
			 ArrayList<Ocena> spisakPolozenih = new ArrayList<Ocena>();
			 
			 for(Ocena o: ocene) {
				 if(o.getStudent().getBrIndeksa() == s.getBrIndeksa()) {
					 spisakPolozenih.add(o);
				 }
			 }
			 s.setPolozeni(spisakPolozenih);
			 
		 }
		 for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			 List<Student> polozili = new ArrayList<Student>();
			 List<Student> nisuPolozili = new ArrayList<Student>();
			 
			 for(Ocena o : ocene) {
				 if(o.getPredmet() == p) {
					 polozili.add(o.getStudent());
				 }
				 else {
					 nisuPolozili.add(o.getStudent());
				 }
			 }
			 p.setListPolozili(polozili);
			 p.setListNisuPolozili(nisuPolozili);
		 }
		
		
		/*int id = StudentJTable.getInstance().getSelectedRow();
		if(id < 0) {
			System.out.println("nije selektovan student");
			return;
		} 
		else {
		Student s = BazaStudenata.getInstance().getStudenti().get(id);
		ocene = s.getPolozeni();
		}
		*/
		
	}
	public void Serializacija() throws Exception, IOException{
		BufferedWriter out = null;
		try {
		out =new  BufferedWriter(new FileWriter("ocene.txt"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			for (Ocena o : ocene){
									
					StringBuilder sb = new StringBuilder("");
					
					sb.append(o.getStudent().getBrIndeksa()+ ", " + o.getPredmet().getIdPredmeta() + ", " + Integer.toString(o.getOcena() )+ ", " +  
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
	public List<Ocena> getOcene() {
		return ocene;
	}
	
	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Ocena getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Ocena ocena = this.ocene.get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getIdPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getBrojEspbBodova());
		case 3:
			return Integer.toString(ocena.getOcena());
		case 4:
			return dateToString(ocena.getDatum());
		case 5:
			return null; 
		default:
			return null;
		}
	}
	
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	public void clearOcene() {
		this.ocene.clear();
		
	}
	public void izbrisiOcenu(Ocena o) {
		for (Ocena it : ocene) {
			if(it == o) {
				ocene.remove(o);
				break;
			}
		}
	}
}
