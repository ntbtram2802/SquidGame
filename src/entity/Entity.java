package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	GamePanel gp;
    public int x, y;
    public int speed;
    

    public BufferedImage up1, up2, up3, stand, down1, down2, left1, left2, right1, right2, chinhdien, xoaylung;
    //Mô tả hình ảnh dưới dạng một thông tin (để lưu trữ file ảnh))

    public String direction, directionbo;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // default solid area for all entity
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false; // phần collision 
    public int actionLockCounter = 0;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    // NPC movement
//    public void setAction() {
//
//    }
//
//    public void update() {
//        setAction();
//
//        // collisionOn = false;
//        // gp.cChecker.checkTile(this);// collision checker created in GamePanel thuộc phần Collision
//
//        // if (collisionOn == false) {
//        switch (direction) {
//            case "up":
//                y -= speed;
//                break;
//            case "down":
//                y += speed;
//                break;
//            case "left":
//                x -= speed;
//                break;
//            case "right":
//                x += speed;
//                break;
//        }
//        // }
//
//        spriteCounter++;
//        if (spriteCounter > 12) {
//            if (spriteNum == 1) {
//                spriteNum = 2;
//            } else if (spriteNum == 2) {
//                spriteNum = 1;
//            }
//            spriteCounter = 0;
//        }
//
//    }
}
