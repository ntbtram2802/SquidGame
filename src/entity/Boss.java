package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Boss extends Entity{
	private int size=32;

	public Boss(GamePanel gp) {
		super(gp);
		getImage();	
		direction = "xoaylung";
	}
	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/Boss/boss_chinhdien.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/Boss/boss_xoaylung.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
	}

	public void update() {
		gp.time_win.checkTime(this);
		if(timeDeath == false) {direction = "xoaylung";}
		else {direction = "chinhdien";}
	}
	
	public void draw (Graphics2D g2) {
		BufferedImage image = null;
		switch(direction) {
		case "xoaylung":
			image = image2;
			break;
		case "chinhdien":
			image = image1;
			break;	
		}
		g2.drawImage(image, size*11, GamePanel.tilesize *5/2,size*GamePanel.scale,size*GamePanel.scale, null);
	}
}
