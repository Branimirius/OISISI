package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.ButtonControllerPredmet;
import controller.PredmetController;
import model.Semestar;
import validation.EspbKeyListener;
import validation.GodIzvodjenjaKeyListener;
import validation.SamoSlovaKeyListener;

/**
 * Dijalog pomocu koga se dodaje novi predmet u tabelu prikaza predmeta
 * @author Branimir
 *
 */
public class NewPredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4843464385947003961L;

private static NewPredmetDialog instance = null;
	
	/**
	 * Metoda koja pravi i vraca instancu dijaloga za dodavanje predmeta.
	 * @param parent roditeljski frejm
	 * @param title naslov dijaloga
	 * @param modal boolean(da li je modalan?) 
	 * @return instance instanca dialoga
	 */
	public static NewPredmetDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new NewPredmetDialog(parent, title, modal);
		}
		return instance;
	}
	
	/**
	 * Kostruktor dijaloga za dodavanje novog predmeta u tabelu prikaza predmeta, sastoji se od parova labela i text polja,
	 * labele oznacavaju potrebne informacije za kreiranje novog predmeta dok txtField-ovi sluze za preuzimanje tih istih informacija.
	 * Dugme "Potrvdi" kreira predmeta sa unetim informacijama, dugme "Odustani" gasi ovaj dialog, beze sacuvavanja
	 * Uzima dimenzije u odnosu na roditeljski frejm.
	 * @param parent roditeljski frejm
	 * @param title naslov
	 * @param modal modalnost
	 */
	public NewPredmetDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		JPanel panelNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelNaziv = new JLabel("      Naziv predmeta*");
		labelNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		KeyListener SamoSlovaListener = new SamoSlovaKeyListener();		
		txtNaziv.addKeyListener(SamoSlovaListener);		
		panelNaziv.add(labelNaziv);
		panelNaziv.add(txtNaziv);
		
		JPanel panelSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelSifra = new JLabel("      Sifra predmeta*");
		labelSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		//KeyListener SifraListener = new SamoSlovaKeyListener();		
		//txtSifra.addKeyListener(SamoSlovaListener);		
		panelSifra.add(labelSifra);
		panelSifra.add(txtSifra);
		
		JPanel panelESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelESPB = new JLabel("      Broj ESPB bodova*");
		labelESPB.setPreferredSize(dim);
		JTextField txtESPB = new JTextField();
		txtESPB.setPreferredSize(dim);
		KeyListener ESPBListener = new EspbKeyListener();
		txtESPB.addKeyListener(ESPBListener);
		panelESPB.add(labelESPB);
		panelESPB.add(txtESPB);
		
		JPanel panelGod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelGod = new JLabel("      Godina izvodjenja*");
		labelGod.setPreferredSize(dim);
		JTextField txtGod = new JTextField();
		txtGod.setPreferredSize(dim);
		KeyListener godListener = new GodIzvodjenjaKeyListener();
		txtGod.addKeyListener(godListener);
		panelGod.add(labelGod);
		panelGod.add(txtGod);
		
		JPanel panelSemestar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelSemestar = new JLabel("      Semestar*");
		labelSemestar.setPreferredSize(dim);
		String semestar[] = { "Zimski", "Letnji"};
		JComboBox<String> comboSemestar = new JComboBox<String>(semestar);
		comboSemestar.setPreferredSize(dim);				
		panelSemestar.add(labelSemestar);
		panelSemestar.add(comboSemestar);
		
		JPanel panelDugmici = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		 potvrdi.setBackground(Color.GREEN);
		 
		 potvrdi.setEnabled(false); //resavanje potvrdi dugmeta
		 Document documentNaziv = txtNaziv.getDocument();
		 documentNaziv.addDocumentListener(new ButtonControllerPredmet(potvrdi, 0));
		 Document documentESPB = txtESPB.getDocument();
		 documentESPB.addDocumentListener(new ButtonControllerPredmet(potvrdi, 1));
		 Document documentGod = txtGod.getDocument();
		 documentGod.addDocumentListener(new ButtonControllerPredmet(potvrdi, 2));
		 
		 potvrdi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {															
					
					int espb = Integer.parseInt(txtESPB.getText());
					if(espb > 30) {
						JOptionPane.showMessageDialog(null, "Maksimalan broj espb po predmetu je 30.");
					}
					else {
					
					PredmetController.getInstance().dodajPredmet(txtSifra.getText(), txtNaziv.getText(), stringToSemestar(semestar[comboSemestar.getSelectedIndex()]), Integer.parseInt(txtGod.getText()), 
							null, Integer.parseInt(txtESPB.getText()), null, null);
				    
					
					}
				}
			});
		 
		 JButton odustani = new JButton("Odustani");
			odustani.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			JLabel stealth = new JLabel();
			stealth.setPreferredSize(new Dimension(30,20));
			panelDugmici.add(potvrdi);
			panelDugmici.add(stealth);
			panelDugmici.add(odustani); 
			
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelNaziv);
		boxCentar.add(panelSifra);
		boxCentar.add(panelESPB);
		boxCentar.add(panelGod);
		boxCentar.add(panelSemestar);
		
		add(boxCentar, BorderLayout.NORTH);
		add(panelDugmici, BorderLayout.SOUTH);
	
	}
	
	/**
	 * Metoda koja prebacuje izabrani semestar iz stringa u enum Semestar.
	 * @param semestar string naziv semestra
	 * @return semestar enum
	 */
	public Semestar stringToSemestar(String semestar) {
		switch (semestar) {
		case "Zimski":
			return Semestar.ZIMSKI;			
		case "Letnji":
			return Semestar.LETNJI;
		default:
			return null;
		}
	}
}
