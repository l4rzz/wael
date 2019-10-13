package nl.codeforall.cannabits.gamelogic;

public class Grid {

    private int cols;
    private int rows;
    private boolean occupied;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public boolean isOccupied(int setCol, int setRow) {
        return occupied;
    }
}



