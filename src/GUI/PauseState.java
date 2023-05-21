package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;
import main.GamePanel;
import main.KeyHandler;

public class PauseState extends GUI_Manager {
   

    public PauseState(GamePanel gp) {
		super(gp);
	}
 @Override
	public void draw(Graphics2D g2) {
        // bg = new Background("/gameplayMenu/optionMenu.png");
        // g2.drawImage(bg.getImage(),200, 250, GamePanel.tilesize*8, GamePanel.tilesize*10 , null);

        //Frame for option menu
    	g2.setColor(new Color(80, 0, 0));
    	g2.setFont(g2.getFont().deriveFont(60F));
    	 x = 200;
    	 y = GamePanel.tilesize*7;
    	int width = GamePanel.tilesize*8;
    	int height = GamePanel.tilesize*9;
    	g2.fillRoundRect(x, y, width, height, 35, 35);
    	Color c = new Color(255,255,255);
    	g2.setColor(c);
    	g2.setStroke(new BasicStroke(5));
    	g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

    	//VOLUME 
    	g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
        String text = "VOLUME";
        g2.drawString(text, x+65, y+140);

        // VOLUME BAR
    	g2.drawRect(x+70, y+160, 250, 30);
    	int volumnWidth = 50*GamePanel.ingame.getvolumeSlace();
    	g2.fillRect(x+70, y+160, volumnWidth, 30);

         //QUIT
         g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
         text = "QUIT";
         g2.drawString(text, x+65, y+300);

        //ARROW SELECT
        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
        if (commandNum == 0) {
            g2.drawString(">",215, y+150);
        } else if (commandNum == 1) {
            g2.drawString(">", 215, y+310);
        }          
    }

}
