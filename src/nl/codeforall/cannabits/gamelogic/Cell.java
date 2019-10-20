package nl.codeforall.cannabits.gamelogic;

//position on the field
public class Cell {

    private int col;
    private int row;
    private boolean passable;

    public Cell(int col, int row){
        this.col = col;
        this.row = row;
        passable = true;
    }

    public boolean isPassable() {
        return passable;
    }

    public void setNotPassable() {
        this.passable = false;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
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
        int randCols = ((int) (Math.random() * getCol()));
        if (randCols == this.col) {
            generateRandCol();
        }
    }

    private void generateRandRow() {
        int randRows = ((int) (Math.random() * getRow()));
        if (randRows == this.row) {
            generateRandRow();
        }
    }
}

