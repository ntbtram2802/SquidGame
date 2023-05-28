package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;
import main.*;

public class GameWin extends GUI_Manager {
    private Background gameWin;

    public GameWin(GamePanel gp) {
        super(gp);
    }

    @Override
    public void draw(Graphics2D g2) {
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y = GamePanel.tilesize * 5;
        gameWin = new Background("/gameplayMenu/gameWinMenu.png");
        g2.drawImage(gameWin.getImage(), x, y, 170 * 3, 170 * 3, null);

        // ARROW SELECT
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
        g2.setColor(new Color(21, 62, 95));
        if (gp.keyH.commandNum == 0) {
            g2.drawString(">", 198, 450);
        } else if (gp.keyH.commandNum == 1) {
            g2.drawString(">", 280, 550);
        } else if (gp.keyH.commandNum == 2) {
            g2.drawString(">", 218, 650);
        }
    }
}
