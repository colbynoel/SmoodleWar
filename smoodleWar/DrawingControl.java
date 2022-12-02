package smoodleWar;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class DrawingControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	
	public DrawingControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		// If submit is pressed, get our drawing from the drawingPanel
		// Then send to server.
		if(command == "Submit") {
			// TODO: Make correct index
			DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(2);
			Graphics drawing = drawingPanel.getDrawing();
			
			try {
			client.sendToServer(drawing);
			}
			catch (IOException e1) {
				e1.printStackTrace();
				System.err.println("Couldn't send drawing");
			}
		}
		
		// We need to be able to handle clearing the active drawing
		// view if clear button is pressed
	}
}
