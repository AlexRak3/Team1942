package balloone_Shooting;
//final game
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


import javax.swing.*;

import Audio.AudioPlayer;
 

public class Combine extends JPanel  implements ActionListener {
	//public class Combine extends GameState implements ActionListener{
		Image back_Ground;
		Timer timer;
		private AudioPlayer music;
		private boolean end = false;
		private int hits;
		private int lives;
		private JLabel statusBar;
		private boolean explosion = false;
		
		Paddle paddle;
		ArrayList<FireBall> fireballs_array;
		ArrayList<Missiles> missile_array;
		ArrayList<Paddle> paddle_array;
		FireBall fireBall;
		private HashMap<String, AudioPlayer> sfx;
		private boolean fire;
		private GameStateManager gsm;
		private Font font;
		
		

		//public Combine(GameStateManager gsm) {
		public Combine() {
			gsm = new GameStateManager();
			hits =0;
			lives = 3;
			font = new Font("Century Gothic", Font.BOLD, 24);
			statusBar = new JLabel( ); 
			setStatusBar("Level 1 Lives: 3 Hits: 0");
			statusBar.setFont(font);
			statusBar.setForeground(Color.GRAY);
	        statusBar.setOpaque(false);
	        
	        add(statusBar, BorderLayout.SOUTH);
			addKeyListener(new Action());
			
			ImageIcon ii = new ImageIcon("skybackground.png");
			
			 //HashMap for sounds effects
			 sfx = new HashMap<String, AudioPlayer>();
			 sfx.put("shoot", new AudioPlayer("Missile.wav"));
			 sfx.put("explosion", new AudioPlayer("Explosion.wav"));
			 sfx.put("jetExplosion", new AudioPlayer("jetExplosion.wav"));
			 //background music
			 //add Libs to play mp3: right click on project - Build Path- add Jars
			 if(end == false){
			    music = new AudioPlayer("Background.wav") ;
			    music.play();
			 }
			 
			fireballs_array = new ArrayList<FireBall>();
			missile_array = new ArrayList<Missiles>();

			paddle = new Paddle();
			setFocusable(true);
			back_Ground = ii.getImage();
			 
			timer = new Timer(70, this);
			timer.start();
			Thread startMissiles = new Thread(new Runnable() {
				public void run() {
					while (true)
						try {
							Missiless();
							Thread.sleep(1000 * 2 );
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

				}
			});
			startMissiles.start();
			Thread startFire = new Thread(new Runnable() {
				public void run() {
					while (true)
						try {
							//System.out.println("fire " + fire);
							if (fire == true) {
								fire();
							}
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

				}
			});
			startFire.start();
			
			Thread movePaddle = new Thread(new Runnable() {
				public void run() {
					while (true)
						try {
							if (paddle.getLeft() == true) {
								paddle.left();
							}
							if (paddle.getRight() == true) {
								paddle.right();
							}
							Thread.sleep(9);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

				}
			});
			movePaddle.start();
			
		}// end of constructor
		
		public boolean isFire() {
			return fire;
		}

		public void setFire(boolean fire) {
			this.fire = fire;
		}
		public int getHits(){
			return hits;
		}
	 	public void setStatusBar(String string){
	 		statusBar.setText(string);
	 	} 
		 
		public void actionPerformed(ActionEvent arg0) {
			 
		
			for (int k = 0; k < fireballs_array.size(); k++) {
				fireballs_array.get(k).move();
				if (fireballs_array.get(k).getY() < 1) {
					fireballs_array.remove(k);
				}
			}
			for (int i = 0; i < missile_array.size(); i++) {
				missile_array.get(i).move();
				if (missile_array.get(i).getY() > 600) {
					missile_array.remove(i);
				}
			}
			Thread collide = new Thread(new Runnable() {

				public void run() {
					 
					collision();
					jetCollision();
					 
				}

			});
			collide.start();
			
			repaint();
		}

		public void paintComponent(Graphics g) {
			
			g.clearRect(0,0, WIDTH, HEIGHT);
			g.drawImage(back_Ground, 0, 0, null);
			//if game over draw GameOver
			if(end == true){
				g.setFont(new Font("Century Gothic", Font.BOLD, 46)); 
				g.setColor(Color.BLACK);
				g.drawString("GAME OVER", 260, 300);
			}else{
				//if a missile hits the jet
			if(explosion == true){
				g.drawImage(paddle.getImageExplosion(), paddle.getX(), paddle.getY(), null);
			}else{
			g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), null);
			}
			explosion = false;
			if (!missile_array.isEmpty()) {
				for (int i = 0; i < missile_array.size(); i++) {
					g.drawImage(missile_array.get(i).getImage(), missile_array.get(i)
							.getX(), missile_array.get(i).getY(), null);
				}
			}
			if (!fireballs_array.isEmpty()) {
				for (int k = 0; k < fireballs_array.size(); k++) {
					g.drawImage(fireballs_array.get(k).getImage(), fireballs_array
							.get(k).getX(), fireballs_array.get(k).getY(), null);
				}
			}

		}
		}
		public void Missiless() {
			Random rn = new Random();
			int ran = rn.nextInt(730);
			Missiles ball = new Missiles(ran);
			missile_array.add(ball);
			
		}

		public void fire() {
			fireBall = new FireBall(paddle.getX() + 35);
			// fireBall.setY(20);
			fireballs_array.add(fireBall);
			//plays a sound when shoot
			sfx.get("shoot").play();
		} 
		public void jetCollision(){
			//jet's rectangle
			 Rectangle rJ = paddle.getBounds();
			for (int j = 0; j < missile_array.size(); j++) {
				Rectangle rM = missile_array.get(j).getBounds();
				//if a missile hits the jet
				if(rM.intersects(rJ)){
					 
					explosion = true;
					missile_array.remove(j);
					//plays a sound when jet explode
					if(end == false)
					sfx.get("jetExplosion").play();
					
					lives--;
					if(lives == 0){
						//System.exit(0); 
						end = true;
					}else if(lives < 0 ){
						lives = 0;
					}
					//update the counter
					setStatusBar("Level 1"
							 + " Lives: "+ lives 
							 + " Hits: " + hits );
					 
					
				}
				
			}
			
		}
		public void collision() {
			
			for (int k = 0; k < fireballs_array.size(); k++) {
				for (int j = 0; j < missile_array.size(); j++) {
					//fire's rectangle
					Rectangle r1;
					if(!fireballs_array.isEmpty()){
						 r1 = fireballs_array.get(k).getBounds();
						
					//missile's rectangle
					Rectangle r2 = missile_array.get(j).getBounds();
					 
					if (r1.intersects(r2)) {
					 	
						fireballs_array.remove(k);
						missile_array.remove(j);
						//plays a sound when a missile hits the jet
						sfx.get("explosion").play();
						 hits++;
						 setStatusBar("Level 1"
						 + " Lives: "+ lives 
						 + " Hits: " + hits );
					}
				  }
				}
			}
		}

		 private class Action extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				gsm.keyPressed(e.getKeyCode());
				paddle.jet_Pressed();
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_SPACE) {
					fire = true;
				}

				if (keyCode == KeyEvent.VK_LEFT) {
					paddle.setLeft(true);
				}

				if (keyCode == KeyEvent.VK_RIGHT) {
					paddle.setRight(true);
				}

			}

			public void keyReleased(KeyEvent e) {
				gsm.keyReleased(e.getKeyCode());
				paddle.jet_Release();

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					fire = false;
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					paddle.setLeft(false);
				}

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					paddle.setRight(false);
				}
			}
		 }
	 

		 
	}