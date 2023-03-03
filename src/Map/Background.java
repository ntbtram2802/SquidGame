package Map;

import java.awt.image.*;
import java.awt.*;
import javax.imageio.ImageIO;


import main.GamePanel;

public class Background {
    private BufferedImage bg;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private double ms; //movescale

    public Background(String address, double ms){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream(address));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setPostion(double x, double y){
        this.x = (x * ms) % GamePanel.screenWidth / GamePanel.scale;
        this.y = (y * ms) % GamePanel.screenHeight / GamePanel.scale;
    }

    public void setVector(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public void update(){
        x += dx;
        y += dy;
    }

    public void draw(Graphics2D g2){
        if(g2==null){
            System.out.println("graphic is null in bg");
            System.exit(0);
        }
        g2.drawImage(bg,(int)x, (int)y, null);

        //movescale
        if(y < 0){
            g2.drawImage(bg, (int)x, (int)y + GamePanel.screenHeight / GamePanel.scale, null);
        } 
        if(y > 0){
            g2.drawImage(bg, (int) x, (int)y - GamePanel.screenHeight / GamePanel.scale, null);
        }
    }

}
