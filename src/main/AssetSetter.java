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
		for (int i = 0; i < gp.NPC.length; i++) {
			gp.NPC[i] = new PlayerNPC(gp);
			setposisionNPC(i) ;
		}
		
	}
	public void setposisionNPC(int i) {
		int x = random.nextInt(15) + 1;
		int y = random.nextInt(2) + 16;
		gp.NPC[i].setX(x * tilesize);
		gp.NPC[i].setY(y * tilesize);
		if (x % 2 != 0) {gp.NPC[i].setType("trang");}
		else if (x%2 ==0){gp.NPC[i].setType("nau");		}
		gp.NPC[i].getImage();
		
	}
	public void restartNPC() {
		for(int i =0; i<gp.NPC.length;i++) {
			gp.NPC[i].setDefault();	
			setposisionNPC(i) ;
		}
	}

}
