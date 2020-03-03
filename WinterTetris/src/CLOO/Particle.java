package CLOO;

import java.awt.*;

public class Particle extends AbstractShape{
    private  int life;

    public Particle(int x, int y, int wid, int ht, Color col, int dx, int dy, int life){
        super(x, y, wid, ht, col);
        this.life=life;
        setXSpeed(dx);
        setYSpeed(dy);
    }

    @Override
    public void draw(Graphics window) {
        window.setColor(getColor());
        window.drawOval(getXPos()-(getWidth()/2), getYPos()-(getHeight()/2), getWidth(), getHeight());
    }

    @Override
    public void moveAndDraw(Graphics window) {
        draw(window);
    }
    public boolean update(){
        int x = getXPos()+getXSpeed();
        int y = getYPos()+getYSpeed();
        setXPos(x);
        setYPos(y);
        life--;
        return life == 0;
    }

    public void setLife(int l){this.life=l;}
    public int getLife(){return life;}

}
