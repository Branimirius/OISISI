package oisisi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * Klasa koja se koristi za kreiranje help prozora
 * @author Branimir
 *
 */
public class HATextArea extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1860111951298993987L;

	/**
	 * Konstruktor prozora koji sadrzi pomocne informacije (help).
	 */
	public HATextArea() {
	 super();
	 setTitle("Tekstualne komponente");
	 setSize(1000,600);
	 setLocationRelativeTo(null);
    //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 setVisible(true);
	 
	ImageIcon icon = new ImageIcon("images_mc/map.png");
	setIconImage(icon.getImage());
	 
	 //panel za prikaz JTextArea
	 
	 JTextArea textArea=new JTextArea("  Glavni prozor se sastoji iz MenuBar-a, ToolBar-a i StatusBar-a za sada. \n"
	 		+ "Opcije menu bara: File, Edit i Help. \n File opcije: New (Ctrl+N), Close (Ctrl+C). \n"
	 		+ " Edit opcije: Edit (Ctrl+E) i Delete (Ctrl+D).\n"
	 		+ " Help opcije: Help (Ctrl+H) i About (Ctrl+A). \n"
	 		+ "Tool bar se sastoji od: dugmica --> New (Alt+N), Edit (Alt+E) i Delete (Alt+D). \n"
	 		+ "  Pored dugmica, tu je i search bar sa druge strane. \n Za sada postoji jos i status bar koji "
	 		+ "zauzima samo dno prozora i prikazuje nam\n labelu sa natpisom studentske sluzbe, datum i vreme. \n ",10,30);
	 
	 Dimension textSize = textArea.getSize();
	 int textWidth = textSize.width;
	 int textHeight = textSize.height;
	 setSize(textWidth,textHeight);
	 
	 textArea.setLineWrap(true);
	 textArea.setEditable(false);

		
	 JScrollPane scrollPane = new JScrollPane(textArea);
	 add(scrollPane,BorderLayout.EAST);
	 
	 add(textArea,BorderLayout.CENTER);
	 
	 //metoda pack se nalazi u klasi JFrame
	 pack();
    
}

}
