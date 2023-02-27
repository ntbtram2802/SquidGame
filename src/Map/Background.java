package Map;

import java.awt.image.*;
import javax.imageio.ImageIO;

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
        
    }

}
