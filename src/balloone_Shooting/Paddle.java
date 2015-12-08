package balloone_Shooting;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
 * Sets the jet
 * @author  Ilya Rakevich && Aaron Hinzey
 *
 */
public class Paddle {
	private int x, y;
	private int width, height;
	private boolean left = false, right = false;;
	private int explosion =0;
	Image jet,jetExplosion;
	 ImageIcon big = new ImageIcon("jet.png");
	 ImageIcon exp = new ImageIcon("jetExplosion.png");
	 /**
	  * non-argument constructor
	  */
	public Paddle() {
		x = 395;
		y = 610;
		 
			jet = big.getImage();
			width = jet.getWidth(null);
			height = jet.getHeight(null);
		 
			jetExplosion = exp.getImage();
			width = jetExplosion.getWidth(null);
			height = jetExplosion.getHeight(null);
		 
		
	}
	 
	public int explosion(int i){
		explosion = i;
	return explosion;	
	}
		 
	 
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	
	public boolean getLeft() {
		return left;

	}

	public boolean getRight() {
		return right;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public Image getImageExplosion(){
		return jetExplosion;
	}
	
	public Image getImage() {
		return jet;
	}

	public void left() {
		x -= 2;
		if (x <= 0)
			x = 0;
	}

	public void right() {
		x += 2;
		if (x >= 706)
			x = 706;
	}

	public void jet_Pressed() {
		
		y = 610;
		 
		jet = big.getImage();
	}

	public void jet_Release() {
		
		y = 600;
		jet = big.getImage();
	}

	public Rectangle getBounds() {
		return new Rectangle( x, y, width, height);
	}

}

