package oisisi;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.StudentController;
import dialog.EditPredmetDialog;
import dialog.EditStudentDialog;
import dialog.NewPredmetDialog;
import dialog.NewProfesorDialog;
import dialog.NewStudentDialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MenuBar extends JMenuBar implements ActionListener {

	
	
	private static final long serialVersionUID = -7863806568418316202L;
	
	public MenuBar(final JFrame parent) {

		JMenu file = new JMenu("File");
		file.setMnemonic('f');
		
		JMenuItem miNew = new JMenuItem("New  ");
		miNew.setIcon(new ImageIcon("Images_mc/bookandquill.png"));
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
		miClose.setIcon(new ImageIcon("Images_mc/closed_book22.png"));
			KeyStroke keyStrokeToClose
				= KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
			miClose.setAccelerator(keyStrokeToClose);
			miClose.setMnemonic('c');
		
		file.add(miNew);
		file.addSeparator();
		
		
		file.add(miClose);		

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('e');
		JMenuItem miEdit = new JMenuItem("Edit  ");
			miEdit.setIcon(new ImageIcon("Images_mc/anvil.png"));
			KeyStroke keyStrokeToEdit
				= KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
			miEdit.setAccelerator(keyStrokeToEdit);
			miEdit.setMnemonic('e');
			miEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					ChangeListenerTabs brt = new ChangeListenerTabs();	
					if(brt.getSel() == 0) {
						EditStudentDialog editStudent = new EditStudentDialog(parent, "Izmena studenta", true);
						editStudent.setVisible(true);
					}	
					else if(brt.getSel() == 1) {
						//EditProfesorDialog editProfesor = new EditProfesorDialog(parent, "Dodavanje profesora", true);
						//editProfesor.setVisible(true);
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
			miDelete.setIcon(new ImageIcon("Images_mc/unlit_furnance.png"));
			KeyStroke keyStrokeToDelete
				= KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
			miDelete.setAccelerator(keyStrokeToDelete);
			miDelete.setMnemonic('d');
		
		JMenu help = new JMenu("Help");
		help.setMnemonic('h');
		
		JMenuItem miHelp = new JMenuItem("Help  ");
		miHelp.setIcon(new ImageIcon("Images_mc/map.png"));
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
			miAbout.setIcon(new ImageIcon("Images_mc/sign.png"));
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
