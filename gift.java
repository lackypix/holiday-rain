import java.awt.*; 												
import java.awt.event.*;
import javax.swing.*;

public class gift { 											
	public int x, y;											
	public Image img;											
	public Boolean act;											
	private Timer timerUpdate;									
	
	public gift(Image img) {
		
		this.img = img;											// transfer of image received by constructor to class variable
		act = false;	
		
		timerUpdate = new Timer(500, new ActionListener() { 	// timer object with our chosen properties
			public void actionPerformed(ActionEvent e) {
				down();											// method that is responsible for gifts down movement
			}
		});

	}
	
	public void start() {										// method with activate gifts
		timerUpdate.start();									
		y = 0;													
		x = (int)(Math.random()*700);							// horizontal coordinate is defined by random if not int x = 0.1.. 1.0
		act = true;												// set gift visible
	}

	void down() {
		if (act == true) y+=10;									// move gift down on 6px
		if (y + img.getHeight(null)>=480) timerUpdate.stop();	// if gift going out of game field stop timer
	}
	
	public void draw(Graphics gr) {
		if (act==true) {
			gr.drawImage(img,x,y,null);
		}
	}

}