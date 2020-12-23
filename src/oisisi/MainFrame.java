package oisisi;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;


public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2427219556160021852L;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NAJBOLJA STUDENTSKA SLUZBA EU :D");
		getContentPane().setLayout(new BorderLayout());
		
		//scalujemo velicinu prozora u odnosu na screensize
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height*3/4;
		int screenWidth = screenSize.width*3/4;
		setSize(screenWidth, screenHeight);
		
		//centriranje prilikom otvaranja
		setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("Images_mc/icon.png");
		setIconImage(icon.getImage());
	    
		JMenuBar menuBar = new MenuBar(); 
		JToolBar toolbar = new MyToolbar();
		JPanel statusBar = new StatusBar();
		Tab tab = new Tab();
		tab.tabelaStudenti.setPreferredSize(new Dimension(screenWidth - 30, screenHeight));
		tab.scrollStudenti.setPreferredSize(new Dimension(screenWidth - 30, screenHeight));
		
		setJMenuBar(menuBar); 
	    getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		add(tab,BorderLayout.CENTER);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
