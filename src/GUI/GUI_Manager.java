package GUI;

import java.awt.Graphics2D;

import main.GamePanel;

public abstract class GUI_Manager {
	protected GamePanel gp;
    public static int commandNum;
    protected int x,y;
    
    public GUI_Manager (GamePanel gp) {
    	this.gp = gp;
    	commandNum = 0;
    }
    public abstract void draw(Graphics2D g2);
}

