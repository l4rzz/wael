package nl.codeforall.cannabits.visuals;

// field in visual logic


import nl.codeforall.cannabits.gamelogic.object.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import nl.codeforall.cannabits.gamelogic.Grid;

import java.awt.*;

public class Screen {

    public final static int PADDING = 10;
    private final static int CELLENGTH = 16;

    private int width;      //width field
    private int length;      //length field
    private Grid grid;
    private Rectangle field;

    public Screen(Grid grid){
        width = grid.getCols()*CELLENGTH;
        length = grid.getRows()*CELLENGTH;
        field = new Rectangle(PADDING, PADDING, width, length);
    }

    //start screen
    public void init() {

    }


    public void show() {
        field.draw();
    }

    public void hide() {
        field.delete();
    }

    public int getCellsize(){
        return CELLENGTH;
        //cellsize
    }

    public int getLength() {
        return length;
    }

    public Grid getGrid() {
        return grid;
    }
}
