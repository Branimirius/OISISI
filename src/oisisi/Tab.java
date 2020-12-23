package oisisi;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
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
	
	
	StudentJTable tabelaStudenti = new StudentJTable();
		JScrollPane scrollStudenti = new JScrollPane(tabelaStudenti);
		
		
	JLabel profesorLabel = new JLabel("Profesor");
	JLabel predmetLabel = new JLabel("Predmet");
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	public Tab() {
		studentPanel.add(scrollStudenti, BorderLayout.CENTER);
		profesorPanel.add(profesorLabel);
		predmetPanel.add(predmetLabel);
		
		add("Student", studentPanel);
		add("Profesor", profesorPanel);
		add("Predmet", predmetPanel);
	}
	
	

}
