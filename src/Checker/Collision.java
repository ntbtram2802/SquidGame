package Checker;

import java.awt.Rectangle;

import entity.Entity;
import entity.PlayerNPC;
import main.GamePanel;

public class Collision {
    Rectangle playerBox, e1Box, e2Box = new Rectangle(0, 0, 10, 10);
    Rectangle npcBox[] = new Rectangle[10];

    public boolean checkCollision(Entity player, PlayerNPC npc[]) {

        int playerleft = player.getX();
        int playerright = GamePanel.tilesize;
        int playertop = player.getY();
        int playerbottom = GamePanel.tilesize;

        playerBox = new Rectangle(playerleft, playertop, playerright, playerbottom);

        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npcBox[i] = new Rectangle(npc[i].getX(), npc[i].getY(), GamePanel.tilesize, GamePanel.tilesize);
                if (npcBox[i].intersects(playerBox)) {
                    if (isOpposite(player, npc[i]))
                        return false;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkCollision(Entity e1, Entity e2) {
        // int playerleft = e1.getX();
        // int playerright = GamePanel.tilesize;
        // int playertop = e1.getY();
        // int playerbottom = GamePanel.tilesize;

        e1Box = new Rectangle(e1.getX(),e1.getY(),GamePanel.tilesize,GamePanel.tilesize);
        e2Box = new Rectangle(e2.getX(), e2.getY(), GamePanel.tilesize, GamePanel.tilesize);

                if (e2Box.intersects(e1Box)) {
                    if (isOpposite(e1,e2))
                        return false;
                    return true;
                }
        return false;
    }

    public boolean isOpposite(Entity e1, Entity e2) {
        if (e1.getDirection() == e2.getDirection()) {
            return true;
        }
        if (e2.getX() < e1.getX() && e1.getDirection() == "right" && e2.getDirection() == "left") {
            e1.setDirection("left");
            return true;
        }
        if (e1.getX() < e2.getX() && e2.getDirection() == "right" && e1.getDirection() == "left") {
            e1.setDirection("right");
            return true;
        }
        if (e2.getY() < e1.getY() && e1.getDirection() == "down" && e2.getDirection() == "up") {
            e1.setDirection("up");
            return true;
        }
        if (e1.getY() < e2.getY() && e2.getDirection() == "down" && e1.getDirection() == "up") {
            e1.setDirection("down");
            return true;
        }
        return false;
    }

    public boolean checkPossibleMove(Entity e, String direction) {
        switch (direction) {
            case "up":
                if ((e.getY() < 150)) {
                    e.setDirection("down");
                    return true;
                }
                break;
            case "down":
                if (e.getY() > (GamePanel.screenHeight - GamePanel.tilesize)) {
                    e.setDirection("up");
                    return true;
                }
                break;
            case "left":
                if (e.getX() < 0) {
                    e.setDirection("right");
                    return true;
                }
                break;
            case "right":
                if (e.getX() > (GamePanel.screenWidth - GamePanel.tilesize)) {
                    e.setDirection("left");
                    return true;
                }
                break;
        }
        return false;
    }

}
