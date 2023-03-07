package Object_linh;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class superobject {
	public BufferedImage image,image1, image2, image3;
	public String name;
	public boolean collision = false;
	public int worldx, worldy;
	
	public void draw(Graphics2D g2) {
		g2.drawImage(image, worldx, worldy, GamePanel.tilesize, GamePanel.tilesize, null);
	}
	public void draw_linh(Graphics2D g2, String action) {
		BufferedImage image = null;
		switch(action) {
		case "round":
			image = image1;
			break;
		case "triangle":
			image = image2;
			break;
		case "square":
			image = image3;
			break;
	
		}
		g2.drawImage(image, worldx, worldy, GamePanel.tilesize,GamePanel.tilesize, null );
	}


}
