package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dialog.ObrisiPolozeniPredmetDialog;

/**
 * Tab koji sadrzi tabelu polozenih predmeta selektovanog studenta.
 * Poziva se pri izmeni studenta, kao drugi tab po redu.
 * @author Branimir
 *
 */
public class TabPolozeniPredmeti extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5979608371285451597L;
	
	private static TabPolozeniPredmeti instance = null;

	/**
	 * Metoda koja vraca/pravi instancu taba polozenih predmeta
	 * @return instance
	 */
	public static TabPolozeniPredmeti getInstance() {
		if (instance == null) {
			instance = new TabPolozeniPredmeti();
		}
		return instance;
	}
	
	
	PolozeniJTable tabelaPolozeni = PolozeniJTable.getInstance();		
	JScrollPane scrollPolozeni = new JScrollPane(tabelaPolozeni);
		
		/**
		 * Konstruktor taba sa polozenim predmetima, tu se ukljucuje tabela polozenih predmeta(ocena) za odredjenog studenta,
		 * kao labela sa prosekom i dugme za ponistavanje ocene.
		 */
		public TabPolozeniPredmeti() {
		
		
		setLayout(new BorderLayout());	
		
		
		JButton ponisti = new JButton("Ponisti ocenu");
			ponisti.setBackground(Color.MAGENTA);	
			ponisti.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ObrisiPolozeniPredmetDialog obrisiDialog = new ObrisiPolozeniPredmetDialog(MainFrame.getInstance(),
							"Ponistavanje ocene", true);
					obrisiDialog.setVisible(true);
				}
				
			});
			
			
		JLabel stealthLab = new JLabel();
		JPanel stealthPan = new JPanel();
			stealthPan.add(stealthLab);
		
		JPanel dugmence = new JPanel();
			dugmence.setLayout(new BorderLayout());
			dugmence.add(ponisti, BorderLayout.WEST);

		JPanel tabela = new JPanel();		
		tabela.add(scrollPolozeni);
		
		
		
			Box boxCentar = Box.createVerticalBox();
			boxCentar.add(Box.createVerticalStrut(20));
			boxCentar.add(dugmence);
			boxCentar.add(Box.createVerticalStrut(20));
			boxCentar.add(tabela);
			boxCentar.add(Box.createGlue());
		
			add(boxCentar, BorderLayout.NORTH);
			
		}
		
		/**
		 * Metoda koja osvezava tabelu polozenih predmeta(ocena) studenta.
		 */
		public void updateViewPolozeni() {
			
			AbstractTableModelPolozeni modelPolozeni = (AbstractTableModelPolozeni) this.tabelaPolozeni.getModel();
			modelPolozeni.fireTableDataChanged();
			validate();
			//System.out.println("azuriro iz mejna studente ");	
		}
		
		
			
		
}
