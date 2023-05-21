package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Checker.Collision;
import Checker.Time_Win;
import GUI.*;
import Map.*;
import entity.*;

public class GamePanel extends JPanel implements Runnable {
	// SCREEN SETTINGS
	public static final int orignialTileSize = 16;
	public static final int scale = 3;
	public static final int tilesize = orignialTileSize * scale; // 48X48 tile
	public static final int maxScreenCol = 16;// cột
	public static final int maxScreenRow = 20; // hàng
	public static final int screenWidth = tilesize * maxScreenCol; // 256 ngang
	public static final int screenHeight = tilesize * maxScreenRow;// 320 doc

	// SYSTEM
	KeyHandler keyH = new KeyHandler(this);
	public Thread gameThread;// to start and stop the game whenever you want to
	private AssetSetter aSetter = new AssetSetter(this);
	public Collision c = new Collision();
	public static Sound music = new Sound();
	public static Sound se = new Sound();
	public static Sound ingame = new Sound();
	public Time_Win time_win = new Time_Win(this);
	public UI u = new UI(this);

	// ENTITY & OBJECT
	public Player player = new Player(this, keyH);
	public Boss boss = new Boss(this);
	public NPC obj[] = new NPC[6];
	public ArrayList<PlayerNPC> NPC = new ArrayList<PlayerNPC>();
	int FPS = 60;
	public double playTime = 60.00;

	// GAME STATE
	public static int gameState;
	public final static int menuState = 0;
	public final static int playState = 1;
	public final static int winState = 3;
	public final static int loseState = 4;
	public static boolean pauseState = false;
	public static boolean restart = false;
	public static int level;
	public MenuState menu = new MenuState(this);
	public PauseState pause = new PauseState(this);
	public gameOver gameOver = new gameOver(this);
	public gameWin gameWin = new gameWin(this);

	// Background
	public Background bg = new Background("/background/background2.png");

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setVisible(true);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		playMusic(3);
		gameState = 0;
		level = 1;
	}
	public void restart_game() {
		time_win.recounter();
		aSetter.setNPC();
		aSetter.restartNPC();
		player.setDefault();
		stopMusic();
		stopSE();
        playSE(0);
        playTime = 60.00;
        gameState = playState;
		restart = false;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawinterval = 1000000000 / FPS;
		double delta = 0;
		long lasttime = System.nanoTime();
		long currenTime;
		long timer = 0;
		int DrawCount = 0;
		while (gameThread != null) {
			currenTime = System.nanoTime();
			delta += (currenTime - lasttime) / drawinterval;
			timer += (currenTime - lasttime);
			lasttime = currenTime;
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				DrawCount++;
			}
			if (timer >= 1000000000) {
				// System.out.println("Fps" + DrawCount);
				DrawCount = 0;
				timer = 0;
			}

		}
	}

	public void update() {
		if(restart == true) {
			restart_game();
		}
		if (gameState == playState && pauseState == false) {
			time_win.upcounter();
			boss.update();
//			fire.update();
			for (PlayerNPC npc:NPC) {
					if (npc.getwin() == false) {
						if (npc.getalive() == true) {
							npc.update();
						}
					}
			}
				if (player.getwin() == false && player.getalive() == true) {player.update();}
		} 
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (gameState == menuState) {
			menu.draw(g2);
		} else {
			bg.draw(g2);
			boss.draw(g2);
			if(pauseState == false) {u.draw(g2);}
			for (int j = 0; j < obj.length; j++) {obj[j].draw(g2);}
			player.draw(g2);
			for(PlayerNPC npc:NPC) {npc.draw(g2);}
			if (gameState == winState) { gameWin.draw(g2);
			} else if (gameState == loseState) {gameOver.draw(g2);
			} else if (pauseState == true) {pause.draw(g2);}
			g2.dispose();
		}
	}

	public static void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}

	public static void stopMusic() {music.stop();}

	public static void continue_music() {ingame.loop();}

	public static void playSE(int i) {
		se.setFile(i);
		se.play();
		se.loop();
	}

	public static void stopSE() {
		ingame = se;
		se.stop();
	}

}