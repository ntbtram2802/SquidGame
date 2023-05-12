package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

import main.GamePanel;

public class UI {
	Graphics2D g2;
	Font arial_30;
	Font arial_40;
	GamePanel gp;
	private  double currenTime;
	protected boolean gamefinish = false;
	public DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI (GamePanel gp) {
		this.gp = gp;
		arial_30 = new Font("Arial", Font.PLAIN,30);
		arial_40 = new Font("Arial", Font.BOLD,40);
	}
	public void setgamefinish(boolean t) {
		this.gamefinish = t;
	}
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		if (GamePanel.gameState == GamePanel.playState) {
			if (gamefinish == true) {
				System.out.println("HAAAAA");
				g2.setFont(arial_30);
				g2.setColor(Color.white);
				
				String text;
				int length;
				int x;
				int y;
				
				g2.setFont(arial_40);
				g2.setColor(Color.white);
				text = "CONGRATULATIONS!";
				length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
				x = gp.screenWidth/2 - length/2;
				y = gp.screenHeight/2 + gp.tilesize;
				g2.drawString(text, x, y);
				gp.gameThread = null;
				
			}
			else {
				g2.setFont(arial_30);
				g2.setColor(Color.white);
				if(gp.pauseState == false) {gp.playTime -=(double)1/60;}
				g2.drawString("Time: "+dFormat.format(gp.playTime),gp.tilesize*11 , gp.tilesize*2);
				
			}
		}
	}

}
