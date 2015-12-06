package balloone_Shooting;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Paddle {
	private int x, y;
	private boolean left = false, right = false;;

	Image jet;
	 ImageIcon big = new ImageIcon("jet.png");
	

	public Paddle() {
		x = 395;
		y = 620;
		jet = big.getImage();
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
		
		y = 620;
		 
		jet = big.getImage();
	}

	public void jet_Release() {
		
		y = 610;
		jet = big.getImage();
	}

}
