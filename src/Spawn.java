import java.util.Random;

public class Spawn {
Handler handler;
public HUD hud;
volatile static int scorekeep=0;	
Game game;
int levelLength=0;
Random random =new Random();
public Spawn(Handler handler, HUD hud, Game game)
{
	this.handler=handler;
	this.hud=hud;
	
   this.game=game;

}
public boolean collision()
{GameObject tempObject=null;
GameObject tempObject2=null;
for(int i=0; i<handler.object.size(); i++)
	{
		tempObject= handler.object.get(i);
	   

		for(int j=0; j<handler.object.size(); j++)
		{
			 tempObject2= handler.object.get(j);
		   
		}
		if(tempObject.getID()==ID.Enemy&&tempObject2.getID()==ID.Player)
	    if(tempObject2.getBounds().intersects(tempObject.getBounds()))
	     {return true;
	    	
	      }
	}
	return false;
}
public void tick()
{    levelLength++;
	if(levelLength>=100)
	{	
		
	
	  levelLength=0;
	 hud.level(hud.getLevel()+1);
     if(hud.getLevel()==11)
    	 Game.gameState=Game.gameState.end;
	 
     int xpos=random.nextInt(Game.WIDTH-17);
	 int ypos=random.nextInt(Game.HEIGHT-43);
     while(collision())
     {xpos=random.nextInt(Game.WIDTH-17);
     ypos=random.nextInt(Game.HEIGHT-43);
     }
     handler.addObject(new Enemy(xpos,ypos,ID.Enemy,handler,game.window));
	}

}


public HUD getHud()
{
	return hud;
}



}
