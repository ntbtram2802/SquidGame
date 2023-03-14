package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Map.*;
import NPC_object.*;
import entity.*;

public class GamePanel extends JPanel implements Runnable {
	// SCREEN SETTINGS
    public static final int orignialTileSize = 16;
    public static final int scale = 3;
    public static final int tilesize = orignialTileSize * scale; // 48 X48 tile
    public static final int maxScreenCol = 20;// horizontal, ngang
    public static final int maxScreenRow = 16; // vertical,doc
    public static final int screenWidth = tilesize * maxScreenRow; //256 ngang
    public static final int screenHeight = tilesize * maxScreenCol;//320 doc
    
    //SYSTEM
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;// to start and stop the game whenever you want to
    public AssetSetter aSetter = new AssetSetter (this);
    
    //ENTITY &OBJECT
    public Player player= new Player(this,keyH);
    public Boss boss = new Boss(this);
    public NPC obj[]= new NPC [10];
	public PlayerNPC NPC[] = new PlayerNPC[10];// this is npc array // sua npc th�nh NPC
    int FPS=60;
    
    // Background bg;
	public Background bg = new Background("/background/background2.png");
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setVisible(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
	}
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
	@Override
	public void run() {
		double drawinterval=1000000000/FPS;
	     double delta=0;
	     long lasttime=System.nanoTime();
	     long currenTime;
	     long timer=0;
	     int DrawCount=0;
	     while(gameThread!=null){
	         currenTime = System.nanoTime();
	         delta += (currenTime-lasttime)/drawinterval;
	         timer += (currenTime-lasttime);
	         lasttime = currenTime;
	         if(delta>=1){
	             update();
	             repaint();
	             delta--;
	             DrawCount++;
	         } if (timer>=1000000000){
	             System.out.println("Fps"+DrawCount);
	             DrawCount=0;
	             timer=0;
	         }

	     }
	    }
	
	public void update() {
        player.update();
        boss.update();

        for (int z = 0; z< NPC.length; z++) {
        	if (NPC[z] != null) {
        		NPC[z].update();
        	}
        }
    }
	 public void paintComponent(Graphics g){

	        super.paintComponent(g); 
	        Graphics2D g2=(Graphics2D)g; // change graphics g-> graphics 2D
	        bg.draw(g2);
	        
	        for(int i = 0; i < NPC.length; i++ ) {
				if (NPC[i]!= null) {
					NPC[i].draw(g2);
				}	
			}

	        int j = 1;
	        while( j<=5 && obj[j]!= null) {
	        	obj[j].draw_NPC(g2, "round");
	        	j++;
	        	obj[j].draw_NPC(g2, "triangle");
	        	j++;
	        	obj[j].draw_NPC(g2, "square");   	
	        	j++;
	        }

	        player.draw(g2);
	        boss.draw(g2);
	        g2.dispose();
	      }

	    }

	