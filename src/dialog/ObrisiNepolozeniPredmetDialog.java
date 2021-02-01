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
import controller.PredmetController;
import oisisi.NepolozeniJTable;
import oisisi.PredmetJTable;

/**
 * Dijalog za brisanje nepolozenog predmeta iz liste nepolozenih predmeta kod  studenta.
 * @author Branimir
 *
 */
public class ObrisiNepolozeniPredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8245831548255010482L;

	private static ObrisiNepolozeniPredmetDialog instance = null;
	
	/**
	 * Metoda koja pravi i vraca instancu dijaloga za brisanje studenta.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 * @return instance instanca dialoga
	 */
	public static ObrisiNepolozeniPredmetDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new ObrisiNepolozeniPredmetDialog(parent, title, modal);
		}
		return instance;
	}
	
	/**
	 * Konstruktor dijaloga za brisanje nepolozenog predmeta kod studenta. Tu su implementirane funkcionalnosti za
	 * potvrdu ili odustanak od brisanja predmeta iz baze nepolozenih predmeta, preko kontrolera.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 */
	public ObrisiNepolozeniPredmetDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
				
				int dialWidth= (parent.getSize().width)/3;
				int dialHeight = (parent.getSize().height*3/8);
				//Dimension dim = new Dimension(dialWidth*4/5, 50);
				
				setLayout(new BorderLayout());
				setSize(dialWidth, dialHeight);
				setLocationRelativeTo(parent);
				
				JLabel tekst = new JLabel("     Da li ste sigurni da zelite da obrisete predmet? ");
				JLabel stealth = new JLabel("  ");		
				
				JPanel panelDugmici = new JPanel();
				JButton obrisi = new JButton("Da");
				JButton nemoj = new JButton("Ne");
				
				obrisi.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						int id = NepolozeniJTable.getInstance().getSelectedRow();	
						NepolozeniController.getInstance().obrisiPredmet(id);
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
