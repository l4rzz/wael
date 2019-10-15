package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class Character extends GameObject implements Moveable {

    private Direction direction;
    private boolean dead;

    @Override
    public boolean isDirectionPossible(Direction direction, Wall[] walls) {
        int totalColumns = getGrid().getCols() -1;
        int totalRows = getGrid().getRows() -1;
        int currentCol = getCell().getCol();
        int currentRow = getCell().getRow();
        /*
            Check if it is NOT possible to move for the borders
            Check if it is NOT possible to move for each wall
         */

        switch (direction){
            case UP:
                return currentRow < 0;
            case DOWN:
                return currentRow > totalRows;
            case LEFT:
                return currentCol < 0;
            case RIGHT:
                return currentCol > totalColumns;
        }
        for(i int = 0; i < walls.lenght; i++){
            //Check if you can NOT move for each wall
            switch(direction){
                case UP:
                    return currentCol < walls.getCell().getCols();
                case Down:
                    return currentCol > walls.getCell().getCols();
                case LEFT:
                    return currentRow < walls.getCell().getRows();
                case RIGHT:
                    return currentRow > walls.getCell().getRows();
            }
        }
        //all borders, walls checked. So you can move.
        return true;
    }

    public void changeDirection(Direction direction){
        this.direction = direction;
    }

    public boolean isDead(){
        return dead;
    }
}
