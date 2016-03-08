import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class End extends MouseAdapter
{int mx;
int my;
Spawn spawner;

public Window window;
public Game game;
public Handler handler;
static boolean trans;
Thread thread;
public End(Spawn spawner,Game game, Handler handler)
  {   trans=false;
	  this.spawner=spawner;
	  this.handler=handler;

		this.game=game;
  }

  public void mousePressed(MouseEvent e)
	{ if(Game.gameState==Game.state.end)
	  {	mx=e.getX();
		
	   my=e.getY();
	  }
	
	}

  public boolean mouseOver(int mx, int my, int x, int y, int width,int height)
  { if( mx > x && mx < x+width)
   {   if(my > y && my < y+height)
  	   return true;
  	   else 
  		   return false;
        	
   }
  else
  	return false;
  	
  	
  }
   public void tick()
   {
  	 
  	 
   }

  public void render(Graphics g)
  {   
		if(Game.gameState==Game.state.end)
		   {  
		  		Font font = new Font("PLAIN",1,20);
		  		
		  		g.setFont(font);
		  		g.setColor(Color.blue);
		  	   g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
		  	   
		  	 if(spawner.getHud().getLevel()==11)
		  	 { g.setColor(Color.black);
		  	   g.drawString("You won  score is: " + spawner.getHud().score, 240, 140);
		  	  	 
		  	 }
		  	
		   if(HUD.health==0)
		  	 { 
		  		 g.setColor(Color.black);
		  	   g.drawString("You lost your score is: " + spawner.getHud().score, 240, 140);
		  	 
		  	
		  		 
		  	 }
		  	 
		  	 g.setColor(Color.black);
				 g.drawRect(210, 150, 200, 64);
			  
	
				g.drawString("Quit", 240, 170);
		  		g.setColor(Color.black);
		  		 g.drawRect(210, 250, 200, 64);
		  	  
		  
		  		g.drawString("Replay Game", 240, 270);
		  		 
		  		if(mouseOver(mx,my,210, 150, 200, 64))
		  		{ 
		  			 mx=0;
		  		  my=0;
		  		  System.exit(1);
		  		}
		  		if(mouseOver(mx,my,210, 250, 200, 64))
		  		{
		  		   mx=0;
		  		   my=0;
		  		 spawner.getHud().health=100;
		  		spawner.getHud().score=0;
		  	   
		  		finish();
		  	  
			  
		  		
		  	   
		  		
		  		
		  		
		  		}
		  	
		   }
   }


public void finish()
{
	
	for(int i=0; i<handler.object.size();i++)
	  {
		GameObject tempObject= handler.object.get(i);
	
		  	handler.removeObject(tempObject);
		       
	  }
   
	
  game.removeMouseListener(game.mouseInput);
	   game.removeMouseMotionListener(game.mouseInput);

	     game.removeMouseListener(game.end);
	     game.removeMouseListener(game.pause);
	      game.removeMouseListener(game.menu);
    game.removeMouseListener(game.help);
   game.window.frame.dispose();
   Game.running=false;
	
}
  }



















