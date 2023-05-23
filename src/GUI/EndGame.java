package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class EndGame extends GUI_Manager{

	public EndGame(GamePanel gp) {
		super(gp);
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(new Color(80, 0, 0));
		g2.setFont(g2.getFont().deriveFont(60F));
		 x = 200;
		 y = GamePanel.tilesize*7;
		int width = GamePanel.tilesize*8;
		int height = GamePanel.tilesize*2;
		g2.fillRoundRect(x, y, width, height, 35, 35);
		Color c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
	}

}
