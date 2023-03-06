package Object_linh;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_round extends superobject{
	public OBJ_round() {
		name = "round";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Object_linh/npc-round.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
