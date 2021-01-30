//referenca: vezbe 4 -> dogadjaji
//sta mail ne sme da sadrzi reference -> https://support.google.com/mail/answer/9211434?hl=en

package validation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Key Listener koji proverava validnost tokom popunjavanja polja za e mail adresu studenta ili profesora.
 * dozvoljava unos 25 karaktera maksimalno, pri cemu nije moguce uneti  brojeve i znakove.
 * @author Branimir
 *
 */
public class MailKeyListener implements KeyListener{
	
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
		if (   c == '&'  || c == '=' || c == '_' || c == '-' || c == '+' || c == ',' 
				|| c == '=' || c == '>' || c == '<' ) {
			JOptionPane.showMessageDialog(null, "Nije dozvoljen unos brojeva i znakova!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}