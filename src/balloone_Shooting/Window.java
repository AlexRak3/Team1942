package balloone_Shooting;

 
import javax.swing.*;
 
/**
 * Starts the game without menu
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public class Window {

	 /**
	  * main method
	  * @param args
	  */
	public static void main(String[] args) {
		 
	 	 
		Combine c = new Combine();
		JFrame f = new JFrame("1942");
		 
		f.add(c);
		f.setResizable(false);
		f.setSize(800,700);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		  
	}
}