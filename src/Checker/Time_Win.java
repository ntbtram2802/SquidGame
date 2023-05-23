package Checker;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

import GUI.UI;

public class Time_Win {
	private int actioncounter;
	private GamePanel gp;
	private UI ui;
	
	public Time_Win(GamePanel gp) {
		this.gp = gp;
	}

	public void checkwin(Entity e) {
		if (e.getY() > 182 && (gp.playTime) <= 0) {e.setwin(false);e.setalive(false);
		} else if (e.getY() <= 182 &&(gp.playTime) > 0) {
			e.setwin(true);}
	}
	public void upcounter() {this.actioncounter++;}
	public void recounter() {this.actioncounter = 0;}

	public void checkTime(Entity e) {
		if (actioncounter < 320) {e.setchecktime(false);
		} else if (actioncounter >= 320 && actioncounter < 720) {e.setchecktime(true);
		} else if (actioncounter == 720) {this.actioncounter = 0;}
	}
}
