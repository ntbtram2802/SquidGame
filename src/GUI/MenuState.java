package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import Map.Background;
import main.GamePanel;

public class MenuState extends GUI_Manager {

    public MenuState(GamePanel gp) {
        super(gp);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(157, 120, 100));
        g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
        x = 60;
        y = GamePanel.tilesize * 2;
        Background background1 = new Background("/menu/menu_squidgame.png");
        g2.drawImage(background1.getImage(), x, y, GamePanel.tilesize * 13, GamePanel.tilesize * 4, null);

        // MENU IMAGE
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y += GamePanel.tilesize * 5;
        Background background2 = new Background("/menu/menu_background.png");
        g2.drawImage(background2.getImage(), x, y, GamePanel.tilesize * 9, GamePanel.tilesize * 10, null);
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

        if (gp.keyH.commandNum == 0) {
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
        if (gp.keyH.commandNum == 1) {
            g2.drawString(">", x - GamePanel.tilesize, y);
        }

        // BOSS IMAGE MENU
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 15) / 2;// =24
        y += GamePanel.tilesize - 100;
        Background background3 = new Background("/Boss/boss_chinhdien.png");
        g2.drawImage(background3.getImage(), x, y, GamePanel.tilesize * 6, GamePanel.tilesize * 7, null);
    }

}
