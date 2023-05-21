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
    	 
         if(gp.gameState == gp.playState) { //Khi gameState == playstate thi se dung bo key cua playste
         	if(gp.pauseState == true) {optionmenu(code);} // if you pause in playing game, use key of pausegame
         	else {playstate(code);}
         	}
         else if(gp.gameState == gp.winState) {winoption(code);} // playstate == win -> only use key of win
         else if(gp.gameState == gp.loseState) {loseoption(code);}
         else if(gp.gameState == gp.menuState) {menuoption(code);}
    }
    public void playstate(int code) {
    	if (code == KeyEvent.VK_W) {
        	upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {//VK_A
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {        	
        		rightPressed = true;            
        }
        if(code == KeyEvent.VK_P){
         	gp.pauseState = true;
             gp.stopSE();
             }
        
    }
    public void winoption(int code) {
        if (code == KeyEvent.VK_W) {
        	gp.gameWin.commandNum--;
                if (gp.gameWin.commandNum < 0) {
                	gp.gameWin.commandNum = 0;
        }
        }
        if (code == KeyEvent.VK_S) {
        		gp.gameWin.commandNum++;
            if (gp.gameWin.commandNum > 1) {
            	gp.gameWin.commandNum = 1;
            	System.out.println("down"+ gp.gameWin.commandNum);
            }
        }
        if (code == KeyEvent.VK_ENTER) {
                if (gp.gameWin.commandNum == 0) {
                	gp.restart = true;
                }
                if (gp.gameWin.commandNum == 1) {
                    System.exit(0);
                }
        }
    }
    public void optionmenu(int code) {
    	
    	if (code == KeyEvent.VK_W) {
        	gp.pause.commandNum--;
                if (gp.pause.commandNum< 0) {
                	gp.pause.commandNum = 0;
        }
        }
        if (code == KeyEvent.VK_S) {
        	gp.pause.commandNum++;
            if (gp.pause.commandNum > 1) {
            	gp.pause.commandNum = 1;
            }
        }
        
    	 if(code==KeyEvent.VK_DOWN) { // an down thi giam nha
         	if(gp.pause.commandNum == 0  && gp.ingame.getvolumeSlace()>0) {
         		gp.ingame.setvolumeSlace(gp.ingame.getvolumeSlace()-1);
         		gp.music.setvolumeSlace(gp.ingame.getvolumeSlace());
         		gp.music.setFile(4);
         		gp.music.play();
         	}
         }
         if(code==KeyEvent.VK_UP) { // tang nhac
         	if(gp.pause.commandNum == 0  && gp.ingame.getvolumeSlace()<5) {
         		gp.ingame.setvolumeSlace(gp.ingame.getvolumeSlace()+1);
         		gp.music.setvolumeSlace(gp.ingame.getvolumeSlace());
         		gp.music.setFile(4);
         		gp.music.play();	
         	}
         }
         if(code == KeyEvent.VK_P){ // an 1p thi se quay lai tro choi
        	 GamePanel.ingame.checkVolume();
             GamePanel.pauseState = false;
             GamePanel.conitue();
             }
         if (code == KeyEvent.VK_ENTER) {
        	 if (gp.pause.commandNum== 0) { // An enter vao nut volume thi se quay lai tro choi
        		 GamePanel.ingame.checkVolume();
                 GamePanel.pauseState = false;
                 GamePanel.conitue();
        	 }
             if (gp.pause.commandNum == 1) { // An pause vao quit thi se thoat game
                 System.exit(0);
             }
         }
    }
    public void loseoption(int code) {
    	if (code == KeyEvent.VK_W) {
    		gp.gameOver.commandNum--;
                if (gp.gameOver.commandNum< 0) {
                	gp.gameOver.commandNum = 0;
        }
        }
        if (code == KeyEvent.VK_S) {
        	gp.gameOver.commandNum++;
            if (gp.gameOver.commandNum > 1) {
            	gp.gameOver.commandNum= 1;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            if (gp.gameOver.commandNum == 0) {
            	GamePanel.restart = true;

            }
            if (gp.gameOver.commandNum == 1) {
                System.exit(0);
            }
        }
    }
    public void menuoption(int code) {
    	if (code == KeyEvent.VK_W) {
        	gp.menu.commandNum--;
                if (gp.menu.commandNum< 0) {
                	gp.menu.commandNum = 0;
        }
        }
        if (code == KeyEvent.VK_S) {
        	gp.menu.commandNum++;
            if (gp.menu.commandNum > 1) {
            	gp.menu.commandNum = 1;
            }
        }
        if (code == KeyEvent.VK_ENTER) {
            if (gp.menu.commandNum == 0) {
            	gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playSE(0);

            }
            if (gp.menu.commandNum== 1) {
                System.exit(0);
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
