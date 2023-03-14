package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	public GamePanel gp;
    public int x;
    public int y;
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

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        // int screenX = x - gp.player.x + gp.player.x;
        // int screenY = y - gp.player.y + gp.player.y;

        // if (x + GamePanel.tilesize > gp.player.x - gp.player.x &&
        //         x - GamePanel.tilesize < gp.player.x + gp.player.y &&
        //         y + GamePanel.tilesize > gp.player.y - gp.player.y&&
        //         y - GamePanel.tilesize < gp.player.y + gp.player.y) {

            switch (direction) {
                case "stand":
                    image=stand;
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
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

            }

            g2.drawImage(image, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }

  	

      // NPC movement
      public void setAction() {
      }

      public void update() {
          setAction();
          // collisionOn = false;
          // gp.cChecker.checkTile(this);// collision checker created in GamePanel thuá»™c pháº§n Collision
          // if (collisionOn == false) {
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


}
