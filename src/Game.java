
/**
* @(#)Game.java
 *
 *
 * @author 
 * @version 1.00 2015/8/29
 */
 import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game extends Canvas implements Runnable {
  private static final long serialVersionUID =1550691097823471818L;
  public static final int WIDTH=640, HEIGHT=WIDTH/12*9;
  static public Thread thread;
  
  public Handler handler;
  public static boolean running=false;
  public HUD hud;
  public Spawn spawner;  
  volatile static public state gameState=state.menu;
  public Menu menu;
  public MouseInput mouseInput;
  
  public Help help;
  public Pause pause;
  public End end;
public enum state
{game,help,pause,end,
	menu;
	
	
	
};
public Window window;

public Game() 
{
    	
    	
    	if(Game.gameState==Game.state.end)
    		Game.gameState=Game.gameState.game;
    	thread =new Thread(this);
    	handler = new Handler();
    	 
    	 
    	  hud= new HUD();
	     
    	  spawner =new Spawn(handler,hud,this);
    	  
    	    mouseInput=new MouseInput(handler); 
    	      menu= new Menu(this,handler,window,  mouseInput);
           help=new Help(this,handler,window,  mouseInput);
      pause=new Pause(this,handler,window,  mouseInput);
      end =new End(spawner,this,handler);
      window= new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
      if(gameState== state.game)	  
      { 
	   
	    handler.addObject(new Player(300,100,ID.Player,handler,this));
          handler.addObject(new fume(313,124,ID.Fume,handler,this));
	     
           this.addMouseListener(mouseInput);
		   this.addMouseMotionListener(mouseInput);

		     this.addMouseListener(end);
		     this.addMouseListener(pause);
		     this.addMouseListener(menu);
		      this.addMouseListener(help);
		      this.addKeyListener(new KeyInput(handler));
		      
            
      }
      else
      {
      this.addMouseListener(end);
      this.addMouseListener(pause);
      this.addMouseListener(menu);
      this.addMouseListener(help);
      this.addKeyListener(new KeyInput(handler));
      }
   

}
   

public  synchronized void start()
{
	
	
    	
    	thread.start();
    	
    	
    	
    	running=true;
    	
    	
    
     

}



public void run()
{
	
	
	
	long lastTime=System.nanoTime();
 double amountOfTicks=60.0;
 double ns=1000000000d / amountOfTicks;
 double delta=0;
 long timer= System.currentTimeMillis();
 int frames=0;
 while(running)
 {
 	this.requestFocus();
	long now= System.nanoTime();
 	delta +=(now-lastTime)/ns;
 	lastTime=now;
 	
 	while(delta >= 1)
 	{
 		
 		tick();
 		delta--;
 	}
 	
 	
 if(running)
 		
	  render();
  	frames++;
  	if(System.currentTimeMillis()- timer>1000)
  	{
     	timer += 1000;
  
  	   frames=0;
  	
  	}
 }
 
stop(); 
}
public synchronized  void stop()
{
	  
	  new Game();
	
	
	
	
}
private void tick()
{
	
	if(gameState==state.game)
	{if(gameState!=state.pause)
	{	handler.tick();
	  hud.tick();
     spawner.tick();}
	}
	
	
}
private void render(){
	
	BufferStrategy bs=this.getBufferStrategy();
	
	if(bs==null)
	{this.createBufferStrategy(3);
	 return;
	}
 Graphics g = bs.getDrawGraphics();
 
  g.setColor(Color.black);
  g.fillRect(0,0,WIDTH,HEIGHT);
 
 
  if(gameState==state.game)
  {   handler.render(g);
	  
	  hud.render(g);
  
  
  }
  else if(gameState==state.menu)
  {  menu.render(g);
  }
  else if(gameState==state.help){
	  
	   help.render(g);
  }
  else if(gameState==state.pause)
  {pause.render(g);
	  
  }
  else if(gameState==state.end)
  {  
	  end.render(g);
	  
  }
  g.dispose();
  bs.show();
}
public static int clamp(int var, int min, int max)
{
	if(var>=max)
	return max;
	else if(var<=min)
		return min;
	else
		return var;
	
	
	
}
    public static void main(String args[]) throws InterruptedException
    {
      new Game();
    }
    
}