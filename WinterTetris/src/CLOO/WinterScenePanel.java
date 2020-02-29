package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.*;
import javax.swing.JPanel;
public class WinterScenePanel extends JPanel implements Runnable
{
	private AbstractShape [] shapes = new AbstractShape [10];	
	private AbstractShape sMan = new SnowMan(35, 350, 40, 40);
	private AbstractShape atree = new TREE(430, 330, 50, 50);
	private grid gamedata = new grid();
	public void updateGame(){
		gamedata.shiftDownPlayer();
		gamedata.rowDelete();
	}
	public void addShape(){
		//int s =(int)(Math.random()*7);
		int s=1;
		switch (s) {
			case 1:
				gamedata.addLine();
				break;
			case 2:
				gamedata.addLShape();
				break;
			case 3:
				gamedata.addJShape();
				break;
			case 4:
				gamedata.addTee();
				break;
			case 5:
				gamedata.addZShape();
				break;
			case 6:
				gamedata.addSShape();
				break;
			default:
				gamedata.addSquare();
				break;
		}
	}
	public void shiftL(){
		gamedata.shiftPlayerL();
	}
	public void shiftR(){
		gamedata.shiftPlayerR();
	}
	public void makeRotation(){
		//insert stuff
	}
	public WinterScenePanel()
	{
		setVisible(true);
		//instantiate the array to hold 50 AbstractShape references
		//populate the array with 50 unique snowflakes
		//WIDTH = 800;HEIGHT = 600;
		//instantiate a snowman
		for (int i = 0; i < shapes.length; i++) {
			shapes[i] = new FancySnowFlake(0, 0, 20, 20);
			shapes[i].setYSpeed(20);
			shapes[i].setXPos((int)(Math.random()*40)*20);
			shapes[i].setYPos((int)(Math.random()*30)*20);
		}
		new Thread(this).start();
	}
	public void update(Graphics window)
	{
		paint(window);	
	}
	public void paint(Graphics window)
	{
		window.setColor(Color.BLACK);
		window.fillRect(0,0,getWidth(), getHeight());
		for (AbstractShape a : shapes) {
			a.moveAndDraw(window);
		}
		window.setColor(Color.WHITE);
		window.drawRect(100,20, 300, 500);
		sMan.draw(window);
		atree.draw(window);
		gamedata.draw(window);
		window.setColor(Color.WHITE);
		window.setFont(new Font("TAHOMA", Font.BOLD,37));
		window.drawString("WINTER TETRIS",100,550);
	}
   public void run() {
	    int time = 0;
	   	int t = 0;
	    try {
			while(true){
				Thread.sleep(35);
				//snow
				for (AbstractShape a : shapes) {
					if(a.getYPos()==500){
						a.setYPos(0);
						int rx = 500/20;
						a.setXPos((int)(Math.random()*rx)*20);
					}
				}
				//snow wiggle
				time++;
				if(time <= 3){
					for (AbstractShape a : shapes) {
						a.setXSpeed(10);
					}
				}
				if(time > 3 && time < 8) {
					for (AbstractShape a : shapes) {
						a.setXSpeed(-10);
					}
				}
				if (time == 8){
					time = 0;
				}
				t++;
				if (t == 16
				){
					updateGame();
					t = 0;
				}
				if(!(gamedata.checkforTwos())){
					addShape();
				}
				repaint();
			}
         }catch(Exception e){}
	   }
}
