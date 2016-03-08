
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Roach {

	 
	public BufferedImage getImage(String pic) {
		BufferedImage image=null;
		try 
		{
	          image = ImageIO.read(getClass().getResource(pic)) ;


     } catch (IOException e) {
e.printStackTrace();
}

	return image;
	}


public static void main(String[] args) {
Roach ri = new Roach();
String string=null;
ri.getImage(string);
}
}