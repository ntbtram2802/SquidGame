package Object_linh;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class superobject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldx, worldy;
	
	public void draw(Graphics2D g2) {
		g2.drawImage(image, worldx, worldy, GamePanel.tilesize, GamePanel.tilesize, null);
	}

}
