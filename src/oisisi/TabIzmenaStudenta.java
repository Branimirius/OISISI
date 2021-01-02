package oisisi;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.ButtonControllerStudent;
import controller.StudentController;
import dialog.EditStudentDialog;
import model.Status;
import validation.AdrKeyListener;
import validation.BrTelKeyListener;
import validation.DatumKeyListener;
import validation.GodUpisaKeyListener;
import validation.IndexKeyListener;
import validation.MailKeyListener;
import validation.SamoSlovaKeyListener;

public class TabIzmenaStudenta extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492311871537969696L;
	
	private static TabIzmenaStudenta instance = null;

	public static TabIzmenaStudenta getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabIzmenaStudenta(dim);
		}
		return instance;
	}
	
	
	public TabIzmenaStudenta(Dimension dim) {
		JPanel informacijePanel = new JPanel();
		informacijePanel.setLayout(new BorderLayout());
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelIme = new JLabel("      Ime*");
		labelIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		KeyListener SamoSlovaListener = new SamoSlovaKeyListener();		
		txtIme.addKeyListener(SamoSlovaListener);		
		panelIme.add(labelIme);
		panelIme.add(txtIme);
		
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelPrezime = new JLabel("      Prezime*");
		labelPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		//txtPrezime.addActionListener(actionListener);
		KeyListener SamoSlovaListenerPrezime = new SamoSlovaKeyListener();
		txtPrezime.addKeyListener(SamoSlovaListenerPrezime);
		panelPrezime.add(labelPrezime);
		panelPrezime.add(txtPrezime);
		
		JPanel panelDatRod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelDatRod = new JLabel("      Datum rodjenja*");
		labelDatRod.setPreferredSize(dim);
		JTextField txtDatRod = new JTextField("dd/MM/yyyy");
		txtDatRod.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener datumKeyListener = new DatumKeyListener();
		txtDatRod.addKeyListener(datumKeyListener);
		panelDatRod.add(labelDatRod);
		panelDatRod.add(txtDatRod);
		
		JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelAdresa = new JLabel("      Adresa stanovanja*");
		labelAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener adresaListener = new AdrKeyListener();
		txtAdresa.addKeyListener(adresaListener);
		panelAdresa.add(labelAdresa);
		panelAdresa.add(txtAdresa);
		
		JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelTel = new JLabel("      Broj telefona*");
		labelTel.setPreferredSize(dim);
		JTextField txtTel = new JTextField();
		txtTel.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener brTelListener = new BrTelKeyListener();
		txtTel.addKeyListener(brTelListener);
		panelTel.add(labelTel);
		panelTel.add(txtTel);
		
		JPanel panelMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelMail = new JLabel("      E-mail adresa*");
		labelMail.setPreferredSize(dim);
		JTextField txtMail = new JTextField();
		KeyListener mailListener = new MailKeyListener();
		txtMail.addKeyListener(mailListener);
		txtMail.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);		
		panelMail.add(labelMail);
		panelMail.add(txtMail);
		
		JPanel panelIndex = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelIndex = new JLabel("      Broj indeksa*");
		labelIndex.setPreferredSize(dim);
		JTextField txtIndex = new JTextField();
		txtIndex.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener indexListener = new IndexKeyListener();
		txtIndex.addKeyListener(indexListener);
		panelIndex.add(labelIndex);
		panelIndex.add(txtIndex);
		
		JPanel panelGod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelGod = new JLabel("      Godina upisa*");
		labelGod.setPreferredSize(dim);
		JTextField txtGod = new JTextField();
		txtGod.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener godListener = new GodUpisaKeyListener();
		txtGod.addKeyListener(godListener);
		panelGod.add(labelGod);
		panelGod.add(txtGod);
		
		JPanel panelGodStudija = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelGodStudija = new JLabel("      Godina studija*");
		labelGodStudija.setPreferredSize(dim);
		String godina[] = { "I (prva)", "II (druga)", "III (treca)","IV (cetvrta)"};
		JComboBox<String> comboGodStudija = new JComboBox<String>(godina);
		comboGodStudija.setPreferredSize(dim);				
		//comboGodStudija.addActionListener(actionListener);
		panelGodStudija.add(labelGodStudija);
		panelGodStudija.add(comboGodStudija);
		
		JPanel panelFinans = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelFinans = new JLabel("      Nacin finansiranja*");
		labelFinans.setPreferredSize(dim);
		String nacin[] = { "Budzet", "Samofinansiranje"};
		JComboBox<String> comboFinans = new JComboBox<String>(nacin);
		comboFinans.setPreferredSize(dim);				
		//comboGodStudija.addActionListener(actionListener);
		panelFinans.add(labelFinans);
		panelFinans.add(comboFinans);
		
		JPanel panelDugmici = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton potvrdi = new JButton("Potvrdi");
		 potvrdi.setBackground(Color.GREEN);
		 
		 potvrdi.setEnabled(false); //resavanje potvrdi dugmeta
		 Document documentPrz = txtPrezime.getDocument();
		 documentPrz.addDocumentListener(new ButtonControllerStudent(potvrdi, 0));
		 Document documentIme = txtIme.getDocument();
		 documentIme.addDocumentListener(new ButtonControllerStudent(potvrdi, 1));
		 Document documentDatRod = txtDatRod.getDocument();
		 documentDatRod.addDocumentListener(new ButtonControllerStudent(potvrdi, 2));
		 Document documentAdresa = txtAdresa.getDocument();
		 documentAdresa.addDocumentListener(new ButtonControllerStudent(potvrdi, 3));
		 Document documentTel = txtTel.getDocument();
		 documentTel.addDocumentListener(new ButtonControllerStudent(potvrdi, 4));
		 Document documentMail = txtMail.getDocument();
		 documentMail.addDocumentListener(new ButtonControllerStudent(potvrdi, 5));
		 Document documentBrLicne = txtIndex.getDocument();
		 documentBrLicne.addDocumentListener(new ButtonControllerStudent(potvrdi, 6));
		 Document documentGod = txtGod.getDocument();
		 documentGod.addDocumentListener(new ButtonControllerStudent(potvrdi, 7));
			 		 		 
		 potvrdi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int slash = 0;
					for (int i = 0; i < txtDatRod.getText().length(); i ++) {
					    if (txtDatRod.getText().charAt(i) == '/') {
					        slash++;
					    }
					}
					
					if (!(slash == 2)) {
						JOptionPane.showMessageDialog(null, "Format datuma mora biti: dd/mm/yyyy");
					}
					else {
					int id = StudentJTable.getInstance().getSelectedRow();					
					StudentController.getInstance().izmeniStudenta(id, txtPrezime.getText(), txtIme.getText(), txtDatRod.getText(), txtAdresa.getText(), 
							txtTel.getText(), txtMail.getText(), txtIndex.getText(), Integer.parseInt(txtGod.getText()), godina[comboGodStudija.getSelectedIndex()], 
							stringToStatus(nacin[comboFinans.getSelectedIndex()]));
					}
					
				}
			});		    
		
		 JButton odustani = new JButton("Odustani");
			odustani.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//EditStudentDialog.getInstance(parent, title, modal).dispose();
				}
			});
			JLabel stealth = new JLabel();
			stealth.setPreferredSize(new Dimension(30,20));
			panelDugmici.add(potvrdi);
			panelDugmici.add(stealth);
			panelDugmici.add(odustani); 
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panelIme);
		boxCentar.add(panelPrezime);
		boxCentar.add(panelDatRod);
		boxCentar.add(panelAdresa);
		boxCentar.add(panelTel);
		boxCentar.add(panelMail);
		boxCentar.add(panelIndex);
		boxCentar.add(panelGod);
		boxCentar.add(panelGodStudija);
		boxCentar.add(panelFinans);
		boxCentar.add(Box.createGlue());
		
		informacijePanel.add(boxCentar, BorderLayout.NORTH);
		informacijePanel.add(panelDugmici, BorderLayout.SOUTH);
		
		add("Informacije", informacijePanel);
	}
	
		public Status stringToStatus(String status) {
			switch (status) {
			case "Budzet":
				return Status.B;			
			case "Samofinansiranje":
				return Status.S;
			default:
				return null;
			}
		}			
}
