package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;

import oisisi.TabIzmenaPredmeta;
import oisisi.TabIzmenaStudenta;

public class EditPredmetDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8107825761383362454L;

	private static EditPredmetDialog instance = null;
	
	public static EditPredmetDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new EditPredmetDialog(parent, title, modal);
		}
		return instance;
	}
	
	public EditPredmetDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		TabIzmenaPredmeta tabIzmena = TabIzmenaPredmeta.getInstance(dim);
		add(tabIzmena);
		
		
			
		
	}
	
}
