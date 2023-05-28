package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import main.GamePanel;
import entity.Entity;

public class UI extends GUI_Manager {
	Font arial_30;
	Font arial_40;
	private DecimalFormat dFormat = new DecimalFormat("#0.00");

	public UI(GamePanel gp) {
		super(gp);
		arial_30 = new Font("Algerian", Font.PLAIN, 30);
	}

	public void draw(Graphics2D g2) {
		g2.setFont(arial_30);
		g2.setColor(Color.white);
		if (GamePanel.gameState == GamePanel.playState) {
			if (gp.playTime <= (double) 1 / 60) {
				gp.playTime = 0;
			} else {
				gp.playTime -= (double) 1 / 60;
			}
		}
		g2.drawString("Time: " + dFormat.format(gp.playTime), GamePanel.tilesize * 11, GamePanel.tilesize * 2);
	}
}