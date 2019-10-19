package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class GameCharacter extends GameObject implements Moveable {

    private Direction direction;
    private boolean dead;

    public GameCharacter(GameObjectType gameObjectType) {
        super(gameObjectType);
    }


    @Override
    public boolean isDirectionPossible(Direction direction, Wall[] walls) {
        int totalColumns = getGrid().getCols() -1;
        int totalRows = getGrid().getRows() -1;
        int currentCol = getCell().getCols();
        int currentRow = getCell().getRows();
        /*
            Check if it is NOT possible to move for the borders
            Check if it is NOT possible to move for each wall
         */
        //if you are already bumping into the border, it is not a wall
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

        for(int i = 0; i < walls.length; i++){
            //Check if you can NOT move for each wall
            switch(direction){
                case UP:
                    if(currentCol < walls.getCell().getCols()){
                        return false;
                    }
                    break;
                case DOWN:
                    if(currentCol > walls.getCell().getCols()){
                        return false;
                    }
                    break;
                case LEFT:
                    if(currentRow < walls.getCell().getRows()){
                        return false;
                    }
                    break;
                case RIGHT:
                    if(currentRow > walls.getCell().getRows()){
                        return false;
                    }

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

    public void setDead(){
        dead = true;
    }
}
