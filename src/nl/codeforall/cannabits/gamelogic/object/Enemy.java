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
        int cdAbs = Math.abs(colDifference);
        int rdAbs = Math.abs(rowDifference);

        //order in which the directions are checked
        int horizontalOrder;
        int verticalOrder;

        //assign movement order
        if(cdAbs > rdAbs){
            System.out.println("horizon has priority");
            //horizon has priority
            horizontalOrder = 1;
            verticalOrder = 0;
        }else {
            System.out.println("vertical has priority");
            //vertical has priority
            horizontalOrder = 0;
            verticalOrder = 1;
        }

        //assign directions
        if(colDifference > 0){
            //go right
            directionOrder[horizontalOrder] = Direction.RIGHT;
        }else{
            //go left
            directionOrder[horizontalOrder] = Direction.LEFT;
        }
        if(rowDifference < 0){
            // go down
            directionOrder[verticalOrder] = Direction.DOWN;
        }else {
            // go up
            directionOrder[verticalOrder] = Direction.UP;
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

    public int pointsForMove(Direction proposedDirection, Cell playerCell) {
        int targetCol = 0;
        int targetRow = 0;

        for (Direction d : Direction.values()) {
            int colDifference = playerCell.getCol() - getCell().getCol();
            int rowDifference = playerCell.getRow() - getCell().getRow();
            targetCol = Math.abs(colDifference);
            targetRow = Math.abs(rowDifference);
            switch (d) {
                case LEFT:
                    targetCol --;
                case RIGHT:
                    targetCol ++;
                case UP:
                    targetRow --;
                case DOWN:
                    targetRow ++;
            }
            System.out.println(d.name() + ": " + (targetCol + targetRow));
        }
        return targetCol + targetRow;
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
                // TEST
                //pointsForMove(Direction.RIGHT, cell);
            }else{
                //go left
                move(Direction.LEFT);
                // TEST
                //pointsForMove(Direction.LEFT, cell);
            }
        }else {

            if(rowDifference < 0){
                // go down
                move(Direction.UP);
                // TEST
                //pointsForMove(Direction.UP, cell);
            }else {
                // go up
                move(Direction.DOWN);
                // TEST
                //pointsForMove(Direction.DOWN, cell);
            }
        }
        System.out.println("player " + cell.getCol() + "/" + cell.getRow());
        System.out.println("enemy " + getCell().getCol() + "/" + getCell().getRow());



    }



}

