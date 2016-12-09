

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Roach {

	BufferedImage image=null;
	public BufferedImage getImage(String pic) 
	{
		try 
		{
	          image = ImageIO.read(getClass().getResource(pic)) ;

              
       } 
		catch (IOException e) 
		{
         e.printStackTrace();
        }

	   return image;
	}
 public void closeImage()
 {
	 image.flush();
 }

   public static void main(String[] args) 
   {
    Roach ri = new Roach();
    String string=null; 
   
    ri.getImage(string);
   }
}
