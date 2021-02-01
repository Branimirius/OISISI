package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.BazaOcena;
import oisisi.AbstractTableModelNepolozeni;
import oisisi.NepolozeniJTable;
import oisisi.PolozeniJTable;
import oisisi.TabIzmenaStudenta;
import oisisi.TabNepolozeniPredmeti;
import oisisi.TabPolozeniPredmeti;

/**
 * Dijalog za izmenu studenta.
 * @author Branimir
 *
 */
public class EditStudentDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2721472932824768104L;
	
	private static EditStudentDialog instance = null;
	
	/**
	 * Metoda koja kreira i vraca instancu dijaloga za izmenu studenta.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 * @return instance instanca dialoga
	 */
	public static EditStudentDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new EditStudentDialog(parent, title, modal);
		}
		return instance;
	}
	
	private Dimension dim;	
	private TabIzmenaStudenta tabIzmena;
	
	/**
	 * Metoda koja sluzi za kreiranje taba na kome ce se nalaziti TabIzmenaStudenta
	 * Moglo je sve da stoji unutar kontruktora bez ove funkcije
	 * 
	 */
	public void showTabIzmena(){
		this.tabIzmena = new TabIzmenaStudenta(dim);
		this.add(tabIzmena);
		this.updateViewNepolozeni();
	}
	
	/**
	 * Konstruktor dijaloga za izmenu studenta.
	 * Poziva tab za izmenu, na kome se nalaze svi potrebni elementi.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 */
	public EditStudentDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		showTabIzmena();

	}
	
/**
 * Metoda koja azurira tabelu nepolozenih predmeta preko abstraktnog modela te jtabele.
 */
public void updateViewNepolozeni() {
		
		AbstractTableModelNepolozeni modelNepolozeni = (AbstractTableModelNepolozeni) NepolozeniJTable.getInstance().getModel();
		modelNepolozeni.fireTableDataChanged();
		validate();
	}
}
