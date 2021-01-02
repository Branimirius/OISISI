package oisisi;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;







public class Tab extends JTabbedPane{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private static Tab instance = null;

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
	

	
	public StudentJTable tabelaStudenti ;
	/*	JScrollPane scrollStudenti = new JScrollPane(tabelaStudenti);
	*/	
		
	//JLabel profesorLabel = new JLabel("Profesor");
		
	ProfesorJTable tabelaProfesori = new ProfesorJTable();
		JScrollPane scrollProfesori = new JScrollPane(tabelaProfesori);
	
	//JLabel predmetLabel = new JLabel("Predmet");
	PredmetJTable tabelaPredmeti = new PredmetJTable();
		JScrollPane scrollPredmeti = new JScrollPane(tabelaPredmeti);
	
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	public Tab() {
		
		prikaziTabeluStudent();
		
		profesorPanel.setLayout(new BorderLayout());
		profesorPanel.add(scrollProfesori, BorderLayout.CENTER);
		
		
		predmetPanel.setLayout(new BorderLayout());
		predmetPanel.add(scrollPredmeti, BorderLayout.CENTER);
		
		
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
	
	public void prikaziTabeluStudent() {
		tabelaStudenti = StudentJTable.getInstance();
		JScrollPane scrollStudenti = new JScrollPane(tabelaStudenti);
		studentPanel.setLayout(new BorderLayout());
		studentPanel.add(scrollStudenti, BorderLayout.CENTER);		
		this.add("Student", studentPanel);

		
		System.out.println("Prikazao tabelu ");
	}
	

}
