package nl.codeforall.cannabits.gamelogic;

public class Grid {

    private int cols;
    private int rows;
    private boolean occupied;
    private boolean[][] cells;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;

        cells = new boolean[cols][rows];

        //rows then columns
        //cell[0][0] cell[0][j]
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                cells[i][j] = true;
            }
        }

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public boolean isPassable(int col, int row){
        return cells[col][row];
    }

    public void notPassable(int col, int row){
        cells[col][row] = false;
    }


}



