import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import java.awt.Color;
public class Player extends GameObject{
Handler handler;
Roach roach =new Roach();
volatile static BufferedImage image;

 BufferedImage image2;
static public int xpos;
static public int ypos;
volatile static boolean picInit=false;
Game game;
	public Player(int x, int y, ID id, Handler handler, Game game)
	{
		super(x,y,id);
	if(!picInit)
        image=roach.getImage("BoyandSpray.png");
	   picInit=true;
       
        this.handler=handler;
	   this.game=game;
	    
	}
	
	public void tick()
	{
		
	    y=Game.clamp(y, 0, Game.HEIGHT-75);
		
		x=Game.clamp(x, 0, Game.WIDTH-46);
		collision();
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,55,55);
		
	}
	
	public Rectangle getBounds2()
	{
		return new Rectangle(x-294,y-129,587,387);
		
	}
	
	public void collision()
	{
		for(int i=0; i<handler.object.size(); i++)
		{
			GameObject tempObject= handler.object.get(i);
		   if(tempObject.getID()==ID.Enemy)
		    if(getBounds().intersects(tempObject.getBounds()))
		     {HUD.health--;
		    	if(HUD.health==0)
		    		{Game.gameState=Game.gameState.end;
		    		
		    		 
		    		}
		    	}
		}
		
	}
	public void render(Graphics g)
	{   xpos=x;
		ypos=y;
		g.drawImage(image, x, y,55,55, game.window);
	    if(!fume.spr) 
		for(int i=0;i<handler.object.size();i++)
	     {
	    	 if(handler.object.get(i).getID()==ID.Fume)
	    	 {handler.object.get(i).setX(x+13);
	    	 handler.object.get(i).setY(y+24);
	    	 }
	    	 
	     }
	
		
		
		
	
	
	
	
	}
	
}
