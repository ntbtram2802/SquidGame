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
		setDefault();
		getImage();
		
	}
	public void setDefaultValues() {
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
		actionLockCounter++;
		if (actionLockCounter < 400 ) { // 400 lan update dau tien thi con boss se o huong xoay lung
			direction = "xoaylung";
		}
		if(actionLockCounter> 400 && actionLockCounter<550) { // sau do con boss se quay lai trong 150 lan update
			direction = "chinhdien";
		}
		if (actionLockCounter>=550) {
			actionLockCounter=0;
		}
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
		g2.drawImage(image, 352, 120,size*GamePanel.scale,size*GamePanel.scale, null);
	}
	

}
