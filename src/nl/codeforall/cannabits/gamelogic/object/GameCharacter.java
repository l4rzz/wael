package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class Character extends GameObject implements Moveable {

    private Direction direction;
    private boolean dead;

    @Override
    public boolean isDirectionPossible(Direction direction) {
        int totalColumns = getGrid().getCols() -1;
        int totalRows = getGrid().getRows() -1;
        int currentCol = getCell().getCols();
        int currentRow = getCell().getRows();

        switch (direction){
            case UP:
                return currentRow >= 0;
            case DOWN:
                return currentRow <= totalRows;
            case LEFT:
                return currentCol >= 0;
            case RIGHT:
                return currentCol <= totalColumns;
        }
        return true;
    }

    protected void changeDirection(Direction direction){
        this.direction = direction;
    }

    public boolean isDead(){
        return dead;
    }
}
