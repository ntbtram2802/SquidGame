package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	KeyHandler keyH;

    public Player (GamePanel gp,KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

    	x = 200;
        y = 500;
        speed = 1;
        direction = "down";
    }

    public void getPlayerImage() {
    	try {
    		up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up1.png"));
    		up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up2.png"));
    		up3 = ImageIO.read(getClass().getResourceAsStream("/player/player_up3.png"));
    		stand = ImageIO.read(getClass().getResourceAsStream("/player/player_standd.png"));
    		down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down1.png"));
    		down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down2.png"));
    		left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left1.png"));
    		left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left2.png"));
    		right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right1.png"));
    		right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right2.png"));
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	  
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || 
                    keyH.leftPressed == true || keyH.rightPressed == true){

                if (keyH.upPressed == true) {
                    direction = "up";
                    y -= speed;
                }
                else if (keyH.downPressed == true) {
                    direction = "down";
                    y += speed;
                } 
                else if (keyH.leftPressed == true) {
                    direction = "left";
                    x -= speed;
                } 
                else if (keyH.rightPressed == true) {
                    direction = "right";
                    x += speed;
                }

                else {
                    direction = "stand";
                }
                
                spriteCounter++;
                if (spriteCounter > 20) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
                }
            
        }

    }


    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "stand":
                image = stand;
                break;
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            /*default:
                throw new IllegalStateException("Unexpected value: " + direction);*/
        }
        g2.drawImage(image, x, y, GamePanel.tilesize, GamePanel.tilesize, null);

    }

}
