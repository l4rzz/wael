package nl.codeforall.cannabits.gamelogic;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction generateRandom(){
        return Direction.values()[(int)(Math.random() * 4)];
    }
}
