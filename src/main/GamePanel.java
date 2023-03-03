package main;

import javax.swing.JPanel;
import java.awt.*;

//import Map.Background;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    public static final int orignialTileSize = 16;
    public static final int scale = 3;
    public static final int tilesize = orignialTileSize * scale; // 48 X48 tile
    public static final int maxScreenCol = 20;// horizontal, ngang
    public static final int maxScreenRow = 16; // vertical,doc
    public static final int screenWidth = tilesize * maxScreenRow; //256 ngang
    public static final int screenHeight = tilesize * maxScreenCol;//320 doc

    KeyHandler keyH= new KeyHandler();
    Thread gameThread;// to start and stop the game whenever you want to
    Player player= new Player(this,keyH);

    int FPS=60;

  // private Background bg;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setVisible(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
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

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2=(Graphics2D)g; // change graphics g-> graphics 2D

        player.draw(g2);

        g2.dispose();


    }
}


