package Map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class PauseState {
    private GamePanel gp;
    private KeyHandler keyH;
    private Background bg;

    public PauseState(KeyHandler keyH) {
        this.keyH = keyH;
    }

    public void update() {
        if (keyH.pausePressed == true) {
            
        }
    }

    public void draw(Graphics2D g2) {
        bg = new Background("/menu/menu_squidgame.png");
        bg.setHeight(GamePanel.screenHeight / 2);
        bg.setWidth(GamePanel.screenWidth / 2);
        //System.out.println("call draw");
        bg.draw(g2);
    }

}
