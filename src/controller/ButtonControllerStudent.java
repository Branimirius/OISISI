package controller;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ButtonControllerStudent implements DocumentListener{

	
	JButton button;
	  int br;
	
	  public ButtonControllerStudent(JButton b, int i) {
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
			  		ValidListaStudent.getInstance().validateList(br);
		if (ValidListaStudent.getInstance().listValid())
					button.setEnabled(true);
	  }
}
