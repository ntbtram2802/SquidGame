package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		setDefault();
		getImage();
	}

	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up1.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up2.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/player/player_up3.png"));
			image10 = ImageIO.read(getClass().getResourceAsStream("/player/player_standd.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/player/player_down1.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/player/player_down2.png"));
			image6 = ImageIO.read(getClass().getResourceAsStream("/player/player_left1.png"));
			image7 = ImageIO.read(getClass().getResourceAsStream("/player/player_left2.png"));
			image8 = ImageIO.read(getClass().getResourceAsStream("/player/player_right1.png"));
			image9 = ImageIO.read(getClass().getResourceAsStream("/player/player_right2.png"));
			image11 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost1.png"));
			image12 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost2.png"));
			image13 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost3.png"));
			image14 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost4.png"));
			image15 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost5.png"));
			image16 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-1.png"));
			image17 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-2.png"));
			image18 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-3.png"));
			image19 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void update() {
		gp.time_win.checkTime(this);
		if (timeDeath == false) {
			if (keyH.upPressed == true || keyH.downPressed == true ||
					keyH.leftPressed == true || keyH.rightPressed == true) {

				if (keyH.upPressed == true) {
					direction = "up";
					if (!gp.c.checkCollision(this, gp.NPC)
							&& !gp.c.checkPossibleMove(this)) {
						y -= speed;
					}

				} else if (keyH.downPressed == true) {
					direction = "down";
					if (!gp.c.checkCollision(this, gp.NPC)
							&& !gp.c.checkPossibleMove(this)) {
						y += speed;
					}

				} else if (keyH.leftPressed == true) {
					direction = "left";
					if (!gp.c.checkCollision(this, gp.NPC)
							&& !gp.c.checkPossibleMove(this)) {
						x -= speed;
					}

				} else if (keyH.rightPressed == true) {
					direction = "right";
					if (!gp.c.checkCollision(this, gp.NPC)
							&& !gp.c.checkPossibleMove(this)) {
						x += speed;
					}

				}

				else {
					direction = "stand";
				}

				spriteCounter++;
				if (spriteCounter > 20) {
					if (spriteNum == 1) {
						spriteNum = 2;
					} else if (spriteNum == 2) {
						spriteNum = 1;
					}
					spriteCounter = 0;
				}

			}
		} else {
			if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
					|| keyH.rightPressed == true) {
				this.dying = true;
				System.out.println("HAAAAA");
			}
		}
		gp.time_win.checkwin(this);

	}

	public void draw(Graphics2D g2) {
		super.draw(g2);
		if (win == true && dying == false) {
			actionLockCounter++;
			int i = 10;
			if (actionLockCounter <= i) {
				g2.drawImage(image16, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
			}
			if (actionLockCounter > i && actionLockCounter <= i * 2) {
				g2.drawImage(image17, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
			}
			if (actionLockCounter > i * 2 && actionLockCounter <= i * 3) {
				g2.drawImage(image18, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
			}
			if (actionLockCounter > i * 3 && actionLockCounter <= i * 4) {
				g2.drawImage(image19, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
				gp.u.setGameFinish(true);
			}
		}
		// g2.draw(gp.c.playerBox);
	}
}