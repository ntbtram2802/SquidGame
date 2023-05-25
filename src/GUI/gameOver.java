package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;
import main.*;

public class gameOver extends GUI_Manager {

    public gameOver(GamePanel gp) {
        super(gp);
    }

    @Override
    public void draw(Graphics2D g2) {
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y = GamePanel.tilesize * 5;
        Background background1 = new Background("/gameplayMenu/gameOverMenu.png");
        g2.drawImage(background1.getImage(),x, y,  GamePanel.tilesize *9 , GamePanel.tilesize * 10, null);
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 65F));
        g2.setColor(new Color(21, 62, 95));
        if (gp.keyH.commandNum == 0) {
            g2.drawString(">", 215, 495);
        } else if (gp.keyH.commandNum == 1) {
            g2.drawString(">", 215, 595);
        }
    }
}
