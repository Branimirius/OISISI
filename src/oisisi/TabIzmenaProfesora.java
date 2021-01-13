package oisisi;

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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.ButtonController;
import controller.ProfesorController;
import model.BazaNepolozeniPredmeti;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Titula;
import model.Zvanje;
import validation.AdrKeyListener;
import validation.BrTelKeyListener;
import validation.DatumKeyListener;
import validation.LicnaKartaKeyListener;
import validation.MailKeyListener;
import validation.SamoSlovaKeyListener;

public class TabIzmenaProfesora extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Profesor p;
	
	private static TabIzmenaProfesora instance = null;

	public static TabIzmenaProfesora getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabIzmenaProfesora(dim);
		}
		return instance;
	}
	
	public TabIzmenaProfesora(Dimension dim) {
		int id = ProfesorJTable.getInstance().getSelectedRow();
		if(id < 0) {
			return;
		}
		else {
			List<Profesor> pp = BazaProfesora.getInstance().getProfesori();
			p = pp.get(id);
		}
		
		JPanel informacijePanel = new JPanel();
		informacijePanel.setLayout(new BorderLayout());
		
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelPrezime = new JLabel("      Prezime*");
		labelPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField(p.getPrezime());
		KeyListener SamoSlovaListener = new SamoSlovaKeyListener();
		txtPrezime.addKeyListener(SamoSlovaListener);
		txtPrezime.setPreferredSize(dim);
		panelPrezime.add(labelPrezime);
		panelPrezime.add(txtPrezime);
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelIme = new JLabel("      Ime*");
		labelIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField(p.getIme());
		txtIme.setPreferredSize(dim);
		KeyListener SamoSlovaListenerime = new SamoSlovaKeyListener();
		txtIme.addKeyListener(SamoSlovaListenerime);
		panelIme.add(labelIme);
		panelIme.add(txtIme);
		
		JPanel panelDatRod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelDatRod = new JLabel("      Datum rodjenja*");
		labelDatRod.setPreferredSize(dim);
		JTextField txtDatRod = new JTextField(p.getDatumRodjString());
		KeyListener datumListener = new DatumKeyListener();
		txtDatRod.addKeyListener(datumListener);
		txtDatRod.setPreferredSize(dim);
		panelDatRod.add(labelDatRod);
		panelDatRod.add(txtDatRod);
		
		JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelAdresa = new JLabel("      Adresa stanovanja*");
		labelAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField(p.getAdresaStanovanja());
		txtAdresa.setPreferredSize(dim);
		KeyListener adresaListener = new AdrKeyListener();
		txtAdresa.addKeyListener(adresaListener);
		panelAdresa.add(labelAdresa);
		panelAdresa.add(txtAdresa);
		
		JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelTel = new JLabel("      Kontakt telefon*");
		labelTel.setPreferredSize(dim);
		JTextField txtTel = new JTextField(p.getKontaktTelefon());
		KeyListener brTelListener = new BrTelKeyListener();
		txtTel.addKeyListener(brTelListener);
		txtTel.setPreferredSize(dim);
		panelTel.add(labelTel);
		panelTel.add(txtTel);
		
		JPanel panelMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelMail = new JLabel("      E-mail adresa*");
		labelMail.setPreferredSize(dim);
		JTextField txtMail = new JTextField(p.getEmailAdresa());
		KeyListener mailListener = new MailKeyListener();
		txtMail.addKeyListener(mailListener);
		txtMail.setPreferredSize(dim);
		panelMail.add(labelMail);
		panelMail.add(txtMail);
		
		JPanel panelBrLicne = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelBrLicne = new JLabel("      Broj Licne Karte*");
		labelBrLicne.setPreferredSize(dim);
		JTextField txtBrLicne = new JTextField(p.getBrLicneKarte());
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
		comboTitula.setSelectedItem(titulaToString(p.getTitula()));
		panelTitula.add(labelTitula);
		panelTitula.add(comboTitula);
		
		JPanel panelZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelZvanje = new JLabel("      Zvanje*");
		labelZvanje.setPreferredSize(dim);
		String zvanja[] = {"Saradnik u nastavi", "Asistent", "Asistent sa doktoratom", "Docent", "Vanredni profesor", "Redovni profesor", "Profesor emeritus"};
		JComboBox<String> comboZvanje = new JComboBox<String>(zvanja);
		comboZvanje.setPreferredSize(dim);
		comboZvanje.setSelectedItem(zvanjeToString(p.getZvanje()));
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
					int id = ProfesorJTable.getInstance().getSelectedRow();					
					ProfesorController.getInstance().izmeniProfesora(id, txtPrezime.getText(), txtIme.getText(),
							txtDatRod.getText(), txtAdresa.getText(), txtTel.getText(), txtMail.getText(), txtBrLicne.getText(), 
							stringToTitula(titule[comboTitula.getSelectedIndex()]), stringToZvanje(zvanja[comboZvanje.getSelectedIndex()]), null);
				}
			});
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		JLabel stealth = new JLabel();
		stealth.setPreferredSize(new Dimension(30,20));
		panelButtons.add(potvrdi);
		panelButtons.add(stealth);
		panelButtons.add(odustani);
		 
		
		informacijePanel.add(boxCentar, BorderLayout.NORTH);
		informacijePanel.add(panelButtons, BorderLayout.SOUTH);
		
		add("Informacije", informacijePanel);
	}
	
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

	public String titulaToString(Titula t) {
		switch(t) {
		case BSC:
			return "BSc";
		case MSC:
			return "MSc";
		case MR:
			return "mr";
		case DR:
			return "dr";
		case PROF_DR:
			return "prof. dr";
		default:
			return null;
		}
	}
	
	public String zvanjeToString(Zvanje z) {
		switch(z) {
		case SARADNIK_U_NASTAVI:
			return "Saradnik u nastavi";
		case ASISTENT:
			return "Asistent";
		case ASISTENT_SA_DOKTORATOM:
			return "Asistent sa doktoratom";
		case DOCENT:
			return "Docent";
		case VANREDNI_PROFESOR:
			return "Vandredni profesor";
		case REDOVNI_PROFESOR:
			return "Redovni profesor";
		case PROFESOR_EMERITUS:
			return "Profesor emeritus";
		default:
			return null;
		}
	}
	
}
