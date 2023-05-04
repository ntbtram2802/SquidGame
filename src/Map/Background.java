package Map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Background {
    private BufferedImage bg;

    private double x;
    private double y;
    private int width=GamePanel.screenWidth;
    private int height=GamePanel.screenHeight;

    public Background(String address){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream(address));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }



    public void draw(Graphics2D g2){

        if(g2==null){
            System.out.println("graphic is null in bg");
            System.exit(0);
        }
        g2.drawImage(bg,(int)x, (int)y, width, height, null);
    }


}
