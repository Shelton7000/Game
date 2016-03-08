import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help extends MouseAdapter{

	Window window;
	Game game;
Handler handler;
MouseInput mouseInput;
int mx;
int my;
	public Help(Game game, Handler handler, Window window, MouseInput mouseInput)
	{this.game=game;
		this.handler=handler;
		this.mouseInput=mouseInput;
	}
	
	

	public void mousePressed(MouseEvent e)
	{ if(Game.gameState==Game.state.help)
	{	mx=e.getX();
		
	 my=e.getY();
	
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
{
	if(Game.gameState==Game.state.help)
 {
		Font font = new Font("PLAIN",1,20);
		
		
		g.setColor(Color.blue);
	   g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
	  
		g.setFont(font);
	   g.setColor(Color.black);
	 
	 g.drawString("Left click and hold down and  drag the mouse to move player", 53, 200);
	  

	 g.drawString("Right click the  mouse  to spray", 65, 220);
	   
	 g.setColor(Color.black);
	 
	 g.drawString("Press p to pause", 65, 240);
	   
	 g.setColor(Color.black);
	 
	 
	 
	 g.drawRect(210, 350, 200, 64);
	 g.setColor(Color.black);
	 g.drawString("Back to Menu",  215, 369);
	 if(mouseOver(mx,my,210, 350, 200, 64))
	 {
	  mx=0;
	  my=0;
	 Game.gameState=Game.state.menu;
	 }
 }
}

}
