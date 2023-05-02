package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true ||
                keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
                if (!gp.c.checkCollision(this, gp.NPC)) {
                    y -= speed;
                }
                
            } else if (keyH.downPressed == true) {
                direction = "down";
                if (!gp.c.checkCollision(this, gp.NPC)) 
                    y += speed;
                
            } else if (keyH.leftPressed == true) {
                direction = "left";
                if (!gp.c.checkCollision(this, gp.NPC)) 
                    x -= speed;
                
            } else if (keyH.rightPressed == true) {
                direction = "right";
                if (!gp.c.checkCollision(this, gp.NPC)) 
                    x += speed;
                
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

    }

    public void draw(Graphics2D g2) {
        super.draw(g2);
        // g2.draw(gp.c.playerBox);
    }

}

