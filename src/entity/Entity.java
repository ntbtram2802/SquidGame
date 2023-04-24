package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;


public abstract class Entity {
	public GamePanel gp;
    protected int x; //Vi tri cua nhan vat tren truc x cua man hinh
    protected int y; //Vi tri cua nhan vat tren truc y cua man hinh
    protected double speed; // Van toc di chuyen cua nhan vat
    protected BufferedImage image, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10;
 

    protected String direction; // huong cua nhan vat
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected  int actionLockCounter = 0; // so lan ham update duoc goi ke tu khi tro choi bat dau

    public Entity(GamePanel gp) {
        this.gp = gp;

    }

      public void setDefault() { // Initial nhung gia tri dau tien cho nhan vat
        x = 500; // ban dau nhan vat se co vi tri 500 so voi truc x cua man hinh
        y = 900; // ban dau nhan vat se co vi tri 900 so voi truc y cua man hinh
		speed =1.5; // van toc cua nhan vat = 1.5
		direction = "down";
	}
      public void setdirection (String d) { //ham thay doi huong cua nhan vat
    	  this.direction = d;
      }
      
      public void setx (int x) { //method thay doi vi tri cua nhan vat theo truc x
    	  this.x = x;
      }
      public void sety (int y) { //method thay doi vi tri cua nhan vat theo truc y
    	  this.y = y;
      }

    public abstract void getImage(); //method lay hinh anh
    public abstract void update(); //method update nhan vat


    public void draw(Graphics2D g2) { // update roi ve hinh anh moi update

        BufferedImage image = null;

            switch (direction) {
                case "stand":
                    image=image10;
                case "up":
                    if (spriteNum == 1) {
                        image = image1; //up1
                    }
                    if (spriteNum == 2) {
                        image = image2; //up2
                    }
                    break;

                case "down":
                    if (spriteNum == 1) {
                        image = image4; //down1
                    }
                    if (spriteNum == 2) {
                        image = image5;//down2
                    }
                    break;

                case "left":
                    if (spriteNum == 1) {
                        image = image6; // left1
                    }
                    if (spriteNum == 2) {
                        image = image7; //left2
                    }
                    break;

                case "right":
                    if (spriteNum == 1) {
                        image = image8;//right1
                    }
                    if (spriteNum == 2) {
                        image = image9; //right2
                    }
                    break;

            }

            g2.drawImage(image, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }


}
