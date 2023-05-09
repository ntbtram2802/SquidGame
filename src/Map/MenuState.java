package Map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import main.KeyHandler;
import javax.imageio.ImageIO;

import main.GamePanel;

public class MenuState {
    private KeyHandler keyH;
    public int commandNum = 0;

    public MenuState(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.enterPressed == true) {

            if ((keyH.upPressed == true)) {
                commandNum--;
                System.out.println("Up:"+commandNum);
                if (commandNum < 0) {
                     commandNum = 0;
                    System.out.println("afterup:"+commandNum);
                }
            }

        }if ((keyH.downPressed == true)) {
            commandNum++;
            if (commandNum >1 ) {
                commandNum = 1;
            System.out.println("afterDown:"+commandNum);
            }
            System.out.println("Down:"+commandNum);
        }
        if (keyH.enterPressed == true) {
            if (commandNum == 0) {
                GamePanel.gameState = GamePanel.playState;
                GamePanel.stopMusic();
               GamePanel.playSE(0);;
                
            }
            if (commandNum == 1) {
                System.exit(0);
            }
        }

    }

    public void draw(Graphics2D g2) {

        g2.setColor(new Color(157, 120, 100));
        g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);

        int x = 60;
        int y = GamePanel.tilesize * 2;
        try {
            g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/menu/menu_squidgame.png")), x, y,
                    GamePanel.tilesize * 13, GamePanel.tilesize * 4, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // MENU IMAGE
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y += GamePanel.tilesize * 5;
        try {
            g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/menu/menu_background.png")), x, y,
                    GamePanel.tilesize * 9, GamePanel.tilesize * 10, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // MENU BUTTON
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));

        String text = "Start";
        x = 320;
        y += GamePanel.tilesize * 5;
        g2.setColor(new Color(80, 0, 0));
        g2.drawString(text, x, y);

        // button shadow
        g2.setColor(new Color(157, 0, 0));
        g2.drawString(text, x + 3, y + 3);
     
        if (commandNum == 0) {
            g2.drawString(">", x - GamePanel.tilesize, y);
        }
        text = "Quit";
        x = 325;
        y += GamePanel.tilesize * 2;
        g2.setColor(new Color(80, 0, 0));
        g2.drawString(text, x, y);

        // button shadow
        g2.setColor(new Color(157, 0, 0));
        g2.drawString(text, x + 3, y + 3);
        if (commandNum == 1) {
            g2.drawString(">", x - GamePanel.tilesize, y);
        }

        // BOSS IMAGE MENU
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 15) / 2;//=24
        y += GamePanel.tilesize - 100;
        try {
            g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/Boss/boss_chinhdien.png")), x, y,
                    GamePanel.tilesize * 6, GamePanel.tilesize * 7, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
