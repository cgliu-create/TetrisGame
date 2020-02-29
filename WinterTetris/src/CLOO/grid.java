package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.Graphics;
import java.awt.Color;

public class grid{
    // let 0 = empty
    // let 1 = draw shape
    // let 2 = draw a shape that the player can move
    private int[][][] data = new int[20][12][3];
    private int shape = 0;
    private int rotation = 1;
    private gridSquare square = new gridSquare();
    private gridLine line = new gridLine();
    private gridLShape lShape = new gridLShape();
    private gridJShape jShape = new gridJShape();
    private gridTee tee = new gridTee();
    private gridZShape zShape = new gridZShape();
    private gridSShape sShape = new gridSShape();
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
    // all shapes fit in a 4 by 4 square
    /*
        data[0][3][2] = 2; data[0][4][2] = 2; data[0][5][2] = 2; data[0][6][2] = 2;
        data[1][3][2] = 2; data[1][4][2] = 2; data[1][5][2] = 2; data[1][6][2] = 2;
        data[2][3][2] = 2; data[2][4][2] = 2; data[2][5][2] = 2; data[2][6][2] = 2;
        data[3][3][2] = 2; data[3][4][2] = 2; data[3][5][2] = 2; data[3][6][2] = 2;
        let 0 = square
        let 1 = line
        let 2 = Lshape
        let 3 = Jshape
        let 4 = Tee
        let 5 = Zshape
        let 6 = Sshape
        rotations = 1,2,3,4
    */
    public void setShape(int s){
        shape = s;
    }
    public int getShape() {
        return shape;
    }
    public void setRotation(int r){
        rotation = r;
    }
    public int getRotation() {
        return rotation;
    }
    public void addSquare(){
        square.add(data);
        setShape(0);
        setRotation(1);
    }
    public void addLine(){
        line.add(data);
        setShape(1);
        setRotation(1);
    }
    public void addLShape(){
        lShape.add(data);
        setShape(2);
        setRotation(1);
    }
    public void addJShape(){
        jShape.add(data);
        setShape(3);
        setRotation(1);
    }
    public void addTee(){
        tee.add(data);
        setShape(4);
        setRotation(1);
    }
    public void addZShape(){
        zShape.add(data);
        setShape(5);
        setRotation(1);
    }
    public void addSShape(){
        sShape.add(data);
        setShape(6);
        setRotation(1);
    }
    // square does not need to rotate
    public void rotateLine(int Rot){
        if(Rot == 1){
            line.rotOne();
            line.updateData(data);
        }
        if(Rot == 2){
            line.rotTwo();
            line.updateData(data);
        }
        if(Rot == 3){
            line.rotThree();
            line.updateData(data);
        }
        if(Rot == 4){
            line.rotFour();
            line.updateData(data);
        }
    }
    public void rotateLShape(int Rot){
        if(Rot == 1){
            lShape.rotOne();
            lShape.updateData(data);
        }
        if(Rot == 2){
            lShape.rotTwo();
            lShape.updateData(data);
        }
        if(Rot == 3){
            lShape.rotThree();
            lShape.updateData(data);
        }
        if(Rot == 4){
            lShape.rotFour();
            lShape.updateData(data);
        }
    }
    public void rotateJShape(int Rot){}
    public void rotateTee(int Rot){}
    public void rotateZShape(int Rot){}
    public void rotateSShape(int Rot){}
    public void clearallTwos(){
        for (int row = 0; row < data.length; row ++) {
            for (int col = 0; col < data[row].length; col++) {
                if(data[row][col][2]==2){
                    data[row][col][2]=0;
                }
            }
        }
    }
    public void updateGridShape(int dir){
        // 1 = left, 2 = right, 3 = down
        if(shape == 1){
            if (dir == 1){
                line.shiftedL();
            }
            if (dir == 2){
                line.shiftedR();
            }
            if (dir == 3){
                line.shiftedD();
            }
        }
        if(shape == 2){
            if (dir == 1){
                lShape.shiftedL();
            }
            if (dir == 2){
                lShape.shiftedR();
            }
            if (dir == 3){
                lShape.shiftedD();
            }
        }
        //add the rest of the shapes
    }
    // checks to regenerate player shape
    public boolean checkforTwos(){
        for (int[][] datum : data) {
            for (int[] ints : datum) {
                if (ints[2] == 2) {
                    return true;
                }
            }
        }
        line.reset();
        lShape.reset();
        return false;
    }
    // draws circles based off data
    // window.drawOval(100, 20, 25, 25);
    public void draw(Graphics window)
    {
        if(shape == 1){
            line.draw(window,data);
        }
        if(shape == 2){
            lShape.draw(window,data);
        }
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
            for (int col = 0; col < data[data.length-1].length; col++ ){
                if (data[row][col][2] == 0) {
                    full = false;
                }
            }
            //shifts everything down deleting the full row adding a empty row to the top
            if (full){
                updateGridShape(3);
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
        updateGridShape(3);
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
        updateGridShape(1);
        for (int col = 0; col < data[0].length-1; col++) {
            for (int row = 0; row< data.length; row ++) {
                if(data[row][col][2] == 0 && data[row][col+1][2] == 2){
                    data[row][col][2] = data[row][col+1][2];
                    data[row][col+1][2] = 0;
                }
            }
        }
    }
    // need to add bounds specific to shape to prevent shape group changes
    public void shiftPlayerR(){
        updateGridShape(2);
        for (int col = data[0].length -1; col > 0; col-- ){
            for (int row = 0; row< data.length; row ++) {
                if(data[row][col][2] == 0 && data[row][col-1][2] == 2){
                    data[row][col][2] = data[row][col-1][2];
                    data[row][col-1][2] = 0;
                }
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
}