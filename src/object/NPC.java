package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.Subject_Time;

public class NPC {
	private BufferedImage image,image1, image2, image3;
	private int x, y;
	private GamePanel gp;
	private String type;
	public NPC(GamePanel gp) {	
		 this.gp = gp;
	     getImage();

	}
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setType(String type) { this.type = type;}
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(type) {
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
		g2.drawImage(image, x + GamePanel.tilesize, y, GamePanel.tilesize,GamePanel.tilesize, null );
	}
	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/Object_guard/npc-round.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/Object_guard/npc-triangle.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/Object_guard/npc-square.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
