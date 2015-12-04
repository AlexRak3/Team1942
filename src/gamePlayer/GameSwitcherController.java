package gamePlayer;

 
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;



	public class GameSwitcherController implements ActionListener
	{
		private GameModel model;
		private GameView view;
		
		/**
		 * Two-argument constructor
		 * @param view object
		 * @param model object
		 */
		public GameSwitcherController(GameView view, GameModel model){
			this.view = view;
			this.model = model;
			
		}
		/**
		 * switch panels and display a panel
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			  
			 this.model.switchPanel();
			  
			 this.view.displayPanel(this.model.whichPanel());
			
		}

}