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
                opposite = Direction.DOWN;
                break;

            case DOWN:
                opposite = Direction.UP;
                break;

            case LEFT:
                opposite = Direction.RIGHT;
                break;

            case RIGHT:
                opposite = Direction.LEFT;
                break;
        }
        return oppositeGridDirection;
    }
}
