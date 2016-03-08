import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;






public class Menu extends MouseAdapter {
	Window window;
	Game game;
   Handler handler;
   MouseInput mouseInput;
   int mx;
   int my;
	public Menu(Game game, Handler handler, Window window, MouseInput mouseInput)
	{this.game=game;
		this.handler=handler;
		this.mouseInput=mouseInput;
	}
	
	
 
public void mousePressed(MouseEvent e)
{ 
  if(Game.gameState==Game.state.menu)
  {
	  mx=e.getX();
	
      my=e.getY();
	
      System.out.println(mx+" " + my+" m");
	
	  if(game.gameState==Game.state.menu) 
	   if(mouseOver(mx,my,210, 150, 200, 64))
	    {
		   game.gameState=Game.state.game;
		   handler.addObject(new Player(300,100,ID.Player,handler,game));
		   
		   handler.addObject(new fume(313,124,ID.Fume,handler,game));
		   game.addMouseListener(mouseInput);
		   game.addMouseMotionListener(mouseInput);
		  
		
	    
	    
	    
	    } 
	  
	
   }
}

	public void mouseReleased(MouseEvent e)
	{
		
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
{ Font f = new Font("PLAIN",1,20);
g.setColor(Color.blue);
g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
	g.setFont(f);
	g.setColor(Color.black);
	g.drawString("Menu", 240, 70);
	g.setColor(Color.black);
	g.drawString("Play", 240, 170);
 g.setColor(Color.black);
 g.drawRect(210, 150, 200, 64);
 g.setColor(Color.black);
	g.drawString("Help", 240, 270);
 g.setColor(Color.black);
 g.drawRect(210, 250, 200, 64);
 
 g.setColor(Color.black);
	g.drawString("Quit", 240, 370);
 
 
 g.setColor(Color.black);
 g.drawRect(210, 350, 200, 64);
 if(mouseOver(mx,my,210, 250, 200, 64))
 { mx=0;
    my=0;
	 Game.gameState=Game.state.help;
 
 }else if(mouseOver(mx,my,210, 350, 200, 64))
 { System.exit(1);
 }
}

}