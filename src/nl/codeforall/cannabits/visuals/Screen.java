package nl.codeforall.cannabits.visuals;

// field in visual logic


import nl.codeforall.cannabits.gamelogic.object.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import nl.codeforall.cannabits.gamelogic.Grid;



public class Screen {

    public final static int PADDING = 10;
    private final static int CELLENGTH = 64;

    private int width;      //width field
    private int length;      //length field
    private Grid grid;
    private Rectangle field;

    public Screen(Grid grid){
        width = grid.getCols()*CELLENGTH+PADDING;
        length = grid.getRows()*CELLENGTH+PADDING;
        field = new Rectangle(PADDING, PADDING, width, length);
    }


    public void show() {
        field.draw();
    }

    public void hide() {
        field.delete();
    }

    public int getCellsize(){
        return CELLENGTH;
    }

    public int getPadding(){
        return PADDING;
    }

    public int getLength() {
        return length;
    }

    public Grid getGrid() {
        return grid;
    }

    public int rowToY(int row) {
        return PADDING + (CELLENGTH * row)-5;
    }

    public int columnToX(int col) {
        return PADDING + (CELLENGTH * col);
    }

    //public showText(){};
    //TODO create a screen for text output.
}
