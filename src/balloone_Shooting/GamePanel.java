package balloone_Shooting;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
/**
 * displays the menu with moving effect
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public class GamePanel extends JPanel implements Runnable, KeyListener{
	
public static final int WIDTH = 620;
public static final int HEIGHT = 340;
public static final int SCALE = 2;
//image
private BufferedImage image;
private Graphics  g;
//game thread
private Thread thread;
private boolean running;
private int FPS = 60;
private long targetTime = 1000/FPS;
private GameStateManager gsm;

	/**
 	* Non-argument constructor
 	*/
 	public GamePanel(){
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
 	}
 	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		
		}
 	}
 	public void init(){
		image = new BufferedImage(
				WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		g =(Graphics) image.getGraphics();
		running = true;
		gsm = new GameStateManager();
 	}
 	@Override
	public void run() {
		 init();
		long start;
		long elapsed;
		long wait;
		//game loop
		while(running){
			start = System.nanoTime(); 
			update();
			draw();
			try{
			drawToScreen();
			}catch(NullPointerException e){
				
			}
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed/1000000;
			if(wait < 0){
				wait = 5;
			}
			try{
				Thread.sleep(wait);
			}catch(Exception e){
				e.printStackTrace();
			}
	}//end of while
}//end of run
	public void update(){
		gsm.update();
	}
	public void draw(){
		 gsm.draw(g);
		 
	}
	public void drawToScreen(){
		Graphics g2 = getGraphics();
		
		g2.drawImage(image,0,0,null);
		g2.dispose();
		 
	}
	@Override
	public void keyPressed(KeyEvent key) {
		 
		gsm.keyPressed(key.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent key) {
		 
		gsm.keyReleased(key.getKeyCode());
		}
		
	 
	@Override
	public void keyTyped(KeyEvent arg0) {
		 
	}
	public static void close() {
		 System.exit(0);
		 
	}	
	}
