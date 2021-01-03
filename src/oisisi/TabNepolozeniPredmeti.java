package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TabNepolozeniPredmeti extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static TabNepolozeniPredmeti instance = null;

	public static TabNepolozeniPredmeti getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabNepolozeniPredmeti(dim);
		}
		return instance;
	}
	
	public TabNepolozeniPredmeti(Dimension dim) {		
		//setLayout(new BorderLayout());
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BorderLayout());
		
		JButton dodaj = new JButton("Dodaj");
		dodaj.setBackground(Color.CYAN);
		
		JButton obrisi = new JButton("Obrisi");
		obrisi.setBackground(Color.CYAN);
		
		JButton polaganje = new JButton("Polaganje");
		polaganje.setBackground(Color.MAGENTA);
		
		buttonsPanel.add(dodaj, BorderLayout.WEST);
		buttonsPanel.add(obrisi, BorderLayout.CENTER);
		buttonsPanel.add(polaganje, BorderLayout.EAST);
		
		add(buttonsPanel, BorderLayout.WEST);
		
	}

}
