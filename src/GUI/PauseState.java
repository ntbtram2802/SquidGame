package GUI;

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
    

    public PauseState(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.enterPressed == true) {
            if ((keyH.upPressed == true)) {
                commandNum--;
                System.out.println("Up:" + commandNum);
                if (commandNum < 0) {
                    commandNum = 0;
                }
            }

        }
        if ((keyH.downPressed == true)) {
            commandNum++;
            if (commandNum > 1) {
                commandNum = 1;
            }
        }
        if (keyH.enterPressed == true) {
            if (commandNum == 0) {
                
                GamePanel.stopMusic();
            }
            if (commandNum == 1) {
                System.exit(0);
            }
        }

    }

    public void draw(Graphics2D g2) {
        bg = new Background("/gameplayMenu/optionMenu.png");
        g2.drawImage(bg.getImage(),200, 250, GamePanel.tilesize*8, GamePanel.tilesize*10 , null);

        g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
        g2.setColor(new Color(157, 0, 0));
        if (commandNum == 0) {
            g2.drawString(">",215, 410);
        } else if (commandNum == 1) {
            g2.drawString(">", 215, 600);
        }
        
    }

}
