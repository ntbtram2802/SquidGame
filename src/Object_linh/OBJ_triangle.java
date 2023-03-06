package Object_linh;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_triangle extends superobject{
	public OBJ_triangle() {
		name = "triangle";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/Object_linh/npc-triangle.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
