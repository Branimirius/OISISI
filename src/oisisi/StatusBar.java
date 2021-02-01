package oisisi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *  Klasa koja predstavlja statusnu liniju programa, ona je panel na dnu glavnog prozora,
 *  sadrzi naziv aplikacije kao i vreme i datum.
 * @author Branimir
 *
 */
public class StatusBar extends JPanel implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2824424565433334923L;
	
	
	
	/**
	 * Konstruktor statusne linije, koristi tajmer i formater kako bi predstavio trenutno vreme i datum sistema.
	 */
	public StatusBar() {
				
		setLayout(new BorderLayout());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		int screenWidth = screenSize.width*3/4;
		
			JLabel statusLabel = new JLabel("   Studentska služba", JLabel.LEFT);
			JLabel datetimeLabel = new JLabel("",JLabel.RIGHT);
			
			Timer timer = new Timer(1000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss  dd.MM.yyyy.   ");
					datetimeLabel.setText(formatter.format(new GregorianCalendar().getTime() ));					
				}
			} );
			
			timer.start();
																																	
		setBorder(BorderFactory.createLineBorder(Color.black));
		setPreferredSize(new Dimension(screenWidth, 30));
		add(statusLabel, BorderLayout.WEST);
		add(datetimeLabel, BorderLayout.EAST);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
