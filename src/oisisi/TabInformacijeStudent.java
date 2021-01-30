package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.ButtonControllerStudent;
import controller.StudentController;
import model.BazaStudenata;
import model.Status;
import model.Student;
import validation.AdrKeyListener;
import validation.BrTelKeyListener;
import validation.DatumKeyListener;
import validation.GodUpisaKeyListener;
import validation.IndexKeyListener;
import validation.MailKeyListener;
import validation.SamoSlovaKeyListener;

/**
 * Ovo je tab koji se pojavljuje pri izmeni studenta i na njemu se mogu menjati sve osnovne informacije o studentu.
 * Sastoji se iz tekstualnih polja, labela i dugmica za potvrdu i odustanak. Dugme za potvrdu se zakljucava ukoliko 
 * nisu popunjena sva polja. Takodje nije moguce uneti nevalidne vrednosti u polja.
 * @author Branimir
 *
 */
/**
 * Konstruktor taba za izmenu informacija o studentu.
 * Sastoji se iz tekstualnih polja, labela i dugmica za potvrdu i odustanak. Dugme za potvrdu se zakljucava ukoliko 
 * nisu popunjena sva polja. Takodje nije moguce uneti nevalidne vrednosti u polja.
 * @author brani
 *
 */
public class TabInformacijeStudent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 360658756718759759L;

	private static TabInformacijeStudent instance = null;

	public static TabInformacijeStudent getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabInformacijeStudent(dim);
		}
		return instance;
	}
	private Student s;
	
	public TabInformacijeStudent(Dimension dim) {
		
		int id = StudentJTable.getInstance().getSelectedRow();
		if(id < 0) {
			return;
		}
		else {
			List<Student> pp = BazaStudenata.getInstance().getStudenti();
			s = pp.get(id);
		}
		
		setLayout(new BorderLayout());
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelIme = new JLabel("      Ime*");
		labelIme.setPreferredSize(dim);
		JTextField txtIme = new JTextField(s.getIme());
		txtIme.setPreferredSize(dim);
		KeyListener SamoSlovaListener = new SamoSlovaKeyListener();		
		txtIme.addKeyListener(SamoSlovaListener);		
		panelIme.add(labelIme);
		panelIme.add(txtIme);
		
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelPrezime = new JLabel("      Prezime*");
		labelPrezime.setPreferredSize(dim);
		JTextField txtPrezime = new JTextField(s.getPrezime());
		txtPrezime.setPreferredSize(dim);
		//txtPrezime.addActionListener(actionListener);
		KeyListener SamoSlovaListenerPrezime = new SamoSlovaKeyListener();
		txtPrezime.addKeyListener(SamoSlovaListenerPrezime);
		panelPrezime.add(labelPrezime);
		panelPrezime.add(txtPrezime);
		
		JPanel panelDatRod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelDatRod = new JLabel("      Datum rodjenja*");
		labelDatRod.setPreferredSize(dim);
		JTextField txtDatRod = new JTextField(dateToString(s.getDatumRodjenja()));
		txtDatRod.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener datumKeyListener = new DatumKeyListener();
		txtDatRod.addKeyListener(datumKeyListener);
		panelDatRod.add(labelDatRod);
		panelDatRod.add(txtDatRod);
		
		JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelAdresa = new JLabel("      Adresa stanovanja*");
		labelAdresa.setPreferredSize(dim);
		JTextField txtAdresa = new JTextField(s.getAdresaStana());
		txtAdresa.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener adresaListener = new AdrKeyListener();
		txtAdresa.addKeyListener(adresaListener);
		panelAdresa.add(labelAdresa);
		panelAdresa.add(txtAdresa);
		
		JPanel panelTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelTel = new JLabel("      Broj telefona*");
		labelTel.setPreferredSize(dim);
		JTextField txtTel = new JTextField(s.getKontaktTel());
		txtTel.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener brTelListener = new BrTelKeyListener();
		txtTel.addKeyListener(brTelListener);
		panelTel.add(labelTel);
		panelTel.add(txtTel);
		
		JPanel panelMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelMail = new JLabel("      E-mail adresa*");
		labelMail.setPreferredSize(dim);
		JTextField txtMail = new JTextField(s.geteMail());
		KeyListener mailListener = new MailKeyListener();
		txtMail.addKeyListener(mailListener);
		txtMail.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);		
		panelMail.add(labelMail);
		panelMail.add(txtMail);
		
		JPanel panelIndex = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelIndex = new JLabel("      Broj indeksa*");
		labelIndex.setPreferredSize(dim);
		JTextField txtIndex = new JTextField(s.getBrIndeksa());
		txtIndex.setPreferredSize(dim);
		//txtDatRod.addActionListener(actionListener);
		KeyListener indexListener = new IndexKeyListener();
		txtIndex.addKeyListener(indexListener);
		panelIndex.add(labelIndex);
		panelIndex.add(txtIndex);
		
		JPanel panelGod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelGod = new JLabel("      Godina upisa*");
		labelGod.setPreferredSize(dim);
		JTextField txtGod = new JTextField(Integer.toString(s.getGodUpisa()));
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
		comboGodStudija.setSelectedItem(s.getGodStudija());
		//comboGodStudija.addActionListener(actionListener);
		panelGodStudija.add(labelGodStudija);
		panelGodStudija.add(comboGodStudija);
		
		JPanel panelFinans = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelFinans = new JLabel("      Nacin finansiranja*");
		labelFinans.setPreferredSize(dim);
		String nacin[] = { "Budzet", "Samofinansiranje"};
		JComboBox<String> comboFinans = new JComboBox<String>(nacin);
		comboFinans.setPreferredSize(dim);
		comboFinans.setSelectedItem(statusToString(s.getStatusStudenta()));
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
		
		
		add(boxCentar, BorderLayout.NORTH);
		add(panelDugmici, BorderLayout.SOUTH);
	}
	
	/**
	 * Metoda koja pretvara tip statusa studenta iz String (combo box) u Status(model studenta)
	 * Status nam je potreban za slanje u kontroler i konstruktor studenta.
	 * @param status String
	 * @return status Status
	 */
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
	
	/**
	 * Metoda koja pretvara tip datuma iz Date u String, radi lakseg rukovanja datumom.
	 * @param datum Date
	 * @return datum String
	 */
	public String dateToString(Date datum) {
		String ret;
		ret = new SimpleDateFormat("dd/MM/yyyy").format(datum);
		
		return ret;
	}
	
	/**
	 * Metoda koja pretvara tip statusa studenta iz Status (model) u String(combo box)
	 * String nam je potreban jer mozemo laske uporedjivati informaciju o statusu studenta.
	 * @param status Status
	 * @return status String
	 */
	public String statusToString(Status status) {
		switch (status) {
		case B:
			return "Budzet";			
		case S:
			return "Samofinansiranje";
		default:
			return null;
		}
	}			
}
