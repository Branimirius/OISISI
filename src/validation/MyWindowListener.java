package validation;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Window Listener koji se koristi prilikom zatvaranja glavnog prozora studentske sluzbe.
 * Prvo izbacuje dijalog gd korisnik potvrdjuje da li zaista zeli da napusti aplikaciju da ne bi dolazilo do 
 * slucajnog zatvaranja.
 * 
 * Window Listener predstavlja "pop out" prozorcic koji pita za potvrdu zatvaranja aplikacije.
 * Sluzi da ne bi doslo do slucajnog zatvaranja aplikacije (cele sluzbe).
 * @author Filip
 *
 */
public class MyWindowListener implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * u slucaju zatvaranja mainframe-a iniciramo "pop-out" prozor sa opcijama "yes"-zatvori "no"-odustani od zatvaranja
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		JFrame frame = (JFrame) arg0.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, "Stvarno zatvarate nasu sluzbu :( ?",
				"Odlazite?", JOptionPane.YES_NO_OPTION);
		if (code != JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}

