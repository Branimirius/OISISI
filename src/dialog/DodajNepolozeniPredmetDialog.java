package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaStudenata;
import model.Predmet;
import model.Student;
import oisisi.StudentJTable;

public class DodajNepolozeniPredmetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2561289172986759311L;

	
	public DodajNepolozeniPredmetDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		Dimension dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		JPanel dialPanel = new JPanel();
		dialPanel.setLayout(new BorderLayout());
		
		DefaultListModel listPredmetiModel = new DefaultListModel();
		
		int id = StudentJTable.getInstance().getSelectedRow();
		Student studenti = BazaStudenata.getInstance().getStudenti().get(id);
		
		
		for(Predmet p : studenti.getNepolozeni() ) {
			listPredmetiModel.addElement(p.getIdPredmeta() + "    " + p.getNazivPredmeta());
		}
		JList listPredmeti = new JList(listPredmetiModel);
		listPredmeti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPredmeti.setSelectedIndex(0);
		listPredmeti.setVisibleRowCount(10);
		
		JScrollPane scrollPredmeti = new JScrollPane(listPredmeti);
		dialPanel.add(scrollPredmeti);
		
		JPanel dugmici = new JPanel();
		dugmici.setLayout(new BorderLayout());
		
		JButton potvrdi = new JButton("Potvrdi");
		JButton odustani = new JButton("Odustani");
			odustani.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
				
			});
		
		
		dugmici.add(potvrdi);
		dugmici.add(odustani);
		dialPanel.add(dugmici);
		
		add(dialPanel);
	}
}
