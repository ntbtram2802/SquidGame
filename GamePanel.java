package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    final int orignialTileSize = 16;
    final int scale = 3;
    final int tilesize = orignialTileSize * scale; // 48 X48 tile
    final int maxScreenCol = 16;// horizontal
    final int maxScreenRow = 16; // vertical
    final int screenWidth = tilesize * maxScreenRow; // 768 pixel
    final int screenHeight = tilesize * maxScreenCol;//
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;// to start and stop the game whenever you want to
// set player default position
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;
    int FPS=60;


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
     long time=0;
     int DrawCount=0;
     while(gameThread!=null){
         currenTime=System.nanoTime();
         delta+=(currenTime-lasttime)/drawinterval;
         lasttime=currenTime;
         if(delta>=1){
             update();
             repaint();
             delta--;
             DrawCount++;
             time+=(currenTime-lasttime);
         } if (time>=1000000000){
             System.out.println("Fps"+DrawCount);
             DrawCount=0;
             time=0;
         }

     }
    }
    public void update(){
        if(keyH.upPressed){
            playerY=playerY-playerSpeed;
        }
        if(keyH.downPressed){
            playerY=playerY+playerSpeed;
        }
        if(keyH.rightPressed){
            playerX=playerX-playerSpeed;
        }
        if(keyH.leftPressed){
            playerX=playerX+playerSpeed;
        }



    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g; // change graphics g-> graphics 2D
        g2.setColor(Color.RED);
        g2.fillRect(playerX,playerY,tilesize,tilesize);
        g2.dispose();


    }
}


