import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
	private Handler handler;
	Roach r =new Roach();
	BufferedImage image;
	Window window;
	public Enemy(int x, int y, ID id, Handler handler, Window window)
	{
		super(x,y,id);
			this.handler=handler;
		velx=3;
		vely=3;
		 image=r.getImage("roach.png");
	 this.window=window;
	}

	public void tick()
	{
		
		x=x+velx;
		y=y+vely;
		if(y<=0||y>=Game.HEIGHT-43)vely=vely*-1;
		if(x<=0||x>=Game.WIDTH-17)velx=velx*-1;
	

	
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,18,18);
		
	}
	public void render(Graphics g)
	{   
		g.drawImage(image, x, y,18,18, window);
	
		
	
	}

	
	
	
}
