package smoodleWar.Tests;

import static org.junit.Assert.*;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import smoodleWar.*;

public class DrawingTest {

	private static DrawingPanelTesting dp;
	private static GameControl drawingControl;
	private DrawingField df;
	private JButton submit;
	private JButton clear;
	private ArrayList<Point> points = new ArrayList<Point>();

	
	@BeforeClass
	public static void setup() {
		GameClient client = new GameClient();
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
		GameData gameData = new GameData();
		drawingControl = new GameControl(container, client, gameData);
		dp = new DrawingPanelTesting(drawingControl);
	}
	
	@Before
	public void setupBeforeTest() throws Exception{
		df = dp.getDrawingField();
		submit = dp.getSubmitButton();
		clear = dp.getClearButton();
		int startX = 40;
		int startY = 40;
		Point point;
		for(int i = 0; i < 20; i++) {
			startX += i;
			point = new Point(startX, startY);
			points.add(point);
		}
		
		for(int i = 0; i < 20; i++) {
			startY += i;
			point = new Point(startX, startY);
			points.add(point);
		}
		
		for(int i = 19; i > 0; i--) {
			startX -= i;
			point = new Point(startX, startY);
			points.add(point);
		}
		
		for(int i = 19; i > 0; i--) {
			startY -= i;
			point = new Point(startX, startY);
			points.add(point);
		}
		df.setDrawingCoords(points);
		Thread.sleep(500);
	}
	
	@Test
	public void testDrawing() {
		if(points.equals(df.getDrawingCoords())) {
			assertEquals(points, df.getDrawingCoords());
		}
	}

}
