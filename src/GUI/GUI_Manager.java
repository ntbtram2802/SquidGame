package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public abstract class GUI_Manager {
	protected GamePanel gp;
    protected int x,y;
    
    public GUI_Manager (GamePanel gp) {
    	this.gp = gp;
    }
    public abstract void draw(Graphics2D g2);
    	
}

