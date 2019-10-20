package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class GameCharacter extends GameObject implements Moveable {

    private Direction direction;
    private boolean dead;

    public GameCharacter(GameObjectType gameObjectType, Grid grid) {
        super(gameObjectType, grid);
        this.direction = Direction.generateRandom();
    }

    public boolean isDirectionPossible(Direction direction) {

        Cell futureCell = getCell();
        switch (direction) {
            case UP:
                futureCell.moveUp();
                if (futureCell.isPassable()) {
                    return true;
                }
            case DOWN:
                futureCell.moveDown();
                if (futureCell.isPassable()){
                    return true;
                }
            case LEFT:
                futureCell.moveLeft();
                if (futureCell.isPassable()){
                    return true;
                }
            case RIGHT:
                futureCell.moveRight();
                if(futureCell.isPassable()){
                    return true;
                }
        }
        return false;
    }

    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isDead() {
        return dead;
    }
}
