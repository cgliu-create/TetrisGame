package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.image.ImageObserver;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
public class FancySnowFlake extends AbstractShape implements ImageObserver {
   private Image snow;
   public FancySnowFlake(int x, int y, int w, int h) {
      super(x, y, w, h, Color.WHITE, 0, 0);
      try {// https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
         snow = ImageIO.read(getClass().getResource("snow.png"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   public void draw(Graphics window) {
      int x = getXPos();
      int y = getYPos();
      int w = getWidth();
      int h = getHeight();
      Image i = snow.getScaledInstance(w, h, Image.SCALE_SMOOTH);
      window.drawImage(i, x, y, this);
   }
   public void moveAndDraw(Graphics window) {
      int x = getXPos()+getXSpeed();
      int y = getYPos()+getYSpeed();
      setXPos(x);
      setYPos(y);
      int w = getWidth();
      int h = getHeight();
      Image i = snow.getScaledInstance(w, h, Image.SCALE_SMOOTH);
      window.drawImage(i, x, y, this);
   }
   @Override
   public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
      // TODO Auto-generated method stub
      return false;
   }
}
//extend the AbstractShape class to make a FancySnowFlake class


