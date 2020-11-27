package oisisi;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class MyToolbar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307178798190736592L;

	public MyToolbar() {
		
		setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		add(panel1,BorderLayout.WEST);
		
		JButton btnNew = new JButton(new ImageIcon("images_mc/crafting_table.png"));
		btnNew.setToolTipText("New");
		btnNew.setBorder(BorderFactory.createEmptyBorder());
		btnNew.setRolloverIcon(new ImageIcon("images_mc/crafting_table_top.png"));
		btnNew.setRolloverEnabled(true);
		panel1.add(btnNew);
			
		JButton btnEdit = new JButton(new ImageIcon("images_mc/anvil.png"));
		btnEdit.setToolTipText("Edit");
		btnEdit.setBorder(BorderFactory.createEmptyBorder());
		panel1.add(btnEdit);

		JButton btnDelete = new JButton(new ImageIcon("images_mc/unlit_furnance.png"));
		btnDelete.setToolTipText("Delete");
		btnDelete.setBorder(BorderFactory.createEmptyBorder());
		btnDelete.setRolloverIcon(new ImageIcon("images_mc/furnance.png"));
		btnDelete.setRolloverEnabled(true);
		panel1.add(btnDelete);
		
		setFloatable(false);
		
		JPanel panel2 = new JPanel();
		add(panel2,BorderLayout.EAST);
		panel2.setBorder(BorderFactory.createEmptyBorder());
		
		JTextField field = new JTextField(12);
		field.setBorder(BorderFactory.createBevelBorder(1));
		//field.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
		panel2.add(field);
		
		JButton btnSearch=new JButton(new ImageIcon("images_mc/search.png"));
		btnSearch.setToolTipText("Search");
		btnSearch.setBorder(BorderFactory.createEmptyBorder());
		panel2.add(btnSearch);
	}
}
