package oisisi;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class MyToolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307178798190736592L;

	public MyToolbar() {
		
		addSeparator();
		
		JButton btnNew = new JButton(new ImageIcon("images_mc/crafting_table.png"));
		btnNew.setToolTipText("New");
		add(btnNew);
		
		addSeparator();
				
		JButton btnEdit = new JButton(new ImageIcon("images_mc/anvil.png"));
		btnEdit.setToolTipText("Edit");
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton(new ImageIcon("images_mc/furnance.png"));
		btnDelete.setToolTipText("Delete");
		add(btnDelete);
		
		addSeparator();
		
		JButton btnRight=new JButton("search");
		add(btnRight,BorderLayout.EAST);
		
		setFloatable(false);
		
	}
}
