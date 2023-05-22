package main;

import static main.GamePanel.tilesize;

import java.util.Random;

import entity.NPC;
import entity.PlayerNPC;

public class AssetSetter {
	GamePanel gp;
	Random random = new Random();
	public static int j = 1;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		for (int i = 0; i < gp.obj.length; i++) {
			gp.obj[i] = new NPC(gp);
			gp.obj[i].setX((j) * tilesize);
			gp.obj[i].setY((3) * tilesize);
			if (i == 2) {j += 4;
			} else {j += 2;}
		}
		int x = 0;
		while (x < 6) {
			gp.obj[x].setDirection("round");x++;
			gp.obj[x].setDirection("triangle");x++;
			gp.obj[x].setDirection("square");x++;
		}
	}

	public void setNPC() {
		if(gp.level == 1) {gp.NPC.clear();}
		for(int i = 0; i <10; i++) {
			PlayerNPC newNPC = new PlayerNPC(gp);
			setposisionNPC(newNPC);
			gp.NPC.add(newNPC);
		}
		
	}
	public void setposisionNPC(PlayerNPC npc) {
		int x = random.nextInt(15) + 1;
		int y = random.nextInt(2) + 16;
		npc.setX(x * tilesize);
		npc.setY(y * tilesize);
		if (x % 2 != 0) {npc.setType("trang");}
		else if (x%2 ==0){npc.setType("nau");		}
		npc.getImage();
		
	}
	public void restartNPC() {
		for(PlayerNPC npc:gp.NPC) {
			npc.setDefault();	
			setposisionNPC(npc) ;
			if(gp.level >1) {npc.setSpeed(npc.getSpeed()+1);}
			}
	}

}
