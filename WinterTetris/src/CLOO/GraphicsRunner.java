package CLOO;
//Name -Christopher Liu
//Class - P.8

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphicsRunner extends JFrame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;
    private WinterScenePanel scene = new WinterScenePanel();
    public GraphicsRunner() {
        super("THE WINTER SCENE PROJECT");
        setSize(WIDTH, HEIGHT);
        getContentPane().add(scene);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("down");
                    scene.updateGame();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("up");
                    scene.addShape();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("left");
                    scene.shiftL();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("right");
                    scene.shiftR();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public static void main(String args[]) {
        GraphicsRunner run = new GraphicsRunner();
        //grid d = new grid();
        //System.out.println(d);
    }
}

