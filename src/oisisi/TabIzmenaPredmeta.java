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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.ButtonControllerPredmet;
import controller.PredmetController;
import controller.StudentController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import validation.EspbKeyListener;
import validation.GodIzvodjenjaKeyListener;
import validation.SamoSlovaKeyListener;

/**
 * Klasa koja predstavlja tabove na kojima se menjaju informacije o selektovanom predmetu.
 * Sastoji se od labela polja i dugmica za sve neophodne informacije o predmetu.
 * @author Filip
 *
 */
public class TabIzmenaPredmeta extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3984268731055278179L;

	private static TabIzmenaPredmeta instance = null;

	/**
	 * Metoda koja vraca/pravi instancu taba za izmenu predmeta.
	 * @param dim dimenzija koja se prosledjuje iz roditeljskog frejma.
	 * @return instance
	 */
	public static TabIzmenaPredmeta getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabIzmenaPredmeta(dim);
		}
		return instance;
	}
	private Predmet p;             
	
	/**
	 * Konstruktor taba za izmenu predmeta. 
	 * Kreiraju se labele, polja i dugmici za sve neophodne informacije o predmetu.  
	 * Ukoliko nisu sva polja popunjena, dugme je zakljucano. Ukoliko neko polje nije validno popnjeno, 
	 * program baca gresku. 
	 * @param dim dimenzija taba, salje se iz roditeljskog frejma
	 */
	public TabIzmenaPredmeta(Dimension dim) {
		int id = PredmetJTable.getInstance().getSelectedRow();
		if(id < 0) {
			return;
		}
		else {
			List<Predmet> pp = BazaPredmeta.getInstance().getPredmeti();
			p = pp.get(id);
		}
		
		JPanel informacijePanel = new JPanel();
		informacijePanel.setLayout(new BorderLayout());
		
		JPanel panelNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelNaziv = new JLabel("      Naziv predmeta*");
		labelNaziv.setPreferredSize(dim);
		JTextField txtNaziv = new JTextField(p.getNazivPredmeta());
		txtNaziv.setPreferredSize(dim);
		KeyListener SamoSlovaListener = new SamoSlovaKeyListener();		
		txtNaziv.addKeyListener(SamoSlovaListener);		
		panelNaziv.add(labelNaziv);
		panelNaziv.add(txtNaziv);
		
		JPanel panelESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelESPB = new JLabel("      Broj ESPB bodova*");
		labelESPB.setPreferredSize(dim);
		JTextField txtESPB = new JTextField(Integer.toString(p.getBrojEspbBodova()));
		txtESPB.setPreferredSize(dim);
		KeyListener ESPBListener = new EspbKeyListener();
		txtESPB.addKeyListener(ESPBListener);
		panelESPB.add(labelESPB);
		panelESPB.add(txtESPB);
		
		JPanel panelGod = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelGod = new JLabel("      Godina izvodjenja*");
		labelGod.setPreferredSize(dim);
		JTextField txtGod = new JTextField(Integer.toString(p.getGodinaIzvodjenja()));
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
		comboSemestar.setSelectedItem(semestarToString(p.getSemestar()));
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
					
					int id = PredmetJTable.getInstance().getSelectedRow();					
					PredmetController.getInstance().izmeniPredmet(id, txtNaziv.getText(), Integer.parseInt(txtESPB.getText()),stringToSemestar(semestar[comboSemestar.getSelectedIndex()]), 					 
							 Integer.parseInt(txtGod.getText()));
					}
				}
			});
		 
		 JButton odustani = new JButton("Odustani");
			odustani.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//dispose();
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
			boxCentar.add(panelESPB);
			boxCentar.add(panelGod);
			boxCentar.add(panelSemestar);
			
			informacijePanel.add(boxCentar, BorderLayout.NORTH);
			informacijePanel.add(panelDugmici, BorderLayout.SOUTH);	
			
			add("Informacije", informacijePanel);
			
			
	}
	
	/**
	 * Metoda koja pretvara tip semestra iz String u enum Semestar.
	 * String se koristio u combo box konponenti, a Semestar enum nam je potreban za cuvanje.
	 * @param semestar String
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
	
	/**
	 * * Metoda koja pretvara tip semestra iz enum Semestar u String.
	 * String se koristi u combo box konponenti, a Semestar za cuvanje.
	 * @param semestar
	 * @return
	 */
	public String semestarToString(Semestar semestar) {
		switch (semestar) {
		case ZIMSKI:
			return "Zimski";			
		case LETNJI:
			return "Letnji";
		default:
			return null;
		}
	}
}
