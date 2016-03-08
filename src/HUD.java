import java.awt.Color;
import java.awt.Graphics;

public class HUD {

volatile public static int health=100;

volatile static int score=0;
int level =1;

public void tick()
{
	
	


	health=(Game.clamp(health,0, 200));
	   
	
	
		

}


public void render(Graphics g)
{
	g.setColor(Color.gray);
	
	
	g.fillRect(45, 15, 200, 32);
	g.setColor(Color.green);
	g.drawString("Score: " + score, 15, 64);
	g.drawString("Level: " + level,15, 73);
	
	g.fillRect(45, 15, health*2, 32);
g.setColor(Color.white);
	
	
	g.drawRect(45, 15, 200, 32);
	
	
	

}

public void score(int score)
{
	this.score=score;
}
public int getScore()
{
	return score;
}
public void level(int level)
{
	this.level=level;
}
public int getLevel()
{
	return level;
}


}
