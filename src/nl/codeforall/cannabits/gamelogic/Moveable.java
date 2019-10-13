package nl.codeforall.cannabits.gamelogic;

public interface Moveable {
    boolean isDirectionPossible(Direction direction);
    void move(Direction direction);
}
