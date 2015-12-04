package gamePlayer;

public class GameModel {
	private boolean pause;
	
	// properties of the panel
    private int width, height, panel;
	public GameModel(){
		width = 0;
        height = 0;
		pause = false;
		panel=1;
	}
	
	
	public boolean getPause() { 
		 return pause;
	}
	public void setPause(boolean pause){
		this.pause = pause;
	}
	/**
	 * Sets size of the panel
	 * @param width
	 * @param length
	 */
	public void setSize(int width, int length) {
        this.width = width;
        this.height = length;
    }
	/**
     * @return the value of panel
     */
    public int whichPanel() {
        return panel;
    }

    /**
     * Switch panel from 1 to 2 or from 2 to 1, but not from any other number
     * any other other number.
     */
    public void switchPanel() {
        if (panel == 1)
            panel = 2;
        else
            panel = 1;
    }
	
}//end of class GameModel

