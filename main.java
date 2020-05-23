import javax.swing.*;

public class main {											
	public static void main(String[] args) {				
		
		String choise = JOptionPane.showInputDialog(null, "Choose the difficulty of the game from 0 to 7", "Game difficulty", 1);
		int difficult = choise.charAt(0)-'0';					// Transfer choice value to integer type variable take char and subtract char 'zero'
		
		if ((difficult >= 1) && (difficult <= 7)) {
			window nw = new window(difficult);					
		}
				
	}
}