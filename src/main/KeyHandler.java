package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	GamePanel gp;
    public boolean upPressed, downPressed, leftPressed,
            rightPressed, enterPressed, pausePressed;
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if(code == KeyEvent.VK_P){
            if(GamePanel.pauseState==false){
            	GamePanel.pauseState = true;
                GamePanel.stopSE();
                
            }    
            else{
                GamePanel.pauseState = false;
                GamePanel.conitue();
            } 
        }
    if(code==KeyEvent.VK_DOWN) {
    	if(gp.pauseState == true && gp.pause.getcommandNum() == 0  && gp.ingame.getvolumeSlace()>0) {
    		gp.ingame.setvolumeSlace(gp.ingame.getvolumeSlace()-1);
    		gp.music.setvolumeSlace(gp.ingame.getvolumeSlace());
    		gp.music.setFile(4);
    		gp.music.play();
    		System.out.println(gp.music.getvolumeSlace());
    		
    	}
    }
    if(code==KeyEvent.VK_UP) {
    	if(gp.pauseState == true && gp.pause.getcommandNum() == 0  && gp.ingame.getvolumeSlace()<5) {
    		gp.ingame.setvolumeSlace(gp.ingame.getvolumeSlace()+1);
    		gp.music.setvolumeSlace(gp.ingame.getvolumeSlace());
    		gp.music.setFile(4);
    		gp.music.play();	
    		System.out.println(gp.music.getvolumeSlace());
    		
    	}
    }    
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
        if (code == KeyEvent.VK_P) {
            pausePressed = false;
        }
       
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
