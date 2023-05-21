package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import Map.Background;
import main.*;
import entity.*;

public class gameOver extends GUI_Manager {

    public gameOver(GamePanel gp) {
		super(gp);
	}
    @Override
    public void draw(Graphics2D g2) {
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
