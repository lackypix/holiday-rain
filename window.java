import javax.swing.*; 								
import java.awt.*;									
import java.awt.event.*;							

class window extends JFrame {
	private gamefield gameF; 						
	private int difficult;								
	
	private class myKey implements KeyListener {	
		public void keyPressed(KeyEvent e) {		
			int key = e.getKeyCode();				
			
			if (key == 27) System.exit(0); 		
			else if (key == 37) {					
				if (gameF.x-30>-48)gameF.x -=30;
				else gameF.x = 752;
			}
			else if (key == 39) { 					
				if (gameF.x+30<752)gameF.x +=30;
				else gameF.x = -48;
			}
			
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}
	
	public window(int difficult) {						// конструктор класса
		this.difficult = difficult;
		addKeyListener(new myKey()); 				// подключаем обработчик событии 
		setFocusable(true);							// активируем и фокусируем окно
		setBounds(0, 0, 800, 600);
		setTitle("Game: New Year`s Rain");
													// создаем панель которая будет лежать в окне
		gameF = new gamefield(difficult);				// создаем объект класса поле
		Container cont = getContentPane();			// создаем контейнер 
		cont.add(gameF);							// связываем окно и панель
		
		setVisible(true);
	}
}
