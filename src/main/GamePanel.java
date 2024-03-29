package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Checker.Collision;
import Checker.CheckTime;
import GUI.*;
import Map.*;
import entity.*;
import object.*;
import object.NPC;

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
	public KeyHandler keyH = new KeyHandler(this);
	public Thread gameThread;// to start and stop the game whenever you want to
	public Subject_Time subject = new Subject_Time(this);
	private AssetSetter aSetter = new AssetSetter(this);
	public Collision c = new Collision();
	public static Sound music = new Sound();
	public static Sound se = new Sound();
	public static Sound ingame = new Sound();
	public CheckTime time_win = new CheckTime(this);
	public UI u = new UI(this);
	public Lightting light = null;

	// ENTITY & OBJECT
	public Player player = new Player(this, keyH, subject);
	public Boss boss = new Boss(this, subject);
	public NPC obj[] = new NPC[6];
	public Fire fire = null;
	public ArrayList<PlayerNPC> NPC = new ArrayList<PlayerNPC>();
	int FPS = 60;
	public double playTime = 60.00;

	// GAME STATE
	public static int gameState;
	public static final int menuState = 0;
	public static final int playState = 1;
	public static final int winState = 2;
	public static final int loseState = 3;
	public static final int endState = 4;
	public static boolean pauseState = false;
	public static boolean restart = false;
	public static int level;
	public MenuState menu = new MenuState(this);
	public PauseState pause = new PauseState(this);
	public GameOver gameOver = new GameOver(this);
	public GameWin gameWin = new GameWin(this);
	public EndGame endgame = new EndGame(this);

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
		aSetter.setNPC();
		aSetter.restartNPC();
		player.setDefault();
		playTime = 60.00;
		restart = false;
		gameState = playState;
		if (level == 3) {
			fire = new Fire(this);
			light = new Lightting(this);
		} else {
			fire = null;
			light = null;
		}
		time_win.recounter();

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
		if (restart == true) {
			restart_game();
		}
		if (gameState == playState && pauseState == false) {
			time_win.checkTime();
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
			if (pauseState == false) {
				u.draw(g2);
			}
			for (int j = 0; j < obj.length; j++) {
				obj[j].draw(g2);
			}
			for (PlayerNPC npc : NPC) {
				npc.draw(g2);
			}
			
			player.draw(g2);
			if (fire != null) {
				fire.draw(g2);
			}
			if (light != null && gameState == playState) {
				light.draw(g2);
			}
			if (gameState == winState) {
				gameWin.draw(g2);
			} else if (gameState == loseState) {
				gameOver.draw(g2);
			} else if (gameState == endState) {
				endgame.draw(g2);
			} else if (pauseState == true) {
				pause.draw(g2);
			}
			g2.dispose();
		}
	}

	public static void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}

	public static void stopMusic() {
		music.stop();
	}

	public static void continue_music() {
		ingame.loop();
	}

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