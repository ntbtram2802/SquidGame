package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.Subject_Time;

public abstract class Entity {
    protected GamePanel gp;
    protected int x; 
    protected int y; 
    protected int speed; 
    protected BufferedImage image, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10,
            image11, image12, image13, image14, image15, image16, image17, image18, image19, image20;

    protected String direction; 
    protected int spriteCounter;
    protected int spriteNum;
    protected int actionLockCounter; 
    protected boolean timeDeath;
    protected boolean alive;
    protected boolean win;
    protected Subject_Time subject;

    public Entity(GamePanel gp, Subject_Time subject) {
        this.gp = gp;
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void getImage();

    public abstract void update();

    public void setDefault() { // Initial nhung gia tri dau tien cho nhan vat
        x = GamePanel.tilesize * 8; // ban dau nhan vat se co vi tri 500 so voi truc x cua man hinh
        y = GamePanel.tilesize * 19; // ban dau nhan vat se co vi tri 900 so voi truc y cua man hinh
        speed = 1; // van toc cua nhan vat = 0.2
        actionLockCounter = 0;
        spriteCounter = 0;
        spriteNum = 1;
        direction = "up";
        timeDeath = false;
        alive = true;
        win = false;
    }
 // getter + setter of variable: direction, x, y, speed
    public void setDirection(String d) { this.direction = d;}
    public String getDirection() {return direction;}
    public void setX(int x) {this.x = x;}
    public int getX() {return x; }
    public void setY(int y) {this.y = y;}
    public int getY() {return y;}
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
// getter + setter of variable associate to gameplay. 
    public boolean getalive() {return alive;}
    public void setalive(boolean t) {this.alive = t;}
    public void setwin(boolean t) {this.win = t;}
    public boolean getwin() {return win;}
    public void setchecktime(boolean t) {this.timeDeath = t;} 
    public void draw(Graphics2D g2) { 
    	 if (win == false && alive == true) {
            BufferedImage image = null;
            switch (direction) {
                case "stand":
                    image = image10;
                case "up":
                    if (spriteNum == 1) {
                        image = image1; // up1
                    } else if (spriteNum == 2) {
                        image = image2; // up2
                    }
                    break;

                case "down":
                    if (spriteNum == 1) {
                        image = image4; // down1
                    } else if (spriteNum == 2) {
                        image = image5;// down2
                    }
                    break;

                case "left":
                    if (spriteNum == 1) {
                        image = image6; // left1
                    } else if (spriteNum == 2) {
                        image = image7; // left2
                    }
                    break;

                case "right":
                    if (spriteNum == 1) {
                        image = image8;// right1
                    } else if (spriteNum == 2) {
                        image = image9; // right2
                    }
                    break;
            }
            g2.drawImage(image, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        } else if (alive == false) {
            dyingAnimation(g2);
        }
    }
    public void dyingAnimation(Graphics2D g2) {
        actionLockCounter++;
        int i = 5;
        if (actionLockCounter <= i) {
            g2.drawImage(image11, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }
        if (actionLockCounter > i * 2 && actionLockCounter <= i * 3) {
            g2.drawImage(image12, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }
        if (actionLockCounter > i * 4 && actionLockCounter <= i * 5) {
            g2.drawImage(image13, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }
        if (actionLockCounter > i * 6 && actionLockCounter <= i * 7) {
            g2.drawImage(image14, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }
        if (actionLockCounter > i * 8 && actionLockCounter <= i * 9) {
            g2.drawImage(image15, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        }
        if (actionLockCounter > i * 10) {
            g2.drawImage(image20, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        } // dying = false;alive = false;
    }
}