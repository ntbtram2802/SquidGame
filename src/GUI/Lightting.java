package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import main.GamePanel;

public class Lightting extends GUI_Manager{
	Color color[] = new Color[5];
	float fraction [] = new float[5];
	public Lightting (GamePanel gp) {
		super(gp);
		setcolor();
	}
	public void setcolor() {
		color[0] = new Color (0,0,0,0f);
		color[1] = new Color (0,0,0,0.25f);
		color[2] = new Color (0,0,0,0.5f);
		color[3] = new Color (0,0,0,0.75f);
		color[4] = new Color (0,0,0,0.95f);
		
		fraction [0] = 0f;
		fraction [1] = 0.25f;
		fraction [2] = 0.5f;
		fraction [3] = 0.75f;
		fraction [4] = 1f;
	}
	@Override
	public void draw(Graphics2D g2) {
		Area area = new Area(new Rectangle2D.Double(0, 0, gp.screenWidth, gp.screenHeight));
		if(gp.fire != null) {
			Area lightarea_player = drawcircle(g2, gp.player.getX(),gp.player.getY(), 50);
			Area lightarea_fire = drawcircle(g2, gp.fire.getX(),gp.fire.getY(), 100);
			area.subtract(lightarea_fire);
			area.subtract(lightarea_player);
		}
		else {Area lightarea_player = drawcircle(g2, gp.player.getX(),gp.player.getY(), 200);area.subtract(lightarea_player);}
		g2.setColor(new Color(0,0,0,0.98f));
		g2.fill(area);
	}
	public Area drawcircle(Graphics2D g2,int x2, int y2, int circleSize) {
		int centerx = x2 + (gp.tilesize)/2;
		int centery = y2+(gp.tilesize)/2;
		double xx = centerx - (circleSize/2);
		double yy = centery - (circleSize/2);
		Shape circle = new Ellipse2D.Double(xx, yy, circleSize, circleSize);
		Area area = new Area(circle);	
		RadialGradientPaint gPaint = new RadialGradientPaint (centerx, centery, (circleSize)/2,fraction, color);
		g2.setPaint(gPaint);
		g2.fill(area);
		return area;
		
	}
}
