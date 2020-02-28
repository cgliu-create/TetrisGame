package CLOO;

public class gridLShape {
    public gridLShape(){

    }
    public void add(int[][][] data){
        data[0][3][2] = 2; data[0][4][2] = 2; data[0][5][2] = 0; data[0][6][2] = 0;
        data[1][3][2] = 0; data[1][4][2] = 2; data[1][5][2] = 0; data[1][6][2] = 0;
        data[2][3][2] = 0; data[2][4][2] = 2; data[2][5][2] = 0; data[2][6][2] = 0;
        data[3][3][2] = 0; data[3][4][2] = 0; data[3][5][2] = 0; data[3][6][2] = 0;
    }

}
