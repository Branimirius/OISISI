package oisisi;


import java.awt.BorderLayout;
import java.util.List;

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
	
	//JLabel studentiLabel = new JLaberl("Student");
	
	StudentJTable tabelaStudenti = new StudentJTable();
		JScrollPane scrollStudenti = new JScrollPane(tabelaStudenti);
		
		
	//JLabel profesorLabel = new JLabel("Profesor");
		
	ProfesorJTable tabelaProfesori = new ProfesorJTable();
		JScrollPane scrollProfesori = new JScrollPane(tabelaProfesori);
	
	//JLabel predmetLabel = new JLabel("Predmet");
	PredmetJTable tabelaPredmeti = new PredmetJTable();
		JScrollPane scrollPredmeti = new JScrollPane(tabelaPredmeti);
	
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
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
	
	public void updateTables() {
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) tabelaProfesori.getModel();
		model.igracDodat();
		model.fireTableDataChanged();
		validate();
	}

	public int getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(int selectedTab) {
		Tab.selectedTab = selectedTab;
	}
	
	

}
