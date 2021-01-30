/**
 * oisisi je view paket aplikacije, u njemu se nalaze sve graficke komponente, osim dijaloga koji imaju zaseban paket.
 */
package oisisi;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


/**
 * Klasa koja se koristi za kreiranje prozora za about.
 * @author Branimir
 *
 */
public class AATextArea extends JFrame{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6270508181557940307L;
	

	/**
	 * Konstruktor prozora koji sadrzi informacije o aplikaciji.
	 */
	public AATextArea() {
	 super();
	 setTitle("Tekstualne komponente");
	 setSize(400,400);
	 setLocationRelativeTo(null);
    //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 setVisible(true);
	 
	ImageIcon icon = new ImageIcon("images_mc/sign.png");
	setIconImage(icon.getImage());
	 
	 //panel za prikaz JTextArea
	 
	 JTextArea textArea=new JTextArea(" Autori \n Filip Pinjuh \n Branimir Maricic \n Vise informacija uskoro ",10,30);
	 textArea.setLineWrap(true);
	 textArea.setEditable(false);

		
	 JScrollPane scrollPane = new JScrollPane(textArea);
	 add(scrollPane,BorderLayout.EAST);
	 
	 add(textArea,BorderLayout.CENTER);
	 
	 //metoda pack se nalazi u klasi JFrame
	 pack();
    
}

}