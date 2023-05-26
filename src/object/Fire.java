package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Fire {
	private GamePanel gp;
	public static int counter = 0;
	private int x, y;
	BufferedImage image, image1, image2, image3, image4, image5, image6;

	public Fire(GamePanel gp) {
		this.gp = gp;
		setposition();
		getImage();
	}

	public void setposition() {
		Random random = new Random();
		int x_position = random.nextInt(15) + 1;
		x = x_position * gp.tilesize;
		y = gp.tilesize * 15;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void getImage() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/fire/fire1.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/fire/fire2.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/fire/fire3.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/fire/fire4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		int i = 70;
		counter++;
		if (counter < i) {
			image = image1;
		} else if (counter <= 2 * i) {
			image = image2;
		} else if (counter <= 3 * i) {
			image = image3;
		} else if (counter <= 4 * i) {
			image = image4;
		} else if (counter <= 5 * i) {
			image = image5;
		} else if (counter <= 6 * i) {
			image = image6;
			counter = 0;
		}
		g2.drawImage(image, x, y, gp.tilesize * 3 / 2, gp.tilesize * 3 / 2, null);

	}

}
