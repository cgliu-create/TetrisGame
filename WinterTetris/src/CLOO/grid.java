package CLOO;
//Name -Christopher Liu
//Class - P.8
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class grid{
    private ArrayList<Particle> particles = new ArrayList<Particle>();
    // Particle Stuff
    // http://www.java-gaming.org/topics/particles-basics-to-advanced/26885/view.html
    public void RemoveParticles(){
        for(int i = particles.size()-1; i>=0; i--){
            if(particles.get(i).update()) // changes particle values, removes if life = 0
            {
                particles.remove(i);
            }
        }
    }
    public void DrawAllParticles(Graphics window){
        for(int i = 0; i <= particles.size() - 1;i++){
            particles.get(i).draw(window); // draws/redraw all particles
        }
    }
    public void addParticle(int dir, int sx, int sy, Color c){
        int dx=0; int dy=0;
        // 1 = R, 2 = D, 3 = L, 4 = U
        if(dir == 1){
            dx = (int) (Math.random()*5); dy = (int) (Math.random()*5);
        }
        if(dir == 2){
            dx = (int) (Math.random()*-5); dy = (int) (Math.random()*5);
        }
        if(dir == 3){
            dx = (int) (Math.random()*-5); dy = (int) (Math.random()*-5);
        }
        if(dir == 4){
            dx = (int) (Math.random()*5); dy = (int) (Math.random()*-5);
        }
        int size = (int) (Math.random()*12);
        int life = (int) (Math.random()*5)+1;
        particles.add(new Particle(sx,sy,size,size,c,dx,dy,life));
    }
    // cool stuff
    public void KaBoom(int sx, int sy, Color c){
        addParticle(1, sx, sy, c); addParticle(2, sx, sy, c); addParticle(3, sx, sy, c); addParticle(4, sx, sy, c);
        addParticle(1, sx, sy, c); addParticle(2, sx, sy, c); addParticle(3, sx, sy, c); addParticle(4, sx, sy, c);
    }
    // let 0 = empty
    // let 1 = draw shape
    // let 2 = draw a shape that the player can move
    // let 3 = temp support spots for complex shapes
    private boolean rowdeleted = false;
    public void setRowdeleted(boolean t){
        rowdeleted = t;
    }

    public boolean isRowdeleted() {
        return rowdeleted;
    }

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
    public void rotateJShape(int Rot){
        if(Rot == 1){
            jShape.rotOne();
            jShape.updateData(data);
        }
        if(Rot == 2){
            jShape.rotTwo();
            jShape.updateData(data);
        }
        if(Rot == 3){
            jShape.rotThree();
            jShape.updateData(data);
        }
        if(Rot == 4){
            jShape.rotFour();
            jShape.updateData(data);
        }
    }
    public void rotateTee(int Rot){
        if(Rot == 1){
            tee.rotOne();
            tee.updateData(data);
        }
        if(Rot == 2){
            tee.rotTwo();
            tee.updateData(data);
        }
        if(Rot == 3){
            tee.rotThree();
            tee.updateData(data);
        }
        if(Rot == 4){
            tee.rotFour();
            tee.updateData(data);
        }
    }
    public void rotateZShape(int Rot){
        if(Rot == 1){
            zShape.rotOne();
            zShape.updateData(data);
        }
        if(Rot == 2){
            zShape.rotTwo();
            zShape.updateData(data);
        }
        if(Rot == 3){
            zShape.rotThree();
            zShape.updateData(data);
        }
        if(Rot == 4){
            zShape.rotFour();
            zShape.updateData(data);
        }
    }
    public void rotateSShape(int Rot){
        if(Rot == 1){
            sShape.rotOne();
            sShape.updateData(data);
        }
        if(Rot == 2){
            sShape.rotTwo();
            sShape.updateData(data);
        }
        if(Rot == 3){
            sShape.rotThree();
            sShape.updateData(data);
        }
        if(Rot == 4){
            sShape.rotFour();
            sShape.updateData(data);
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
        if(shape == 3){
            if (dir == 1){
                jShape.shiftedL();
            }
            if (dir == 2){
                jShape.shiftedR();
            }
            if (dir == 3){
                jShape.shiftedD();
            }
        }
        if(shape == 4){
            if (dir == 1){
                tee.shiftedL();
            }
            if (dir == 2){
                tee.shiftedR();
            }
            if (dir == 3){
                tee.shiftedD();
            }
        }
        if(shape == 5){
            if (dir == 1){
                zShape.shiftedL();
            }
            if (dir == 2){
                zShape.shiftedR();
            }
            if (dir == 3){
                zShape.shiftedD();
            }
        }
        if(shape == 6){
            if (dir == 1){
                sShape.shiftedL();
            }
            if (dir == 2){
                sShape.shiftedR();
            }
            if (dir == 3){
                sShape.shiftedD();
            }
        }
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
        jShape.reset();
        tee.reset();
        zShape.reset();
        sShape.reset();
        return false;
    }
    // draws circles based off data
    // window.drawOval(100, 20, 25, 25);
    public void draw(Graphics window)
    {
        DrawAllParticles(window);
        //uncomment to show ref box
        if(shape == 1){
            line.draw(window,data);
        }
        if(shape == 2){
            lShape.draw(window,data);
        }
        if(shape == 3){
            jShape.draw(window,data);
        }
        if(shape == 4){
            tee.draw(window,data);
        }
        if(shape == 5){
            zShape.draw(window,data);
        }
        if(shape == 6){
            sShape.draw(window,data);
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
                if(b[2] == 3){
                    window.setColor(Color.GREEN);
                    window.drawOval(b[1], b[0], 25,25);
                }
            }
        }
    }
    public void removeThree(){
        // change all 3 to 0 if a 1 is below
        for (int row = data.length-1; row > 0; row --) {
            for (int col = 0; col < data[row].length; col++) {
                if(data[row][col][2] == 1 && data[row-1][col][2] == 3 ){
                    for (int r= 0; r < data.length; r ++) {
                        for (int c = 0; c < data[r].length; c++) {
                            if(data[r][c][2] == 3){
                                data[r][c][2] = 0;
                            }
                        }
                    }
                }
            }
        }
        // removes 3 when player is to the side of 1
        for (int col = 0; col < data[0].length-1; col++) {
            for (int row = data.length - 1; row >= 0; row--) {
                if(data[row][col][2] == 1 && data[row][col+1][2] == 3){
                    for (int r= 0; r < data.length; r ++) {
                        for (int c = 0; c < data[r].length; c++) {
                            if(data[r][c][2] == 3){
                                data[r][c][2] = 0;
                            }
                        }
                    }
                }
            }
        }
        for (int col = data[0].length -1; col > 0; col-- ) {
            for (int row = data.length - 1; row >= 0; row--) {
                if(data[row][col][2] == 1 && data[row][col-1][2] == 3){
                    for (int r= 0; r < data.length; r ++) {
                        for (int c = 0; c < data[r].length; c++) {
                            if(data[r][c][2] == 3){
                                data[r][c][2] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
    public void collisionWithOne(){
        for (int col = 0; col < data[0].length; col++) {
            for (int row = data.length - 1; row >= 0; row--) {
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
    public void resetShape(){
        // check for no 3
        boolean check = true;
        for (int[][] datum : data) {
            for (int[] ints : datum) {
                if (ints[2] == 3) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            if(shape == 2){
                lShape.updateData(data);
            }
            if(shape == 3){
                jShape.updateData(data);
            }
            if(shape == 4){
                tee.updateData(data);
            }
            if(shape == 5){
                zShape.updateData(data);
            }
            if(shape == 6){
                sShape.updateData(data);
            }
        }
    }
    // delete full rows
    public void rowDelete(){
        boolean full = true;
        //checks if row is full
        int rr = data.length-1;
        for (int row = data.length-1; row > 0; row --){
            for (int col = 0; col < data[data.length-1].length; col++ ){
                if (data[row][col][2] == 0) {
                    full = false;
                    break;
                }
            }
            //shifts everything down deleting the full row adding a empty row to the top
            if (full){
                for (int c = 0; c < data[data.length-1].length; c++ ){
                    int y = data[rr][c][0];
                    int x = data[rr][c][1];
                    KaBoom(x,y,Color.RED);
                }
                updateGridShape(3);
                setRowdeleted(true);
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
            rr--;
        }
    }
    // moves the shapes the player controls down (data with 2)
    public void shiftDownPlayer(){
        updateGridShape(3);
        removeThree();
        collisionWithOne();
        // reads ups rows
        for (int row = data.length-1; row > 0; row --) {
            //reads across col
            for (int col = 0; col < data[row].length; col++) {
                if(data[row][col][2] == 0 && data[row-1][col][2] == 2 || data[row][col][2] == 0 && data[row-1][col][2] == 3){
                    //shifts data down if cur is 0 and above is 2
                    data[row][col][2] = data[row-1][col][2];
                    data[row-1][col][2] = 0;
                }
            }
        }
        //if player is at bottom row, change player to 1
        for (int col = 0; col < data[data.length-1].length; col++ ){
            if (data[data.length-1][col][2] == 2) {
                //change all 2 to 1
                for (int r= 0; r < data.length; r ++) {
                    for (int c = 0; c < data[r].length; c++) {
                        if(data[r][c][2] == 2){
                            data[r][c][2] = 1;
                        }
                    }
                }
            }
            // change 3 to 0
            if (data[data.length-1][col][2] == 3) {
                data[data.length-1][col][2] = 0;
            }

        }
    }
    public void shiftPlayerL(){
        updateGridShape(1);
        for (int col = 0; col < data[0].length-1; col++) {
            for (int row = data.length - 1; row>=0; row --) {
                if(data[row][col][2] == 0 && data[row][col+1][2] == 2  || data[row][col][2] == 0 && data[row][col+1][2] == 3){
                    data[row][col][2] = data[row][col+1][2];
                    data[row][col+1][2] = 0;
                }
            }
        }
        removeThree();
        collisionWithOne();
        resetShape();
    }
    // need to add bounds specific to shape to prevent shape group changes
    public void shiftPlayerR(){
        updateGridShape(2);
        for (int col = data[0].length -1; col > 0; col-- ){
            for (int row = data.length - 1; row>=0; row --) {
                if(data[row][col][2] == 0 && data[row][col-1][2] == 2 || data[row][col][2] == 0 && data[row][col-1][2] == 3){
                    data[row][col][2] = data[row][col-1][2];
                    data[row][col-1][2] = 0;
                }
            }
        }
        removeThree();
        collisionWithOne();
        resetShape();
    }
    public void resetGame(){
        for (int row = 0; row < data.length; row ++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col][2] = 0;
            }
        }
    }
    public boolean checkIfRowNotEmpty(int row){
        for (int col = 0; col < data[row].length; col++) {
            if(data[row][col][2] == 2 || data[row][col][2] == 1){
                return true;
            }
        }
        return false;
    }
    public boolean checkifAllRowsNotEmpty(){
        boolean r0 = checkIfRowNotEmpty(0);
        boolean r1 = checkIfRowNotEmpty(1);
        boolean r2 = checkIfRowNotEmpty(2);
        boolean r3 = checkIfRowNotEmpty(3);
        boolean r4 = checkIfRowNotEmpty(4);
        boolean r5 = checkIfRowNotEmpty(5);
        boolean r6 = checkIfRowNotEmpty(6);
        boolean r7 = checkIfRowNotEmpty(7);
        boolean r8 = checkIfRowNotEmpty(8);
        boolean r9 = checkIfRowNotEmpty(9);
        boolean r10 = checkIfRowNotEmpty(10);
        boolean r11 = checkIfRowNotEmpty(11);
        boolean r12 = checkIfRowNotEmpty(12);
        boolean r13 = checkIfRowNotEmpty(13);
        boolean r14 = checkIfRowNotEmpty(14);
        boolean r15 = checkIfRowNotEmpty(15);
        boolean r16 = checkIfRowNotEmpty(16);
        boolean r17 = checkIfRowNotEmpty(17);
        boolean r18 = checkIfRowNotEmpty(18);
        boolean r19 = checkIfRowNotEmpty(19);
        return r0 && r1 && r2 && r3 && r4 && r5 && r6 && r7 && r8 && r9 &&
                r10 && r11 && r12 && r13 && r14 && r15 && r16 && r17 && r18 && r19;
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