package l_1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class m_1 {

	public static void main(String[] args) {
		okno window = new okno();
		
	}

}

class okno extends JFrame {
	
	public okno() {
		setBounds(-10, 0, 800, 600);
		setTitle("mouse controlling");
		panel pan = new panel();
		Container con = getContentPane();
		con.add(pan);
		setVisible(true);

	}
}
class panel extends JPanel {
	private Color[] masColor;
	private int tCol = 0;
	private int mX, mY;
	private boolean flag = false;
	
	public panel() {
		addMouseListener(new myMouse1());
		addMouseMotionListener(new myMouse2());
		setFocusable(true);
	}
	
	
	public void paintComponent(Graphics gr) {
		masColor = new Color[7];
		Color col1 = new Color(255,255,255);
		masColor[0] = Color.BLACK;
		masColor[1] = Color.GREEN;
		masColor[2] = Color.BLUE;
		masColor[3] = Color.RED;
		masColor[4] = Color.YELLOW;
		masColor[5] = Color.WHITE;
		masColor[6] = Color.ORANGE;
		for (int i = 0; i < 7; i++) {
			gr.setColor(masColor[i]);
			gr.fillRect(i*100, 0, 100, 50);
		}
			gr.setColor(masColor[tCol]);
			gr.fillRect(mX, mY, 3, 3);
			if (tCol == 7) {
				gr.setColor(masColor[7]);
				gr.fillRect(mX, mY, 10, 10);
			
			
		}
	}
	
	public class myMouse1 implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {	
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			int tX = e.getX();
			int tY = e.getY();
			int col = e.getClickCount();
			int btn = e.getButton();
			if ((tX>0) && (tX<700) && (tY>0) && (tX<700)) {
				if (col == 1) {
					if (btn == 1) {tCol=tX/100;}
				}
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			flag = false;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		
		@Override
		public void mouseExited(MouuseEvent e) {
		}	
	}
	
	public class myMouse2 implements MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			int tX = e.getX();
			int tY = e.getY();
			
			if (tY > 50) {
				mX = tX;
				mY = tY;
				flag = true;
				repaint();
			}
			
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println(e.getX()+"   " + e.getY());
			int tX = e.getX();
			int tY = e.getY();
			if (tX>0 && tX<700 && tY>0 && tY<50) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
}

