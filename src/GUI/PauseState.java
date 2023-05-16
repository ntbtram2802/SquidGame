package GUI;

import java.awt.Graphics2D;
// import java.io.IOException;
// import java.util.Scanner;

// import javax.imageio.ImageIO;

import Map.Background;
import main.GamePanel;
import main.KeyHandler;

public class PauseState {
    // private GamePanel gp;
    private KeyHandler keyH;
    private Background bg;
    private int subState=0;
    private int textX,textY;

    public PauseState(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void update() {

    }

    public void draw(Graphics2D g2) {
        bg = new Background("/gameplayMenu/optionMenu.png");
        g2.drawImage(bg.getImage(),200, 250, GamePanel.tilesize*8, GamePanel.tilesize*10 , null);
        // System.out.println("call draw");
        //bg.draw(g2);
    }

}
