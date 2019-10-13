package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.object.Character;

public class Enemy extends Character {

    public void moveToWard(Cell cell) {

        // compare columns
        int colDifference = cell.getCol() - getCell().getCol();
        // compare rows
        int rowDifference = cell.getRow() - getCell().getRow();

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
