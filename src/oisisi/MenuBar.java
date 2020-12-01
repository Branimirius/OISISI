package oisisi;


import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;


public class MenuBar extends JMenuBar implements ActionListener,ItemListener {

	
	
	private static final long serialVersionUID = -7863806568418316202L;

	public MenuBar() {

		JMenu file = new JMenu("File");
		
		JMenuItem miNew = new JMenuItem("New  ");
		miNew.setIcon(new ImageIcon("images_mc/bookandquill.png"));
			KeyStroke keyStrokeToNew
				= KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
			miNew.setAccelerator(keyStrokeToNew);
		
		
		JMenuItem miClose = new JMenuItem("Close  ");
		miClose.setIcon(new ImageIcon("images_mc/closed_book22.png"));
			KeyStroke keyStrokeToClose
				= KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
			miClose.setAccelerator(keyStrokeToClose);
		
		file.add(miNew);
		file.addSeparator();
		
		
		file.add(miClose);		

		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit  ");
			miEdit.setIcon(new ImageIcon("images_mc/anvil.png"));
			KeyStroke keyStrokeToEdit
				= KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
			miEdit.setAccelerator(keyStrokeToEdit);
			
		JMenuItem miDelete = new JMenuItem("Delete  ");
			miDelete.setIcon(new ImageIcon("images_mc/unlit_furnance.png"));
			KeyStroke keyStrokeToDelete
				= KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
			miDelete.setAccelerator(keyStrokeToDelete);
		
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help  ");
		miHelp.setIcon(new ImageIcon("images_mc/map.png"));
			KeyStroke keyStrokeToHelp
				= KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);
			miHelp.setAccelerator(keyStrokeToHelp);
			miHelp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					HATextArea helpText = new HATextArea();
					helpText.setTitle(" You stuck? ");
				}
			});
			
			
		JMenuItem miAbout = new JMenuItem("About  ");
			miAbout.setIcon(new ImageIcon("images_mc/sign.png"));
			KeyStroke keyStrokeToAbout
				= KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
			miAbout.setAccelerator(keyStrokeToAbout);
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
