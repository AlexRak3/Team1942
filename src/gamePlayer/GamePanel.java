package gamePlayer;

import java.awt.*;
import javax.swing.*;

 

public class GamePanel extends JPanel {
	private GameModel model;
	private GameView view;
	  Image img;
	  Timer time;
	private int xS = 0; 
	private int yS =0;
	public GamePanel(GameModel model, GameView view){
		this.model = model;
		this.view = view;
		ImageIcon i = new ImageIcon("sky640x960.png");
		img = i.getImage();
		
		// so this JPanel can listen to the keyboard
		this.setFocusable(true);
		//time = new Timer(5, this) ;
		//time.start();
	}
	
	/**
	 * Draw    
	 */
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D) g;
		 GamePanel sky = new GamePanel(model, view);
		g2d.drawImage(sky.getImageSky(), sky.getX(), sky.getY(), null);
	}
	 
	private Image getImageSky() { 
		return img;
	}
	public int getyS(){
		return yS;
	}
	public int getxS(){
		return xS;
	}
}//end class GamPanel
