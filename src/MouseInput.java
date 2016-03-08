import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class MouseInput extends MouseAdapter{
	Handler handler;
	
	GameObject object;
Player player;
int x=0;
int y=0;
static int j=0;

public MouseInput(Handler handler)
 { x=300;
   y=100;
	this.handler=handler;
	
 }

public void mousePressed(MouseEvent e)
{
	if(Game.gameState==Game.state.game)
	{int mx=e.getX();
	
	int my=e.getY();
	
	if(e.getButton()>1)
	
	 
     	for(int i=0;i<handler.object.size();i++)
	    {		
	     if(handler.object.get(i).id==ID.Fume)
	      { fume fm= (fume)handler.object.get(i);
          
	    
	        fm.targetXY(e.getX(), e.getY());
	           fume.spr=true;
	    
	       }
	    }
	}
}

public boolean zone(int x, int y,int z)
{ 
  if( x>=handler.object.get(z).getX()&&x<=handler.object.get(z).getX()+55)
   {
	  if( y>=handler.object.get(z).getY()&&y<=handler.object.get(z).getY()+55)
	  { 
		  return true;
		  
	  }
    }
	
	
	       return false;
}

public void mouseDragged(MouseEvent e)
{
	
	
	
	if(Game.gameState==Game.state.game)
	{
	 int mx=e.getX();
	
	 int my=e.getY();
	 
     for(int i=0;i<handler.object.size();i++)
      if(handler.object.get(i).id==ID.Player)
 {   object=handler.object.get(i);
	
    	   object.setX(mx);
         object.setY(my);
       
 
	}
	}
}

public void mouseRelease(MouseEvent e)
{
	
	
	
	
	int mx=e.getX();
	
	int my=e.getY();


	for(int i=0;i<handler.object.size();i++)
   if(handler.object.get(i).id==ID.Player)
      {   object=handler.object.get(i);
	 
    	  object.setVelx(0);
         object.setVely(0);
         }
}





}
