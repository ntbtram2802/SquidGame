package Checker;

import java.awt.Rectangle;
import java.util.ArrayList;

import entity.Entity;
import object.Fire;
import entity.PlayerNPC;
import main.GamePanel;

public class Collision {
    private Rectangle e1Box, e2Box, e1FutureBox = new Rectangle(0, 0, 10, 10);

    public boolean checkCollision(Entity player, ArrayList< PlayerNPC> npcs) {

        for (PlayerNPC npc: npcs) {
                if (checkCollision(player, npc)) {
                    switch (player.getDirection()) {
                        case "up":
                            player.setDirection("down");
                            break;
                        case "down":
                            player.setDirection("up");
                            break;
                        case "left":
                            player.setDirection("right");
                            break;
                        case "right":
                            player.setDirection("left");
                            break;
                    }
                    return true;
                }
        }
        return false;
    }

    public boolean checkCollision(Entity e1, Entity e2) {
        e1Box = new Rectangle(e1.getX(), e1.getY(),
                GamePanel.tilesize - 6, GamePanel.tilesize - 6);
        e2Box = new Rectangle(e2.getX(), e2.getY(),
                GamePanel.tilesize - 6, GamePanel.tilesize - 6);

        // draw a rectangle in front of the entity
        switch (e1.getDirection()) {
            case "up":
                e1FutureBox = new Rectangle(e1.getX(), e1.getY() - 1,
                        GamePanel.tilesize - 6, 1);
                break;
            case "down":
                e1FutureBox = new Rectangle(e1.getX(), e1.getY() + GamePanel.tilesize - 6 + 1,
                        GamePanel.tilesize - 6, 1);
                break;
            case "left":
                e1FutureBox = new Rectangle(e1.getX() - 1, e1.getY(),
                        1, GamePanel.tilesize - 6);
                break;
            case "right":
                e1FutureBox = new Rectangle(e1.getX() + GamePanel.tilesize - 6 + 1, e1.getY(),
                        1, GamePanel.tilesize - 6);
                break;
        }

        if (e1FutureBox.intersects(e2Box) && e1.getwin() == false && e2.getwin() == false) {
            return true;
        }
        return false;
    }

    public boolean checkPossibleMove(Entity e) {
        switch (e.getDirection()) {
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
    public boolean pickup(Entity e1, Fire fire) {
    	if(fire !=null) {
    		  e2Box = new Rectangle(fire.getX(), fire.getY(),
    	                GamePanel.tilesize, GamePanel.tilesize+20);

    	        // draw a rectangle in front of the entity
    	        switch (e1.getDirection()) {
    	            case "up":
    	                e1FutureBox = new Rectangle(e1.getX(), e1.getY() - e1.getSpeed(),GamePanel.tilesize, GamePanel.tilesize);
    	                if (e1FutureBox.intersects(e2Box)) {e1.setDirection("down");return true;}
    	                break;
    	            case "down":
    	                e1FutureBox = new Rectangle(e1.getX(), e1.getY() + e1.getSpeed(),GamePanel.tilesize, GamePanel.tilesize);
    	                if (e1FutureBox.intersects(e2Box)) {e1.setDirection("up");return true;}
    	                break;
    	            case "left":
    	                e1FutureBox = new Rectangle(e1.getX() - e1.getSpeed(), e1.getY(),GamePanel.tilesize, GamePanel.tilesize);
    	                if (e1FutureBox.intersects(e2Box)) {e1.setDirection("right");return true;}
    	                break;
    	            case "right":
    	                e1FutureBox = new Rectangle(e1.getX() +e1.getSpeed(), e1.getY(),GamePanel.tilesize, GamePanel.tilesize);
    	                if (e1FutureBox.intersects(e2Box)) {e1.setDirection("left");return true;}
    	                break;
    	        }       
    	}
    	return false;
    }


}
