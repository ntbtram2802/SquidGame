package main;

import static main.GamePanel.tilesize;
import entity.NPC;
import entity.PlayerNPC;

public class AssetSetter {
	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {

		gp.obj[1] = new NPC(gp);
		gp.obj[1].setX(1 * tilesize);
		gp.obj[1].setY(3 * tilesize);

		gp.obj[2] = new NPC(gp);
		gp.obj[2].setX(3 * tilesize);
		gp.obj[2].setY(3 * tilesize);

		gp.obj[3] = new NPC(gp);
		gp.obj[3].setX(5 * tilesize);
		gp.obj[3].setY(3 * tilesize);

		gp.obj[4] = new NPC(gp);
		gp.obj[4].setX(9 * tilesize);
		gp.obj[4].setY(3 * tilesize);

		gp.obj[5] = new NPC(gp);
		gp.obj[5].setX(11 * tilesize);
		gp.obj[5].setY(3 * tilesize);

		gp.obj[6] = new NPC(gp);
		gp.obj[6].setX(13 * tilesize);
		gp.obj[6].setY(3 * tilesize);

	}

	public void setNPC() {
		// for (int i=1; i< gp.NPC.length; i++){
		// gp.NPC[i]= new PlayerNPC(gp);
		// gp.NPC[i].setX(((i))*tilesize);
		// }
		gp.NPC[1] = new PlayerNPC(gp);
		gp.NPC[1].setX(2 * tilesize);

		gp.NPC[2] = new PlayerNPC(gp);
		gp.NPC[2].setX(4 * tilesize);

		gp.NPC[3] = new PlayerNPC(gp);
		gp.NPC[3].setX(6 * tilesize);

		gp.NPC[4] = new PlayerNPC(gp);
		gp.NPC[4].setX(8 * tilesize);
	}

}
