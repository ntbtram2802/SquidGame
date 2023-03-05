package Object_linh;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_square extends superobject {
	public OBJ_square() {
		name = "square";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Object_linh/npc-square.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
