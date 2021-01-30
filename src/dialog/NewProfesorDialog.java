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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.text.Document;

import controller.ButtonController;
import controller.ProfesorController;
import model.Titula;
import model.Zvanje;
import validation.AdrKeyListener;
import validation.BrTelKeyListener;
import validation.DatumKeyListener;
import validation.LicnaKartaKeyListener;
import validation.MailKeyListener;
import validation.SamoSlovaKeyListener;

import javax.swing.JComboBox;

/**
 * Dijalog za dodavanje novog profesora u tabelu svih profesora.
 * @author Filip
 *
 */
public class NewProfesorDialog  extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor dijaloga za dodavanje novog profesora u tabelu profesora, sastoji se od polja za svaku potrebnu informaciju,
	 * dugmica za odustanak ili potvrdu. Ukoliko polja nisu validno popunjena, bacice gresku. Ukoliko nisu sva polja popunjena,
	 * onemogucava pritisak dugmeta za potvrdu.
	 * Uzima dimenzije u odnosu na roditeljski frejm.
	 * @param parent roditeljski frejm
	 * @param title naslov
	 * @param modal modalnost
	 */
	public NewProfesorDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelPrezime = new JLabel("      Prezime*");
		labelPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		KeyListener SamoSlovaListener = new SamoSlovaKeyListener();
		txtPrezime.addKeyListener(SamoSlovaListener);
		txtPrezime.setPreferredSize(dim);
		panelPrezime.add(labelPrezime);
		panelPrezime.add(txtPrezime);
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelIme = new JLabel("      Ime*");
		labelIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		KeyListener SamoSlovaListenerime = new SamoSlovaKeyListener();
		txtIme.addKeyListener(SamoSlovaListenerime);
		panelIme.add(labelIme);
		panelIme.add(txtIme);
		
		JPanel panelDatRod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelDatRod = new JLabel("      Datum rodjenja*");
		labelDatRod.setPreferredSize(dim);
		JTextField txtDatRod = new JTextField("dd/MM/yyyy");
		KeyListener datumListener = new DatumKeyListener();
		txtDatRod.addKeyListener(datumListener);
		txtDatRod.setPreferredSize(dim);
		panelDatRod.add(labelDatRod);
		panelDatRod.add(txtDatRod);
		
		JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelAdresa = new JLabel("      Adresa stanovanja*");
		labelAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dim);
		KeyListener adresaListener = new AdrKeyListener();
		txtAdresa.addKeyListener(adresaListener);
		panelAdresa.add(labelAdresa);
		panelAdresa.add(txtAdresa);
		
		JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelTel = new JLabel("      Kontakt telefon*");
		labelTel.setPreferredSize(dim);
		JTextField txtTel = new JTextField();
		KeyListener brTelListener = new BrTelKeyListener();
		txtTel.addKeyListener(brTelListener);
		txtTel.setPreferredSize(dim);
		panelTel.add(labelTel);
		panelTel.add(txtTel);
		
		JPanel panelMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelMail = new JLabel("      E-mail adresa*");
		labelMail.setPreferredSize(dim);
		JTextField txtMail = new JTextField();
		KeyListener mailListener = new MailKeyListener();
		txtMail.addKeyListener(mailListener);
		txtMail.setPreferredSize(dim);
		panelMail.add(labelMail);
		panelMail.add(txtMail);
		
		JPanel panelBrLicne = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelBrLicne = new JLabel("      Broj Licne Karte*");
		labelBrLicne.setPreferredSize(dim);
		JTextField txtBrLicne = new JTextField();
		KeyListener licnaKartaListener = new LicnaKartaKeyListener();
		txtBrLicne.addKeyListener(licnaKartaListener);
		txtBrLicne.setPreferredSize(dim);
		panelBrLicne.add(labelBrLicne);
		panelBrLicne.add(txtBrLicne);

		JPanel panelTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelTitula = new JLabel("      Titula*");
		labelTitula.setPreferredSize(dim);
		String titule[] = {"BSc", "MSc", "mr", "dr", "prof. dr"};
		JComboBox<String> comboTitula = new JComboBox<String>(titule);
		comboTitula.setPreferredSize(dim);
		panelTitula.add(labelTitula);
		panelTitula.add(comboTitula);
		
		JPanel panelZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelZvanje = new JLabel("      Zvanje*");
		labelZvanje.setPreferredSize(dim);
		String zvanja[] = {"Saradnik u nastavi", "Asistent", "Asistent sa doktoratom", "Docent", "Vanredni profesor", "Redovni profesor", "Profesor emeritus"};
		JComboBox<String> comboZvanje = new JComboBox<String>(zvanja);
		comboZvanje.setPreferredSize(dim);
		panelZvanje.add(labelZvanje);
		panelZvanje.add(comboZvanje);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelPrezime);
		boxCentar.add(panelIme);
		boxCentar.add(panelDatRod);
		boxCentar.add(panelAdresa);
		boxCentar.add(panelTel);
		boxCentar.add(panelMail);
		boxCentar.add(panelBrLicne);
		boxCentar.add(panelTitula);
		boxCentar.add(panelZvanje);
		
		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		 potvrdi.setBackground(Color.GREEN);
		 
		 potvrdi.setEnabled(false); //resavanje potvrdi dugmeta
		 Document documentPrz = txtPrezime.getDocument();
		 documentPrz.addDocumentListener(new ButtonController(potvrdi, 0));
		 Document documentIme = txtIme.getDocument();
		 documentIme.addDocumentListener(new ButtonController(potvrdi, 1));
		 Document documentDatRod = txtDatRod.getDocument();
		 documentDatRod.addDocumentListener(new ButtonController(potvrdi, 2));
		 Document documentAdresa = txtAdresa.getDocument();
		 documentAdresa.addDocumentListener(new ButtonController(potvrdi, 3));
		 Document documentTel = txtTel.getDocument();
		 documentTel.addDocumentListener(new ButtonController(potvrdi, 4));
		 Document documentMail = txtMail.getDocument();
		 documentMail.addDocumentListener(new ButtonController(potvrdi, 5));
		 Document documentBrLicne = txtBrLicne.getDocument();
		 documentBrLicne.addDocumentListener(new ButtonController(potvrdi, 6));
		 
		 potvrdi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ProfesorController.getInstance().dodajProfesora(txtPrezime.getText(), txtIme.getText(), 
							txtDatRod.getText(), txtAdresa.getText(), txtTel.getText(), txtMail.getText(), txtBrLicne.getText(), 
							stringToTitula(titule[comboTitula.getSelectedIndex()]), stringToZvanje(zvanja[comboZvanje.getSelectedIndex()]), null);
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
		panelButtons.add(potvrdi);
		panelButtons.add(stealth);
		panelButtons.add(odustani);
		 
		
		add(boxCentar, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.SOUTH);
	}
	
	/**
	 * Metoda koja prebacuje vrednost titule profesora iz tipa string u tip enum Titula.
	 * @param t string titula
	 * @return titula enum
	 */
	public Titula  stringToTitula(String t) {
		switch(t) {
		case "BSc":
			return Titula.BSC;
		case "MSc":
			return Titula.MSC;
		case "mr":
			return Titula.MR;
		case "dr":
			return Titula.DR;
		case "prof. dr":
			return Titula.PROF_DR;
		default:
			return null;
		}
	}
	
	/**
	 * Metoda koja prebacuje vrednost zvanja profesora iz tipa string u tip enum Zvanje.
	 * @param z string zvanje
	 * @return zvanje enum
	 */
	public Zvanje stringToZvanje(String z) {
		switch(z) {
		case "Saradnik u nastavi":
			return Zvanje.SARADNIK_U_NASTAVI;
		case "Asistent":
			return Zvanje.ASISTENT;
		case "Asistent sa doktoratom":
			return Zvanje.ASISTENT_SA_DOKTORATOM;
		case "Docent":
			return Zvanje.DOCENT;
		case "Vanredni profesor":
			return Zvanje.VANREDNI_PROFESOR;
		case "Redovni profesor":
			return Zvanje.REDOVNI_PROFESOR;
		case "Profesor emeritus":
			return Zvanje.PROFESOR_EMERITUS;
		default:
			return null;
		}
	}
}

