import javax.imageio.*;					
import javax.swing.*; 					
import java.awt.*;						
import java.awt.event.*; 				
import java.io.*;		

class gamefield extends JPanel {
	private Image avatar;
	private Image background;
	private Image endGame;
	private gift[] giftsArr;	
	private int difficult;
	public int x = 400; 				
	public Timer timerUpdate, timerDraw;	// declaration array of gifts

	
	public gamefield(int difficult) {
		this.difficult = difficult;
		try {
			avatar = ImageIO.read(new File("./avatar.png"));
		}
		catch(IOException ex) {System.out.println("Can`t load \"avatar\" image");}
		try {
			background = ImageIO.read(new File("./background.jpg"));
		}
		catch(IOException ex) {System.out.println("Can`t load \"background\" image");}
		try {
			endGame = ImageIO.read(new File("./end_game.png"));
		}
		catch(IOException ex) {System.out.println("Can`t load \"end game\" image");}

		giftsArr = new gift[7];										
		for (int i = 0; i < 7; i++) {
			try {
				giftsArr[i] = new gift(ImageIO.read(new File("./p" + i + ".png")));
			}
			catch(IOException ex) {System.out.println("Can`t load \"gift " + i + "\" image");}
		}

		timerUpdate = new Timer(3000, new ActionListener() { 	// add timer for gifts drawings
			public void actionPerformed(ActionEvent e) {
				updateStart();										// method for checking is gifts added at game field
			}
		});
		timerUpdate.start();

		timerDraw = new Timer(50, new ActionListener() { 		// create timer which will repaint game field 20 times per second
			public void actionPerformed(ActionEvent e) {
				repaint(); 											// run method public void paintComponent(Graphics gr) {}
			}
		});
		timerDraw.start(); 											// run timer
	}
	
	public void paintComponent(Graphics gr) { 						// game field repaint method
		super.paintComponent(gr); 									// repaint graphic component
		gr.drawImage(background, 0, 0, null);					
		gr.drawImage(avatar, x , 465, null); 						
		
		// loop for gifts drawing
		for (int i = 0; i < 7; i++) {
			giftsArr[i].draw(gr);
			if (giftsArr[i].act==true) {
				if ((giftsArr[i].y+giftsArr[i].img.getHeight(null))>=400) {
					if (Math.abs(giftsArr[i].x - x) > 75) {		// if gift is lost
						gr.drawImage(endGame, 300, 300, null);
						timerDraw.stop();
						timerUpdate.stop();
						break;
					} else giftsArr[i].act=false;
				}
			}
		}
	}

	private void updateStart() {
		int giftsNumber = 0;
		for (int i = 0; i < 7; i++) {
			if (giftsArr[i].act == false) {
				if (giftsNumber < difficult) {
					giftsArr[i].start();
					break;
				}
			} else giftsNumber++;
		}
	}
}
