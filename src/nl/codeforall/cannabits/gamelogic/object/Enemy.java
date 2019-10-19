package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;

public class Enemy extends GameCharacter {

    public Enemy(GameObjectType gameObjectType){
        super(gameObjectType);
    }

    public void moveTowardWithWalls(Cell cell, Wall[] walls) {
        /*
         * Which direction can you go?
         * Which directions get the enemy closer to the player
         * if that direction is possible
         *  go into that direction
         * */

        // compare columns
        int colDifference = cell.getCols() - getCell().getCols();
        // compare rows
        int rowDifference = cell.getRows() - getCell().getRows();

        boolean moved = false;
        if (Math.abs(colDifference) > Math.abs(rowDifference)) {
            if (colDifference < 0) {
                //go right
                if (isDirectionPossible(Direction.RIGHT, walls)) {
                    changeDirection(Direction.RIGHT);
                    cell.moveRight();
                    return;
                }
                if (isDirectionPossible(Direction.LEFT, walls)) {
                    changeDirection(Direction.LEFT);
                    cell.moveLeft();
                    return;
                }

            }
            if (rowDifference < 0) {
                //go down
                if (isDirectionPossible(Direction.DOWN, walls)) {
                    changeDirection(Direction.DOWN);
                    cell.moveDown();
                    return;
                }

                if (isDirectionPossible(Direction.UP, walls)) {
                    changeDirection(Direction.UP);
                    cell.moveUp();
                    return;
                }
            }
        }
    }


    @Override
    public boolean isDirectionPossible(Direction direction, Wall[] walls) {
        return false;
    }

    @Override
    public void move(Direction direction) {

    }
}

