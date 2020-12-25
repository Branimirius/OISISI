package oisisi;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerTabs implements ChangeListener {
	
	
	public static int sel;
	
	
	

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane pane = (JTabbedPane) e.getSource();
		sel = pane.getSelectedIndex();
		System.out.println(pane.getSelectedIndex());
		
	}




	public int getSel() {
		return sel;
	}




	public void setSel(int sel) {
		ChangeListenerTabs.sel = sel;
	}

	

}
