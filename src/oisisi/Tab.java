package oisisi;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.BazaNepolozeniPredmeti;







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
		
		tabelaStudenti.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	//TabPolozeniPredmeti.getInstance().updateViewPolozeni();
				TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
				//BazaNepolozeniPredmeti.getInstance().clearPredmeti();
	            System.out.println(tabelaStudenti.getValueAt(tabelaStudenti.getSelectedRow(), 0).toString());
	        }
	    });
		
				
	}
	
	public int getSelectedTab() {
		return selectedTab;
	}

	public void setSelectedTab(int selectedTab) {
		Tab.selectedTab = selectedTab;
	}
	
	
	

}
