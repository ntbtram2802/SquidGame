package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class NPC {
	public BufferedImage image,image1, image2, image3;
	public int worldx, worldy;

	public NPC() {	
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

	public void draw_NPC(Graphics2D g2, String action) {
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
		g2.drawImage(image, worldx + GamePanel.tilesize, worldy, GamePanel.tilesize,GamePanel.tilesize, null );
	}
}
