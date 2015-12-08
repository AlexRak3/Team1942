package balloone_Shooting;

/**
 *  Game state's interface
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public abstract class GameState {
	protected GameStateManager gsm;
	/**
	 * Initialize the state of the game
	 */
	public abstract void init();
	/**
	 * Updates gsm
	 */
	public abstract void update();
	 public abstract void draw(java.awt.Graphics g);
	 
	public abstract void keyPressed(int k);
	public abstract void  keyReleased(int k);

}
