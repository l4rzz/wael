package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;

public class Player extends GameCharacter {

    public Player(GameObjectType gameObjectType, Grid grid) {
        super(gameObjectType, grid);
    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case UP:
                if (isDirectionPossible(Direction.UP)) {
                    changeDirection(Direction.UP);
                    getCell().moveUp();
                }
                break;
            case DOWN:
                if (isDirectionPossible(Direction.DOWN)) {
                    changeDirection(Direction.DOWN);
                    getCell().moveDown();
                }
                break;
            case LEFT:
                if (isDirectionPossible(Direction.LEFT)) {
                    changeDirection(Direction.LEFT);
                    getCell().moveLeft();
                }
                break;
            case RIGHT:
                if (isDirectionPossible(Direction.RIGHT)) {
                    changeDirection(Direction.RIGHT);
                    getCell().moveRight();
                }
                break;
        }
    }

}
