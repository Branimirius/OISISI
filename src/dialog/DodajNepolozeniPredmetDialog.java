package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;
import oisisi.MainFrame;
import oisisi.StudentJTable;
import oisisi.TabNepolozeniPredmeti;

public class DodajNepolozeniPredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2561289172986759311L;

	
	public DodajNepolozeniPredmetDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)*2/5;
		int dialHeight = (parent.getSize().height*5/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		JPanel dialPanel = new JPanel();
		dialPanel.setLayout(new BorderLayout());
		
		DefaultListModel<String> listPredmetiModel = new DefaultListModel<String>();
		
		int id = StudentJTable.getInstance().getSelectedRow();
		//Student student = BazaStudenata.getInstance().getStudenti().get(id);
		
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			listPredmetiModel.addElement(p.getIdPredmeta() + "   " + p.getNazivPredmeta());
		}
		JList<String> listPredmeti = new JList<String>(listPredmetiModel);
		listPredmeti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPredmeti.setSelectedIndex(0);
		listPredmeti.setVisibleRowCount(10);
		
		JScrollPane scrollPredmeti = new JScrollPane(listPredmeti);
		dialPanel.add(scrollPredmeti);
		
		JPanel dugmici = new JPanel();
		
		dugmici.setSize(dim);
		
		JButton potvrdi = new JButton("Potvrdi");
			potvrdi.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int id = listPredmeti.getSelectedIndex();
					if(id < 0) {
						JOptionPane.showMessageDialog(null, "Izaberite predmet");
						return;
					}
					Predmet predmet = BazaPredmeta.getInstance().getRow(id);
					int idS = StudentJTable.getInstance().getSelectedRow();
					BazaStudenata.getInstance().getRow(idS).addPredmet(predmet);
					TabNepolozeniPredmeti.getInstance().updateViewNepolozeni();
					
				}
				
			});
		JButton odustani = new JButton("Odustani");
			odustani.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
				
			});
		
		
		dugmici.add(potvrdi);
		dugmici.add(odustani);
		dialPanel.add(scrollPredmeti, BorderLayout.NORTH);
		dialPanel.add(dugmici, BorderLayout.CENTER);
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(scrollPredmeti);
		boxCentar.add(dugmici);
		
		add(boxCentar);
		//add(dialPanel);
	}
	/*public List<Predmet> noviPredmeti(Student s){
		List<Predmet> predmeti = new ArrayList<Predmet>();
		List<Ocena> ocene = BazaOcena.getInstance().getOcene();
		predmeti = BazaPredmeta.getInstance().getPredmeti();
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti() ) {
			if(s.getNepolozeni().contains(p)) {
				predmeti.remove(p);
			}
		}
		for(Ocena o : ocene) {
			if(s.getPolozeni().contains(o)) {
				predmeti.remove(o.getPredmet());
					
			}
		}
		
		
		return predmeti;
	}*/
}
