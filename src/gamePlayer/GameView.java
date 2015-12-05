package gamePlayer;

import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*; 

/**
 * This class implements the view of the 1942 game
 * @author Ilya Rakevich
 *
 */
public class GameView extends JFrame {
	private GameModel model;
    private GamePanel gamePanel;
    private JPanel startPanel;
    private JLabel statusBar;
    private JMenu gameMenu;
    private JPopupMenu popupMenu;
    private JButton button;
    private GameSwitcherController controller;
    
    
    public GameView(GameModel model){
    	super("1942");
    	this.model = model;
    	 Font font = new Font("Serif", Font.ITALIC, 30);
    	 JLabel label = new JLabel("1942", JLabel.CENTER);
    	JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        gameMenu = new JMenu("Menu");
        gameMenu.setMnemonic('M');
        menuBar.add(gameMenu);
        
        JMenuItem pauseItem = new JMenuItem("Pause/Continue");
        pauseItem.setMnemonic('P');
        gameMenu.add(pauseItem);
        JMenuItem soundItem = new JMenuItem("Sound ON/OFF");
        soundItem.setMnemonic('S');
        gameMenu.add(soundItem);
        JMenuItem exitItem = new JMenuItem("EXIT");
        exitItem.setMnemonic('E');
        gameMenu.add(exitItem);
        // create the popup menu, need new JMenuItems

        popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("Pause/Continue"));
        popupMenu.add(new JMenuItem("Exit"));
       
        /* CENTER:
         * The panel where 1942 is played
         */
        gamePanel = new GamePanel(model, this);
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.setBackground(Color.GREEN);
        Dimension size = gamePanel.getSize();
        model.setSize(size.width, size.height);
        /* SOUTH:
         * A status bar for telling us what happens.
         */
        statusBar = new JLabel("This is the status bar.",JLabel.CENTER);
        statusBar.setBackground(Color.WHITE);
        statusBar.setOpaque(true);  
        add(statusBar, BorderLayout.SOUTH);

        // so the PongPanel can listen to the keyboard
        gamePanel.requestFocus();
        
        //startup window
       
        startPanel = new JPanel();
        startPanel.setLayout(new BorderLayout());
        
        button = new JButton("Switch Panels");
        button.setFont(font);
        add(button, BorderLayout.NORTH);
        //label which has the name of the game
        
          font = new Font("Serif", Font.BOLD, 55);
        label = new JLabel("1942 GAME", JLabel.CENTER);
        //label.setBackground(Color.GREEN);
        label.setFont(font);
        label.setOpaque(false);
         
        gamePanel.add(label, BorderLayout.SOUTH);
        
    }//end of constructor
    
    public void registerListeners(GameMenueController controller1){ 
    	gamePanel.addKeyListener(controller1);
    
    Component[] components = gameMenu.getMenuComponents();
    for (Component component : components) {
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.addActionListener(controller1);
        }
    }
    components = popupMenu.getComponents();
    for (Component component : components) {
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.addActionListener(controller1);
        }
      }
    }//end method registerListeners
    
    /**
     * Set the text in the status bar.
     * @param text
     */
    public void setStatus(String text) {
        statusBar.setText(text);
    }
    /**
     * Show pop-up menu if indicated.
     * @param event
     */
    public void checkForTriggerEvent(MouseEvent event) {
        if (event.isPopupTrigger()) {
            popupMenu.show(event.getComponent(), event.getX(), event.getY()); 
        }
    }
    /**
     * register method that gives a button access to an actionListener
     * @param controller
     */
    public void register(GameSwitcherController controller){
    	getButton().addActionListener(controller );
    }
    
    /**
     * This method returns a button
     * @return  button
     */
     public JButton getButton(){
    	 return button; 
     }
     /**
      * This seems to be a way to switch JPanels.  Let me know of any bugs
      * or more elegant ways of doing the same task.
      * 
      * @param whichPanel Should panel1 or panel2 be displayed?
      */
     public void displayPanel(int whichPanel) {
         remove(startPanel ); // doesn't seem to mind trying to remove
         remove(gamePanel); // components that are not displayed
         if (whichPanel == 1) {
             System.out.println("Should display panel1");
             add(startPanel, BorderLayout.CENTER);
         } else {
             System.out.println("Should display panel2");
             add(gamePanel, BorderLayout.CENTER);
         }
         validate();
         repaint();
     }
    
}// end class GameView
