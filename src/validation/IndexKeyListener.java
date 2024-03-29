package validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Key Listener koji se koristi pri proveri validnosti popunjavanja polja za indeks.
 * Sluzi za proveru validnosti unetih znakova i ogranicava unos previse karaktera.
 * @author Branimir
 *
 */
public class IndexKeyListener implements KeyListener {

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
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_SHIFT) {
			return;
		}
		JTextField txt = (JTextField) e.getComponent();
		if (txt.getText().length() ==  11) {
			JOptionPane.showMessageDialog(null, "Mo�ete uneti maksimalno 11 karaktera!");
			txt.setText(txt.getText().substring(0, 11));
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
				&& c != '9' && c != '/' && c != '-' && c != 'Q' && c != 'W' && c != 'E' && c != 'R' && c != 'T' && c != 'Y' && c != 'U' && c != 'I'
				&& c != 'O' && c != 'P' && c != 'A' && c != 'S' && c != 'D' && c != 'F' && c != 'G' && c != 'H' && c != 'J' && c != 'K' && c != 'L'
				&& c != 'Z' && c != 'X' && c != 'C' && c != 'V' && c != 'B' && c != 'N' && c != 'M' && e.getKeyCode() != KeyEvent.VK_SHIFT) {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva, velikih slova, kose crte i crtice!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}
		
	}

}
