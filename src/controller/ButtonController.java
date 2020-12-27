//reference: http://www.java2s.com/Tutorials/Java/Swing/JButton/Enable_or_disable_a_JButton_based_on_JTextField_content_in_Java.htm
//ref : https://stackoverflow.com/questions/23856818/set-enable-button-if-text-field-is-fill
package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class ButtonController implements DocumentListener {
	  JButton button;
	  
	  public ButtonController(JButton b) {
	    button = b;
	  }

	  public void changedUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void insertUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void removeUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void disableIfEmpty(DocumentEvent e) {
		  button.setEnabled(e.getDocument().getLength() > 0);
	  }

	}