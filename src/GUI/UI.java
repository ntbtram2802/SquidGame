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
	GamePanel gp;
	Entity e;
	public double time = 60.00;
	public DecimalFormat dFormat = new DecimalFormat("#0.00");
	private boolean gamefinish;

	public void setGameFinish(boolean b) {
		this.gamefinish = b;
	}

	public UI(GamePanel gp) {
		this.gp = gp;
		arial_30 = new Font("Arial", Font.PLAIN, 30);
		arial_40 = new Font("Arial", Font.BOLD, 40);
	}

	public void draw(Graphics2D g2) {
		this.g2 = g2;
		if (GamePanel.gameState == GamePanel.playState) {
			g2.setFont(arial_30);
			g2.setColor(Color.white);
			if (gamefinish == false) {
				gp.playTime -= (double) 1 / 60;
			}
			g2.drawString("Time: " + dFormat.format(gp.playTime), GamePanel.tilesize * 11, GamePanel.tilesize * 2);
		} else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			drawPauseScreen();
		}
	}

	public void drawPauseScreen() {
		String text = "PAUSE";
		int x;
		int y;
		int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		x = GamePanel.screenWidth / 2 - length / 2;
		y = GamePanel.screenHeight / 2 + GamePanel.tilesize;
		g2.drawString(text, x, y);
	}

}