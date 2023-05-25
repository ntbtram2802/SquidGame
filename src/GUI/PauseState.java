package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;
import main.GamePanel;
import main.KeyHandler;

public class PauseState extends GUI_Manager {
    private Background bg;

    public PauseState(GamePanel gp) {
		super(gp);
	}
 @Override
	public void draw(Graphics2D g2) {
        bg = new Background("/gameplayMenu/optionMenu.png");
        g2.drawImage(bg.getImage(),180, 255, GamePanel.tilesize*10, GamePanel.tilesize*11 , null);

        // VOLUME BAR
        g2.setColor(new Color(21, 62, 90));
    	int volumnWidth = 68*GamePanel.ingame.getvolumeSlace();
    	g2.fillRect(260, 490, volumnWidth, 40);



        //ARROW SELECT
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 85));
        g2.setColor(new Color(21, 62, 95));
        if (KeyHandler.commandNum == 0) {
            g2.drawString(">",220, 430);
        } else if (KeyHandler.commandNum == 1) {
            g2.drawString(">", 220, 680);
        }          
    }

}
