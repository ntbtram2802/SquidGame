package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import GUI.GUI_Manager;
import Map.Background;
import main.GamePanel;
import main.KeyHandler;

public class GameOver extends GUI_Manager {
	private Background gameOver;

    public GameOver(GamePanel gp) {
        super(gp);
    }

    @Override
    public void draw(Graphics2D g2) {
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y = GamePanel.tilesize * 5;

        gameOver = new Background("/gameplayMenu/gameOverMenu.png");
        g2.drawImage(gameOver.getImage(), x, y, GamePanel.tilesize * 9, GamePanel.tilesize * 10, null);

        // ARROW SELECT
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 65F));
        g2.setColor(new Color(21, 62, 95));
        if (KeyHandler.commandNum == 0) {
            g2.drawString(">", 215, 495);
        } else if (KeyHandler.commandNum == 1) {
            g2.drawString(">", 215, 595);
        }
    }
}
