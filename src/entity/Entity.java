package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;

public abstract class Entity {
    public GamePanel gp;
    protected int x; // Vi tri cua nhan vat tren truc x cua man hinh
    protected int y; // Vi tri cua nhan vat tren truc y cua man hinh
    protected double speed; // Van toc di chuyen cua nhan vat
    protected BufferedImage image, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10,
            image11, image12, image13, image14, image15, image16, image17, image18, image19;

    protected String direction; // huong cua nhan vat
    protected int spriteCounter = 0;
    protected int spriteNum = 1;
    protected int actionLockCounter = 0; // so lan ham update duoc goi ke tu khi tro choi bat dau
    protected boolean timeDeath;
    protected boolean alive;
    protected boolean dying;
    protected boolean win;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public abstract void getImage();

    public abstract void update();

    public void setDefault() { // Initial nhung gia tri dau tien cho nhan vat
        x = 500; // ban dau nhan vat se co vi tri 500 so voi truc x cua man hinh
        y = 900; // ban dau nhan vat se co vi tri 900 so voi truc y cua man hinh
        speed = 1; // van toc cua nhan vat = 1.5
        direction = "up";
        timeDeath = false;
        alive = true;
        dying = false;
        win = false;
    }

    public void setDirection(String d) { // ham thay doi huong cua nhan vat
        this.direction = d;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(int x) { // method thay doi vi tri cua nhan vat theo truc x
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) { // method thay doi vi tri cua nhan vat theo truc y
        this.y = y;
    }

    public int getY() {
        return y;
    }

    // public double getSpeed() {
    // return speed;
    // }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getalive() {
        return alive;
    }

    public boolean getdying() {
        return dying;
    }

    public void setdying(boolean t) {
        this.dying = t;
    }

    public void setwin(boolean t) {
        this.win = t;
    }

    public boolean getwin() {
        return win;
    }

    public void setchecktime(boolean t) {
        this.timeDeath = t;
    }

    public void draw(Graphics2D g2) { // update roi ve hinh anh moi update
        if (dying == false && win == false) {
            BufferedImage image = null;
            switch (direction) {
                case "stand":
                    image = image10;
                case "up":
                    if (spriteNum == 1) {
                        image = image1; // up1
                    }
                    if (spriteNum == 2) {
                        image = image2; // up2
                    }
                    break;

                case "down":
                    if (spriteNum == 1) {
                        image = image4; // down1
                    }
                    if (spriteNum == 2) {
                        image = image5;// down2
                    }
                    break;

                case "left":
                    if (spriteNum == 1) {
                        image = image6; // left1
                    }
                    if (spriteNum == 2) {
                        image = image7; // left2
                    }
                    break;

                case "right":
                    if (spriteNum == 1) {
                        image = image8;// right1
                    }
                    if (spriteNum == 2) {
                        image = image9; // right2
                    }
                    break;
            }
            g2.drawImage(image, x, y, GamePanel.tilesize, GamePanel.tilesize, null);
        } else if (dying == true) {
            dyingAnimation(g2);
        }
    }

    public void dyingAnimation(Graphics2D g2) {
        actionLockCounter++;
        int i = 5;
        if (actionLockCounter <= i) {g2.drawImage(image11, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
        if (actionLockCounter > i * 2 && actionLockCounter <= i * 3) {g2.drawImage(image12, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
        if (actionLockCounter > i * 4 && actionLockCounter <= i * 5) {g2.drawImage(image13, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
        if (actionLockCounter > i * 6 && actionLockCounter <= i * 7) {g2.drawImage(image14, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
        if (actionLockCounter > i * 8 && actionLockCounter <= i * 9) {g2.drawImage(image15, x, y, GamePanel.tilesize, GamePanel.tilesize, null);}
        if (actionLockCounter > i * 10) {dying = false;alive = false;}
    }
}