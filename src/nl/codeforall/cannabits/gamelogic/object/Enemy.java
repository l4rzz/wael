package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;

public class Enemy extends GameCharacter {

    public void moveToWard(Cell cell) {

        // compare columns
        int colDifference = cell.getCols() - getCell().getCols();
        // compare rows
        int rowDifference = cell.getRows() - getCell().getRows();

        // test first, can be cleaned up later
        // get highest value
        // move into that direction
        if(Math.abs(colDifference) > Math.abs(rowDifference)){
            if(colDifference <0){
                //go right
                cell.moveRight();
            }else{
                //go left
                cell.moveRight();
            }
        }else{
            if(rowDifference <0){
                //go down
                cell.moveDown();
            }else{
                //go up
                cell.moveUp();
            }
        }


    }

    @Override
    public void move(Direction direction) {

    }
}
