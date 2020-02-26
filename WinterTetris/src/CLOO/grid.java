package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.Graphics;
public class grid{
    private int[][][] data = new int[20][12][3];
    public grid(){
        //add y cord
        for (int row = 0; row < data.length; row ++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col][0] = 20 + 25*row;
            }
        }
        //add x cord
        for (int row = 0; row < data.length; row ++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col][1] = 100 + 25*col;
            }
        }
        // status
        for (int row = 0; row < data.length; row ++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col][2] = 0;
            }
        }
    }
    public String toString(){
        String out = "";
        for (int[][] a : data) {
            for (int[] b : a) {
                out = out + "{";
                out = out + b[0];
                out = out + "," + b[1];
                out = out + "," + b[2];
                out = out + "}";
            }
            out = out + "\n";
        }
        return out;
    }
     //window.drawOval(100, 20, 25, 25);
    public void draw(Graphics window)
    {
        for (int[][] a : data) {
            for (int[] b : a) {
                if(b[2] == 0){
                    window.drawOval(b[1], b[0], 25,25);
                }
            }
        }
    }
}