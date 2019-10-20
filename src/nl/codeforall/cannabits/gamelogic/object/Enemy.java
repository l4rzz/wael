package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;

public class Enemy extends GameCharacter {

    public Enemy(GameObjectType gameObjectType, Grid grid){
        super(gameObjectType, grid);
    }

    public void moveTowardWithWalls(Cell cell) {
        // compare columns
        int colDifference = cell.getCol() - getCell().getCol();
        // compare rows
        int rowDifference = cell.getRow() - getCell().getRow();
        int cdAbs = Math.abs(colDifference);
        int rdAbs = Math.abs(rowDifference);

        if(cdAbs > rdAbs) {
            if(colDifference > 0){
                //go right
                move(Direction.RIGHT);
            }else{
                //go left
                move(Direction.LEFT);
            }
        }else {

            if(rowDifference < 0){
                // go down
                move(Direction.UP);
            }else {
                // go up
                move(Direction.DOWN);
            }
        }
        System.out.println("player " + cell.getCol() + "/" + cell.getRow());
        System.out.println("enemy " + getCell().getCol() + "/" + getCell().getRow());


    }

    public void moveTowards(Cell cell){
        // compare columns
        int colDifference = cell.getCol() - getCell().getCol();
        // compare rows
        int rowDifference = cell.getRow() - getCell().getRow();
        int cdAbs = Math.abs(colDifference);
        int rdAbs = Math.abs(rowDifference);

        if(cdAbs > rdAbs) {
            if(colDifference > 0){
                //go right
                move(Direction.RIGHT);
            }else{
                //go left
                move(Direction.LEFT);
            }
        }else {

            if(rowDifference < 0){
                // go down
                move(Direction.UP);
            }else {
                // go up
                move(Direction.DOWN);
            }
        }
        System.out.println("player " + cell.getCol() + "/" + cell.getRow());
        System.out.println("enemy " + getCell().getCol() + "/" + getCell().getRow());



    }



}

