package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Boss extends Entity{
	static int count = 0;

	public Boss(GamePanel gp) {
		super(gp);
		setDefaultValues();
		getBossImage();
		
	}
	public void setDefaultValues() {
		directionbo = "xoaylung";
	}
	public void getBossImage() {
		try {
			chinhdien = ImageIO.read(getClass().getResourceAsStream("/Boss/boss_chinhdien.png"));
			xoaylung = ImageIO.read(getClass().getResourceAsStream("/Boss/boss_xoaylung.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
	public void update() {
		count++;
		if (count < 400 ) {
			directionbo = "xoaylung";
		}
		if(count> 400 && count<550) {
			directionbo = "chinhdien";
		}
		if (count>=550) {
			count=0;
		}
	}
	public void draw (Graphics2D g2) {
		BufferedImage image = null;
		switch(directionbo) {
		case "xoaylung":
			image = xoaylung;
			break;
		case "chinhdien":
			image = chinhdien;
			break;	
		}
		g2.drawImage(image, 300, 125, GamePanel.tilesize*2,GamePanel.tilesize*2, null );
	}
	

}
