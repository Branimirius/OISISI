package validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
* Key Listener koji se koristi pri proveri validnosti popunjavanja polja za ESPB bodove.
 * Sluzi za proveru validnosti unetih znakova i ogranicava unos previse karaktera.
 * @author Branimir
 *
 */
public class EspbKeyListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 *Ova funkcija se poziva pri unosenju karaktera u txtField, koristimo je za ogranicenje broja unetih karaktera.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) e.getComponent();
		if (txt.getText().length() ==  2) {
			JOptionPane.showMessageDialog(null, "Mo�ete uneti maksimalno 2 karaktera!");
			txt.setText(txt.getText().substring(0, 2));
		}
		
	}

	/**
	 *Ova funkcija se poziva nako unosa karaktera u txtField, koristimo je da bi ogranicili unos odredjenih karaktera.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = e.getKeyChar();
		if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
				&& c != '9') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}
		
	}

}
