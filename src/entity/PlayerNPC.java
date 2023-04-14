package entity;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import main.GamePanel;

public class PlayerNPC extends Entity{
	public PlayerNPC(GamePanel gp) {
		super(gp);
		setDefault();
		getNPCImage();
	}

	public void getNPCImage() {
		
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/NPC_nau/npc_nau_right2.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	public void setAction() {
		
		actionLockCounter ++;
		if (actionLockCounter == 180) { //once pick up a direction it won't change for the next 120 frames with means 2 seconds // note that we set FPS is 60
				
			Random random = new Random();
				
			int x = random.nextInt(100)+1; // pick up a number randomly 1-100 plus 1 bc it random from 0-99 and plus 1 is 1-100
			int y = random.nextInt(100);
			
			if (x <= 25) {
					direction = "up";
				}
			if (x > 25 && y <= 50) {
					direction = "down";
				}
			if (x > 50 && y <=75) {
					direction = "left";
				}
			if (x > 75 && y <= 100) {
					direction = "right";
				}
				
			actionLockCounter = 0;
			}
	}

	public void update(){
		setAction();
		super.update();
	}

	@Override
	public void draw(Graphics2D g2){
        int screenX = x - gp.player.x + gp.player.x;
        int screenY = y - gp.player.y + gp.player.y;

        if (x + GamePanel.tilesize > this.gp.player.x - gp.player.x &&
                x - GamePanel.tilesize < gp.player.x + gp.player.y &&
                y + GamePanel.tilesize > gp.player.y - gp.player.y&&
                y - GamePanel.tilesize < gp.player.y + gp.player.y) {
			super.draw(g2);
		}

	}

}
