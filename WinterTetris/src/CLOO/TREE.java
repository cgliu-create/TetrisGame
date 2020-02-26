package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
public class TREE extends AbstractShape
{
   public TREE(int x, int y, int w, int h )
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
      //trunk
      window.setColor(Color.BLACK);
      window.fillRect(x+w/2-w/3/2, y+h/2, w/3, h-h/2+(int)(h*s)-(int)(h*s/2)+(int)(h*s*s)-(int)(h*s/2*s/2)+2*w/3);
      window.setColor(Color.WHITE);
      window.drawRect(x+w/2-w/3/2, y+h/2, w/3, h-h/2+(int)(h*s)-(int)(h*s/2)+(int)(h*s*s)-(int)(h*s/2*s/2)+2*w/3);
      //triangles
      int xa=x-(int)(w*s/2.0 - w/2.0); //dif between radius = distance in center
      int ya=y+h/2;
      int wa=(int)(w*s);
      int ha=(int)(h*s);
      int xb=xa-(int)(wa*s/2.0 - wa/2.0);
      int yb=ya+ha/2;
      int wb=(int)(wa*s);
      int hb=(int)(ha*s);
      window.setColor(Color.BLACK);   
      window.fillPolygon(new int[] {xb, xb+wb/2, xb+wb}, new int[] {yb+hb, yb, yb+hb}, 3); 	
      window.setColor(Color.WHITE);
      window.drawPolygon(new int[] {xb, xb+wb/2, xb+wb}, new int[] {yb+hb, yb, yb+hb}, 3);
      window.setColor(Color.BLACK);   
      window.fillPolygon(new int[] {xa, xa+wa/2, xa+wa}, new int[] {ya+ha, ya, ya+ha}, 3); 	
      window.setColor(Color.WHITE);
      window.drawPolygon(new int[] {xa, xa+wa/2, xa+wa}, new int[] {ya+ha, ya, ya+ha}, 3);
      window.setColor(Color.BLACK);   
      window.fillPolygon(new int[] {x, x+w/2, x+w}, new int[] {y+h, y, y+h}, 3); 	
      window.setColor(Color.WHITE);
      window.drawPolygon(new int[] {x, x+w/2, x+w}, new int[] {y+h, y, y+h}, 3);
   }
   public void moveAndDraw(Graphics window)
   {
     draw(window);
   }
}