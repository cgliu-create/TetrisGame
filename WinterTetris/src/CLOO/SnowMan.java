package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }
   public void draw(Graphics window)
   {
      double s = 1.5;
      int x = getXPos();
      int y = getYPos();
      int w = getWidth();
      int h = getHeight();
      //Head
      window.setColor(Color.BLACK);
      window.fillOval(x, y, w, h);
      window.setColor(Color.WHITE);
      window.drawOval(x, y, w, h);
      //hat
      window.setColor(Color.BLACK);
      window.fillRect(x, y-2-h, w, h);
      window.setColor(Color.WHITE);
      window.drawRect(x, y-2-h, w, h);
      window.setColor(Color.BLACK);
      window.fillRect(x-(int)((w*s-w)/2), y-10, (int)(w*s), 10);
      window.setColor(Color.WHITE);
      window.drawRect(x-(int)((w*s-w)/2), y-10, (int)(w*s), 10);
      //eyes
      window.setColor(Color.WHITE);
      window.fillOval(x, y+(int)(h/2), 10, 10);
      window.fillOval(x+w-10, y+(int)(h/2), 10, 10);
      //Body
      x=x-(int)(w*s/2.0 - w/2.0); //dif between radius = distance in center
      y=y+h;
      w=(int)(w*s);
      h=(int)(h*s);
      window.setColor(Color.BLACK);
      window.fillOval(x, y, w, h);
      window.setColor(Color.WHITE);
      window.drawOval(x, y, w, h);
      //Booty
      x=x-(int)(w*s/2.0 - w/2.0);
      y=y+h;
      w=(int)(w*s);
      h=(int)(h*s);
      window.setColor(Color.BLACK);
      window.fillOval(x, y, w, h);
      window.setColor(Color.WHITE);
      window.drawOval(x, y, w, h);
      //add code here to make a snowman 	      	
   }
   public void moveAndDraw(Graphics window)
   {
     draw(window);
   }
}