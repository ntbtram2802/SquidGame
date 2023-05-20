package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import Map.Background;
import main.*;
import entity.*;

public class gameOver {
    
    private KeyHandler keyH;
    private Graphics2D g2;
    private GamePanel gp;
    private int commandNum = 0;
    private int x,y;

    public gameOver(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.enterPressed == true) {
            if ((keyH.upPressed == true)) {commandNum--;
                if (commandNum < 0) {
                    commandNum = 0;
                }
            }

        }
        if ((keyH.downPressed == true)) {
            commandNum++;
            if (commandNum > 1) {
                commandNum = 1;
            }
        }
        if (keyH.enterPressed == true) {
            if (commandNum == 0) {
            	GamePanel.restart = true;

            }
            if (commandNum == 1) {
                System.exit(0);
            }
        }
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y = GamePanel.tilesize * 5;
        try {
            g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/gameplayMenu/gameOverMenu.png")), x, y,
                    GamePanel.tilesize * 9, GamePanel.tilesize * 10, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setColor(new Color(157, 0, 0));
        if (commandNum == 0) {
            g2.drawString(">", 200, 485);
        } else if (commandNum == 1) {
            g2.drawString(">", 200, 585);
        }
    }
}
