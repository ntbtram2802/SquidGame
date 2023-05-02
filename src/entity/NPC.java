package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class NPC extends Entity{
//	public BufferedImage image,image1, image2, image3;
//	public int worldx, worldy;

	public NPC(GamePanel gp) {	
		 super(gp);
	        setDefault();
	        getImage();

	}
	@Override
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
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
	@Override
	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/Object_guard/npc-round.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/Object_guard/npc-triangle.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/Object_guard/npc-square.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void update() {
	}
}
