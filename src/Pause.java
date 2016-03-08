import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pause extends MouseAdapter 
{ int mx;
int my;
Window window;
Game game;
Handler handler;
MouseInput mouseInput;
     public Pause(Game game, Handler handler, Window window, MouseInput mouseInput)
     {
	
    	 this.game=game;
 		this.handler=handler;
 		this.mouseInput=mouseInput;
	
	
     }


  public void mousePressed(MouseEvent e)
 { 
	  if(Game.gameState==Game.state.pause)
 	   {	mx=e.getX();
 		
 	       my=e.getY();
 	      System.out.println(mx+" " + my+" h");
 	
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
  public void render(Graphics g)
  {
  	if(Game.gameState==Game.state.pause)
   {
  		Font f = new Font("PLAIN",1,20);
  		
  		g.setFont(f);
  		g.setColor(Color.blue);
  	   g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
  	   //
  	 g.setColor(Color.black);
		 g.drawRect(210, 150, 200, 64);
	  
//g.setFont(f1);
		g.drawString("Go to Help menu", 240, 170);
  		//g.drawString("Go to Help", 450, 290);
  		 g.setColor(Color.black);
  		 g.drawRect(210, 250, 200, 64);
  	  
  //g.setFont(f1);
  		g.drawString("Go back to Game", 240, 270);
  		 //g.setColor(Color.black);
  		 //g.drawRect(210, 250, 200, 64);
  		
  		if(mouseOver(mx,my,210, 150, 200, 64))
  		{
  			Game.gameState=Game.gameState.help;
  		mx=0;
  		my=0;
  		}
  		if(mouseOver(mx,my,210, 250, 200, 64))
  		{mx=0;
  		my=0;
  			Game.gameState=Game.gameState.game;
  		}
  	
   }
  }

}