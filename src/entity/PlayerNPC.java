package entity;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import main.GamePanel;

public class PlayerNPC extends Entity {
	private static String type;

	public PlayerNPC(GamePanel gp) {
		super(gp);
		setDefault();
	}

	public void setType(String type) {
		PlayerNPC.type = type;
	}

	public void getImage() {
		try {
			if (type.equals("nau")) {
				image1 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_up1.png"));
				image2 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_up2.png"));
				image4 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_down1.png"));
				image5 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_down2.png"));
				image6 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_left1.png"));
				image7 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_left2.png"));
				image8 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_right1.png"));
				image9 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_right2.png"));
			}
			if (type.equals("trang")) {
				image1 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_up1.png"));
				image2 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_up2.png"));
				image4 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_down1.png"));
				image5 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_down2.png"));
				image6 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_left2.png"));
				image7 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_left3.png"));
				image8 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_right2.png"));
				image9 = ImageIO.read(getClass().getResourceAsStream("/NPC_trang/npc_trang_right3.png"));
			}
			if (type.equals("xanh")) {
				image1 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_up1.png"));
				image2 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_up2.png"));
				image4 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_down1.png"));
				image5 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_down2.png"));
				image6 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_left1.png"));
				image7 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_left2.png"));
				image8 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_right1.png"));
				image9 = ImageIO.read(getClass().getResourceAsStream("/NPC_xanh/npc_girl_right2.png"));
			}
			//Dead state
			image11 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost1.png"));
			image12 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost2.png"));
			image13 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost3.png"));
			image14 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost4.png"));
			image15 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost5.png"));
			image20 = ImageIO.read(getClass().getResourceAsStream("/ghost/bia_mo.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAction() {

		actionLockCounter++;
		if (actionLockCounter == 100) { // once pick up a direction it won't change for the next 120 frames with means 2
										// seconds // note that we set FPS is 60

			Random random = new Random();
			int x = random.nextInt(100) + 1; // pick up a number randomly 1-100 plus 1 bc it random from 0-99 and plus 1
												// is 1-100
			if (x < 40) {
				direction = "up";
			}
			else if (x <= 50) {
				direction = "down";
			}
			else if (x <= 75) {
				direction = "left";
			}
			else {
				direction = "right";
			}
			actionLockCounter = 0;
		}
	}

	public void update() {
		Random random = new Random();
		gp.time_win.checkTime(this);
		if (timeDeath == false) { // khuc boss quay len -> time song
			setAction();
			if (!gp.c.checkCollision(this, gp.player)
					&& !gp.c.checkPossibleMove(this)
					&& !gp.c.checkCollision(this, gp.NPC)&&!gp.c.checkCollision(this, gp.fire)) {
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
		} else { // khuc quyet dinh song chet trong time chet
			int x = random.nextInt(1200) + 1;
			if (x == 10) {
				actionLockCounter = 0;
				this.alive = false;
			}
		}
		gp.time_win.checkwin(this);
		if(win == true) {
			int y_win = random.nextInt(25)+5;
			y = y-y_win;
		}

	}

	public void draw(Graphics2D g2) {
		super.draw(g2);
		if (win == true) {
			g2.drawImage(image4, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
		}
	}

}
