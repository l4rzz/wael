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
        Direction[] directionOrder = new Direction[2];

        //order in which the directions are checked
        int horizontalOrder;
        int verticalOrder;

        //assign movement order
        if(Math.abs(colDifference) > Math.abs(rowDifference)){
            horizontalOrder = 0;
            verticalOrder = 1;

        }else {
            horizontalOrder = 1;
            verticalOrder = 0;

        }

        //assign directions
        if(colDifference < 0){
            //go right
            directionOrder[horizontalOrder] = Direction.RIGHT;
        }else{
            //go left
            directionOrder[horizontalOrder] = Direction.LEFT;
        }

        if(rowDifference < 0){
            // go down
            directionOrder[verticalOrder] = Direction.UP;
        }else {
            // go up
            directionOrder[verticalOrder] = Direction.DOWN;
        }

        //move to the first direction if possible,if it's not possible. Try the next
        for(int i = 0; i < directionOrder.length; i++){
            if(isDirectionPossible(directionOrder[i])){
                System.out.println("possible " +directionOrder[i]);
                move(directionOrder[i]);
                break;
            }
        }

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

