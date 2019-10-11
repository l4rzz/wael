package nl.codeforall.cannabits;

public class Field {
    private int cols;
    private int rows;

    public Field(int cols, int rows) {
    this.cols = cols;
    this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
