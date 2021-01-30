package oisisi;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import validation.MyWindowListener;

import java.awt.BorderLayout;



/**
 * Ovo je singleton klasa glavnog prozora aplikacije, instanca se poziva upravo u Main.
 * Ovo je stablo aplikacije.
 * @author Filip
 *
 */
public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2427219556160021852L;
	
	private static MainFrame instance = null;

	/**
	 * Metoda koja pravi/vraca instancu klase MainFrame.
	 * @return instance
	 */
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private Tab tab;
	
	/**
	 * Konstruktor u kome je definisan izgled glavnog prozora aplikacije, koristi se u instanciranju.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("STUDENTSKA SLUZBA");
		getContentPane().setLayout(new BorderLayout());
		
		//scalujemo velicinu prozora u odnosu na screensize
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height*3/4;
		int screenWidth = screenSize.width*3/4;
		setSize(screenWidth, screenHeight);
		
		//centriranje prilikom otvaranja
		setLocationRelativeTo(null);
		
		addWindowListener(new MyWindowListener());
		
		ImageIcon icon = new ImageIcon("Images_mc" + File.separator + "icon.png");
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
	
	/**
	 * Metoda koja azurira izgled tabele studenata nakon svake izmene.
	 */
	public void updateViewStudent() {
		
		AbstractTableModelStudent modelStudent = (AbstractTableModelStudent) this.tab.tabelaStudenti.getModel();
		modelStudent.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna studente ");	
	}
	
	/**
	 * Metoda koja azurira izgled tabele profesora nakon svake izmene.
	 */
	public void updateViewProfesor() {
		
		AbstractTableModelProfesor modelProfesor = (AbstractTableModelProfesor) this.tab.tabelaProfesori.getModel();
		modelProfesor.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna profesore");	
	}
	
	/**
	 * Metoda koja azurira izgled tabele predmeta nakon svake izmene.
	 */
	public void updateViewPredmet() {
		
		AbstractTableModelPredmet modelPredmet = (AbstractTableModelPredmet) this.tab.tabelaPredmeti.getModel();
		modelPredmet.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna predmete");	
	}
	
	/**
	 * Metoda koja poziva tabove sa tabelama studenata, profesora i premeta.
	 */
	public void showTab() {
		this.tab = new Tab();
		this.add(tab, BorderLayout.CENTER);		
		this.updateViewStudent();
		this.updateViewProfesor();

	}
	
	
	
	
}
