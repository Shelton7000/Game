import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class fume extends GameObject {
	BufferedImage image;
	Roach r =new Roach();
	Handler handler;
	
	int targetX=0;
	int targetY=0;
	fume f;
	 int hor=0;
	 int ver=0;
	volatile static boolean spr=false;
	Game game;
	public fume(int x, int y, ID id ,Handler handler,Game game) {
		super(x, y, id);
		hor=x;
		ver=y;
		// TODO Auto-generated constructor stub
	image=r.getImage("fume.png");
	 
	this.handler=handler;
	this.game=game;
	
	
	}
public void targetXY(int x,int y)
{
	
	targetX=x;
	targetY=y;
   
   
}
public void setDeltaX(int x2, int x1)
{
	if(zeroRelation(x2,x1)>0)
		   setVelx(1);
	   else if(zeroRelation(x2,x1)<0)
	  setVelx((-1));
	   else
		   setVelx(0);
	
	
}
public void setDeltaY(int y2, int y1)
{
	if(zeroRelation(y2,y1)>0)
		   setVely(1);
	   else if(zeroRelation(y2,y1)<0)
	  setVely((-1));
	   else
		   setVely(0);
	
	
}


public int zeroRelation(int num2,int num1)
{   return (num2-num1);

}
	@Override
public void tick() 
{
		// TODO Auto-generated method stub
    x=x+velx;
    y=y+vely;
}
public Rectangle getPlayerBounds()
{
	
	for(int i=0;i<handler.object.size();i++)
	{	//
		if(handler.object.get(i).getID()==ID.Player)
		{ 
			Player player=(Player)handler.object.get(i);
		
		  return player.getBounds2();
		}
	 
	}
	
	
	return null;
}
	@Override
	public Rectangle getBounds()
	{
		
		return new Rectangle(x,y,35,35);
		
	}
	public void collision()
	{
		for(int i=0; i<handler.object.size(); i++)
		{
			GameObject tempObject= handler.object.get(i);
		   if(tempObject.getID()==ID.Enemy)
		    if(getBounds().intersects(tempObject.getBounds())&&x!=Player.xpos+13 &&y!=Player.ypos+24)
		     {handler.removeObject(tempObject);
		    	HUD.score=HUD.score+50;
		      }
		}
		
	}
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(getBounds().intersects(getPlayerBounds())&&spr)
			{	setDeltaX(targetX,x);
			    setDeltaY(targetY,y);
				
			    if(x!=targetX ||y!=targetY)
				 {  
					this.tick();
						 
				  g.drawImage(image, x,y,35,35, game.window);
				  collision();
				}
				else
				{  x=Player.xpos+13;
				   y=Player.ypos+24;
				   
				   spr=false;
				  
				}	
			  
			}
			else
			{
				
				
				spr=false;
			}
			
		
		
	}
	

	
}
