package entity;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import main.GamePanel;

public class PlayerNPC extends Entity {
	public PlayerNPC(GamePanel gp) {
		super(gp);
		setDefault();
		getImage();
	}

	public void getImage() {

		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_up1.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_up2.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_down1.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_down2.png"));
			image6 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_left1.png"));
			image7 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_left2.png"));
			image8 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_right1.png"));
			image9 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_right2.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAction() {

		actionLockCounter++;
		if (actionLockCounter == 180) { // once pick up a direction it won't change for the next 120 frames with means 2
										// seconds // note that we set FPS is 60

			Random random = new Random();

			int x = random.nextInt(100) + 1; // pick up a number randomly 1-100 plus 1 bc it random from 0-99 and plus 1
												// is 1-100
			int y = random.nextInt(100);

			if (x <= 25) {
				direction = "up";
			}
			if (x > 25 && y <= 50) {
				direction = "down";
			}
			if (x > 50 && y <= 75) {
				direction = "left";
			}
			if (x > 75 && y <= 100) {
				direction = "right";
			}

			actionLockCounter = 0;
		}
	}

	public void update() {
		setAction();
		if (!gp.c.checkCollision(this, gp.player)
			 && !gp.c.checkPossibleMove(this, direction)){
			switch (direction) {
				case "up":
					y -= speed;
					break;
				case "down":
					y += speed;
					break;
				case "left":
					x -= speed;
					break;
				case "right":
					x += speed;
					break;
			}
		}

		spriteCounter++;
		if (spriteCounter > 12) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}

	}

	public void draw(Graphics2D g2) {
		super.draw(g2);
	}

}
