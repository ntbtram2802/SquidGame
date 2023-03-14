package main;

import NPC_object.NPC;
import NPC_object.PlayerNPC;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		gp.obj[1] = new NPC();
		gp.obj[1].worldx = 1*GamePanel.tilesize;
		gp.obj[1].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[2] = new NPC();
		gp.obj[2].worldx = 3*GamePanel.tilesize;
		gp.obj[2].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[3] = new NPC();
		gp.obj[3].worldx = 5*GamePanel.tilesize;
		gp.obj[3].worldy = 3*GamePanel.tilesize;
		
		
		
		gp.obj[4] = new NPC();
		gp.obj[4].worldx = 9*GamePanel.tilesize;
		gp.obj[4].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[5] = new NPC();
		gp.obj[5].worldx = 11*GamePanel.tilesize;
		gp.obj[5].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[6] = new NPC();
		gp.obj[6].worldx = 13*GamePanel.tilesize;
		gp.obj[6].worldy = 3*GamePanel.tilesize;
		
	}
	public void setNPC() {
		System.out.println("HHHHHHHHHHHH");
		gp.NPC[1] = new PlayerNPC(gp);
		gp.NPC[1].x = 2*GamePanel.tilesize;
		gp.NPC[1].y = 6*GamePanel.tilesize;
		
		gp.NPC[2] = new PlayerNPC(gp);
		gp.NPC[2].x = 3*GamePanel.tilesize;
		gp.NPC[2].y = 6*GamePanel.tilesize;
		
		gp.NPC[3] = new PlayerNPC(gp);
		gp.NPC[3].x = 5*GamePanel.tilesize;
		gp.NPC[3].y = 6*GamePanel.tilesize;
		
		gp.NPC[4] = new PlayerNPC(gp);
		gp.NPC[4].x = 6*GamePanel.tilesize;
		gp.NPC[4].y = 6*GamePanel.tilesize;
	}

}
