package balloone_Shooting;


import javax.swing.JFrame;
/**
 * Starts the menu of the game
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public class Game {
	static JFrame window;
	public static void main(String[] args) {
		 window = new JFrame("1942");
		 window.setContentPane(new GamePanel());
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.setResizable(false);
		 window.pack();
		 window.setVisible(true);
		 window.setLocationRelativeTo(null);

	}
}
