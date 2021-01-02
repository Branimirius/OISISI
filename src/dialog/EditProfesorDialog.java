package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;

import oisisi.TabIzmenaProfesora;


public class EditProfesorDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static EditProfesorDialog instance = null;
	
	public static EditProfesorDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new EditProfesorDialog(parent, title, modal);
		}
		return instance;
	}
	
	public EditProfesorDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		TabIzmenaProfesora tabIzmena = TabIzmenaProfesora.getInstance(dim);
		add(tabIzmena);
		
	}

	
}
