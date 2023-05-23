package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import Map.Background;
import main.*;
import entity.*;

public class gameWin extends GUI_Manager  {
    

    public gameWin(GamePanel gp) {
		super(gp);
	}
    @Override
	public void draw(Graphics2D g2) {
        x = GamePanel.screenWidth / 2 - (GamePanel.tilesize * 9) / 2;
        y = GamePanel.tilesize * 5;
        Background bg = new Background("/gameplayMenu/gameWinMenu.png");
        g2.drawImage(bg.getImage(),x, y, 170*3, 170*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
        g2.setColor(new Color(157, 0, 0));
        g2.setColor(new Color(21, 62, 95));
        if (commandNum == 0) {
            g2.drawString(">", 198, 450);
        } 
        else if (commandNum == 1) {
            g2.drawString(">", 280, 550);
        }
        else if(commandNum == 2) {
        	g2.drawString(">", 218, 650);
        }
    }
}