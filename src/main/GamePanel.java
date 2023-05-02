package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Checker.Collision;
import Map.*;
import entity.*;

public class GamePanel extends JPanel implements Runnable {
	// SCREEN SETTINGS
	public static final int orignialTileSize = 16;
	public static final int scale = 3;
	public static final int tilesize = orignialTileSize * scale; // 48X48 tile
	public static final int maxScreenCol = 20;// horizontal, ngang
	public static final int maxScreenRow = 16; // vertical,doc
	public static final int screenWidth = tilesize * maxScreenRow; // 256 ngang
	public static final int screenHeight = tilesize * maxScreenCol;// 320 doc

	// SYSTEM
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;// to start and stop the game whenever you want to
	private AssetSetter aSetter = new AssetSetter(this);
	public Collision c = new Collision();
	public static Sound sound = new Sound();

	// ENTITY &OBJECT
	public Player player = new Player(this, keyH);
	public Boss boss = new Boss(this);
	public NPC obj[] = new NPC[7];
	public PlayerNPC NPC[] = new PlayerNPC[7];// this is npc array
	int FPS = 60;

	// GAME STATE
	public static int gameState;
	public final static int playState = 1;
	public final static int titleState = 0;
	public static int commandNum = 0;

	// Background
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
		// playMusic(0);
		gameState = titleState;
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
				System.out.println("Fps" + DrawCount);
				DrawCount = 0;
				timer = 0;
			}

		}
	}

	public void update() {
		if (gameState == playState) {
			player.update();
			boss.update();

			for (int z = 0; z < NPC.length; z++) {
				if (NPC[z] != null) {
					NPC[z].update();
				}
			}
		}
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (gameState == titleState) {

			g2.setColor(new Color(157, 120, 100));
			g2.fillRect(0, 0, screenWidth, screenHeight);

			int x = 60;
			int y = tilesize * 2;
			try {
				g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/menu/menu_squidgame.png")), x, y,
						tilesize * 13, tilesize * 4, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// MENU IMAGE
			x = screenWidth / 2 - (tilesize * 9) / 2;
			y += tilesize * 5;
			try {
				g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/menu/menu_background.png")), x, y,
						tilesize * 9, tilesize * 10, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// MENU BUTTON
			g2.setFont(g2.getFont().deriveFont(Font.TYPE1_FONT, 60F));
			String text = "Start";
			x = 320;
			y += tilesize * 5;
			g2.setColor(new Color(80, 0, 0));
			g2.drawString(text, x, y);
			// button shadow
			g2.setColor(new Color(157, 0, 0));
			g2.drawString(text, x + 3, y + 3);

			if (commandNum == 0) {
				g2.drawString(">", x - tilesize, y);
			}
			text = "Quit";
			x = 325;
			y += tilesize * 2;
			g2.setColor(new Color(80, 0, 0));
			g2.drawString(text, x, y);
			// button shadow
			g2.setColor(new Color(157, 0, 0));
			g2.drawString(text, x + 3, y + 3);

			if (commandNum == 1) {
				g2.drawString(">", x - tilesize, y);
			}
			// BOSS IMAGE MENU
			x = screenWidth / 2 - (tilesize * 15) / 2;
			y += tilesize - 100;
			try {
				g2.drawImage(ImageIO.read(getClass().getResourceAsStream("/Boss/boss_chinhdien.png")), x, y,
						tilesize * 6, tilesize * 7, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			bg.draw(g2);
			player.draw(g2);
			boss.draw(g2);
			
			for (int i = 0; i < NPC.length; i++) {
				if (NPC[i] != null) {
					NPC[i].draw(g2);
				}
			}

			for (int j = 1; j <= 6; j++) {
				if (obj[j] != null) {
					obj[j].draw(g2);
				}
			}

			
			g2.dispose();
		}

	}

	public static void playMusic(int i) {
		sound.setFile(i);
		sound.play();
		sound.loop();
	}

	public void stopMusic() {
		sound.stop();
	}

	public void playSE(int i) {
		sound.setFile(i);
		sound.play();
	}

}
