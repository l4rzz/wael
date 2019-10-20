package nl.codeforall.cannabits.gamelogic;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public boolean isOppositeGridDirection(Direction direction) {
        return direction.equals(oppositeGridDirection());
    }

    public Direction oppositeGridDirection() {
        Direction oppositeGridDirection = null;

        switch (this) {
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;

        }
        return oppositeGridDirection;
    }

    public static Direction generateRandom(){
        return Direction.values()[(int)(Math.random() * 4)];
    }
}
