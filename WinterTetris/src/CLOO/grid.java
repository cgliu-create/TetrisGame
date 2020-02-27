package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.*;

public class grid{
    // let 0 = empty
    // let 1 = draw shape
    // let 2 = draw a shape that the player can move
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
    // draws circles based off data
    // window.drawOval(100, 20, 25, 25);
    public void draw(Graphics window)
    {
        for (int[][] a : data) {
            for (int[] b : a) {
                if(b[2] == 1){
                    window.setColor(Color.RED);
                    window.drawOval(b[1], b[0], 25,25);
                }
                if(b[2] == 2){
                    window.setColor(Color.WHITE);
                    window.drawOval(b[1], b[0], 25,25);
                }
            }
        }
    }
    // delete full rows
    public void rowDelete(){
        boolean full = true;
        //checks if row is full
        for (int row = data.length-1; row > 0; row --){
            int rx = row;
            for (int col = 0; col < data[data.length-1].length; col++ ){
                if (data[row][col][2] == 0) {
                    full = false;
                }
            }
            //shifts everything down deleting the full row adding a empty row to the top
            if (full){
                for (int r = row; r > 0; r --) {
                    for (int c = 0; c < data[r].length; c++) {
                        data[r][c][2] = data[r-1][c][2];
                    }
                }
                for (int c = 0; c < data[0].length; c++) {
                    data[0][c][2] = 0;
                }
            }
            full = true;
        }
    }
    // moves the shapes the player controls down (data with 2)
    public void shiftDownPlayer(){
        // reads ups rows
        for (int row = data.length-1; row > 0; row --) {
            //reads across col
            for (int col = 0; col < data[row].length; col++) {
                if(data[row][col][2] == 0 && data[row-1][col][2] == 2 ){
                    //shifts data down cur is 0 and above is 2
                    data[row][col][2] = data[row-1][col][2];
                    data[row-1][col][2] = 0;
                }
            }
        }
        //if player is at bottom row, change player to 1
        for (int col = 0; col < data[data.length-1].length; col++ ){
            if (data[data.length-1][col][2] == 2) {
                data[data.length-1][col][2] = 1;
            }
        }
        for (int row = data.length-1; row > 0; row --) {
            //reads across col
            for (int col = 0; col < data[row].length; col++) {
                // collision with a 1
                if(data[row][col][2] == 1 && data[row-1][col][2] == 2 ){
                    //change all 2 to 1
                    for (int r= 0; r < data.length; r ++) {
                        for (int c = 0; c < data[r].length; c++) {
                            if(data[r][c][2] == 2){
                                data[r][c][2] = 1;
                            }
                        }
                    }
                }
            }
        }
    }
    public void shiftPlayerL(){
        for (int col = 0; col < data[0].length-1; col++) {
            for (int row = 0; row< data.length; row ++) {
                if(data[row][col][2] == 0 && data[row][col+1][2] == 2){
                    data[row][col][2] = data[row][col+1][2];
                    data[row][col+1][2] = 0;
                }
            }
        }
    }
    public void shiftPlayerR(){
        for (int col = data[0].length -1; col > 0; col-- ){
            for (int row = 0; row< data.length; row ++) {
                if(data[row][col][2] == 0 && data[row][col-1][2] == 2){
                    data[row][col][2] = data[row][col-1][2];
                    data[row][col-1][2] = 0;
                }
            }
        }
    }
    public void addSquare(){
        data[0][4][2] = 2;
        data[0][3][2] = 2;
        data[1][4][2] = 2;
        data[1][3][2] = 2;
    }

}