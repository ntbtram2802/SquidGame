package Object_linh;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_linh {
	public BufferedImage image1, image2, image3;
	public int worldx, worldy;
	GamePanel gp;
	public OBJ_linh(GamePanel gp) {
		this.gp = gp;
		getPlayerImage();

	}
	public void getPlayerImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/Object_linh/npc-round.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/Object_linh/npc-triangle.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/Object_linh/npc-square.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw (Graphics2D g2, String action, int worldx, int worldy) {
		BufferedImage image = null;
		switch(action) {
		case "round":
			image = image1;
		case "triangle":
			image = image2;
		case "square":
			image = image3;
	
		}
		g2.drawImage(image, worldx, worldy, GamePanel.tilesize,GamePanel.tilesize, null );
	}

}
