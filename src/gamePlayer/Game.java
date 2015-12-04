package gamePlayer;

import javax.swing.JFrame;

public class Game {
 
	 /**
	  * Create the objects for the model, view and controller,
	  * and launch the application.
	  */
	public static void main(String[] args) {
		//create new model, view and controller 
		GameModel model = new GameModel();
		GameView view = new GameView(model);
		GameMenueController menuController = new GameMenueController(model, view);
		 GameSwitcherController controller = new GameSwitcherController(view, model);
		//register a controller
        view.register(controller);
 
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(640, 960);
		view.setVisible(true);
		

	}

}
