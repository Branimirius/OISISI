package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StudentController;
import oisisi.StudentJTable;

/**
 * Dijalog za brisanje studenta, predstavlja "pop out" prozor koji trazi od korisnika potvrdu brisanja studenta.
 * @author Branimir
 *
 */
public class DeleteStudentDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 54699537888204593L;
	
	private static DeleteStudentDialog instance = null;
	
	/**
	 * Metoda koja pravi i vraca instancu dijaloga za brisanje studenta.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 * @return instance instanca dijaloga
	 */
	public static DeleteStudentDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new DeleteStudentDialog(parent, title, modal);
		}
		return instance;
	}
	
	/**
	 * Konstruktor dijaloga za brisanje studenta,
	 * Unutar ovog konstruktora implementirani su dugmici za potvrdu ili odustanak od brisanja studenta koji je selektovan u tabeli. 
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?)
	 */
	public DeleteStudentDialog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/3;
		int dialHeight = (parent.getSize().height*3/8);
		//Dimension dim = new Dimension(dialWidth*4/5, 50);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		JLabel tekst = new JLabel("     Da li ste sigurni da zelite da obrisete studenta? ");
		JLabel stealth = new JLabel("  ");		
		
		JPanel panelDugmici = new JPanel();
		JButton obrisi = new JButton("Da");
		JButton nemoj = new JButton("Ne");
		
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = StudentJTable.getInstance().getSelectedRow();	
				StudentController.getInstance().izbrisiStudenta(id);
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
