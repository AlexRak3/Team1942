package gamePlayer;

import java.awt.event.*;

 
/**
 * This class passes the decision to show the pop-up menu to the GameView
 * @author Ilya Rakevich
 *
 */
public class GamePopupController extends MouseAdapter {
	private GameModel model;
	private GameView view;
	
	/**
	 * Two argument constructor
	 * @param model
	 * @param view
	 */
	public GamePopupController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Go back to the view object to do the pop up menu.
	 */
	public void mousePressed(MouseEvent event) { 
	       view.checkForTriggerEvent(event);  
	    }
	/**
	 * Go back to the view object to do the pop up menu.
	 */
	public void mouseReleased(MouseEvent event) { 
	       view.checkForTriggerEvent(event); // check for trigger
	    } 
}//end of class GamePopupController

