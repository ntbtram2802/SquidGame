package main;

import entity.NPC;
import entity.PlayerNPC;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		gp.obj[1] = new NPC(gp);
		gp.obj[1].setx(1*GamePanel.tilesize);
		gp.obj[1].sety(3*GamePanel.tilesize);
		
		
		gp.obj[2] = new NPC(gp);
		gp.obj[2].setx(3*GamePanel.tilesize);
		gp.obj[2].sety(3*GamePanel.tilesize);
		
		
		gp.obj[3] = new NPC(gp);
		gp.obj[3].setx(5*GamePanel.tilesize);
		gp.obj[3].sety(3*GamePanel.tilesize);
		
		
		
		gp.obj[4] = new NPC(gp);
		gp.obj[4].setx(9*GamePanel.tilesize);
		gp.obj[4].sety(3*GamePanel.tilesize);
		
		
		gp.obj[5] = new NPC(gp);
		gp.obj[5].setx(11*GamePanel.tilesize);
		gp.obj[5].sety(3*GamePanel.tilesize);
		
		
		gp.obj[6] = new NPC(gp);
		gp.obj[6].setx(13*GamePanel.tilesize);
		gp.obj[6].sety(3*GamePanel.tilesize);
		
	}
	public void setNPC() {

		gp.NPC[1] = new PlayerNPC(gp);
		gp.NPC[1].setx(2*GamePanel.tilesize);
		gp.NPC[1].sety(6*GamePanel.tilesize);
		
		gp.NPC[2] = new PlayerNPC(gp);
		gp.NPC[2].setx(3*GamePanel.tilesize);
		gp.NPC[2].sety(6*GamePanel.tilesize);
		
		gp.NPC[3] = new PlayerNPC(gp);
		gp.NPC[3].setx(5*GamePanel.tilesize);
		gp.NPC[3].sety(6*GamePanel.tilesize);
		
		gp.NPC[4] = new PlayerNPC(gp);
		gp.NPC[4].setx(6*GamePanel.tilesize);
		gp.NPC[4].sety(6*GamePanel.tilesize);
	}

}
