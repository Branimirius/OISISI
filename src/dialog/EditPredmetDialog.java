package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;

import oisisi.TabIzmenaPredmeta;
import oisisi.TabIzmenaStudenta;

/**
 * Dijalog za izmenu predmeta.
 * @author Branimir
 *
 */
public class EditPredmetDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8107825761383362454L;

	private static EditPredmetDialog instance = null;
	
	/**
	 * Metoda koja kreira i vraca instancu dijaloga za izmenu predmeta.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 * @return instance instanca dialoga
	 */
	public static EditPredmetDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new EditPredmetDialog(parent, title, modal);
		}
		return instance;
	}
	
	/**
	 * Konstruktor dijaloga za izmenu predmeta, 
	 * koji sluzi za kreiranje taba na kome ce se nalaziti TabIzmenapredmeta
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 */
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
