package validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Key Listener koji proverava validnost tokom popunjavanja polja za godinu izvodjenja predmeta.
 * Dozvoljava samo unos jednocifrenih brojeva od 1 do 6.
 * @author Filip
 *
 */
public class GodIzvodjenjaKeyListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) e.getComponent();
		if (txt.getText().length() ==  1) {
			JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 1 karakter!");
			txt.setText(txt.getText().substring(0, 1));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = e.getKeyChar();
		if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva, od 1 do 6!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}
		
	}

}
