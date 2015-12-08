package balloone_Shooting;

import java.awt.*;
import java.awt.event.KeyEvent;
import TileMap.Background;
/**
 * Displays the menu of the game
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public class MenuState extends GameState {
	private Background bg;
	//to keep track of selected choice
	private int currentChoice =0 ;
	private String[] options ={"Start", "Help", "Quit"};
	private Color titleColor;
	private Font titleFont, font;
	
public MenuState(GameStateManager gsm){
	this.gsm = gsm;
	try{
		bg= new Background("Jets.jpg", 1);
		bg.setVector(-0.1,  0);
		titleColor = new Color(128,0,0);
		titleFont = new Font("Century Gothic", Font.BOLD, 65);
		font = new Font("Arial", Font.PLAIN, 34);
	}catch(Exception e){
		e.printStackTrace();
	}
}

	public void init(){
	}
	public void update(){
		bg.update();
	}
	 public void draw(Graphics  g){
	 
		 bg.draw(g);
		  
		//draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("1942", 230, 70);
		
		//draw menu options
		g.setFont(font);
		for(int i=0; i<options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.BLACK);
			}else{
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 270, 140+ i*65);
		}
		
	}
	public void select(){
		if(currentChoice == 0){
			gsm.add();
			  gsm.setState(GameStateManager.LEVEL1STATE);
			  Game.window.dispose();
		}
		if(currentChoice ==1){
			System.out.println("Help");
		}
		if(currentChoice == 2){
			 System.exit(0);
		}
	}
	public void keyPressed(int k){
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k ==KeyEvent.VK_UP){
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = options.length -1;
			}
		}
		if(k == KeyEvent.VK_DOWN){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice =0;
			}
		}
	}
	public void keyReleased(int k){
		
	}

	 
}