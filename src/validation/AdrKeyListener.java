/**
 * validation je paket koji zaokruzuje sve koriscene Key Listener komponente aplikacije.
 */
package validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Key Listener koji se koristi pri proveri validnosti popunjavanja polja za adresu.
 * Sluzi za proveru validnosti unetih znakova i ogranicava unos previse karaktera.
 * @author Branimir
 *
 */
public class AdrKeyListener implements KeyListener{
	
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
			if (txt.getText().length() == 25) {
				JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 25 karaktera!");
				txt.setText(txt.getText().substring(0, 25));
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
			if (     c == '!'  || c == '~' || c == '@' 
					|| c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' 
					|| c == '(' || c == ')' || c == '_' || c == '-' || c == '=' || c == '+' 
					|| c == '|' || c == ']' || c == '[' || c == '}' || c == '{' || c == '.' 
					|| c == '/' || c == '?' || c == '>' || c == '<') {
				JOptionPane.showMessageDialog(null, "Nije dozvoljen unos znakova!");
				JTextField txt = (JTextField) arg0.getComponent();
				txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

			}

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}
}
