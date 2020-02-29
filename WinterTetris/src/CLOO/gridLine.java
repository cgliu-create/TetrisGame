package CLOO;
import java.awt.Graphics;
import java.awt.Color;
// keeps track of player as a 4 by 4 block
public class gridLine {
    // all shapes fit in a 4 by 4 square
    /*
        data[0][3][2] = 2; data[0][4][2] = 2; data[0][5][2] = 2; data[0][6][2] = 2;
        data[1][3][2] = 2; data[1][4][2] = 2; data[1][5][2] = 2; data[1][6][2] = 2;
        data[2][3][2] = 2; data[2][4][2] = 2; data[2][5][2] = 2; data[2][6][2] = 2;
        data[3][3][2] = 2; data[3][4][2] = 2; data[3][5][2] = 2; data[3][6][2] = 2;
     */
    private int[][][] group = new int[4][4][3];
    // group[#][#] = {row#, col#, stat#)
    public gridLine(){
        reset();
    }
    public void reset(){
        group[0][0][0]=0; group[0][0][1]=3; group[0][0][2]=0;
        group[0][1][0]=0; group[0][1][1]=4; group[0][1][2]=2;
        group[0][2][0]=0; group[0][2][1]=5; group[0][2][2]=0;
        group[0][3][0]=0; group[0][3][1]=6; group[0][3][2]=0;

        group[1][0][0]=1; group[1][0][1]=3; group[1][0][2]=0;
        group[1][1][0]=1; group[1][1][1]=4; group[1][1][2]=2;
        group[1][2][0]=1; group[1][2][1]=5; group[1][2][2]=0;
        group[1][3][0]=1; group[1][3][1]=6; group[1][3][2]=0;

        group[2][0][0]=2; group[2][0][1]=3; group[2][0][2]=0;
        group[2][1][0]=2; group[2][1][1]=4; group[2][1][2]=2;
        group[2][2][0]=2; group[2][2][1]=5; group[2][2][2]=0;
        group[2][3][0]=2; group[2][3][1]=6; group[2][3][2]=0;

        group[3][0][0]=3; group[3][0][1]=3; group[3][0][2]=0;
        group[3][1][0]=3; group[3][1][1]=4; group[3][1][2]=2;
        group[3][2][0]=3; group[3][2][1]=5; group[3][2][2]=0;
        group[3][3][0]=3; group[3][3][1]=6; group[3][3][2]=0;
    }
    public void add(int[][][] data){
        data[0][3][2] = 0; data[0][4][2] = 2; data[0][5][2] = 0; data[0][6][2] = 0;
        data[1][3][2] = 0; data[1][4][2] = 2; data[1][5][2] = 0; data[1][6][2] = 0;
        data[2][3][2] = 0; data[2][4][2] = 2; data[2][5][2] = 0; data[2][6][2] = 0;
        data[3][3][2] = 0; data[3][4][2] = 2; data[3][5][2] = 0; data[3][6][2] = 0;
    }
    public void rotOne(){
        group[0][0][2]=0; group[0][1][2]=2; group[0][2][2]=0; group[0][3][2]=0;
        group[1][0][2]=0; group[1][1][2]=2; group[1][2][2]=0; group[1][3][2]=0;
        group[2][0][2]=0; group[2][1][2]=2; group[2][2][2]=0; group[2][3][2]=0;
        group[3][0][2]=0; group[3][1][2]=2; group[3][2][2]=0; group[3][3][2]=0;
    }
    public void rotTwo(){
        group[0][0][2]=0; group[0][1][2]=0; group[0][2][2]=0; group[0][3][2]=0;
        group[1][0][2]=2; group[1][1][2]=2; group[1][2][2]=2; group[1][3][2]=2;
        group[2][0][2]=0; group[2][1][2]=0; group[2][2][2]=0; group[2][3][2]=0;
        group[3][0][2]=0; group[3][1][2]=0; group[3][2][2]=0; group[3][3][2]=0;
    }
    public void rotThree(){
        group[0][0][2]=0; group[0][1][2]=0; group[0][2][2]=2; group[0][3][2]=0;
        group[1][0][2]=0; group[1][1][2]=0; group[1][2][2]=2; group[1][3][2]=0;
        group[2][0][2]=0; group[2][1][2]=0; group[2][2][2]=2; group[2][3][2]=0;
        group[3][0][2]=0; group[3][1][2]=0; group[3][2][2]=2; group[3][3][2]=0;
    }
    public void rotFour(){
        group[0][0][2]=0; group[0][1][2]=0; group[0][2][2]=0; group[0][3][2]=0;
        group[1][0][2]=0; group[1][1][2]=0; group[1][2][2]=0; group[1][3][2]=0;
        group[2][0][2]=2; group[2][1][2]=2; group[2][2][2]=2; group[2][3][2]=2;
        group[3][0][2]=0; group[3][1][2]=0; group[3][2][2]=0; group[3][3][2]=0;
    }
    public void updateData(int[][][] data){
        for (int r = 0; r < group.length; r++) {
            for (int c = 0; c < group[r].length; c++) {
                int dr = group[r][c][0];
                int dc = group[r][c][1];
                data[dr][dc][2] = group[r][c][2];
            }
        }
    }
    public void shiftedL(){
        for (int r = 0; r < group.length; r++) {
            for (int c = 0; c < group[r].length; c++) {
                int dc = group[r][c][1];
                dc = dc - 1;
                //can slide along ref box
                if(dc == -1){
                    dc = 3;
                }
                group[r][c][1] = dc;
            }
        }
    }
    public void shiftedR(){
        for (int r = 0; r < group.length; r++) {
            for (int c = 0; c < group[r].length; c++) {
                int dc = group[r][c][1];
                dc = dc + 1;
                //can slide along ref box
                if(dc == 12){
                    dc = 8;
                }
                group[r][c][1] = dc;
            }
        }
    }
    public void shiftedD(){
        for (int r = 0; r < group.length; r++) {
            for (int c = 0; c < group[r].length; c++) {
                int dr = group[r][c][0];
                dr = dr + 1;
                group[r][c][0] = dr;
            }
        }
    }
    public void draw(Graphics window, int[][][] data){
        // draws a 4 by 4 ref box
        for (int[][] a : group) {
            for (int[] b : a) {
                int dr = b[0];
                int dc = b[1];
                int y = data[dr][dc][0];
                int x = data[dr][dc][1];
                window.setColor(Color.BLUE);
                window.drawOval(x, y, 25,25);
            }
        }
    }
}
