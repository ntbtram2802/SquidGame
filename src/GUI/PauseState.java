package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Map.Background;
import main.GamePanel;
import main.KeyHandler;

public class PauseState {
    private KeyHandler keyH;
    private Background bg;
    private int commandNum=0;
    Graphics2D g2;
    

    public PauseState(KeyHandler keyH) {
        this.keyH = keyH;
    }
    public int getcommandNum() {return commandNum;}
    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.enterPressed == true) {
            if ((keyH.upPressed == true)) {
                commandNum--;
                
                if (commandNum < 0) {
                    commandNum = 0;
                }
                System.out.println("Up:" + commandNum);
            }

        }
        if ((keyH.downPressed == true)) {
            commandNum++;
            if (commandNum > 1) {
                commandNum = 1;
            }
            System.out.println("Down:" + commandNum);
        }
        if (keyH.enterPressed == true) {
            if (commandNum == 0) { // an enter vao o music thi se tiep tuc
            	GamePanel.ingame.checkVolume();
                 GamePanel.pauseState = false;
                 GamePanel.conitue();
           }
            if (commandNum == 1) {
                System.exit(0);
            }
        }

    }

    public void draw(Graphics2D g2) {
        bg = new Background("/gameplayMenu/optionMenu.png");
        g2.drawImage(bg.getImage(),GamePanel.tilesize, 250, GamePanel.tilesize*8, GamePanel.tilesize*10 , null);

        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
        g2.setColor(new Color(157, 0, 0));
        if (commandNum == 0) {
            g2.drawString(">",GamePanel.tilesize +20, 410);
        } else if (commandNum == 1) {
            g2.drawString(">", GamePanel.tilesize +20, 600);
        }
        	drawvolume(g2);
        
        
    }
    public void drawvolume(Graphics2D g2) {
    	//Ve khung
    	g2.setColor(new Color(80, 0, 0));
    	g2.setFont(g2.getFont().deriveFont(32F));
    	int x = GamePanel.tilesize*10;
    	int y = GamePanel.tilesize*7;
    	int width = GamePanel.tilesize*5;
    	int height = GamePanel.tilesize*5;
    	g2.fillRoundRect(x, y, width, height, 35, 35);
    	Color c = new Color(255,255,255);
    	g2.setColor(c);
    	g2.setStroke(new BasicStroke(5));
    	g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    	//Ve chu VOLUME 
    	g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 40F));
        String text = "VOLUME";
        g2.drawString(text, x+45, y+70);
    	// Ve o nhac
    	g2.drawRect(x+40, y+150, 150, 30);
    	int volumnWidth = 30*GamePanel.ingame.getvolumeSlace();
    	System.out.println(volumnWidth);
    	g2.fillRect(x+40, y+150, volumnWidth, 30);
    }
}
