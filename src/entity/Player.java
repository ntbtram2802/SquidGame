package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import main.Subject_Time;

public class Player extends Entity {
	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH, Subject_Time subject) {
		super(gp, subject);
		this.keyH = keyH;
		setDefault();
		getImage();
	}
	public void restartplayer() {
		setDefault();
		
	}

	public void getImage() {
		try {
			//Play state
			image1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up2.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up3.png"));
			image10 = ImageIO.read(getClass().getResourceAsStream("/player/player_standd.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/player/player_down1.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/player/player_down2.png"));
			image6 = ImageIO.read(getClass().getResourceAsStream("/player/player_left1.png"));
			image7 = ImageIO.read(getClass().getResourceAsStream("/player/player_left2.png"));
			image8 = ImageIO.read(getClass().getResourceAsStream("/player/player_right1.png"));
			image9 = ImageIO.read(getClass().getResourceAsStream("/player/player_right2.png"));
			//Dead state
			image11 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost1.png"));
			image12 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost2.png"));
			image13 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost3.png"));
			image14 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost4.png"));
			image15 = ImageIO.read(getClass().getResourceAsStream("/ghost/ghost5.png"));
			image20 = ImageIO.read(getClass().getResourceAsStream("/ghost/bia_mo.png"));
			//Win state
			image16 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-1.png"));
			image17 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-2.png"));
			image18 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-3.png"));
			image19 = ImageIO.read(getClass().getResourceAsStream("/playerwin/winState-4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void update() {
		if(!gp.subject.getState()) {

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
				if(gp.c.checkCollision(this, gp.fire)==true) {gp.fire = null; System.out.println("True");}
			}
		} else {
			if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
					|| keyH.rightPressed == true) {
				this.alive = false;

			}
		}
		gp.time_win.checkwin(this);
		if (win==true) {
			GamePanel.stopSE();
			if(gp.level ==3) {
				GamePanel.gameState = GamePanel.endState;
				GamePanel.playMusic(4);//Hang thay nhac khuc nay nha
			}
			else {
			GamePanel.gameState = GamePanel.winState;
			GamePanel.playMusic(2);}
		}
		if(alive == false) {
			GamePanel.gameState = GamePanel.loseState;
			GamePanel.stopMusic();
			GamePanel.stopSE();
			GamePanel.playMusic(1);
		}
	}

	public void draw(Graphics2D g2) {
		super.draw(g2);
		if (win == true && gp.level!=3) {
			actionLockCounter++;
			int i = 10;
			if (actionLockCounter <= i) {g2.drawImage(image16, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
			if (actionLockCounter > i && actionLockCounter <= i * 2) {g2.drawImage(image17, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
			if (actionLockCounter > i * 2 && actionLockCounter <= i * 3) {g2.drawImage(image18, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
			if (actionLockCounter > i * 3 && actionLockCounter <= i * 4) {g2.drawImage(image19, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
			if(actionLockCounter > i*4) {g2.drawImage(image4, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
			}
	}
}