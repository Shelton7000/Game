import java.awt.Graphics;
import java.awt.Rectangle;
public abstract class GameObject {
protected int x,y;
protected ID id;
protected int velx, vely;

public GameObject(int x, int y, ID id)
{
   this.x=x;
   this.y=y;
   this.id=id;
		   
}
public abstract void tick();
public abstract void render(Graphics g); 
public abstract  Rectangle getBounds(); 
public void setX(int x)
{
    this.x=x;	
}

public void setY(int y)
{
    this.y=y;	
}
public void setID(ID id)
{
    this.id=id;	
}
public int getX()
{
    return this.x;
}

public int getY()
{
	return this.y;
}
public ID getID()
{
	return this.id;
}
public void setVelx(int velx)
{
	this.velx=velx;
}

public void setVely(int vely)
{
	this.vely=vely;
}

public int getVelx(int velx)
{
	return velx;
}


public int getVely(int vely)
{
	return vely;
}



}