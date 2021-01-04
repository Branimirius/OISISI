package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.BazaOcena;
import oisisi.PolozeniJTable;
import oisisi.TabIzmenaStudenta;
import oisisi.TabPolozeniPredmeti;

public class EditStudentDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2721472932824768104L;
	
	private static EditStudentDialog instance = null;
	
	public static EditStudentDialog getInstance(Frame parent, String title, boolean modal) {
		if (instance == null) {
			instance = new EditStudentDialog(parent, title, modal);
		}
		return instance;
	}
	
	private Dimension dim;	
	
	public EditStudentDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int dialWidth= (parent.getSize().width)/2;
		int dialHeight = (parent.getSize().height*7/8);
		dim = new Dimension(dialWidth*2/5, 25);
		
		setLayout(new BorderLayout());
		setSize(dialWidth, dialHeight);
		setLocationRelativeTo(parent);
		
		TabIzmenaStudenta tabIzmena = TabIzmenaStudenta.getInstance(dim);
		
		add(tabIzmena);
		addWindowListener(new WindowListener(){			
			

			@Override
			public void windowClosed(WindowEvent e) {				

				TabPolozeniPredmeti.getInstance().updateViewPolozeni();
			}

			@Override
			public void windowOpened(WindowEvent e) {
				//TabPolozeniPredmeti.getInstance().updateViewPolozeni();
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				
				BazaOcena.getInstance().clearOcene();
				
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			
		});
		
		
			
		
	}
}
