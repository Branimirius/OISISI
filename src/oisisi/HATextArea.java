package oisisi;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;


public class HATextArea extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1860111951298993987L;

	public HATextArea() {
	 super();
	 setTitle("Tekstualne komponente");
	 setSize(400,400);
	 setLocationRelativeTo(null);
    //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 setVisible(true);
	 
	 
	 //panel za prikaz JTextArea
	 
	 JTextArea textArea=new JTextArea("pomocicemo vam \n  Pomocicemo Vam \n\n\n\n\n EEEVO momenat samo ",10,30);
	 textArea.setLineWrap(true);
	 textArea.setEditable(false);

		
	 JScrollPane scrollPane = new JScrollPane(textArea);
	 add(scrollPane,BorderLayout.EAST);
	 
	 add(textArea,BorderLayout.CENTER);
	 
	 //metoda pack se nalazi u klasi JFrame
	 pack();
    
}

}
