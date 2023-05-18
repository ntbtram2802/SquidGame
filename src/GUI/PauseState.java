package GUI;

import java.awt.Graphics2D;

import Map.Background;
import main.GamePanel;
import main.KeyHandler;

public class PauseState {
    // private GamePanel gp;
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
                    System.out.println("afterup:" + commandNum);
                }
            }

        }
        if ((keyH.downPressed == true)) {
            commandNum++;
            if (commandNum > 1) {
                commandNum = 1;
                System.out.println("afterDown:" + commandNum);
            }
            System.out.println("Down:" + commandNum);
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
    }

}
