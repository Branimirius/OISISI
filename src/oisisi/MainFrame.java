package oisisi;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import java.awt.BorderLayout;



public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2427219556160021852L;
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private Tab tab;
	
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
	    
		JMenuBar menuBar = new MenuBar(this); 
		JToolBar toolbar = new MyToolbar(this);
		JPanel statusBar = new StatusBar();
		
		showTab();
		
		setJMenuBar(menuBar); 
	    getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void updateViewStudent() {
		
		AbstractTableModelStudent modelStudent = (AbstractTableModelStudent) this.tab.tabelaStudenti.getModel();
		modelStudent.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna studente ");	
	}
	
	public void updateViewProfesor() {
		
		AbstractTableModelProfesor modelProfesor = (AbstractTableModelProfesor) this.tab.tabelaProfesori.getModel();
		modelProfesor.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna profesore");	
	}
	
	
	public void showTab() {
		this.tab = new Tab();
		this.add(tab, BorderLayout.CENTER);		
		this.updateViewStudent();
		this.updateViewProfesor();

	}
	
	
	
	
}
