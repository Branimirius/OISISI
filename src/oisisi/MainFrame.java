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
 * MainFrame klasa predstavalja  glavni prozor aplikacije, instanca ove klase se poziva u Main klasi.
 * Osnova cele studentske sluzbe.
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
	 * Metoda koja kreira i vraca instancu klase MainFrame.
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
	 * Konstruktor u kome je definisan izgled glavnog prozora aplikacije.
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
	 * Metoda koja sluzi za azuriranje izgleda tabele studenata, 
	 * poziva se nakon svake promene te tabele.
	 */
	public void updateViewStudent() {
		
		AbstractTableModelStudent modelStudent = (AbstractTableModelStudent) this.tab.tabelaStudenti.getModel();
		modelStudent.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna studente ");	
	}
	
	/**
	 * Metoda koja sluzi za azuriranje izgleda tabele profesora, 
	 * poziva se nakon svake promene te tabele.
	 */
	public void updateViewProfesor() {
		
		AbstractTableModelProfesor modelProfesor = (AbstractTableModelProfesor) this.tab.tabelaProfesori.getModel();
		modelProfesor.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna profesore");	
	}
	
	/**
	 * Metoda koja sluzi za azuriranje izgleda tabele predmeta, 
	 * poziva se nakon svake promene te tabele.
	 */
	public void updateViewPredmet() {
		
		AbstractTableModelPredmet modelPredmet = (AbstractTableModelPredmet) this.tab.tabelaPredmeti.getModel();
		modelPredmet.fireTableDataChanged();
		validate();
		System.out.println("azuriro iz mejna predmete");	
	}
	
	/**
	 * Metoda koja kreira tab, na kome se nalaze tabovi studenata, profesora i predmeta,
	 * zatim updatuje tabelu studenata i tabelu profesora
	 */
	public void showTab() {
		this.tab = new Tab();
		this.add(tab, BorderLayout.CENTER);		
		this.updateViewStudent();
		this.updateViewProfesor();

	}
	
	
	
	
}
