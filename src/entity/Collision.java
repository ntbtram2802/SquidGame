package entity;

import java.awt.Rectangle;

import main.GamePanel;

public class Collision {
    Rectangle playerBox = new Rectangle(0,0,10,10);
    Rectangle npcBox[] = new Rectangle[10];

    public boolean checkColision(PlayerNPC player, PlayerNPC npc[]) {
		int playerleft = player.getX();
		int playerright = GamePanel.tilesize;
		int playertop = player.getY();
		int playerbottom =  GamePanel.tilesize;

        playerBox = new Rectangle(playerleft,playertop,playerright,playerbottom);

        for(int i=0; i<npc.length;i++){
            if((npc[i]!=null)&& (npc[i]!=player)){
                npcBox[i]=new Rectangle(npc[i].getX(), npc[i].getY(),GamePanel.tilesize, GamePanel.tilesize);
                if (npcBox[i].intersects(playerBox)){
                    if(isOpposite(player, npc[i]))
                        return false;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkColision(Player player, PlayerNPC npc[]) {
		
		int playerleft = player.getX();
		int playerright = GamePanel.tilesize;
		int playertop = player.getY();
		int playerbottom =  GamePanel.tilesize;

        playerBox = new Rectangle(playerleft,playertop,playerright,playerbottom);

        for(int i=0; i<npc.length;i++){
            if(npc[i]!=null){
                npcBox[i]=new Rectangle(npc[i].getX(), npc[i].getY(),GamePanel.tilesize, GamePanel.tilesize);
                if (npcBox[i].intersects(playerBox)){
                    if(isOpposite(player, npc[i]))
                        return false;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isOpposite(Entity e1, Entity e2){
        if(e1.getDirection()==e2.getDirection()){
            return true;
        }
        if (e2.getX()<e1.getX() && e1.getDirection()=="right" && e2.getDirection()=="left"){
            return true;
        }
        if (e1.getX()<e2.getX() && e2.getDirection()=="right" && e1.getDirection()=="left"){
            return true;
        }
        if (e2.getY()<e1.getY() && e1.getDirection()=="down" && e2.getDirection()=="up"){
            return true;
        }
        if (e1.getY()<e2.getY() && e2.getDirection()=="down" && e1.getDirection()=="up"){
            return true;
        }
        return false;
    }

}
