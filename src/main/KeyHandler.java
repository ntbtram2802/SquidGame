package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	private GamePanel gp;
	public static int commandNum=0;
	public static int count;
    public boolean upPressed, downPressed, leftPressed,
            rightPressed, enterPressed, pausePressed;
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
    	 int code = e.getKeyCode();
    	 
         if(gp.gameState == gp.playState) { //Khi gameState == playstate thi se dung bo key cua playste	
        	 count=0;
        	 if(gp.pauseState == true) {optionmenu(code);} // if you pause in playing game, use key of pausegame
         	else {playstate(code);}
         	}
         else if(gp.gameState == gp.winState) {winoption(code);} // playstate == win -> only use key of win
         else if(gp.gameState == gp.loseState||gp.gameState==gp.endState) {loseoption(code);}
         else if(gp.gameState == gp.menuState) {menuoption(code);}
    }
    public void playstate(int code) {
    	commandNum=0;
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
        	//gp.gameWin.commandNum--; //len
        	commandNum--;
        	if(commandNum<0) {commandNum=0;}
        }
        if (code == KeyEvent.VK_S) { //xuong
        	commandNum++;
        	if(commandNum>2) {commandNum=2;}
        }
        if (code == KeyEvent.VK_ENTER) {
        	if(commandNum==0) {
        		count++;
        		if(count ==1) {
        			gp.level ++;
        			GamePanel.restart = true;
                	gp.stopMusic();
                	gp.playSE(0);
                	if(gp.level ==4) {gp.level = 1;}
                	
        		}
        	}
        	if(commandNum==1) {
        		gp.level = 1;
        		GamePanel.restart = true;
            	gp.stopMusic();
                gp.playSE(0);
            	
        	}
        	if(commandNum==2) {
        		System.exit(0);
        	}
        }
        
    }
    public void optionmenu(int code) {
    	if (code == KeyEvent.VK_W) {
    		commandNum--;
    		if(commandNum<0) {commandNum=0;}
//    	if (code == KeyEvent.VK_W) {
//        	gp.pause.commandNum--;
//                if (gp.pause.commandNum< 0) {
//                	gp.pause.commandNum = 0;
//        }
        }
    		 if (code == KeyEvent.VK_S) {
    	        	commandNum++;
    	        	if(commandNum>1) {commandNum=1;}
      }
        
    	 if(code==KeyEvent.VK_DOWN) { // an down thi giam nha
    		 if(commandNum == 0  && gp.ingame.getvolumeSlace()>0) {
    			 gp.ingame.setvolumeSlace(gp.ingame.getvolumeSlace()-1);
          		gp.music.setvolumeSlace(gp.ingame.getvolumeSlace());
          		gp.music.setFile(4);
          		gp.music.play();
          	}
    		 }
    	 
         if(code==KeyEvent.VK_UP) { // tang nhac
        	 if(commandNum == 0  && gp.ingame.getvolumeSlace()<5) {
        		 gp.ingame.setvolumeSlace(gp.ingame.getvolumeSlace()+1);
          		gp.music.setvolumeSlace(gp.ingame.getvolumeSlace());
          		gp.music.setFile(4);
          		gp.music.play();	
        	 }
         }
         
         if(code == KeyEvent.VK_P){ // an 1p thi se quay lai tro choi
        	 gp.ingame.checkVolume();
        	 gp.pauseState = false;
        	 gp.continue_music();
             }
         if (code == KeyEvent.VK_ENTER) {
        	 if(commandNum==0) {
        		 gp.ingame.checkVolume();
        		 gp.pauseState = false;
        		 gp.continue_music();
        	 }
        	 if(commandNum==1) {
        		 System.exit(0);
        	 }
         }
    }
    public void loseoption(int code) {

    	if (code == KeyEvent.VK_W) {
    		commandNum--;
    		if(commandNum<0) {commandNum=0;}
        }
        if (code == KeyEvent.VK_S) {
        	commandNum++;
        	if(commandNum>1) {commandNum=1;}
        }
        if (code == KeyEvent.VK_ENTER) {
        	if(commandNum==0) {
        		gp.level = 1;    
        		GamePanel.restart = true;
            	gp.stopMusic();
            	gp.playSE(0);
            	
        	}
        	if(commandNum==1) { System.exit(0);}
        }
    }
    public void menuoption(int code) {
    	if (code == KeyEvent.VK_W) {
    		commandNum--;
    		if(commandNum<0) {commandNum=0;}
        }
        if (code == KeyEvent.VK_S) {
        	commandNum++;
        	if(commandNum>1) {commandNum=1;}
        }
        if (code == KeyEvent.VK_ENTER) {
        	if(commandNum==0) {
        		gp.gameState = gp.playState;
                gp.stopMusic();
                gp.playSE(0);
                
        	}
        	if(commandNum==1) { System.exit(0);}
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
