package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.object.Character;

public class Player extends Character {

    public void attack(){
        //attack enemy when close
        //skeleton version: this is just walking over them.
    }

    @Override
    public void move(Direction direction) {
        switch (direction){
            case UP:
                changeDirection(Direction.UP);
                getCell().moveUp();
                break;
            case DOWN:
                changeDirection(Direction.DOWN);
                getCell().moveDown();
                break;
            case LEFT:
                changeDirection(Direction.LEFT);
                getCell().moveLeft();
                break;
            case RIGHT:
                changeDirection(Direction.Right);
                getCell().moveRight();
                break;
        }
    }
    @Override
    public boolean isDirectionPossible(Direction direction){
        return false;
   }
}
