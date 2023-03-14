package NPC_object;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import main.GamePanel;
import entity.Entity;

public class PlayerNPC extends Entity{
	public PlayerNPC(GamePanel gp) {
		super(gp);
		getNPCImage();
		setDefault();
		
	}
	public void setDefault() {
		speed =1;
		direction = "down";
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
				
			int i = random.nextInt(100)+1; // pick up a number randomly 1-100 plus 1 bc it random from 0-99 and plus 1 is 1-100
						
			if (i <= 25) {
					direction = "up";
				}
			if (i > 25 && i <= 50) {
					direction = "down";
				}
			if (i > 50 && i <=75) {
					direction = "left";
				}
			if (i > 75 && i <= 100) {
					direction = "right";
				}
				
			actionLockCounter = 0;
			}
	}

	public void update(){
		super.update();
	}
	
	public void draw_NPC(Graphics2D g2){
        int screenX = x - gp.player.x + gp.player.x;
        int screenY = y - gp.player.y + gp.player.y;

        if (x + GamePanel.tilesize > gp.player.x - gp.player.x &&
                x - GamePanel.tilesize < gp.player.x + gp.player.y &&
                y + GamePanel.tilesize > gp.player.y - gp.player.y&&
                y - GamePanel.tilesize < gp.player.y + gp.player.y) {
			super.draw(g2);
		}

	}

}
