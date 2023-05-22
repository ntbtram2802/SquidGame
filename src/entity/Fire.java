package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Fire extends Entity {
	public static int i = 0;
	BufferedImage image = image1;
	public Fire(GamePanel gp) {
		super(gp);
		setposition();
		getImage();
		
	}
	public void setposition() {
		Random random = new Random();
		int x_position = random.nextInt(15) + 1;
		x =x_position * gp.tilesize;
		y = gp.tilesize * 12;
		
	}

	@Override
	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/fire/fire1.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/fire/fire2.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/fire/fire3.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/fire/fire4.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/fire/fire5.png"));
			image6 = ImageIO.read(getClass().getResourceAsStream("/fire/fire6.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update() {
		actionLockCounter++;
		if (actionLockCounter == 70) {
			i++;
			actionLockCounter =0;
		}
		if(i == 1) {image = image1;}
		else if(i==2) {image = image2;}
		else if(i==3) {image = image3;}
		else if(i==4) {image = image4;}
		else if(i==5) {image = image5;}
		else if(i==6) {image = image6;i=0;}
		
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(image, x, y,gp.tilesize*3/2,gp.tilesize*3/2, null);
	}
		
}
