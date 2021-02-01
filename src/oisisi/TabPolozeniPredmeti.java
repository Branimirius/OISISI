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
 * Klasa koja predstavlja tab sa svim informacijama o polozenim predmetima jednog studenta, tj. ocenama
 * 3. tab u editStudent dialogu
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
	 * Metoda koja kreira i vraca instancu taba polozenih predmeta
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
		 * Konstruktor ove klase, on kreira tabelu prikaza polozenih predmeta i sve informacije o njima
		 * takodje kreiramo i labelu sa prosekom studenta i dugme za ponistavanje ocene (polozenog predmeta).
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
		 * Metoda koja azurira tabelu polozenih predmeta (ocena).
		 */
		public void updateViewPolozeni() {
			
			AbstractTableModelPolozeni modelPolozeni = (AbstractTableModelPolozeni) this.tabelaPolozeni.getModel();
			modelPolozeni.fireTableDataChanged();
			validate();
			//System.out.println("azuriro iz mejna studente ");	
		}
		
		
			
		
}
