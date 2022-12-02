package smoodleWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class DrawingField extends JPanel implements MouseListener, MouseMotionListener {

	public DrawingField() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawString("Blah blah!", 20, 20);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g = this.getGraphics();
		g.setColor(Color.black);
		
		// get X and y position
		int x, y;
		x = e.getX();
		y = e.getY();
		
		// draw a Oval at the point
		// where mouse is moved
		g.fillOval(x, y, 5, 5);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Graphics g = this.getGraphics();
		g.setColor(Color.black);
		
		// get X and y position
		int x, y;
		x = e.getX();
		y = e.getY();
		
		// draw a Oval at the point
		// where mouse is moved
		g.fillOval(x, y, 5, 5);

	}

	// NOT NEEDED
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
