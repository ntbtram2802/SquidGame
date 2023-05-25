package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class EndGame extends GUI_Manager{
	private static int counter = 0;
	Font algerian_80 = new Font("Algerian", Font.PLAIN, 80);
	Font arial_40 = new Font("Arial", Font.BOLD, 40);
	BufferedImage image, image1, image2, image3, image4, image5, image6, image7;
	public EndGame(GamePanel gp) {
		super(gp);
		image = image1;
		getImage();
	}
	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-1.png.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-2.png.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-3.png.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-4.png.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-5.png.png"));
			image6 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-5.png.png"));
			image7 = ImageIO.read(getClass().getResourceAsStream("/EndGame/winState-end-5.png.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		
	}

	@Override
	public void draw(Graphics2D g2) {
		counter++;
		int i = 50;
		g2.setColor(new Color(0,0,0,120));
		g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
		//Congratulations
		String text;		
		g2.setFont(algerian_80);
		g2.setColor(new Color(255,191,28));
		text = "CONGRATULATIONS";
		g2.drawString(text, 12, GamePanel.tilesize*7);
		//image
		if(counter <i) {image = image1;}
		else if(counter<2*i) {image = image2;}
		else if(counter<3*i) {image = image3;}
		else if(counter<4*i) {image = image4;}
		else if(counter<5*i) {image = image5;}
		else if(counter<6*i) {image = image6;}
		else if(counter<7*i) {image = image7;counter= 0;}
		g2.drawImage(image, GamePanel.tilesize*9/2,GamePanel.tilesize*7,GamePanel.tilesize*6,GamePanel.tilesize*7, null);
		
		// 
		  g2.setFont(arial_40);
		  g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
		  g2.setColor(new Color(80, 0, 0));
		  // Replay
		  text = "Replay";
          x = GamePanel.tilesize*13/2;
          y = GamePanel.tilesize * 16;
          g2.drawString(text, x, y);
          if (KeyHandler.commandNum == 0) {
              g2.drawString(">", x-GamePanel.tilesize,y);
          }
          
          //Quit
          text = "QUIT";
          x =  GamePanel.tilesize*13/2;
          y = GamePanel.tilesize * 18;
          g2.drawString(text, x, y);
          //
           if (KeyHandler.commandNum == 1) {
        	   g2.drawString(">", x-GamePanel.tilesize,y);
          }
	}
	


}
