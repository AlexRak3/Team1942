 
	package gamePlayer;
	import java.awt.event.*;
	
	/**
	 * This reacts to selections from the menu, and also
	 * implements the keyboard shortcuts.
	 * @author Ilya Rakevich
	 */
	public class GameMenueController extends KeyAdapter implements ActionListener{
	private GameModel model;
	private GameView view;


	public GameMenueController(GameModel model, GameView view){
		this.model = model;
		this.view = view;
	}//end of constructor
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Exit")) {
			view.dispose();
			System.exit(0);
		} else if (command.equals("Pause/Continue")) {
			model.setPause(! model.getPause());
	}
	}// end of actionPerformed
	}//end of class gameMenueController
 
