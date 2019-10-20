package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;
import nl.codeforall.cannabits.gamelogic.Moveable;

public abstract class GameCharacter extends GameObject implements Moveable {

    private Direction direction;
    private boolean dead;

    public GameCharacter(GameObjectType gameObjectType) {
        super(gameObjectType);
    }

    public boolean isDirectionPossible(Direction direction) {

        Cell futureCell = new Cell();
        switch (direction) {
            case UP:
                futureCell.moveUp();
                if (futureCell.isAvailable()) {
                    return true;
                }
            case DOWN:
                futureCell.moveDown();
                if (futureCell.isAvailable()){
                    return true;
                }
            case LEFT:
                futureCell.moveLeft();
                if (futureCell.isAvailable()){
                    return true;
                }
            case RIGHT:
                futureCell.moveRight();
                if(futureCell.isAvailable()){
                    return true;
                }
        }
        return false;
    }

    protected void changeDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isDead() {
        return dead;
    }
}
