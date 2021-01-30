package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.NepolozeniController;
import model.BazaNepolozeniPredmeti;
import model.Predmet;
import oisisi.NepolozeniJTable;
import validation.DatumKeyListener;
import validation.GodUpisaKeyListener;
import validation.SamoSlovaKeyListener;

/**
 * Dijalog za unos ocene kod studenta, to jest polaganje predmeta.
 * @author Filip
 *
 */
public class UnosOceneDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static UnosOceneDialog instance = null;
	
	/**
	 * Metoda koja vraca/pravi instancu dijaloga za unos ocene kod studenta.
	 * @param parent roditeljski frejm
	 * @param title naslov
	 * @param modal modalnost
	 * @return instance
	 */
	public static UnosOceneDialog getInstance(JFrame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new UnosOceneDialog(parent, title, modal);
		}
		return instance;
	}
	
	private Predmet p;
	private String unesenaOcena;
	
	/**
	 * Konstruktor za dijalog unosa ocene kod studenta. Sastoji se od polja, labela i dugmica. 
	 * Polja se popunjavaju informacijama o oceni koja se upisuje, ako nije validno popunjeno, baca gresku.
	 * Ako nije sve popunjeno, dugme ce biti onemoguceno.
	 * @param parent roditeljski frejm
	 * @param title naslov
	 * @param modal modalnost
	 */
	public UnosOceneDialog(JFrame parent, String title, boolean modal) {
	super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)*2/5;
		int dialHeight = (parent.getSize().height*5/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
	
		int id = NepolozeniJTable.getInstance().getSelectedRow();
		if(id < 0) {
			return;
		}
		else {
			List<Predmet> pp = BazaNepolozeniPredmeti.getInstance().getPredmeti();
			p = pp.get(id);
		}
		
		JPanel panelSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelSifra = new JLabel("      Sifra*");
		labelSifra.setPreferredSize(dim);
		JTextField txtSifra = new JTextField(p.getIdPredmeta());
		txtSifra.setPreferredSize(dim);	
		txtSifra.setEditable(false);
		panelSifra.add(labelSifra);
		panelSifra.add(txtSifra);
		
		JPanel panelNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelNaziv = new JLabel("      Naziv*");
		labelNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField(p.getNazivPredmeta());
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setEditable(false);
		KeyListener SamoSlovaListenerNaziv = new SamoSlovaKeyListener();
		txtNaziv.addKeyListener(SamoSlovaListenerNaziv);
		panelNaziv.add(labelNaziv);
		panelNaziv.add(txtNaziv);
		
		JPanel panelOcena = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelOcena = new JLabel("      Ocena*");
		labelOcena.setPreferredSize(dim);
		JTextField txtOcena = new JTextField();
		txtOcena.setPreferredSize(dim);
		KeyListener godListener = new GodUpisaKeyListener();
		txtOcena.addKeyListener(godListener);
		panelOcena.add(labelOcena);
		panelOcena.add(txtOcena);
		
		JPanel panelDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelDatum = new JLabel("      Datum Polaganja*");
		labelDatum.setPreferredSize(dim);
		JTextField txtDatum = new JTextField("dd/MM/yyyy");
		txtDatum.setPreferredSize(dim);
		KeyListener datumKeyListener = new DatumKeyListener();
		txtOcena.addKeyListener(datumKeyListener);
		panelDatum.add(labelDatum);
		panelDatum.add(txtDatum);
		
		JPanel panelDugmici = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		 potvrdi.setBackground(Color.GREEN);
		 potvrdi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = NepolozeniJTable.getInstance().getSelectedRow();
					NepolozeniController.getInstance().Polaganje(txtOcena.getText(), txtDatum.getText(), id);
					//setUnesenaOcena(txtOcena.getText());
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
			boxCentar.add(panelSifra);
			boxCentar.add(panelNaziv);
			boxCentar.add(panelOcena);
			boxCentar.add(panelDatum);
			
			add(boxCentar, BorderLayout.NORTH);
			add(panelDugmici, BorderLayout.SOUTH);
	}

	public String getUnesenaOcena() {
		return unesenaOcena;
	}

	public void setUnesenaOcena(String unesenaOcena) {
		this.unesenaOcena = unesenaOcena;
	}


	
}
