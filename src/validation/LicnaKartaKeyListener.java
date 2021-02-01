//reference: 4 vezbe -> dogadjaji

package validation;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Key Listener koji se koristi pri proveri validnosti popunjavanja polja za broj licne karte profesora.
 * Sluzi za proveru validnosti unetih znakova i ogranicava unos previse karaktera.
 * @author Filip
 *
 */
public class LicnaKartaKeyListener implements KeyListener {

	/**
	 *Ova funkcija se poziva pri unosenju karaktera u txtField, koristimo je za ogranicenje broja unetih karaktera.
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) arg0.getComponent();
		if (txt.getText().length() ==  9) {
			JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 9 karaktera!");
			txt.setText(txt.getText().substring(0, 9));
		}

	}

	/**
	 *Ova funkcija se poziva nako unosa karaktera u txtField, koristimo je da bi ogranicili unos odredjenih karaktera.
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {

		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = arg0.getKeyChar();
		if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
				&& c != '9') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}