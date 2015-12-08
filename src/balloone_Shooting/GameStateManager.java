package balloone_Shooting;

import java.util.ArrayList;

 
/**
 * Manages different states of the game
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public class GameStateManager {
	private ArrayList<GameState> gameStates;
	private int currentState;
	
	public static final int MENUESTATE = 0;
	public static final int LEVEL1STATE = 1;
	
	public GameStateManager(){
		gameStates = new ArrayList<GameState>();
	  currentState = MENUESTATE;
	  
	  
	  gameStates.add(new MenuState(this));
	  // gameStates.add(new Level1State(this));
	  
	}//end of constructor
	
	public void setState(int state){
		currentState = state;
		 // gameStates.get(currentState).init();
	}
	public void update(){
		gameStates.get(currentState).update();
		
	}
	 public void draw(java.awt.Graphics g){
	 
		gameStates.get(currentState).draw(g);
	}
	public void keyPressed(int k){
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k){
		gameStates.get(currentState).keyReleased(k);
	}
	public void add( ){
		gameStates.add( new Level1State(this) );
	}
}// end of class
