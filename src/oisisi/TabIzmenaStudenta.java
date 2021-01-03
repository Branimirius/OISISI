package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.ButtonControllerStudent;
import controller.StudentController;
import dialog.EditStudentDialog;
import model.Status;
import validation.AdrKeyListener;
import validation.BrTelKeyListener;
import validation.DatumKeyListener;
import validation.GodUpisaKeyListener;
import validation.IndexKeyListener;
import validation.MailKeyListener;
import validation.SamoSlovaKeyListener;

public class TabIzmenaStudenta extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492311871537969696L;
	
	private static TabIzmenaStudenta instance = null;

	public static TabIzmenaStudenta getInstance(Dimension dim) {
		if (instance == null) {
			instance = new TabIzmenaStudenta(dim);
		}
		return instance;
	}
	
	
	public TabIzmenaStudenta(Dimension dim) {
		
					 		 		 
		JPanel polozeniPanel = new JPanel();
		JPanel infoPanel = TabInformacijeStudent.getInstance(dim);
		add("Informacije", infoPanel);
		add("Polozeni Predmeti", polozeniPanel);
	}
	
	
}
