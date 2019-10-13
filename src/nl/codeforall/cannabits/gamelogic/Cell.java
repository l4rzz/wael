package nl.codeforall.cannabits.gamelogic;

//position on the field
public class Cell {

    private int col;
    private int row;
    private boolean availableCell = true;

    public boolean checkAvailableCell() {
        return availableCell;
    }

    public boolean isAvailable() {
        return availableCell;
    }

    public void setAvailable(boolean availableCell) {
        this.availableCell = availableCell;
    }

    private int getCols() {
        return this.col;
    }

    private int getRows() {
        return this.row;
    }

    //move one position up on field

    public void moveUp() {
        this.col += col--;
    }

    public void moveDown() {
        this.col += col++;
    }

    public void moveLeft() {
        this.row -= row--;
    }

    public void moveRight() {
        this.row -= row++;
    }

    private void generateRandCol() {
        int randCols = ((int) (Math.random() * getCols()));
        if (randCols == this.col) {
            generateRandCol();
        }
    }

    private void generateRandRow() {
        int randRows = ((int) (Math.random() * getRows()));
        if (randRows == this.row) {
            generateRandRow();
        }
    }
}

