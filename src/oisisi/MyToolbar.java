package oisisi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
		btnNew.setBorder(BorderFactory.createEmptyBorder());
		add(btnNew);
		
		addSeparator();
				
		JButton btnEdit = new JButton(new ImageIcon("images_mc/anvil.png"));
		btnEdit.setToolTipText("Edit");
		btnEdit.setBorder(BorderFactory.createEmptyBorder());
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton(new ImageIcon("images_mc/unlit_furnance.png"));
		btnDelete.setToolTipText("Delete");
		btnDelete.setBorder(BorderFactory.createEmptyBorder());
		btnDelete.setRolloverIcon(new ImageIcon("images_mc/furnance.png"));
		btnDelete.setRolloverEnabled(true);
		add(btnDelete);
		
		addSeparator();
		
		setFloatable(false);
		
		add(Box.createHorizontalGlue());
		//add(new JToolBar.Separator(new Dimension(15,10)));
		
		JTextField field = new JTextField();
		add(field);
		
		JButton btnSearch=new JButton(new ImageIcon("images_mc/search.png"));
		btnSearch.setToolTipText("Search");
		btnSearch.setBorder(BorderFactory.createEmptyBorder());
		add(btnSearch);
	}
}
