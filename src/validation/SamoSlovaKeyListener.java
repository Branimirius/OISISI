//referenca: vezbe 4 -> dogadjaji
package validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Key Listener koji proverava validnost prilikom popunjavanja polja u kojima se ne sme pojaviti nista osim slova.
 * Dozvoljava samo unos slova u tekucem polju. Koristi se u svakom dijalogu.
 * @author Filip
 *
 */
public class SamoSlovaKeyListener implements KeyListener{
	
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

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = arg0.getKeyChar();
		if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' 
				|| c == '8' || c == '9' || c == '0' ||  c == '!'  || c == '~' || c == '@' 
				|| c == '#' || c == '$'  || c == '%' || c == '^' || c == '&' || c == '*' 
				|| c == '(' || c == ')' || c == '_' || c == '-' || c == '=' || c == '+' 
				|| c == '|' || c == ']' || c == '[' || c == '}' || c == '{' || c == '.' 
				|| c == ',' || c == '/' || c == '?' || c == '>' || c == '<' ) {
			JOptionPane.showMessageDialog(null, "Nije dozvoljen unos brojeva i znakova!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
