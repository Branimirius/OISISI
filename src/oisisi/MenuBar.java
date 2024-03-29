package oisisi;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.NepolozeniController;
import controller.OceneController;
import dialog.DeleteProfesorDialog;
import dialog.DeleteStudentDialog;
import dialog.EditPredmetDialog;
import dialog.EditProfesorDialog;
import dialog.EditStudentDialog;
import dialog.NewPredmetDialog;
import dialog.NewProfesorDialog;
import dialog.NewStudentDialog;
import model.BazaNepolozeniPredmeti;
import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;


/**
 * Klasa koja kreira meni liniju aplikacije i sve potrebne dugmice u tom meniju.
 * @author Branimir
 *
 */
public class MenuBar extends JMenuBar implements ActionListener {

	
	
	private static final long serialVersionUID = -7863806568418316202L;
	
	/**
	 * Konstruktor meni linije i svih potrebnih opcija na njoj,
	 * sadrzi tri padajuca menija File, Edit i Help.
	 * File : new, close; Edit : edit, delete; Help : help, about.
	 * @param parent roditeljski frejm (main frame)
	 */
	public MenuBar(final JFrame parent) {

		JMenu file = new JMenu("File");
		file.setMnemonic('f');
		
		JMenuItem miNew = new JMenuItem("New  ");
		miNew.setIcon(new ImageIcon("Images_mc" + File.separator + "bookandquill.png"));
			KeyStroke keyStrokeToNew
				= KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
			miNew.setAccelerator(keyStrokeToNew);
			miNew.setMnemonic('n');
			miNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					ChangeListenerTabs brt = new ChangeListenerTabs();				
																										
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
			
		JMenuItem miClose = new JMenuItem("Close  ");
		miClose.setIcon(new ImageIcon("Images_mc" + File.separator + "closed_book22.png"));
			KeyStroke keyStrokeToClose
				= KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
			miClose.setAccelerator(keyStrokeToClose);
			miClose.setMnemonic('c');
			miClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				try {
					BazaStudenata.getInstance().Serializacija();
					BazaOcena.getInstance().Serializacija();
					BazaNepolozeniPredmeti.getInstance().Serializacija();
					BazaPredmeta.getInstance().Serializacija();
					BazaProfesora.getInstance().Serializacija();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
		
		file.add(miNew);
		file.addSeparator();
		
		
		file.add(miClose);		

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('e');
		JMenuItem miEdit = new JMenuItem("Edit  ");
			miEdit.setIcon(new ImageIcon("Images_mc" + File.separator + "anvil.png"));
			KeyStroke keyStrokeToEdit
				= KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
			miEdit.setAccelerator(keyStrokeToEdit);
			miEdit.setMnemonic('e');
			miEdit.addActionListener(new ActionListener() {

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
								//TabPolozeniPredmeti.getInstance().updateViewPolozeni();
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
			
			
		JMenuItem miDelete = new JMenuItem("Delete  ");
			miDelete.setIcon(new ImageIcon("Images_mc" + File.separator + "unlit_furnance.png"));
			KeyStroke keyStrokeToDelete
				= KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
			miDelete.setAccelerator(keyStrokeToDelete);
			miDelete.setMnemonic('d');
			miDelete.addActionListener(new ActionListener() {

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
						//DeletePredmetDialog deletePredmet = new DeletePredmetDialog(parent, "Brisanje predmeta", true);
						//deletePredmet.setVisible(true);
					}
					else 
						JOptionPane.showMessageDialog(null, ("This shouldn't be possible"));
					
				
					
				}
				
			});
			
		JMenu help = new JMenu("Help");
		help.setMnemonic('h');
		
		JMenuItem miHelp = new JMenuItem("Help  ");
		miHelp.setIcon(new ImageIcon("Images_mc" + File.separator + "map.png"));
			KeyStroke keyStrokeToHelp
				= KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);
			miHelp.setAccelerator(keyStrokeToHelp);
			miHelp.setMnemonic('h');
			miHelp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					HATextArea helpText = new HATextArea();
					helpText.setTitle(" You stuck? ");
				}
			});
			
			
		JMenuItem miAbout = new JMenuItem("About  ");
			miAbout.setIcon(new ImageIcon("Images_mc" + File.separator + "sign.png"));
			KeyStroke keyStrokeToAbout
				= KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
			miAbout.setAccelerator(keyStrokeToAbout);
			miAbout.setMnemonic('a');
			miAbout.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					AATextArea aboutText = new AATextArea();
					aboutText.setTitle(" About info ");
					
				}
			});
		
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);

	}
	
	
	



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
