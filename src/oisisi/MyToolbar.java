package oisisi;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import controller.NepolozeniController;
import controller.OceneController;
import dialog.DeletePredmetDialog;
import dialog.DeleteProfesorDialog;
import dialog.DeleteStudentDialog;
import dialog.EditPredmetDialog;
import dialog.EditProfesorDialog;
import dialog.EditStudentDialog;
import dialog.NewPredmetDialog;
import dialog.NewProfesorDialog;
import dialog.NewStudentDialog;



/**
 * Klasa koja predstavlja liniju alata u aplikaciji. Sadrzi alate za kreiranje, izmenu, brisanje i pretragu entiteta unutar aplikacije.
 * @author Filip
 *
 */
public class MyToolbar extends JToolBar implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307178798190736592L;

	/**
	 * Konstruktor linije alata i svih potrebnih opcija na njoj.
	 * Dugmici na Toolbaru:  NEW, EDIT, DELETE, SEARCH(txtField), SEARCH(button)
	 * @param parent
	 */
	public MyToolbar(final JFrame parent) {
		
		setLayout(new BorderLayout());
		
		setBorder(new LineBorder(Color.BLACK));
		//setBorder(BorderFactory.createBevelBorder(1));
		
		JPanel panel1 = new JPanel();
		add(panel1,BorderLayout.WEST);
		
		JButton btnNew = new JButton(new ImageIcon("Images_mc" + File.separator + "crafting_table.png"));
		btnNew.setToolTipText("New");
		btnNew.setBorder(BorderFactory.createEmptyBorder());
		btnNew.setRolloverIcon(new ImageIcon("Images_mc" + File.separator + "crafting_table_top.png"));
		btnNew.setRolloverEnabled(true);
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ChangeListenerTabs brt= new ChangeListenerTabs();				
				//iz nekog razloga ovo nije htelo sa switch, uvek je ispisivalo sve :( 
				
				if(brt.getSel() == 0) {
					NewStudentDialog newStudent = new NewStudentDialog(parent, "Dodavanje studenta", true);
					newStudent.setVisible(true);
				}	
				else if(brt.getSel() == 1) {
					NewProfesorDialog newProfesor = new NewProfesorDialog(parent, "Dodavanje profesora", true);
					newProfesor.setVisible(true);
				}
				else 	if(brt.getSel() ==  2) {
					NewPredmetDialog newPredmet = new NewPredmetDialog(parent, "Dodavanje predmeta", true);
					newPredmet.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(null, ("This shouldn't be possible"));
			}
		});
				
		panel1.add(btnNew);
			
		JButton btnEdit = new JButton(new ImageIcon("Images_mc" + File.separator + "anvil.png"));
		btnEdit.setToolTipText("Edit");
		btnEdit.setBorder(BorderFactory.createEmptyBorder());
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selStud = StudentJTable.getInstance().getSelectedRow();
				
				ChangeListenerTabs brt = new ChangeListenerTabs();	
				if(brt.getSel() == 0) {
					if(selStud < 0) {
						JOptionPane.showMessageDialog(null, "Izaberite studenta kog zelite da menjate");
					}
					else {
					OceneController.getInstance().initOcene();
					NepolozeniController.getInstance().initNepolozeni();
					EditStudentDialog editStudent = new EditStudentDialog(parent, "Izmena studenta", true);
					editStudent.setVisible(true);
					}
				}	
				else if(brt.getSel() == 1) {
					EditProfesorDialog editProfesor = new EditProfesorDialog(parent, "Izmena profesora", true);
					editProfesor.setVisible(true);
				}
				else if(brt.getSel() ==  2) {
					EditPredmetDialog editPredmet = new EditPredmetDialog(parent, "Izmena predmeta", true);
					editPredmet.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(null, ("This shouldn't be possible"));
			}	
			
			
		});
		panel1.add(btnEdit);

		JButton btnDelete = new JButton(new ImageIcon("Images_mc" + File.separator + "unlit_furnance.png"));
		btnDelete.setToolTipText("Delete");
		btnDelete.setBorder(BorderFactory.createEmptyBorder());
		btnDelete.setRolloverIcon(new ImageIcon("Images_mc" + File.separator + "furnance.png"));
		btnDelete.setRolloverEnabled(true);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeListenerTabs brt = new ChangeListenerTabs();	
				if(brt.getSel() == 0) {
					DeleteStudentDialog deleteStudent = new DeleteStudentDialog(parent, "Brisanje studenta", true);
					deleteStudent.setVisible(true);
				}	
				else if(brt.getSel() == 1) {
					DeleteProfesorDialog deleteProfesor = new DeleteProfesorDialog(parent, "Brisanje profesora", true);
					deleteProfesor.setVisible(true);
				}
				else if(brt.getSel() ==  2) {
					DeletePredmetDialog deletePredmet = new	DeletePredmetDialog(parent, "Brisanje predmeta", true);
					deletePredmet.setVisible(true);
				}
				else 
					JOptionPane.showMessageDialog(null, ("This shouldn't be possible"));		
			}
		});
		panel1.add(btnDelete);
		
		setFloatable(false);
		
		JPanel panel2 = new JPanel();
		add(panel2,BorderLayout.EAST);
		panel2.setBorder(BorderFactory.createEmptyBorder());
		
		JTextField field = new JTextField(12);
		field.setBorder(BorderFactory.createBevelBorder(1));
		panel2.add(field);
		
		JButton btnSearch=new JButton(new ImageIcon("Images_mc" + File.separator + "search.png"));
		btnSearch.setToolTipText("Search");
		btnSearch.setBorder(BorderFactory.createEmptyBorder());
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ("TEST TEST TEST TEST"));
			}
		});
		panel2.add(btnSearch);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
