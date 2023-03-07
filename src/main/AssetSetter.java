package main;

import Object_linh.OBJ_linh;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		gp.obj[1] = new OBJ_linh();
		gp.obj[1].worldx = 1*GamePanel.tilesize;
		gp.obj[1].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[2] = new OBJ_linh();
		gp.obj[2].worldx = 3*GamePanel.tilesize;
		gp.obj[2].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[3] = new OBJ_linh();
		gp.obj[3].worldx = 5*GamePanel.tilesize;
		gp.obj[3].worldy = 3*GamePanel.tilesize;
		
		
		
		gp.obj[4] = new OBJ_linh();
		gp.obj[4].worldx = 9*GamePanel.tilesize;
		gp.obj[4].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[5] = new OBJ_linh();
		gp.obj[5].worldx = 11*GamePanel.tilesize;
		gp.obj[5].worldy = 3*GamePanel.tilesize;
		
		
		gp.obj[6] = new OBJ_linh();
		gp.obj[6].worldx = 13*GamePanel.tilesize;
		gp.obj[6].worldy = 3*GamePanel.tilesize;
		
	}


}
