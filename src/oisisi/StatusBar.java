package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatusBar extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2824424565433334923L;

	public StatusBar() {
		setLayout(new BorderLayout());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		int screenWidth = screenSize.width*3/4;
		
			JLabel statusLabel = new JLabel("   Studentska služba", JLabel.LEFT);
			
			Date date = new Date(System.currentTimeMillis()); // Ovaj objekat sadrzi trenutni datum
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm  dd.MM.yyyy.   ");
			JLabel datetimeLabel = new JLabel(formatter.format(date),JLabel.RIGHT);
				
			
		setBorder(BorderFactory.createLineBorder(Color.black));
		setPreferredSize(new Dimension(screenWidth, 30));
		add(statusLabel, BorderLayout.WEST);
		add(datetimeLabel, BorderLayout.EAST);
	}
}
