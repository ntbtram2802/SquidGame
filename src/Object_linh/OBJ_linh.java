package Object_linh;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_linh extends superobject {

	public OBJ_linh() {
		
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
	
	
}
