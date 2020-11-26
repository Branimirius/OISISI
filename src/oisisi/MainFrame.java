package oisisi;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class MainFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2427219556160021852L;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NAJBOLJA STUDENTSKA SLUZBA EU :D");
		
		//scalujemo velicinu prozora u odnosu na screensize
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height*3/4;
		int screenWidth = screenSize.width*3/4;
	
		setSize(screenWidth, screenHeight);
		
		//centriranje prilikom otvaranja
		setLocationRelativeTo(null);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
