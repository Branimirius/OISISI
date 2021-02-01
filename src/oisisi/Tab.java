package oisisi;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BazaNepolozeniPredmeti;



/**
 * Tab nasledjuje JTabbedPane i predstavlja tabove na kojima se nalaze paneli sa odgovarajucim tabelama:
 * Tabela profesora, tabela studenata, tabela predmeta.
 * Koristimo klasu ChangeListenerTabs da bi odredili na kom se tabu korisnik nalazi.
 * @author Filip
 *
 */
public class Tab extends JTabbedPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private static Tab instance = null;

	/**
	 * Metoda koja kreira i vraca instancu klase tab
	 * @return instanca klase tab
	 */
	public static Tab getInstance() {
		if (instance == null) {
			instance = new Tab();
		}
		return instance;
	}
	
	JPanel studentPanel = new JPanel();
	JPanel profesorPanel = new JPanel();
	JPanel predmetPanel = new JPanel();
	
	public static int selectedTab;
	

	
	//public StudentJTable tabelaStudenti ;

	StudentJTable tabelaStudenti = StudentJTable.getInstance();
	JScrollPane scrollStudenti = new JScrollPane(tabelaStudenti);
		
	//JLabel profesorLabel = new JLabel("Profesor");
		
	ProfesorJTable tabelaProfesori = ProfesorJTable.getInstance();
		JScrollPane scrollProfesori = new JScrollPane(tabelaProfesori);
	
	//JLabel predmetLabel = new JLabel("Predmet");
	PredmetJTable tabelaPredmeti = PredmetJTable.getInstance();
		JScrollPane scrollPredmeti = new JScrollPane(tabelaPredmeti);
	
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	/**
	 * Konsturktor Tab klase
	 */
	public Tab() {
		
		studentPanel.setLayout(new BorderLayout());
		studentPanel.add(scrollStudenti, BorderLayout.CENTER);
		
		profesorPanel.setLayout(new BorderLayout());
		profesorPanel.add(scrollProfesori, BorderLayout.CENTER);
		
		
		predmetPanel.setLayout(new BorderLayout());
		predmetPanel.add(scrollPredmeti, BorderLayout.CENTER);
		
		add("Student", studentPanel);
		add("Profesor", profesorPanel);
		add("Predmet", predmetPanel);		
		
		addChangeListener(new ChangeListenerTabs());
		
				
	}
	
	public int getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(int selectedTab) {
		Tab.selectedTab = selectedTab;
	}
	
	
	

}
