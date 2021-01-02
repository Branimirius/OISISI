package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ButtonControllerPredmet implements DocumentListener{

	JButton button;
	int br;
	
	public ButtonControllerPredmet(JButton b, int i) {
		    button = b;
		    br = i;
		  }  
	  
	@Override
	public void insertUpdate(DocumentEvent e) {
		disableIfEmpty(e);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		disableIfEmpty(e);
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		disableIfEmpty(e);
		
	}
	
	public void disableIfEmpty(DocumentEvent e) {
		  if (e.getDocument().getLength() > 0) 
			  		ValidListaPredmet.getInstance().validateList(br); 
		  if(ValidListaPredmet.getInstance().listValid())
					button.setEnabled(e.getDocument().getLength() > 0);
	  }

}
