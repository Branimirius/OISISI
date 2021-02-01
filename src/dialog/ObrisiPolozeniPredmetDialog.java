package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.NepolozeniController;
import controller.OceneController;
import oisisi.NepolozeniJTable;
import oisisi.PolozeniJTable;

/**
 * Dijalog koji sluzi za ponistavanje predmeta, tj. uklanjanje predmeta sa liste polozenih, i dodavanje istog
 * na listu ne polozenih unutar studenta.
 * @author Branimir
 *
 */
public class ObrisiPolozeniPredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7857530925277765202L;

	
	private static ObrisiPolozeniPredmetDialog instance = null;
	

	/**
	 * Metoda koja pravi i vraca instancu dijaloga za brisanje studenta.
     * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 */
	public static ObrisiPolozeniPredmetDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new ObrisiPolozeniPredmetDialog(parent, title, modal);
		}
		return instance;
	}
	
	/**
	 * Konstruktor dijaloga za brisanje polozenog predmeta kod studenta. Tu su implementirane funkcionalnosti za
	 * potvrdu ili odustanak od brisanja predmeta iz baze ocena, preko kontrolera.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 */
	public ObrisiPolozeniPredmetDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
				
				int dialWidth= (parent.getSize().width)/3;
				int dialHeight = (parent.getSize().height*3/8);
				//Dimension dim = new Dimension(dialWidth*4/5, 50);
				
				setLayout(new BorderLayout());
				setSize(dialWidth, dialHeight);
				setLocationRelativeTo(parent);
				
				JLabel tekst = new JLabel("     Da li ste sigurni da zelite da ponistite ocenu? ");
				JLabel stealth = new JLabel("  ");		
				
				JPanel panelDugmici = new JPanel();
				JButton obrisi = new JButton("Da");
				JButton nemoj = new JButton("Ne");
				
				obrisi.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						int id = PolozeniJTable.getInstance().getSelectedRow();	
						OceneController.getInstance().ponistiOcenu(id);
						dispose();
					}
					
					
				});
				
				nemoj.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {								
						dispose();
					}
				});
				
				panelDugmici.add(obrisi);
				panelDugmici.add(stealth);
				panelDugmici.add(nemoj);
				
				add(tekst, BorderLayout.CENTER);
				add(panelDugmici, BorderLayout.SOUTH);
	}
}
