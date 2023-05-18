package Checker;

import entity.Entity;
import main.GamePanel;
import GUI.UI;

public class Time_Win {
	private int actioncounter;
	GamePanel gp;
	UI ui;

	public Time_Win(GamePanel gp) {
		this.gp = gp;
	}

	public void checkwin(Entity e) {
		if (e.getY() > 184 && (gp.playTime) <= 0) {
			e.setwin(false);
			e.setdying(true);
		} else if (e.getY() <= 184 && (gp.playTime) > 0) {
			e.setwin(true);
			e.setY(e.getY()-gp.orignialTileSize);
		}
	}

	public void upcounter() {
		this.actioncounter++;
	}

	public void checkTime(Entity e) {
		if (actioncounter < 320) {
			e.setchecktime(false);
		} else if (actioncounter >= 320 && actioncounter < 720) {
			e.setchecktime(true);
		} else if (actioncounter == 720) {
			this.actioncounter = 0;
		}
	}
}
