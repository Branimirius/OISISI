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

import controller.ProfesorController;
import oisisi.ProfesorJTable;

/**
 * Dijalog za brisanje profesora. Sastoji se od konstruktora dijaloga unutar koga su implementirane 
 * sve potrebne funkcionalnosti.
 * @author Branimir
 *
 */
public class DeleteProfesorDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -996656305975062013L;

	private static DeleteProfesorDialog instance = null;
	
	/**
	 * Metoda koja vraca instancu dijaloga za brisanje profesora.
	 * Kao parametre prima roditeljski frejm, naslov dijaloga i istinitosnu vrednost da li je modalan ili ne.
	 * @param parent
	 * @param title
	 * @param modal
	 * @return instance
	 */
	public static DeleteProfesorDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new DeleteProfesorDialog(parent, title, modal);
		}
		return instance;
	}
	
	/**
	 * Konstruktor dijaloga za brisanje profesora,
	 *  kao parametre prima roditeljski frejm, naslov dijaloga i istinitosnu vrednost da li je modalan ili ne.
	 * Unutar ovog konstruktora implementirani su dugmici za potvrdu ili odustanak od brisanja profesora koji je selektovan u tabeli. 
	 * @param parent roditeljski frejm
	 * @param title naslov
	 * @param modal modalnost 
	 */
	public DeleteProfesorDialog(Frame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/3;
		int dialHeight = (parent.getSize().height*3/8);
		//Dimension dim = new Dimension(dialWidth*4/5, 50);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		JLabel tekst = new JLabel("     Da li ste sigurni da zelite da obrisete profesora? ");
		JLabel stealth = new JLabel("  ");		
		
		JPanel panelDugmici = new JPanel();
		JButton obrisi = new JButton("Da");
		JButton nemoj = new JButton("Ne");
		
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = ProfesorJTable.getInstance().getSelectedRow();	
				ProfesorController.getInstance().izbrisiProfesora(id);
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
