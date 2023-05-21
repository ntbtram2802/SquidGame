package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import main.GamePanel;
import entity.Entity;

public class UI {
	Graphics2D g2;
	Font arial_30;
	Font arial_40;
	private GamePanel gp;
	private DecimalFormat dFormat = new DecimalFormat("#0.00");

	public UI(GamePanel gp) {
		this.gp = gp;
		arial_30 = new Font("Arial", Font.PLAIN, 30);
		arial_40 = new Font("Arial", Font.BOLD, 40);
	}

	public void draw(Graphics2D g2) {
		this.g2 = g2;
			g2.setFont(arial_30);
			g2.setColor(Color.white);
			if (gp.gameState == gp.playState) {
				if(gp.playTime <= (double) 1 / 60) {gp.playTime = 0;}
				else {gp.playTime -= (double) 1 / 60;}
			}
			g2.drawString("Time: " + dFormat.format(gp.playTime), GamePanel.tilesize * 11, GamePanel.tilesize * 2);
	}



}