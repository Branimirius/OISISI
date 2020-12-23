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
	
	JPanel studentPanel = new JPanel();
	JPanel profesorPanel = new JPanel();
	JPanel predmetPanel = new JPanel();
	
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
	}
	
	

}
