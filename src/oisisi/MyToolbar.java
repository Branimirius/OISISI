package oisisi;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;



public class MyToolbar extends JToolBar implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307178798190736592L;

	public MyToolbar() {
		
		setLayout(new BorderLayout());
		
		setBorder(new LineBorder(Color.BLACK));
		//setBorder(BorderFactory.createBevelBorder(1));
		
		JPanel panel1 = new JPanel();
		add(panel1,BorderLayout.WEST);
		
		JButton btnNew = new JButton(new ImageIcon("images_mc/crafting_table.png"));
		btnNew.setToolTipText("New");
		btnNew.setBorder(BorderFactory.createEmptyBorder());
		btnNew.setRolloverIcon(new ImageIcon("images_mc/crafting_table_top.png"));
		btnNew.setRolloverEnabled(true);
		btnNew.setMnemonic('N');
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ("TEST"));	
			}
		});
		panel1.add(btnNew);
			
		JButton btnEdit = new JButton(new ImageIcon("images_mc/anvil.png"));
		btnEdit.setToolTipText("Edit");
		btnEdit.setBorder(BorderFactory.createEmptyBorder());
		btnEdit.setMnemonic('E');
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ("TEST TEST"));
			}
		});
		panel1.add(btnEdit);

		JButton btnDelete = new JButton(new ImageIcon("images_mc/unlit_furnance.png"));
		btnDelete.setToolTipText("Delete");
		btnDelete.setBorder(BorderFactory.createEmptyBorder());
		btnDelete.setRolloverIcon(new ImageIcon("images_mc/furnance.png"));
		btnDelete.setRolloverEnabled(true);
		btnDelete.setMnemonic('D');
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ("TEST TEST TEST"));				
			}
		});
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
		btnSearch.setMnemonic('S');
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
