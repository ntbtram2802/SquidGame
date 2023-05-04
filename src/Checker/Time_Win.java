package Checker;

import entity.Entity;
import main.GamePanel;

public class Time_Win {
	private int actioncounter;
    GamePanel gp;
    public Time_Win(GamePanel gp) {
    	this.gp = gp;}
	public void checkwin(Entity e) {
		if(e.getY()>184 && (gp.playTime) <=0 ) {
			e.setdying(true);
			//gamoversreen
		}
		else if(e.getY()<=184 && (gp.playTime) >0) {
			gp.u.setgamefinish(true);
			e.setwin(true);
		}
	}
    public void upcounter() {
		this.actioncounter ++;
	}
	public void checkTime(Entity e) {
		if (actioncounter<320) {
			e.setchecktime(false);
		}
		else if(actioncounter>=320 && actioncounter<720) {
			e.setchecktime(true);
			}
		else if (actioncounter == 720) {
			this.actioncounter =0;
		}
		}
}
