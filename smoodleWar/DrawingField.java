package smoodleWar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingField extends JPanel implements MouseListener, MouseMotionListener {

	//private BufferedImage image;
	private ArrayList<Point> coordinates;
	
	public DrawingField() {
		//image = new BufferedImage(500,500.BufferedImage.TYPE_INT_);
		coordinates = new ArrayList<Point>();
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(getPreferredSize());
	}
	
	@Override
	public Dimension getPreferredSize(){
		Dimension size = super.getPreferredSize();
		size.width = 500;
		size.height = 500;
		return size;
		
	}
	
	public ArrayList<Point> getDrawingCoords(){
		return coordinates;
	}
	
	// This method is for displaying the drawing on the guesser's pov
	public void setDrawingCoords(ArrayList<Point> coordinates) {
		this.coordinates = coordinates;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;
		
		graphics.setColor(Color.black);

		// Loops through the ArrayList of Points and connects them on each re-draw
		for (int i = 1; i < coordinates.size(); i++) {
			
			int startx = (int) coordinates.get(i - 1).getX();
			int starty = (int) coordinates.get(i - 1).getY();
			int endx = (int) coordinates.get(i).getX();
			int endy = (int) coordinates.get(i).getY();

			graphics.setStroke(new BasicStroke(5));
			graphics.drawLine(startx, starty, endx, endy);
		}
		//g.drawString("Blah blah!", 20, 20);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point coord = new Point();
		coord.setLocation(e.getX(), e.getY());
		
		coordinates.add(coord);
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
//		Point coord = new Point();
//		coord.setLocation(e.getX(), e.getY());
//		
//		point.add(coord);
//		repaint();
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
