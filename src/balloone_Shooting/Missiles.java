package balloone_Shooting;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Sets enemy's missiles 
 * @author Ilya Rakevich && Aaron Hinzey
 *
 */
public class Missiles {
	private int x, y, width, height;
	private Image img;
	
	public Missiles(int x) {
		ImageIcon ic = new ImageIcon("Missiles.png");
		img = ic.getImage();
		this.x = x;
		y = 0;
		width = img.getWidth(null);
		height = img.getHeight(null);
	}

	public int getX()
	{
		if(x<=30)
		return x = 30;
		return x ;
	}
	public int getY()
	{
		return y;
	}
	public void move() {
		y+= 8;
	}
	public Image getImage()
	{
		return img;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}