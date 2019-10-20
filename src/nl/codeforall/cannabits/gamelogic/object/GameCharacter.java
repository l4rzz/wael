package nl.codeforall.cannabits.gamelogic.object;

import nl.codeforall.cannabits.gamelogic.Cell;
import nl.codeforall.cannabits.gamelogic.Direction;
import nl.codeforall.cannabits.gamelogic.Grid;

public abstract class GameCharacter extends GameObject {

    private Direction direction;
    private boolean dead;


    public GameCharacter(GameObjectType gameObjectType, Grid grid) {
        super(gameObjectType, grid);
        this.direction = Direction.generateRandom();
    }

    public boolean isDirectionPossible(Direction direction) {

        Cell futureCell = new Cell(getCell().getCol(), getCell().getRow());
        switch (direction) {
            case UP:
                futureCell.moveUp();
                if (futureCell.getRow() > 0 && futureCell.isPassable()) {
                    return true;
                }else {
                    return false;
                }
            case DOWN:
                futureCell.moveDown();
                if (futureCell.getRow() < getGrid().getRows() && futureCell.isPassable()){
                    return true;
                }else {
                    return false;
                }
            case LEFT:
                futureCell.moveLeft();
                if (futureCell.getCol() > 0 && futureCell.isPassable()){
                    return true;
                }else {
                    return false;
                }
            case RIGHT:
                futureCell.moveRight();
                if(futureCell.getCol() < getGrid().getCols() && futureCell.isPassable()){
                    return true;
                }else {
                    return false;
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

    public void setDead(){
        this.dead = true;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                if (isDirectionPossible(Direction.UP)) {
                    changeDirection(Direction.UP);
                    getCell().moveUp();
                    break;
                }
                break;
            case DOWN:
                if (isDirectionPossible(Direction.DOWN)) {
                    changeDirection(Direction.DOWN);
                    getCell().moveDown();
                    break;
                }
                break;
            case LEFT:
                if (isDirectionPossible(Direction.LEFT)) {
                    changeDirection(Direction.LEFT);
                    getCell().moveLeft();
                    break;
                }
                break;
            case RIGHT:
                if (isDirectionPossible(Direction.RIGHT)) {
                    changeDirection(Direction.RIGHT);
                    getCell().moveRight();
                    break;
                }
                break;
            default:
                System.out.println("No direction found");
                break;
        }
    }
}
